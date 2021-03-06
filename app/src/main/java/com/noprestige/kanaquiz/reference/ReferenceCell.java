package com.noprestige.kanaquiz.reference;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.noprestige.kanaquiz.R;
import com.noprestige.kanaquiz.questions.Question;

public class ReferenceCell extends View
{
    private String subject;
    private String description;

    private TextPaint subjectPaint = new TextPaint();
    private TextPaint descriptionPaint = new TextPaint();

    private float subjectXPoint;
    private float subjectYPoint;
    private float descriptionXPoint;
    private float descriptionYPoint;

    private float subjectWidth;
    private float descriptionWidth;

    private float subjectHeight;
    private float descriptionHeight;

    private static TypedArray defaultAttributes;

    public ReferenceCell(Context context)
    {
        super(context);
        init(null, 0);
    }

    public ReferenceCell(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init(attrs, 0);
    }

    public ReferenceCell(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle)
    {
        Context context = getContext();

        if (defaultAttributes == null)
            defaultAttributes = context.getTheme().obtainStyledAttributes(new int[]{android.R.attr.textColorTertiary});

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ReferenceCell, defStyle, 0);

        setSubject(a.getString(R.styleable.ReferenceCell_subject));
        setDescription(a.getString(R.styleable.ReferenceCell_description));
        setSubjectSize(a.getDimension(R.styleable.ReferenceCell_subjectSize,
                getResources().getDimension(R.dimen.defaultReferenceSubjectSize)));
        setDescriptionSize(a.getDimension(R.styleable.ReferenceCell_descriptionSize,
                getResources().getDimension(R.dimen.defaultReferenceDescriptionSize)));
        setColour(a.getColor(R.styleable.ReferenceCell_colour, defaultAttributes.getColor(0, 0)));

        a.recycle();

        setOnLongClickListener(view -> copyItem());

