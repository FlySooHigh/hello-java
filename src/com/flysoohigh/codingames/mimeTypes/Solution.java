package com.flysoohigh.codingames.mimeTypes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("src//com//flysoohigh//codingames//mimeTypes//input.txt"));
        int elemNum = in.nextInt(); // Number of elements which make up the association table.
        int fileNum = in.nextInt(); // Number fileNum of file names to be analyzed.

        HashMap<String, String> extensionToMime = new HashMap<>();

        for (int i = 0; i < elemNum; i++) {
            String ext = in.next().toLowerCase(); // file extension
            String mt = in.next(); // MIME type.
            extensionToMime.put(ext, mt);
        }
        in.nextLine();

        // For each of the fileNum filenames, display on a line the corresponding MIME type. If there is
        // no corresponding type, then display UNKNOWN.
        for (int i = 0; i < fileNum; i++) {
            String fileName = in.nextLine(); // One file name per line.
            int indexOfPeriod = fileName.lastIndexOf(".");
            if (indexOfPeriod != -1) {
                String extension = fileName.substring(indexOfPeriod + 1).toLowerCase();
                System.out.println(extensionToMime.getOrDefault(extension, "UNKNOWN"));
            }
            else {
                System.out.println("UNKNOWN");
            }
        }
    }
}
