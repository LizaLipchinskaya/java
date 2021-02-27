package com.company;

import java.io.*;
import java.util.*;

public class MakeCSV {
    private Reader reader = null;
    private List<Map.Entry<String, Integer>> list = new ArrayList<>();
    private int count = 0;

    public void fileReader(String fileName) {
        try {
        reader = new InputStreamReader(new FileInputStream(fileName));
        } catch (IOException e){
            System.err.println("Error while reading file: " + e.getLocalizedMessage());
        }
    }

    public void parsing() throws IOException {
        int sym;
        StringBuilder str = new StringBuilder();
        HashMap<String, Integer> words = new HashMap<>();
        while ((sym = reader.read()) != -1) {
            if (Character.isLetterOrDigit(sym)) {
                str.append((char)sym);
            }
            else if (!str.isEmpty()) {
                count++;
                String word = str.toString();
                words.put(word, words.getOrDefault(word,0) + 1);
                str.delete(0, str.length());
            }
        }
        if (!str.isEmpty()) {
            count++;
            String word = str.toString();
            words.put(word, words.getOrDefault(word,0) + 1);
            str.delete(0, str.length());
        }

        list = new ArrayList<>(words.entrySet());
        list.sort((a, b) -> (b.getValue() - a.getValue()));
    }

    public void writeFile(String fileName) {
        try {
        Writer writer = new OutputStreamWriter(new FileOutputStream(fileName));

        for(Map.Entry<String, Integer> pair : list) {
            writer.write(String.format("%s, %d, %d%n", pair.getKey(), pair.getValue(),
                    (pair.getValue() * 100) / count));
        }
        writer.close();
        } catch (IOException e) {
            System.err.println("Error while writing file: " + e.getLocalizedMessage());
        }
    }
}

