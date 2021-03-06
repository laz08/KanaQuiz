package com.noprestige.kanaquiz.quiz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.noprestige.kanaquiz.AboutScreen;
import com.noprestige.kanaquiz.R;
import com.noprestige.kanaquiz.logs.DailyRecord;
import com.noprestige.kanaquiz.logs.LogDao;
import com.noprestige.kanaquiz.logs.LogDatabase;
import com.noprestige.kanaquiz.logs.LogView;
import com.noprestige.kanaquiz.options.OptionsControl;
import com.noprestige.kanaquiz.options.OptionsScreen;
import com.noprestige.kanaquiz.options.QuestionSelection;
import com.noprestige.kanaquiz.questions.QuestionManagement;
import com.noprestige.kanaquiz.reference.ReferenceScreen;

import org.threeten.bp.LocalDate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;

import static android.graphics.Typeface.BOLD;
import static android.graphics.Typeface.NORMAL;
import static android.os.Build.VERSION.SDK_INT;
import static android.util.TypedValue.COMPLEX_UNIT_SP;

public class MainQuiz extends AppCompatActivity
{
    int totalQuestions;
    float totalCorrect;
    private boolean canSubmit;

    private TextView lblResponse;
    private TextView lblQuestion;
    AnswerFrame frmAnswer;

    private static final int MAX_RETRIES = 3;

    private Handler delayHandler = new Handler();

    private int retryCount;

    private FetchTodaysLog fetchScoreThread;

    @SuppressLint("StaticFieldLeak")
    class FetchTodaysLog extends AsyncTask<LocalDate, Void, DailyRecord>
    {
        @Override
        protected void onPreExecute()
        {
            totalQuestions = 0;
            totalCorrect = 0;
        }

        @Override
        protected DailyRecord doInBackground(LocalDate... date)
        {
            return LogDatabase.DAO.getDateRecord(date[0]);
        }

        @Override
        protected void onPostExecute(DailyRecord record)
        {
            if (record != null)
            {
                totalQuestions += record.getTotalAnswers();
                totalCorrect += record.getCorrectAnswers();
            }
            frmAnswer.updateScore(totalCorrect, totalQuestions);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_quiz);

        lblResponse = findViewById(R.id.lblResponse);
        lblQuestion = findViewById(R.id.lblQuestion);
        frmAnswer = findViewById(R.id.frmAnswer);

        onConfigurationChanged(getResources().getConfiguration());

        if (SDK_INT < Build.VERSION_CODES.O)
            TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(lblQuestion, 12, 144, 2, COMPLEX_UNIT_SP);

        frmAnswer.setOnAnswerListener(this::checkAnswer);

        resetQuiz();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);

