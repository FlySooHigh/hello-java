package com.flysoohigh.codingames.unary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
        private static String messageFromChuckNorris = "0 0 00 0000 0 0000 00 0 0 0 00 000 0 000 00 0 0 0 00 0 0 000 00 " +
                "000 0 0000 00 0 0 0 00 0 0 00 00 0 0 0 00 00000 0 0 00 00 0 000 00 0 0 00 00 0 0 0000000 00 00 0 0 00 " +
                "0 0 000 00 00 0 0 00 0 0 00 00 0 0 0 00 00 0 0000 00 00 0 00 00 0 0 0 00 00 0 000 00 0 0 0 00 00000 0 " +
                "00 00 0 0 0 00 0 0 0000 00 00 0 0 00 0 0 00000 00 00 0 000 00 000 0 0 00 0 0 00 00 0 0 000000 00 0000" +
                " 0 0000 00 00 0 0 00 0 0 00 00 00 0 0 00 000 0 0 00 00000 0 00 00 0 0 0 00 000 0 00 00 0000 0 0000 00" +
                " 00 0 00 00 0 0 0 00 000000 0 00 00 00 0 0 00 00 0 0 00 00000 0 00 00 0 0 0 00 0 0 0000 00 00 0 0 00 0" +
                " 0 00000 00 00 0 0000 00 00 0 00 00 0 0 000 00 0 0 0 00 00 0 0 00 000000 0 00 00 00000 0 0 00 00000 0" +
                " 00 00 0000 0 000 00 0 0 000 00 0 0 00 00 00 0 0 00 000 0 0 00 00000 0 000 00 0 0 00000 00 0 0 0 00 000" +
                " 0 00 00 0 0 0 00 00 0 0000 00 0 0 0 00 00 0 00 00 00 0 0 00 0 0 0 00 0 0 0 00 00000 0 000 00 00 0 00000" +
                " 00 0000 0 00 00 0000 0 000 00 000 0 0000 00 00 0 0 00 0 0 0 00 0 0 0 00 0 0 000 00 0";

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src//com//flysoohigh//codingames//unary//input.txt"));
        String strInput = scanner.nextLine();

        StringBuilder binary = getBinaryRep(strInput);
        StringBuilder unary = binaryToUnary(binary);
        System.out.println(unary.toString());

        // Optional part - to decode message from Chuck Norris
        unary.setLength(0);
        unary.append(messageFromChuckNorris);
        StringBuilder binaryRep = unaryToBinary(unary);
        binarytoASCII(binaryRep);
    }

    /**
     * Convert binary to ASCII (7-bit)
     */
    private static void binarytoASCII(StringBuilder unaryToBinary) {
        for (int k = 0; k < unaryToBinary.length(); k += 7) {
            String sevenBits = unaryToBinary.substring(k, k + 7);
            System.out.print((char)Integer.parseInt(sevenBits,2));
        }
    }

    /**
     * Convert unary to binary
     */
    private static StringBuilder unaryToBinary(StringBuilder unary) {
        StringBuilder unaryToBinary = new StringBuilder();
        int i = 0;
        int j = 0;
        while (i < unary.length()){
            while (unary.charAt(i) != ' '){
                j++;
                i++;
            }
            if (j == 1){
                unaryToBinary.append('1');
                j = 0;
                i += 2;
                while (i < unary.length() && unary.charAt(i) != ' '){
                    unaryToBinary.append('1');
                    i++;
                }
                i++;
            }
            else{
                unaryToBinary.append('0');
                j = 0;
                i += 2;
                while (i < unary.length() && unary.charAt(i) != ' '){
                    unaryToBinary.append('0');
                    i++;
                }
                i++;
            }
        }
        return unaryToBinary;
    }

    /**
     * Convert binary to unary
     * @param binary representation to convert to unary
     * @return unary representation
     */
    private static StringBuilder binaryToUnary(StringBuilder binary) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < binary.length()){
            if (binary.charAt(i) == '1'){
                int j = 0;
                while (i < binary.length() &&  binary.charAt(i) == '1'){
                    j++;
                    i++;
                }
                result.append(substitute("1", j));
            }
            else{
                int k = 0;
                while (i < binary.length() && binary.charAt(i) == '0'){
                    k++;
                    i++;
                }
                result.append(substitute("0", k));
            }
        }
        return result;
    }

    /**
     * @param strInput input string
     * @return binary representation of ASCII symbols (7-bit)
     */
    private static StringBuilder getBinaryRep(String strInput) {
        byte[] bytes = strInput.getBytes();
        StringBuilder binary = new StringBuilder();
        for (byte b : bytes)
        {
            int val = b;
            for (int i = 0; i < 7; i++)
            {
                binary.append((val & 64) == 0 ? 0 : 1);
                val <<= 1;
            }
        }
        return binary;
    }

    /**
     * Utility method
     * @param s "1" or "0"
     * @param k number of ones or zeros
     * @return Needed sequence: 1 - 0 0, 11 - 0 00, 111 - 0 000, ... ;
     *                          0 - 00 0, 00 - 00 00, 000 - 00 000, ...;
     */
    private static String substitute(String s, int k) {
        StringBuilder result = new StringBuilder();
        if (s.equals("1")) {
            result.append("0 0");
        }
        else{
            result.append("00 0");
        }
        for (int i = 1; i < k; i++) {
            result.append("0");
        }
        result.append(" ");
        return result.toString();
    }
}
