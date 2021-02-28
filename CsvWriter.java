package com.company;

import java.io.*;
import java.util.*;

public class CsvWriter {
    final int finalCount;
    final List<Map.Entry<String, Integer>> finalList;
    CsvWriter (int count, List<Map.Entry<String, Integer>> list) {
        this.finalCount = count;
        this.finalList = list;
    }

    public void write(String outputFile) {
        try {
            Writer writer = new OutputStreamWriter(new FileOutputStream(outputFile));

            for(Map.Entry<String, Integer> pair : finalList) {
                writer.write(String.format("%s, %d, %d%n", pair.getKey(), pair.getValue(),
                        (pair.getValue() * 100) / finalCount));
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("Error while writing file: " + e.getLocalizedMessage());
        }
    }
}
