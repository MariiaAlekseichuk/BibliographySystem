package com.github.MaryHrisanfova.BibliographySystem.utilities;

import java.io.BufferedReader;

/**
 * @author Mariia_Khrisanfova
 */
public class FileReader {
    public static String readFile(String filename) {
        String result = "";
        try {
            BufferedReader br = new BufferedReader(new java.io.FileReader(filename));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            result = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
