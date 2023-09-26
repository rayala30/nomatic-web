package com.rayala30.nomatic.client.matchmaker.model.archive.fileio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextFileStorage implements BasicFileStorage {

    private File filename;

    @Override
    public void writeContentsToFile(String contents, String fileName) throws FileStorageException {
        //Example: writing to a file with a PrintWriter
        try (PrintWriter printWriter = new PrintWriter(filename)) {
            printWriter.print(contents);
        } catch (FileNotFoundException e) {
            throw new FileStorageException("Can't write to " + filename, e);
        }

    }

    @Override
    public String readContentsOfFile(String filename) throws FileStorageException {
        String contents = "";
        //Example: reading a file with a Scanner
        File inputFile = new File(filename);
        try (Scanner scanner = new Scanner(inputFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                contents += line + "\n";
            }
        } catch (FileNotFoundException e) {
            throw new FileStorageException("Failed to read from " + filename, e);
        }
        return contents;
    }

}
