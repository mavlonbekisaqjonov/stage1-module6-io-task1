package com.epam.mjc.io;

import java.io.File;
import java.io.*;


public class FileReader {

    public Profile getDataFromFile(File file) {
        FileInputStream fr = null;
        StringBuilder outt = new StringBuilder();

        try {
            fr = new FileInputStream(file);
            int byteData;
            while ((byteData = fr.read()) != -1) {
                outt.append((char) byteData);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fr != null) fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String out = outt.toString();

        String[] lines = out.split("\n");
        String name = lines[0].split(": ")[1].trim();
        int age = Integer.parseInt(lines[1].split(": ")[1].trim());
        String email = lines[2].split(": ")[1].trim();
        long phone = Long.parseLong(lines[3].split(": ")[1].trim());

        return new Profile(name, age, email, phone);
    }
}
