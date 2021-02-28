package com.company;

import java.io.*;

public class WordsReader {
    
    private Reader reader = null;

    public Reader read(String fileName) {
        try {
        reader = new InputStreamReader(new FileInputStream(fileName));
        } catch (IOException e){
            System.err.println("Error while reading file: " + e.getLocalizedMessage());
        }
        return reader;
    }
}

