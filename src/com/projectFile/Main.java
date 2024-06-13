package com.projectFile;

import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "C:\\IntelliJ\\Academy\\Files\\fileJava.txt";

        File f = new File(filePath);

        if(f.exists()) {
            System.out.println("File exists");
            f.delete();
        } else {
            System.out.println("File does not exist");
        }

        FileWriter o = null;
        try {
            o = new FileWriter(f);
            o.write("record 1\n");
            o.write("record 2\n");
            o.write("record 3\n");
            o.write("record 4\n");
            o.write("record 5\n");
            o.write("record 6\n");
            o.write("record 7\n");
            o.write("record 8\n");
            o.write("record 9\n");
            o.write("record 10\n");

        } catch (IOException e) {
            System.out.println("File creation error: " + e.getMessage());
            throw new RuntimeException(e);
        } finally {
            if(o!= null) {
                try {
                    o.flush();
                    o.close();
                    System.out.println("FileWriter is closed");
                } catch (IOException e) {
                    System.out.println("File closing error: " + e.getMessage());
                    throw new RuntimeException(e);
                }
            }
        }
        String record = "Record added...\n";
        appendUsingFileWriter(filePath, record);

        System.out.println("\nBeing read");
        readFile(filePath);
    }

    public static void appendUsingFileWriter(String filePath, String record) {
        File file = new File(filePath);
        FileWriter fr = null;

        try {
            fr = new FileWriter(file, true);
            fr.write(record);
        } catch (IOException e) {
            System.out.println("Append error: " + e.getMessage());
            throw new RuntimeException(e);
        } finally {
            if(fr!= null) {
                try {
                    fr.flush();
                    fr.close();
                    System.out.println("FileWriter is closed");
                } catch (IOException e) {
                    System.out.println("File closing error: " + e.getMessage());
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private static void readFile(String filePath) {

        int next;
        FileReader fileIn;

        try {
            fileIn = new FileReader(filePath);
            do {
                try {
                    next = fileIn.read();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if(next!= -1) {
                    System.out.print((char) next);
                }
            } while (next != -1);


        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}