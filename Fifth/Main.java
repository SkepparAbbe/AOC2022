package Fifth;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.event.InternalFrameListener;

public class Main{
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> inList = readFile();
        ArrayList<Stack<Character>> stacks = parseToStacks(inList);
        moveCargo9000(inList, stacks);
        String topOfStacks = topOfStacks(stacks);
        System.out.println(topOfStacks);

        ArrayList<ArrayList<Character>> lists = parseToArrayList(inList);
        moveCargo9001(inList, lists);
        System.out.println(topOfLists(lists));
    }

    private static String topOfLists(ArrayList<ArrayList<Character>> lists) {
        String topOfLists = new String();
        for (int i = 0; i < lists.size(); i++) {
            topOfLists += lists.get(i).get(lists.get(i).size()-1);
        }
        return topOfLists;
    }

    private static void moveCargo9001(ArrayList<String> inList, ArrayList<ArrayList<Character>> lists) {
            for (int i = 10; i < inList.size(); i++) {
                ArrayList<Integer> instructions = parseInstructions(inList.get(i));
                for (int j = 0; j < instructions.get(0); j++) {
                    lists.get(instructions.get(2)).add(lists.get(instructions.get(1)).remove(lists.get(instructions.get(1)).size() - instructions.get(0) + j));
                }
            }
        
    }

    private static ArrayList<ArrayList<Character>> parseToArrayList(ArrayList<String> inList) {
        ArrayList<ArrayList<Character>> lists = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            lists.add(new ArrayList<Character>());
        }
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < lists.size(); j++) {
                if (inList.get(i).charAt(4*j + 1) != ' ') {
                lists.get(j).add(inList.get(i).charAt(4*j + 1));
                }
            }
        }
        return lists;
    }

    private static String topOfStacks(ArrayList<Stack<Character>> stacks) {
        String topOfStacks = new String();
        for (int i = 0; i < stacks.size(); i++) {
            topOfStacks += stacks.get(i).peek();
        }
        return topOfStacks;
    }

    private static void moveCargo9000(ArrayList<String> inList, ArrayList<Stack<Character>> stacks) {
        for (int i = 10; i < inList.size(); i++) {
            ArrayList<Integer> instructions = parseInstructions(inList.get(i));
            for (int j = 0; j < instructions.get(0); j++) {
                stacks.get(instructions.get(2)).push(stacks.get(instructions.get(1)).pop());
            }
        }
    }

    private static ArrayList<Integer> parseInstructions(String instruction) {
        ArrayList<Integer> instructionSet = new ArrayList<>();
        instructionSet.add(Integer.parseInt(instruction.split(" ")[1]));
        instructionSet.add(Integer.parseInt(instruction.split(" ")[3])-1);
        instructionSet.add(Integer.parseInt(instruction.split(" ")[5])-1);

        return instructionSet;
    }

    private static ArrayList<Stack<Character>> parseToStacks(ArrayList<String> inList) {
        ArrayList<Stack<Character>> stacks = new ArrayList<Stack<Character>>();
        for (int i = 0; i < 9; i++) {
            stacks.add(new Stack<Character>());
        }
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 9; j++) {
                if (inList.get(i).charAt(4*j + 1) != ' ') {
                stacks.get(j).push((inList.get(i).charAt(4*j + 1)));
                }
            }   
        }
        return stacks;
    }

    private static ArrayList<String> readFile() throws FileNotFoundException {
        String filepath = "Fifth\\input.txt";
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