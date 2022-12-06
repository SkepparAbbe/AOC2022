import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        ArrayList<String> inList = readFile();
        int totalPriority = 0;
        for (int i = 0; i < inList.size(); i++) {
            ArrayList<Character> pairs = findPairs(inList.get(i)); 
            for (int j = 0; j < pairs.size(); j++) {
                totalPriority += convertCharToPriority(pairs.get(j));
            }
        }
        System.out.println(totalPriority);
        totalPriority = 0;
        for (int i = 0; i < inList.size(); i += 3) {
            char badge = findAuthenticationBadge(inList.get(i), inList.get(i+1), inList.get(i+2));
            totalPriority += convertCharToPriority(badge);
        }
        System.out.println(totalPriority);
    }

    private static char findAuthenticationBadge(String firstBackpack, String secondBackpack, String thirdBackpack) {
        ArrayList<Character> pairs = new ArrayList<>();
        for (int i = 0; i < firstBackpack.length(); i++) {
            for (int j = 0; j < secondBackpack.length(); j++) {
                if (firstBackpack.charAt(i) == secondBackpack.charAt(j) && !pairs.contains(firstBackpack.charAt(i))) {
                        pairs.add(firstBackpack.charAt(i));
                    }
                }
            }
        for (int k = 0; k < thirdBackpack.length(); k++) {
            if (pairs.contains(thirdBackpack.charAt(k))) {
                return thirdBackpack.charAt(k);
            }
        }
        return 'c';
    }

    private static ArrayList<String> readFile() throws FileNotFoundException {
        String filepath = "Third\\input.txt";
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
                if (first.charAt(i) == second.charAt(j) && !pairs.contains(first.charAt(i))) {
                        pairs.add(first.charAt(i));
                    }
                }
            }
        return pairs;
        }
        

    // private static int calculatePriorityPoints(ArrayList<String> pairs) {
    //     return convertCharToPriority(pairs);
    // }

    private static int convertCharToPriority(Character c) {
        int priority = 0;
        if (Character.isLowerCase(c)) {
            priority = ((int) c) - 96;
        }
        else if (Character.isUpperCase(c)) {
            priority = ((int) c) - 38;
        }
        return priority;
    }
}