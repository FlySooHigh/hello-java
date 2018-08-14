package com.flysoohigh.codingames.brackets;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("src//com//flysoohigh//codingames//brackets//test.txt"));
        String expression = in.next();
        System.out.println(bracketChecker(expression));
    }

    private static boolean bracketChecker(String expression) {
        Set<Character> closingBrackets = new HashSet<>();
        closingBrackets.add(')');
        closingBrackets.add('}');
        closingBrackets.add(']');
        Set<Character> openingBrackets = new HashSet<>();
        openingBrackets.add('(');
        openingBrackets.add('{');
        openingBrackets.add('[');
        Stack<Character> brackets = new Stack<>();
        for (Character bracket : expression.toCharArray()) {
            if (openingBrackets.contains(bracket)) {
                brackets.push(bracket);
            } else {
                if (closingBrackets.contains(bracket)) {
                    if (brackets.isEmpty()) {
                        return false;
                    } else {
                        Character popped = brackets.pop();
                        switch (bracket) {
                            case ']': if (popped != '[') {return false;}break;
                            case ')': if (popped != '(') {return false;}break;
                            case '}': if (popped != '{') {return false;}break;
                        }
                    }
                }
            }
        }
        return brackets.isEmpty();
    }
}