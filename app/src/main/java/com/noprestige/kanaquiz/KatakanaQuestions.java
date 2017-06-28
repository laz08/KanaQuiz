package com.noprestige.kanaquiz;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import static android.util.TypedValue.COMPLEX_UNIT_SP;

abstract class KatakanaQuestions
{
    private static final KanaQuestion[] KANA_SET_1 = {
            new KanaQuestion('ア', "a"),
            new KanaQuestion('イ', "i"),
            new KanaQuestion('ウ', "u"),
            new KanaQuestion('エ', "e"),
            new KanaQuestion('オ', "o")};

    private static final KanaQuestion[] KANA_SET_2_BASE = {
            new KanaQuestion('カ', "ka"),
            new KanaQuestion('キ', "ki"),
            new KanaQuestion('ク', "ku"),
            new KanaQuestion('ケ', "ke"),
            new KanaQuestion('コ', "ko")};

    private static final KanaQuestion[] KANA_SET_2_DAKUTEN = {
            new KanaQuestion('ガ', "ga"),
            new KanaQuestion('ギ', "gi"),
            new KanaQuestion('グ', "gu"),
            new KanaQuestion('ゲ', "ge"),
            new KanaQuestion('ゴ', "go")};

    private static final KanaQuestion[] KANA_SET_2_BASE_DIGRAPHS = {
            new KanaQuestion("キャ", "kya"),
            new KanaQuestion("キュ", "kyu"),
            new KanaQuestion("キョ", "kyo")};

    private static final KanaQuestion[] KANA_SET_2_DAKUTEN_DIGRAPHS = {
            new KanaQuestion("ギャ", "gya"),
            new KanaQuestion("ギュ", "gyu"),
            new KanaQuestion("ギョ", "gyo")};

    private static final KanaQuestion[] KANA_SET_3_BASE = {
            new KanaQuestion('サ', "sa"),
            new KanaQuestion('シ', "shi"),
            new KanaQuestion('ス', "su"),
            new KanaQuestion('セ', "se"),
            new KanaQuestion('ソ', "so")};

    private static final KanaQuestion[] KANA_SET_3_DAKUTEN = {
            new KanaQuestion('ザ', "za"),
            new KanaQuestion('ジ', "ji"),
            new KanaQuestion('ズ', "zu"),
            new KanaQuestion('ゼ', "ze"),
            new KanaQuestion('ゾ', "zo")};

    private static final KanaQuestion[] KANA_SET_3_BASE_DIGRAPHS = {
            new KanaQuestion("シャ", "sha"),
            new KanaQuestion("シュ", "shu"),
            new KanaQuestion("ショ", "sho")};

    private static final KanaQuestion[] KANA_SET_3_DAKUTEN_DIGRAPHS = {
            new KanaQuestion("ジャ", new String[] {"ja", "jya"}),
            new KanaQuestion("ジュ", new String[] {"ju", "jyu"}),
            new KanaQuestion("ジョ", new String[] {"jo", "jyo"})};

    private static final KanaQuestion[] KANA_SET_4_BASE = {
            new KanaQuestion('タ', "ta"),
            new KanaQuestion('チ', "chi"),
            new KanaQuestion('ツ', "tsu"),
            new KanaQuestion('テ', "te"),
            new KanaQuestion('ト', "to")};

    private static final KanaQuestion[] KANA_SET_4_DAKUTEN = {
            new KanaQuestion('ダ', "da"),
            new KanaQuestion('ヂ', "ji"),
            new KanaQuestion('ヅ', "zu"),
            new KanaQuestion('デ', "de"),
            new KanaQuestion('ド', "do")};

    private static final KanaQuestion[] KANA_SET_4_BASE_DIGRAPHS = {
            new KanaQuestion("チャ", "cha"),
            new KanaQuestion("チュ", "chu"),
            new KanaQuestion("チョ", "cho")};

    private static final KanaQuestion[] KANA_SET_4_DAKUTEN_DIGRAPHS = {
            new KanaQuestion("ヂャ", new String[] {"ja", "dzya"}),
            new KanaQuestion("ヂュ", new String[] {"ju", "dzyu"}),
            new KanaQuestion("ヂョ", new String[] {"jo", "dzyo"})};

