package com.company;

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Reader reader = null;
        final String inputFile = args[0];
        try {
            reader = new InputStreamReader(new FileInputStream(inputFile));

            int sym;
            StringBuilder str = new StringBuilder();
            HashMap<String, Integer> words = new HashMap<>();
            int count = 0;
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

            List<Map.Entry<String, Integer>> list = new ArrayList<>(words.entrySet());
            list.sort((a, b) -> (b.getValue() - a.getValue()));

            Writer writer = new OutputStreamWriter(new FileOutputStream(args[1]));

            for(Map.Entry<String, Integer> pair : list) {
                writer.write(String.format("%s, %d, %d%n", pair.getKey(), pair.getValue(),
                        (pair.getValue() * 100) / count));
            }
            writer.close();
        }
        catch (IOException e) {
            System.err.println("Error while reading file: " + e.getLocalizedMessage());
        }
        finally {
            if (null != reader) {
                try {
                    reader.close();
                }
                catch (IOException e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }
}