        if ((newConfig.keyboard == Configuration.KEYBOARD_NOKEYS) &&
                (newConfig.hardKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_YES))
            frmAnswer.setTextHint(R.string.answer_hint_touch);
        else
            frmAnswer.setTextHint(R.string.answer_hint_hardware);
    }

    @Override
    protected void onDestroy()
    {
        if (fetchScoreThread != null)
            fetchScoreThread.cancel(true);
        super.onDestroy();
    }

    private void resetQuiz()
    {
        if (fetchScoreThread != null)
            fetchScoreThread.cancel(true);
        fetchScoreThread = new FetchTodaysLog();
        fetchScoreThread.execute(LocalDate.now());

        lblQuestion.setText("");
        lblResponse.setText("");

        if (!OptionsControl.compareStrings(R.string.prefid_on_incorrect, R.string.prefid_on_incorrect_default))
            lblResponse.setMinLines(2);

        if (QuestionManagement.refreshStaticQuestionBank())
            nextQuestion();
        else
            refreshDisplay();

        frmAnswer.resetQuiz();
    }

    private void nextQuestion()
    {
        QuestionManagement.getStaticQuestionBank().newQuestion();
        refreshDisplay();
    }

    private void refreshDisplay()
    {
        if (QuestionManagement.getStaticQuestionBank().count() > 0)
        {
            lblQuestion.setText(QuestionManagement.getStaticQuestionBank().getCurrentQuestionText());
            retryCount = 0;
            frmAnswer.setMultipleChoices(QuestionManagement.getStaticQuestionBank());
            readyForAnswer();
        }
        else
        {
            lblQuestion.setText("");
            lblResponse.setText(R.string.no_questions);
            canSubmit = false;
            lblResponse.setTypeface(null, NORMAL);
            lblResponse.setTextColor(getApplicationContext().getTheme().obtainStyledAttributes(new int[]{
                    android.R.attr.textColorTertiary
            }).getColor(0, 0));
            frmAnswer.onNoQuestions();
        }
        frmAnswer.updateScore(totalCorrect, totalQuestions);
    }

    private void checkAnswer(String answer)
    {
        if (canSubmit && !answer.isEmpty())
        {
            canSubmit = false;
            boolean isGetNewQuestion = true;

            if (QuestionManagement.getStaticQuestionBank().checkCurrentAnswer(answer))
            {
                lblResponse.setText(R.string.correct_answer);
                lblResponse.setTypeface(null, BOLD);
                lblResponse.setTextColor(ContextCompat.getColor(this, R.color.correct));
                if (retryCount == 0)
                {
                    totalCorrect++;
                    LogDao.reportCorrectAnswer(QuestionManagement.getStaticQuestionBank().getCurrentQuestionKey());
                }
                else if (retryCount <= MAX_RETRIES) //anything over MAX_RETRIES gets no score at all
                {
                    float score = (float) Math.pow(0.5f, retryCount);
                    totalCorrect += score;
                    LogDao.reportRetriedCorrectAnswer(
                            QuestionManagement.getStaticQuestionBank().getCurrentQuestionKey(), score);
                }
                else
                    LogDao.reportRetriedCorrectAnswer(
                            QuestionManagement.getStaticQuestionBank().getCurrentQuestionKey(), 0);
            }
            else
            {
                lblResponse.setText(R.string.incorrect_answer);
                lblResponse.setTypeface(null, BOLD);
                lblResponse.setTextColor(ContextCompat.getColor(this, R.color.incorrect));

                if (OptionsControl
                        .compareStrings(R.string.prefid_on_incorrect, R.string.prefid_on_incorrect_show_answer))
                {
                    lblResponse.append(System.getProperty("line.separator"));
                    lblResponse.append(getResources().getText(R.string.show_correct_answer));
                    lblResponse.append(": ");
                    lblResponse.append(QuestionManagement.getStaticQuestionBank().fetchCorrectAnswer());
                }
                else if (OptionsControl
                        .compareStrings(R.string.prefid_on_incorrect, R.string.prefid_on_incorrect_retry))
                {
                    lblResponse.append(System.getProperty("line.separator"));
                    lblResponse.append(getResources().getText(R.string.try_again));
                    retryCount++;
                    isGetNewQuestion = false;

                    LogDao.reportIncorrectRetry(QuestionManagement.getStaticQuestionBank().getCurrentQuestionKey(),
                            answer);

                    delayHandler.postDelayed(() ->
                    {
                        readyForAnswer();
                        frmAnswer.enableButtons();
                    }, 1000);
                }

                if (isGetNewQuestion)
                    LogDao.reportIncorrectAnswer(QuestionManagement.getStaticQuestionBank().getCurrentQuestionKey(),
                            answer);
            }

            if (isGetNewQuestion)
            {
                totalQuestions++;
                //TODO: Find a way to disable a textbox without closing the touch keyboard
                //txtAnswer.setEnabled(false);
                delayHandler.postDelayed(this::nextQuestion, 1000);
            }
        }
    }

    private void readyForAnswer()
    {
        if (OptionsControl.getBoolean(R.string.prefid_multiple_choice))
            if (QuestionManagement.getStaticQuestionBank().isCurrentQuestionVocab())
                lblResponse.setText(R.string.request_vocab_multiple_choice);
            else
                lblResponse.setText(R.string.request_kana_multiple_choice);
        else
        {
            if (QuestionManagement.getStaticQuestionBank().isCurrentQuestionVocab())
                lblResponse.setText(R.string.request_vocab_text_input);
            else
                lblResponse.setText(R.string.request_kana_text_input);

            frmAnswer.readyForTextAnswer();
        }
        canSubmit = true;
        lblResponse.setTypeface(null, NORMAL);
        lblResponse.setTextColor(getApplicationContext().getTheme().obtainStyledAttributes(new int[]{
                android.R.attr.textColorTertiary
        }).getColor(0, 0));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Class destination;
        int result = 0;

        switch (item.getItemId())
        {
            case R.id.mnuSelection:
                destination = QuestionSelection.class;
                result = 1;
                break;
            case R.id.mnuReference:
                destination = ReferenceScreen.class;
                break;
            case R.id.mnuOptions:
                destination = OptionsScreen.class;
                result = 1;
                break;
            case R.id.mnuLogs:
                destination = LogView.class;
                break;
            case R.id.mnuAbout:
                destination = AboutScreen.class;
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        startActivityForResult(new Intent(this, destination), result);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == 1)
        {
            resetQuiz();
        }
    }
}