    private static final KanaQuestion[] KANA_SET_5 = {
            new KanaQuestion('ナ', "na"),
            new KanaQuestion('ニ', "ni"),
            new KanaQuestion('ヌ', "nu"),
            new KanaQuestion('ネ', "ne"),
            new KanaQuestion('ノ', "no")};

    private static final KanaQuestion[] KANA_SET_5_DIGRAPHS = {
            new KanaQuestion("ニャ", "nya"),
            new KanaQuestion("ニュ", "nyu"),
            new KanaQuestion("ニョ", "nyo")};

    private static final KanaQuestion[] KANA_SET_6_BASE = {
            new KanaQuestion('ハ', "ha"),
            new KanaQuestion('ヒ', "hi"),
            new KanaQuestion('フ', new String[] {"fu", "hu"}),
            new KanaQuestion('ヘ', "he"),
            new KanaQuestion('ホ', "ho")};

    private static final KanaQuestion[] KANA_SET_6_DAKUTEN = {
            new KanaQuestion('バ', "ba"),
            new KanaQuestion('ビ', "bi"),
            new KanaQuestion('ブ', "bu"),
            new KanaQuestion('ベ', "be"),
            new KanaQuestion('ボ', "bo")};

    private static final KanaQuestion[] KANA_SET_6_HANDAKETEN = {
            new KanaQuestion('パ', "pa"),
            new KanaQuestion('ピ', "pi"),
            new KanaQuestion('プ', "pu"),
            new KanaQuestion('ペ', "pe"),
            new KanaQuestion('ポ', "po")};

    private static final KanaQuestion[] KANA_SET_6_BASE_DIGRAPHS = {
            new KanaQuestion("ヒャ", "hya"),
            new KanaQuestion("ヒュ", "hyu"),
            new KanaQuestion("ヒョ", "hyo")};

    private static final KanaQuestion[] KANA_SET_6_DAKUTEN_DIGRAPHS = {
            new KanaQuestion("ビャ", "bya"),
            new KanaQuestion("ビュ", "byu"),
            new KanaQuestion("ビョ", "byo")};

    private static final KanaQuestion[] KANA_SET_6_HANDAKETEN_DIGRAPHS = {
            new KanaQuestion("ピャ", "pya"),
            new KanaQuestion("ピュ", "pyu"),
            new KanaQuestion("ピョ", "pyo")};

    private static final KanaQuestion[] KANA_SET_7 = {
            new KanaQuestion('マ', "ma"),
            new KanaQuestion('ミ', "mi"),
            new KanaQuestion('ム', "mu"),
            new KanaQuestion('メ', "me"),
            new KanaQuestion('モ', "mo")};

    private static final KanaQuestion[] KANA_SET_7_DIGRAPHS = {
            new KanaQuestion("ミャ", "mya"),
            new KanaQuestion("ミュ", "myu"),
            new KanaQuestion("ミョ", "myo")};

    private static final KanaQuestion[] KANA_SET_8 = {
            new KanaQuestion('ラ', "ra"),
            new KanaQuestion('リ', "ri"),
            new KanaQuestion('ル', "ru"),
            new KanaQuestion('レ', "re"),
            new KanaQuestion('ロ', "ro")};

    private static final KanaQuestion[] KANA_SET_8_DIGRAPHS = {
            new KanaQuestion("リャ", "rya"),
            new KanaQuestion("リュ", "ryu"),
            new KanaQuestion("リョ", "ryo")};

    private static final KanaQuestion[] KANA_SET_9 = {
            new KanaQuestion('ヤ', "ya"),
            new KanaQuestion('ユ', "yu"),
            new KanaQuestion('ヨ', "yo")};

    private static final KanaQuestion[] KANA_SET_10_W_GROUP = {
            new KanaQuestion('ワ', "wa"),
            new KanaQuestion('ヲ', "wo")};

    private static final KanaQuestion[] KANA_SET_10_N_CONSONANT = {
            new KanaQuestion('ン', "n")};

