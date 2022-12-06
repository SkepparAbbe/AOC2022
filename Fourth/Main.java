package Fourth;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import Util.FileToArray;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> inList = FileToArray.readFile("Fourth\\input.txt");
        int containedAssignments = 0;
        for (int i = 0; i < inList.size(); i++) {
            containedAssignments += hasOverlap(inList.get(i));
        }
        System.out.print(containedAssignments);
    }

    private static int hasOverlap(String assignment) {
        String firstElf = assignment.split(",")[0];
        String secondElf = assignment.split(",")[1];
        ArrayList<Integer> assignmentfirstsAndLasts = new ArrayList<>();
        assignmentfirstsAndLasts.add(Integer.parseInt(firstElf.split("-")[0]));
        assignmentfirstsAndLasts.add(Integer.parseInt(firstElf.split("-")[1]));
        assignmentfirstsAndLasts.add(Integer.parseInt(secondElf.split("-")[0]));
        assignmentfirstsAndLasts.add(Integer.parseInt(secondElf.split("-")[1]));

        if (assignmentfirstsAndLasts.get(0) <= assignmentfirstsAndLasts.get(2) && assignmentfirstsAndLasts.get(1) >= assignmentfirstsAndLasts.get(3)) {
            return 1;
        } else if (assignmentfirstsAndLasts.get(0) >= assignmentfirstsAndLasts.get(2) && assignmentfirstsAndLasts.get(1) <= assignmentfirstsAndLasts.get(3)) {
            return 1;
        }
        return 0;
    
    }
}
