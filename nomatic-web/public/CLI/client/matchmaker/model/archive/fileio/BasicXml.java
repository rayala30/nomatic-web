package com.rayala30.nomatic.client.matchmaker.model.archive.fileio;

/**
 * The BasicXml interface is implemented by classes that can serialize and deserialize
 * their internal state using a limited subset of XML.
 */
public interface BasicXml {

    void initializeFromXml(String xml);

    String getInnerXml();
}