    private static final int PREFID_1 = R.string.prefid_katakana_1;
    private static final int PREFID_2 = R.string.prefid_katakana_2;
    private static final int PREFID_3 = R.string.prefid_katakana_3;
    private static final int PREFID_4 = R.string.prefid_katakana_4;
    private static final int PREFID_5 = R.string.prefid_katakana_5;
    private static final int PREFID_6 = R.string.prefid_katakana_6;
    private static final int PREFID_7 = R.string.prefid_katakana_7;
    private static final int PREFID_8 = R.string.prefid_katakana_8;
    private static final int PREFID_9 = R.string.prefid_katakana_9;
    private static final int PREFID_10 = R.string.prefid_katakana_10;

    static KanaQuestionBank getQuestionBank()
    {
        KanaQuestionBank questionBank = new KanaQuestionBank();

        boolean isDigraphs = OptionsControl.getBoolean(R.string.prefid_digraphs) && OptionsControl.getBoolean(PREFID_9);
        boolean isDiacritics = OptionsControl.getBoolean(R.string.prefid_diacritics);

        if (OptionsControl.getBoolean(PREFID_1))
            questionBank.addQuestions(KANA_SET_1);
        if (OptionsControl.getBoolean(PREFID_2))
        {
            questionBank.addQuestions(KANA_SET_2_BASE);
            if (isDiacritics)
                questionBank.addQuestions(KANA_SET_2_DAKUTEN);
            if (isDigraphs)
                questionBank.addQuestions(KANA_SET_2_BASE_DIGRAPHS);
            if (isDigraphs && isDiacritics)
                questionBank.addQuestions(KANA_SET_2_DAKUTEN_DIGRAPHS);
        }
        if (OptionsControl.getBoolean(PREFID_3))
        {
            questionBank.addQuestions(KANA_SET_3_BASE);
            if (isDiacritics)
                questionBank.addQuestions(KANA_SET_3_DAKUTEN);
            if (isDigraphs)
                questionBank.addQuestions(KANA_SET_3_BASE_DIGRAPHS);
            if (isDigraphs && isDiacritics)
                questionBank.addQuestions(KANA_SET_3_DAKUTEN_DIGRAPHS);
        }
        if (OptionsControl.getBoolean(PREFID_4))
        {
            questionBank.addQuestions(KANA_SET_4_BASE);
            if (isDiacritics)
                questionBank.addQuestions(KANA_SET_4_DAKUTEN);
            if (isDigraphs)
                questionBank.addQuestions(KANA_SET_4_BASE_DIGRAPHS);
            if (isDigraphs && isDiacritics)
                questionBank.addQuestions(KANA_SET_4_DAKUTEN_DIGRAPHS);
        }
        if (OptionsControl.getBoolean(PREFID_5))
        {
            questionBank.addQuestions(KANA_SET_5);
            if (isDigraphs)
                questionBank.addQuestions(KANA_SET_5_DIGRAPHS);
        }
        if (OptionsControl.getBoolean(PREFID_6))
        {
            questionBank.addQuestions(KANA_SET_6_BASE);
            if (isDiacritics)
                questionBank.addQuestions(KANA_SET_6_DAKUTEN, KANA_SET_6_HANDAKETEN);
            if (isDigraphs)
                questionBank.addQuestions(KANA_SET_6_BASE_DIGRAPHS);
            if (isDigraphs && isDiacritics)
                questionBank.addQuestions(KANA_SET_6_DAKUTEN_DIGRAPHS, KANA_SET_6_HANDAKETEN_DIGRAPHS);

        }
        if (OptionsControl.getBoolean(PREFID_7))
        {
            questionBank.addQuestions(KANA_SET_7);
            if (isDigraphs)
                questionBank.addQuestions(KANA_SET_7_DIGRAPHS);
        }
        if (OptionsControl.getBoolean(PREFID_8))
        {
            questionBank.addQuestions(KANA_SET_8);
            if (isDigraphs)
                questionBank.addQuestions(KANA_SET_8_DIGRAPHS);
        }
        if (OptionsControl.getBoolean(PREFID_9))
            questionBank.addQuestions(KANA_SET_9);
        if (OptionsControl.getBoolean(PREFID_10))
            questionBank.addQuestions(KANA_SET_10_W_GROUP, KANA_SET_10_N_CONSONANT);

        return questionBank;
    }

