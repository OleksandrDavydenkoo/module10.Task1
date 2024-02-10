package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        printValidPhoneNumbers("file.txt");
    }

    private static void printValidPhoneNumbers(String filename) {
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (isValidPhoneNumber(line)) {
                    System.out.println(line);
                }
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isValidPhoneNumber(String phoneNumber) {
        String regex = "(\\d{3}-\\d{3}-\\d{4})|(\\(\\d{3}\\) \\d{3}-\\d{4})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}