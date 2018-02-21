package com.noprestige.kanaquiz.questions;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;

import com.noprestige.kanaquiz.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

abstract class XmlParser
{
    static boolean parseXmlKanaSet(XmlResourceParser parser, Resources resources,
                                   ArrayList<KanaQuestion[][][]> kanaSetList, ArrayList<String> prefIdList,
                                   ArrayList<String> setTitleList, ArrayList<String> setNoDiacriticsTitleList)
            throws XmlPullParserException, IOException, ParseException
    {
        int setNumber = -1;
        String prefId = "";
        String setTitle = "";
        String setNoDiacriticsTitle = null;

        for (int i = 0; i < parser.getAttributeCount(); i++)
        {
            switch (parser.getAttributeName(i))
            {
                case "number":
                    setNumber = parser.getAttributeIntValue(i, -1);
                    break;
                case "prefId":
                    prefId = parseXmlValue(parser, i, resources);
                    break;
                case "setTitle":
                    setTitle = parseXmlValue(parser, i, resources, R.string.set);
                    break;
                case "setNoDiacriticsTitle":
                    setNoDiacriticsTitle = parseXmlValue(parser, i, resources, R.string.set);
            }
        }

        if (setNumber < 0)
            throw new ParseException("setNumber < 0", 0);

        while (kanaSetList.size() <= setNumber)
        {
            kanaSetList.add(new KanaQuestion[Diacritic.values().length][2][]);
            prefIdList.add("");
            setTitleList.add("");
            setNoDiacriticsTitleList.add("");
        }

        if (setNoDiacriticsTitle == null)
            setNoDiacriticsTitle = setTitle;

        prefIdList.set(setNumber, prefId);
        setTitleList.set(setNumber, setTitle);
        setNoDiacriticsTitleList.set(setNumber, setNoDiacriticsTitle);

        ArrayList<KanaQuestion> currentSet = new ArrayList<>();

        for (int eventType = parser.getEventType(); eventType != XmlPullParser.END_DOCUMENT; eventType = parser.next())
        {
            if (eventType == XmlPullParser.START_TAG)
            {
                if (parser.getName().equalsIgnoreCase("Section"))
                    parseXmlKanaSubsection(parser, resources, kanaSetList, setNumber);

                else if (parser.getName().equalsIgnoreCase("KanaQuestion"))
                    currentSet.add(parseXmlKanaQuestion(parser, resources));
            }

            else if (eventType == XmlPullParser.END_TAG && parser.getName().equalsIgnoreCase("KanaSet"))
            {
                parseXmlStoreSet(currentSet, kanaSetList, setNumber, Diacritic.NO_DIACRITIC, false);
                return true;
            }
        }
        throw new ParseException("Missing KanaSet Closing Tag", 0);
    }

    static private boolean parseXmlKanaSubsection(XmlResourceParser parser, Resources resources,
                                                  ArrayList<KanaQuestion[][][]> kanaSetList,
                                                  int setNumber)
            throws XmlPullParserException, IOException, ParseException
    {
        Diacritic diacritics = null;
        boolean isDigraphs = false;

        ArrayList<KanaQuestion> currentSet = new ArrayList<>();

        for (int i = 0; i < parser.getAttributeCount(); i++)
        {
            switch (parser.getAttributeName(i))
            {
                case "diacritics":
                    diacritics = Diacritic.valueOf(parser.getAttributeValue(i));
                    break;
                case "digraphs":
                    isDigraphs = parser.getAttributeBooleanValue(i, false);
            }
        }

        for (int eventType = parser.getEventType(); eventType != XmlPullParser.END_DOCUMENT; eventType = parser.next())
        {
            if (eventType == XmlPullParser.START_TAG && parser.getName().equalsIgnoreCase("KanaQuestion"))
                currentSet.add(parseXmlKanaQuestion(parser, resources));

            else if (eventType == XmlPullParser.END_TAG && parser.getName().equalsIgnoreCase("Section"))
            {
                parseXmlStoreSet(currentSet, kanaSetList, setNumber, diacritics, isDigraphs);
                return true;
            }
        }
        throw new ParseException("Missing Section Closing Tag", 0);
    }

    static private void parseXmlStoreSet(ArrayList<KanaQuestion> currentSet, ArrayList<KanaQuestion[][][]> kanaSetList,
                                         int setNumber, Diacritic diacritics, boolean isDigraphs)
    {
        KanaQuestion[] currentSetArray = new KanaQuestion[currentSet.size()];
        currentSet.toArray(currentSetArray);

        KanaQuestion[][][] pulledArray = kanaSetList.get(setNumber);
        pulledArray[diacritics.ordinal()][isDigraphs ? 1 : 0] = currentSetArray;
        kanaSetList.set(setNumber, pulledArray);
    }

    static private KanaQuestion parseXmlKanaQuestion(XmlResourceParser parser, Resources resources)
            throws ParseException
    {
        String thisQuestion = "";
        String thisAnswer = "";
        String thisAltAnswer = null;
        for (int i = 0; i < parser.getAttributeCount(); i++)
        {
            switch (parser.getAttributeName(i))
            {
                case "question":
                    thisQuestion = parseXmlValue(parser, i, resources);
                    break;
                case "answer":
                    thisAnswer = parseXmlValue(parser, i, resources);
                    break;
                case "altAnswer":
                    thisAltAnswer = parseXmlValue(parser, i, resources);
            }
        }
        if (thisQuestion == null || thisAnswer == null)
            throw new ParseException("Missing Section Closing Tag", 0);
        else if (thisAltAnswer == null)
            return new KanaQuestion(thisQuestion, thisAnswer);
        else
            return new KanaQuestion(thisQuestion, new String[]{thisAnswer, thisAltAnswer});
    }

    static private String parseXmlValue(XmlResourceParser parser, int index, Resources resources)
    {
        return parseXmlValue(parser, index, resources, 0);
    }

    static private String parseXmlValue(XmlResourceParser parser, int index, Resources resources, int stringResource)
    {
        int refId = parser.getAttributeResourceValue(index, 0);
        return (refId == 0) ? parser.getAttributeValue(index) :
                (stringResource == 0) ? resources.getString(refId) :
                        resources.getString(refId, resources.getString(stringResource));
    }
}
