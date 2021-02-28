package com.company;

import java.io.Reader;
import java.util.*;

public class WordsCountCalculator {
    protected int count = 0;
    protected List<Map.Entry<String, Integer>> list = new ArrayList<>();

    public int getCount() {
        return count;
    }

    public List<Map.Entry<String, Integer>> getList() {
        return list;
    }

    public void calculate(Reader text) throws Exception {
        int sym;
        StringBuilder str = new StringBuilder();
        HashMap<String, Integer> words = new HashMap<>();
        while ((sym = text.read()) != -1) {
            if (Character.isLetterOrDigit(sym)) {
                str.append((char) sym);
            } else if (!str.isEmpty()) {
                count++;
                String word = str.toString();
                words.put(word, words.getOrDefault(word, 0) + 1);
                str.delete(0, str.length());
            }
        }
        if (!str.isEmpty()) {
            count++;
            String word = str.toString();
            words.put(word, words.getOrDefault(word, 0) + 1);
            str.delete(0, str.length());
        }
        list = new ArrayList<>(words.entrySet());
        list.sort((a, b) -> (b.getValue() - a.getValue()));
    }
}
