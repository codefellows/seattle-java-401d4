package demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class AliceReader {
    public String findMostCommonCharacter() {
        HashMap<String, Integer> characterCounts = new HashMap<>();
        String[] characters = new String[]{"Alice", "Hatter", "Queen"};
//        characterCounts.put("Alice", 0);
////        characterCounts.put("Hatter", 0);
////        characterCounts.put("Queen", 0);
        for (String c : characters) {
            characterCounts.put(c, 0);
        }

        try {
            Scanner sc = new Scanner(new File("src/main/resources/Alice.txt"));
            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                // look in that line
                for (String character : characters) {
                    if(line.contains(character)) {
                        int countSoFar = characterCounts.get(character);
                        characterCounts.put(character, countSoFar + 1);
                    }
                }
                // if each character is in that line
                // increment that value in characterCounts
            }
            int minCount = 9001;
            String minCharacter = "";
            for (String character : characters) {
                int count = characterCounts.get(character);
                if (count < minCount) {
                    minCount = count;
                    minCharacter = character;
                }
            }
            return minCharacter;
        } catch(FileNotFoundException e) {
            System.out.println("File not found");
            System.out.println(e);
            return "";
        }

    }
}
