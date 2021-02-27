package com.company;

import java.lang.*;

import static com.company.Сonstants.InputFileNameIndex;
import static com.company.Сonstants.OutputFileNameIndex;

public class Main {

    public static void main(String[] args) {
        try {
            MakeCSV makeCSV = new MakeCSV();
            makeCSV.fileReader(args[InputFileNameIndex]);
            makeCSV.parsing();
            makeCSV.writeFile(args[OutputFileNameIndex]);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
