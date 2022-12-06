package Sixth;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        String content = parseFileToString("Sixth\\input.txt");
        System.out.println(findStartOfPacketMarker(content, 15));

        
    }
    private static String parseFileToString(String filePath) throws IOException {
        Path path = Path.of(filePath);
        String content = Files.readString(path);
        return content;
    }

    private static int findStartOfPacketMarker(String input, int sequenceLength) {
        int i = sequenceLength;
        while (true) {
              String substring = input.substring(i-sequenceLength, i);
              if (isCharPacketMarker(substring, sequenceLength)) {
                return i-1;
              }
            i++;
        }
    }

    private static boolean isCharPacketMarker(String fiveLetters, int sequenceLength) {
        //ArrayList<Character> lettersToCheck = new ArrayList<>();
        // for (int i = 0; i < sequenceLength - 1; i++) {
        //     lettersToCheck.add(fiveLetters.charAt(i));
        // }
        for (int i = 0; i < sequenceLength -2; i++) {
            for (int j = i + 1; j < sequenceLength - 1; j++) {
                if (fiveLetters.charAt(i) == fiveLetters.charAt(j)) {
                    return false;
                }
            }
        }
        return true; 
    }
}
