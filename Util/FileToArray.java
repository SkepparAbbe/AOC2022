package Util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileToArray {
    public static ArrayList<String> readFile(String filepath) throws FileNotFoundException {
        File file = new File(filepath);
        Scanner fileReader = new Scanner(file);
        ArrayList<String> inList = new ArrayList<>();

        while (fileReader.hasNextLine()) {
            inList.add(fileReader.nextLine());
        }
        fileReader.close();
        return inList;
    }
}
