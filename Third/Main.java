import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(convertCharToPriority("A"));

    }

    private static ArrayList<String> readFile() throws FileNotFoundException {
        String filepath = "input.txt";
        File file = new File(filepath);
        Scanner fileReader = new Scanner(file);
        ArrayList<String> inList = new ArrayList<>();

        while (fileReader.hasNextLine()) {
            inList.add(fileReader.nextLine());
        }
        fileReader.close();
        return inList;

    }
    private static ArrayList<Character> findPairs(String backpacks) {
        String first = backpacks.substring(0, backpacks.length()/2);
        String second = backpacks.substring(backpacks.length()/2, backpacks.length());
        ArrayList<Character> pairs = new ArrayList<>();
        for (int i = 0; i < first.length(); i++) {
            for (int j = 0; j < second.length(); j++) {
                if (first.charAt(i) == second.charAt(j)) {
                    
                }
            }
        }
    }

    private static int convertCharToPriority(String c) {
        int priority = 0;
        char ch = c.charAt(0);
        if (Character.isLowerCase(ch)) {
            priority = ((int) ch) - 96;
        }
        else if (Character.isUpperCase(ch)) {
            priority = ((int) ch) - 38;
        }
        return priority;
    }
}