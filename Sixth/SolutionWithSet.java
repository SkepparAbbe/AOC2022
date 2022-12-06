package Sixth;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SolutionWithSet {
    public static void main(String[] args) throws IOException {
        String file = parseFileToString("Sixth\\input.txt");
        System.out.println(Solution(file, 14));
    }
    
    private static String parseFileToString(String filePath) throws IOException {
        Path path = Path.of(filePath);
        String content = Files.readString(path);
        return content;
    }

    private static int Solution(String indata, int markerLength) {
        for (int i = markerLength; i < indata.length(); i++) {
            ArrayList<Character> substring = new ArrayList<>();
            for (int j = i - markerLength; j < i; j++) {
                substring.add(indata.charAt(j));

            }
            Set<Character> checkLengthForDuplicates = new HashSet<Character>(substring);
            if (checkLengthForDuplicates.size() == markerLength) {
                return i;
            }
         }
         return 0;
    }
}
