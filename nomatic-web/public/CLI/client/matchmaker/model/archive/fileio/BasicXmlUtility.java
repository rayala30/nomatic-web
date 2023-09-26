package com.rayala30.nomatic.client.matchmaker.model.archive.fileio;

/**
 * BasicXmlUtility is a class that defines functionality shared by the other
 * utility classes the application uses to process XML.
 */

public abstract class BasicXmlUtility {
    public static String makeOpeningTag(String tagName) {
        return "<" + tagName + ">";
    }

    public static String makeClosingTag(String tagName) {
        return "</" + tagName + ">";
    }
}