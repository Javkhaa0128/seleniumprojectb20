package com.cybertek.tests.day14_excel_io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadTextFile {

    public static void main(String[] args) throws FileNotFoundException {
       // path to file that we want to read
        String path ="shopping_list.txt";
        //File's constructor requires path to the file as an agrument
        File file = new File(path);
        // check if file exists
        System.out.println(file.exists());
        //we can read lines of file with Scanner class
        //System.in - for keyboard input
        //file object - for reading file
        Scanner scanner = new Scanner(file);

        System.out.println(scanner.nextLine());
        System.out.println(scanner.nextLine());

        while(scanner.hasNext()){
            System.out.println(scanner.nextLine());
        }

    }
}