    static boolean anySelected()
    {
        return (OptionsControl.getBoolean(PREFID_1) ||
                OptionsControl.getBoolean(PREFID_2) ||
                OptionsControl.getBoolean(PREFID_3) ||
                OptionsControl.getBoolean(PREFID_4) ||
                OptionsControl.getBoolean(PREFID_5) ||
                OptionsControl.getBoolean(PREFID_6) ||
                OptionsControl.getBoolean(PREFID_7) ||
                OptionsControl.getBoolean(PREFID_8) ||
                OptionsControl.getBoolean(PREFID_9) ||
                OptionsControl.getBoolean(PREFID_10));
    }

    static TableLayout getReferenceTable(Context context)
    {
        TableLayout layout = new TableLayout(context);

        if (OptionsControl.getBoolean(PREFID_1))
            layout.addView(ReferenceCell.buildRow(context, KANA_SET_1));
        if (OptionsControl.getBoolean(PREFID_2))
            layout.addView(ReferenceCell.buildRow(context, KANA_SET_2_BASE));
        if (OptionsControl.getBoolean(PREFID_3))
            layout.addView(ReferenceCell.buildRow(context, KANA_SET_3_BASE));
        if (OptionsControl.getBoolean(PREFID_4))
            layout.addView(ReferenceCell.buildRow(context, KANA_SET_4_BASE));
        if (OptionsControl.getBoolean(PREFID_5))
            layout.addView(ReferenceCell.buildRow(context, KANA_SET_5));
        if (OptionsControl.getBoolean(PREFID_6))
            layout.addView(ReferenceCell.buildRow(context, KANA_SET_6_BASE));
        if (OptionsControl.getBoolean(PREFID_7))
            layout.addView(ReferenceCell.buildRow(context, KANA_SET_7));
        if (OptionsControl.getBoolean(PREFID_8))
            layout.addView(ReferenceCell.buildRow(context, KANA_SET_8));
        if (OptionsControl.getBoolean(PREFID_9))
            layout.addView(ReferenceCell.buildRow(context, KANA_SET_9));
        if (OptionsControl.getBoolean(PREFID_10))
        {
            layout.addView(ReferenceCell.buildRow(context, KANA_SET_10_W_GROUP));
            layout.addView(ReferenceCell.buildRow(context, KANA_SET_10_N_CONSONANT));
        }

        if (OptionsControl.getBoolean(R.string.prefid_diacritics) &&
                (OptionsControl.getBoolean(PREFID_2) ||
                OptionsControl.getBoolean(PREFID_3) ||
                OptionsControl.getBoolean(PREFID_4) ||
                OptionsControl.getBoolean(PREFID_6)))
        {
            TextView header = new TextView(context);
            header.setText(R.string.diacritics_title);
            header.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            header.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            header.setTextSize(COMPLEX_UNIT_SP, 14);
            header.setPadding(0, Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 14, context.getResources().getDisplayMetrics())),
                    0, Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 14, context.getResources().getDisplayMetrics())));
            header.setTypeface(header.getTypeface(), 1);
            header.setAllCaps(true);
            layout.addView(header);

            if (OptionsControl.getBoolean(PREFID_2))
                layout.addView(ReferenceCell.buildRow(context, KANA_SET_2_DAKUTEN));
            if (OptionsControl.getBoolean(PREFID_3))
                layout.addView(ReferenceCell.buildRow(context, KANA_SET_3_DAKUTEN));
            if (OptionsControl.getBoolean(PREFID_4))
                layout.addView(ReferenceCell.buildRow(context, KANA_SET_4_DAKUTEN));
            if (OptionsControl.getBoolean(PREFID_6))
            {
                layout.addView(ReferenceCell.buildRow(context, KANA_SET_6_DAKUTEN));
                layout.addView(ReferenceCell.buildRow(context, KANA_SET_6_HANDAKETEN));
            }
        }

        return layout;
    }
}