        subjectPaint.setAntiAlias(true);
        descriptionPaint.setAntiAlias(true);
    }

    private boolean copyItem()
    {
        //TODO: Allow the ability to select and copy multiple items at once.
        String data = subject + " - " + description;
        ClipboardManager clipboard = (ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
        clipboard.setPrimaryClip(ClipData.newPlainText("Kana Reference", data));

        String message = "'" + data + "' " + getContext().getResources().getString(R.string.clipboard_message);
        Snackbar.make(this, message, Snackbar.LENGTH_LONG).show();
        return true;
    }

    @Override
    protected void onSizeChanged(int width, int height, int oldWidth, int oldHeight)
    {
        super.onSizeChanged(width, height, oldWidth, oldHeight);

        int contentWidth = width - getPaddingLeft() - getPaddingRight();
        int contentHeight = height - getPaddingTop() - getPaddingBottom();

        float fullHeight = subjectHeight + descriptionHeight;

        subjectXPoint = getPaddingLeft() + ((contentWidth - subjectWidth) / 2);
        subjectYPoint = getPaddingTop() + (((contentHeight - fullHeight) / 2) - subjectPaint.getFontMetrics().ascent);
        descriptionXPoint = getPaddingLeft() + ((contentWidth - descriptionWidth) / 2);
        descriptionYPoint =
                getPaddingTop() + (((contentHeight + fullHeight) / 2) - descriptionPaint.getFontMetrics().descent);
    }

    //ref: http://stackoverflow.com/questions/13273838/onmeasure-wrap-content-how-do-i-know-the-size-to-wrap
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        int desiredWidth = Math.round(Math.max(subjectWidth, descriptionWidth)) + getPaddingLeft() + getPaddingRight();
        int desiredHeight = Math.round(subjectHeight + descriptionHeight) + getPaddingTop() + getPaddingBottom();

        int width = calculateSize(widthMeasureSpec, desiredWidth);
        int height = calculateSize(heightMeasureSpec, desiredHeight);

        setMeasuredDimension(width, height);
    }

    private static int calculateSize(int measureSpec, int desired)
    {
        switch (MeasureSpec.getMode(measureSpec))
        {
            case MeasureSpec.EXACTLY:
                return MeasureSpec.getSize(measureSpec);
            case MeasureSpec.AT_MOST:
                return Math.min(desired, MeasureSpec.getSize(measureSpec));
            case MeasureSpec.UNSPECIFIED:
            default:
                return desired;
        }
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        canvas.drawText(subject, subjectXPoint, subjectYPoint, subjectPaint);
        canvas.drawText(description, descriptionXPoint, descriptionYPoint, descriptionPaint);
    }

    public String getSubject()
    {
        return subject;
    }

    public float getSubjectSize()
    {
        return subjectPaint.getTextSize();
    }

    public String getDescription()
    {
        return description;
    }

    public float getDescriptionSize()
    {
        return descriptionPaint.getTextSize();
    }

    public int getColour()
    {
        return subjectPaint.getColor();
        //return descriptionPaint.getColor();
    }

    public void setSubject(String subject)
    {
        this.subject = (subject == null) ? "" : subject;
        subjectWidth = subjectPaint.measureText(this.subject);
    }

    public void setSubjectSize(float subjectSize)
    {
        subjectPaint.setTextSize(subjectSize);
        subjectHeight = subjectPaint.getFontMetrics().descent - subjectPaint.getFontMetrics().ascent;
        subjectWidth = subjectPaint.measureText(subject);
    }

    public void setDescription(String description)
    {
        this.description = (description == null) ? "" : description;
        descriptionWidth = descriptionPaint.measureText(this.description);
    }

    public void setDescriptionSize(float descriptionSize)
    {
        descriptionPaint.setTextSize(descriptionSize);
        descriptionHeight = descriptionPaint.getFontMetrics().descent - descriptionPaint.getFontMetrics().ascent;
        descriptionWidth = descriptionPaint.measureText(description);
    }

    public void setColour(int colour)
    {
        subjectPaint.setColor(colour);
        descriptionPaint.setColor(colour);
    }

    public static TableRow buildSpecialRow(Context context, Question[] questions)
    {
        if (questions == null)
            return null;
        else
        {
            TableRow row = new TableRow(context);

            switch (questions.length)
            {
                case 1:
                    row.addView(new View(context));
                    row.addView(new View(context));
                    row.addView(questions[0].generateReference(context));
                    break;
                case 2:
                    row.addView(questions[0].generateReference(context));
                    row.addView(new View(context));
                    row.addView(new View(context));
                    row.addView(new View(context));
                    row.addView(questions[1].generateReference(context));
                    break;
                case 3:
                    row.addView(questions[0].generateReference(context));
                    row.addView(new View(context));
                    row.addView(questions[1].generateReference(context));
                    row.addView(new View(context));
                    row.addView(questions[2].generateReference(context));
                    break;
                case 4:
                    row.addView(questions[0].generateReference(context));
                    row.addView(questions[1].generateReference(context));
                    row.addView(new View(context));
                    row.addView(questions[2].generateReference(context));
                    row.addView(questions[3].generateReference(context));
                    break;
                default:
                    for (Question question : questions)
                        row.addView(question.generateReference(context));
            }
            return row;
        }
    }

    public static TableRow buildRow(Context context, Question[] questions)
    {
        if (questions == null)
            return null;
        else
        {
            TableRow row = new TableRow(context);

            for (Question question : questions)
                row.addView(question.generateReference(context));

            return row;
        }
    }

    static TextView buildHeader(Context context, int title)
    {
        TextView header = new TextView(context);
        header.setText(title);
        header.setLayoutParams(
                new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        header.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.headerTextSize));
        header.setPadding(0, context.getResources().getDimensionPixelSize(R.dimen.headerTopPadding), 0,
                context.getResources().getDimensionPixelSize(R.dimen.headerBottomPadding));
        header.setTypeface(header.getTypeface(), Typeface.BOLD);
        header.setAllCaps(true);
        return header;
    }
}
