package com.github.MaryHrisanfova.BibliographySystem.utilities;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @author Mariia_Khrisanfova
 */
public class FileReader {
    public static String readFile(String filename) {
        String result = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new
                    FileInputStream(filename), "UTF-8"));
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
