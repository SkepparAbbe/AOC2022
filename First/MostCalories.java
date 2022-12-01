package AOC22.First;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MostCalories {
    public static void main(String[] args) throws FileNotFoundException {
        String data = "First\\input.txt";

        ArrayList<String> inputArr = new ArrayList<String>();
        File input = new File(data);
        Scanner fileScanner = new Scanner(input);
        while(fileScanner.hasNextLine()) {
            inputArr.add(fileScanner.nextLine());
        }
        fileScanner.close();
        ArrayList<Integer> caloriesSum = new ArrayList<>();
        int sumPerElf = 0;
        for (int i = 0; i < inputArr.size(); i++) {
            if (inputArr.get(i) != "") {
                sumPerElf += Integer.parseInt(inputArr.get(i));
            } else {
                caloriesSum.add(sumPerElf);
                sumPerElf = 0;
            }
        }
        System.out.println(Collections.max(caloriesSum));
    }
}