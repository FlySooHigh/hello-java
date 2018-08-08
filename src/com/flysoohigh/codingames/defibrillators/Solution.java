package com.flysoohigh.codingames.defibrillators;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    private static final int EARTH_RADUIS_KM = 6371;

    public static void main(String args[]) throws FileNotFoundException {
        Scanner in = new Scanner(new File("src//com//flysoohigh//codingames//defibrilators//input.txt"));

        String longUsStr = in.next();
        Double longUsDeg = Double.valueOf(longUsStr.replace(',','.'));
        double longUsRad = Math.toRadians(longUsDeg);

        String latUsStr = in.next();
        Double latUsDeg = Double.valueOf(latUsStr.replace(',','.'));
        double latUsRad = Math.toRadians(latUsDeg);

        int defibNum = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }

        HashMap<Integer, String> recordNumToFullString = new HashMap<>();
        HashMap<Double, Integer> distanceToRecordNum = new HashMap<>();

        calcDistances(in, longUsRad, latUsRad, defibNum, recordNumToFullString, distanceToRecordNum);
        double minDistance = getMinDistance(distanceToRecordNum);
        parseAddress(recordNumToFullString, distanceToRecordNum, minDistance);
    }

    /**
     * Get address from full record string
     */
    private static void parseAddress(HashMap<Integer, String> recordNumToFullString,
                                     HashMap<Double, Integer> distanceToRecordNum, double minDistance) {
        String minDistRecord = recordNumToFullString.get(distanceToRecordNum.get(minDistance));
        int startAddr = minDistRecord.indexOf(";");
        int endAddr = minDistRecord.indexOf(";", startAddr + 1);
        System.out.println(minDistRecord.substring(startAddr + 1, endAddr));
    }

    /**
     * Find minimal distance
     */
    private static double getMinDistance(HashMap<Double, Integer> recordNumToDistance) {
        double minDistance = Double.MAX_VALUE;
        for (double dist: recordNumToDistance.keySet()) {
            if (minDistance > dist){
                minDistance = dist;
            }
        }
        return minDistance;
    }

    /**
     * Calculate distances and put them into map
     */
    private static void calcDistances(Scanner in, double longUsRad, double latUsRad, int defibNum,
                                      HashMap<Integer, String> recordNumToFullString,
                                      HashMap<Double, Integer> distanceToRecordNum) {
        for (int i = 0; i < defibNum; i++) {
            String defibRecord = in.nextLine();
            recordNumToFullString.put(i, defibRecord);

            int latStart = defibRecord.lastIndexOf(";");
            double defibLatDeg = Double.valueOf(defibRecord.substring(latStart + 1)
                                                           .replace(',','.'));
            double defibLatRad = Math.toRadians(defibLatDeg);

            int longStart = defibRecord.lastIndexOf(";", latStart - 1);
            double defibLongDeg = Double.valueOf(defibRecord.substring(longStart + 1, latStart)
                                                            .replace(',','.'));
            double defibLongRad = Math.toRadians(defibLongDeg);

            double x = (defibLongRad - longUsRad) * Math.cos((latUsRad + defibLatRad) / 2);
            double y = defibLatRad - latUsRad;
            double distance = Math.sqrt(Math.pow(x,2) + Math.pow(y,2)) * EARTH_RADUIS_KM;

            distanceToRecordNum.put(distance, i);
        }
    }
}
