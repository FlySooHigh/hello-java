package com.flysoohigh.codingames.ascii;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String args[]) throws FileNotFoundException {

        Scanner in = new Scanner(new File("src//com//flysoohigh//codingames//ascii//test.txt"));
        int ascLetterLen = in.nextInt();
        int ascLetterHt = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        String wordToAsc = in.nextLine();
        String nextRow = in.nextLine();
        int firstRowLen = nextRow.length();

        char[][] matrix = asciiToMatrix(in, ascLetterHt, nextRow, firstRowLen);
        StringBuilder toPrint = prepareWordToAsc(wordToAsc);
        HashMap<Character, Integer> dictionary = getCharacterIntegerHashMap();
        printAscRepresentation(ascLetterLen, ascLetterHt, matrix, toPrint, dictionary);
    }

    /**
     * Save ASCII alphabet representation to 2D array
     */
    private static char[][] asciiToMatrix(Scanner in, int ascLetterHt, String nextRow, int firstRowLen) {
        char[][] matrix = new char[ascLetterHt][firstRowLen + 1];

        for (int i = 0; i < ascLetterHt; i++) {
            for (int j = 0; j < nextRow.length(); j++) {
                matrix[i][j] = nextRow.charAt(j);
            }
            if (nextRow.length() < firstRowLen + 1){
                for (int k = 0; k < firstRowLen + 1 - nextRow.length(); k++) {
                    matrix[i][nextRow.length() + k] = ' ';
                }
            }
            if (in.hasNextLine()) {
                nextRow = in.nextLine();
            }
        }
        return matrix;
    }

    /**
     * Print word in ASCII representation, for example: E - ***
     *                                                      *
     *                                                      **
     *                                                      *
     *                                                      ***
     */
    private static void printAscRepresentation(int ascLetterLen, int ascLetterHt, char[][] matrix,
                                               StringBuilder toPrint, HashMap<Character, Integer> dictionary) {
        for (int i = 0; i < ascLetterHt; i++) {
            for (char letter : toPrint.toString().toCharArray()) {
                Integer letterPosition = dictionary.get(letter);
                int endPoint = letterPosition * ascLetterLen;
                int startPoint = endPoint - ascLetterLen;
                for (int k = startPoint; k < endPoint; k++) {
                    System.out.print(matrix[i][k]);
                }
            }
            System.out.println();
        }
    }

    /**
     * Convert all chars to capital ones and insert '?' instead of any other symbols
     */
    private static StringBuilder prepareWordToAsc(String wordToAsc) {
        wordToAsc = wordToAsc.toUpperCase();
        StringBuilder toPrint = new StringBuilder();
        for (char ch: wordToAsc.toCharArray()) {
            int intRep = (int)ch;
            if ((intRep >=65 && intRep <=90)){
                toPrint.append(ch);
            }
            else {
                toPrint.append("?");
            }
        }
        return toPrint;
    }

    /*
     * Utility method
     * Map capital letters to integers: A-1, B-2, ... Z-26, ?-27
     */
    private static HashMap<Character, Integer> getCharacterIntegerHashMap() {
        HashMap<Character, Integer> dictionary = new HashMap<>();
        int j = 1;
        for (int i = 65; i <= 90 ; i++) {
            dictionary.put((char)i, j);
            j++;
        }
        dictionary.put("?".charAt(0), 27);
        return dictionary;
    }
}
