package org.studi.utils;

import java.io.*;

public class Files {

    public static String openFile(String filename){
        BufferedReader bufferedReader;
        StringBuilder contenuFichier= new StringBuilder("");
        try {
            bufferedReader = new BufferedReader(new FileReader(filename));
            String line = bufferedReader.readLine();
            while (line != null) {
                contenuFichier.append(line);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch(IOException e){
            e.printStackTrace();
        }
        return contenuFichier.toString();
    }
    public static Boolean writeFile(String fileName,String text){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(text);
            writer.close();
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }
}
