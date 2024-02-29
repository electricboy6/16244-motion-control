package org.electricboy6.internal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private final String filename;
    private final File logFile;
    public Logger(String filename) {
        this.filename = filename;
        logFile = new File(this.filename);
        logFile.delete();
    }
    public void addLine(String line) {
        try {
            logFile.createNewFile();
        } catch (IOException e) {
            System.err.println("Unable to create log!");
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true));
            writer.append(line);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.err.println("Unable to write to log!");
        }
    }
}
