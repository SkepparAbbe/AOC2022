package AOC22.First;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.nio.file;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class MostCalories {
    private static final String data = "C:\\Users\\albsk\\Desktop\\Kod\\AOC22\\First\\data.txt";
    final private static String EOL = "\\r\\n";

    public static ArrayList<Integer> textFileToArrayList() {
        String content = new String(Files.readAllBytes(Paths.get(data));)

        ArrayList<String> caloriesList = new ArrayList<>();
        fileReader.useDelimiter("  ");

        while(fileReader.hasNext()) {
            caloriesList.add(fileReader.next());
        }  
        for (int i=0; i<caloriesList.size(); i++) {
            System.out.println(caloriesList.get(i));
        }

        fileReader.close();

    }
    

    public static void main(String[] args) {
        
        
        File filepath = new File();
        
        File starting = new File(System.getProperty("user.dir"));
        File fileToBeRead = new File(starting,"data.txt");

        System.out.println(fileToBeRead);

        Scanner s = new Scanner(fileToBeRead);
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNextLine()){
            list.add(s.nextLine());
        }
        s.close();

        for(int i = 0; i < list.size(); i++) {   
          System.out.print(list.get(i));
      } 
      
    }
    

// dela upp i en lista 


    
}