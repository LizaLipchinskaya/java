package com.company;

import java.io.Reader;
import java.lang.*;

import static com.company.Сonstants.*;

public class Main {

    public static void main(String[] args) {
        try {
            WordsReader wordsReader = new WordsReader();
            Reader reader = wordsReader.read(args[InputFileNameIndex]);
            WordsCountCalculator wordsCountCalculator = new WordsCountCalculator();
            wordsCountCalculator.calculate(reader);
            CsvWriter csvWriter = new CsvWriter(wordsCountCalculator.getCount(), wordsCountCalculator.getList());
            csvWriter.write(args[OutputFileNameIndex]);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
