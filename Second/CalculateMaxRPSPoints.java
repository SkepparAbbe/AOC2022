

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CalculateMaxRPSPoints {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Strategy 1 " + strategyLogic(readFile()));
        System.out.println("Strategy 2 " + forcedDraw(readFile()));

    }

    private static ArrayList<String> readFile() throws FileNotFoundException {
        String filepath = "RPSinput.txt";
        File file = new File(filepath);
        Scanner fileReader = new Scanner(file);
        ArrayList<String> inList = new ArrayList<>();

        while (fileReader.hasNextLine()) {
            inList.add(fileReader.nextLine());
            //System.out.println("Line: "+ fileReader.next());
        }
        fileReader.close();
        return inList;

    }

    /*
     * A Rock
     * B PAper
     * C Scissor
     * 
     * X Rock
     * Y Paper
     * Z Scissor
     */


    private static int forcedDraw(ArrayList<String> drawList) {
        // X lose, Y draw, and Z win.
        int points = 0;
        for (int i = 0; i < drawList.size(); i++) {
            switch (drawList.get(i)) {
                case "A X":
                    points += 3;
                    break;
                case "B X":
                    points += 1;
                    break;
                case "C X":
                    points += 2;
                    break;
                case "A Y":
                    points += 4;
                    break;
                case "B Y":
                    points += 5;
                    break;
                case "C Y":
                    points += 6;
                    break;
                case "A Z":
                    points += 8;
                    break;
                case "B Z":
                    points += 9;
                    break;
                case "C Z":
                    points += 7;
                    break;

            }
        }
        return points;
    }

    private static int strategyLogic(ArrayList<String> drawList) {
        int points = 0;
        for (int i = 0; i < drawList.size(); i++) {
            switch (drawList.get(i)) {
                case "A X":
                    points += 4;
                    break;
                case "B X":
                    points += 1;
                    break;
                case "C X":
                    points += 7;
                    break;
                case "A Y":
                    points += 8;
                    break;
                case "B Y":
                    points += 5;
                    break;
                case "C Y":
                    points += 2;
                    break;
                case "A Z":
                    points += 3;
                    break;
                case "B Z":
                    points += 9;
                    break;
                case "C Z":
                    points += 6;
                    break;

            }
        }
        return points;
    }
}