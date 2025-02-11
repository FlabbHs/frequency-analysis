import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * A utility class that performs frequency analysis on text files.
 * This program reads a text file and analyzes the frequency of each alphabetic character,
 * useful for basic cryptographic analysis.
 */
public class FrequencyAnalysis {
    private static final String DEFAULT_INPUT_FILE = "ciphertext.txt";

    public static void main(String[] args) {
        System.out.println("Frequency Analysis");
        String filePath = args.length > 0 ? args[0] : DEFAULT_INPUT_FILE;
        
        try {
            String textString = readFile(filePath);
            HashMap<Character, Integer> frequency = getFrequency(textString);
            frequency = sortHashMap(frequency);

            System.out.println("\nCharacter frequencies (most to least common):");
            frequency.forEach((key, value) -> 
                System.out.printf("%c: %d%n", key, value));
                
        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }

    public static HashMap<Character, Integer> sortHashMap(HashMap<Character, Integer> unsortedHashMap) {
        // Create a list from elements of HashMap
        List<Map.Entry<Character, Integer> > list = new LinkedList<Map.Entry<Character, Integer> >(unsortedHashMap.entrySet());

        // Sort the list
        Collections.sort(list, (o1, o2) -> 
            o2.getValue().compareTo(o1.getValue())); // Reverse sort

        // put data from sorted list to hashmap 
        HashMap<Character, Integer> temp = new LinkedHashMap<Character, Integer>();
        for (Map.Entry<Character, Integer> a : list) {
            temp.put(a.getKey(), a.getValue());
        }

        return temp;
    }

    public static HashMap<Character, Integer> getFrequency(String textString) {
        if (textString == null || textString.isEmpty()) {
            return new HashMap<>();
        }
        
        // Convert string to character array
        char[] charArray = textString.toCharArray();

        // Holds the frequency of each character in the txt file
        HashMap<Character, Integer> frequency = new HashMap<Character, Integer>();
        
        // Use a for each loop to iterate through each character
        for (char c : charArray) {
            // Check if character is a letter
            if (Character.isAlphabetic(c)) {

                // Check if the map already has the character key
                if (frequency.containsKey(c)) {
                    // If yes incremement the value
                    frequency.put(c, frequency.get(c) + 1);
                }

                // If the map does not contain the key, add it
                else {
                    frequency.put(c, 1);    
                }
            }
        }
        return frequency;
    }

    /**
     * Reads the contents of a file into a string.
     * @param filePath path to the file to be read
     * @return the contents of the file as a string
     * @throws IOException if there is an error reading the file
     */
    public static String readFile(String filePath) throws IOException {
        StringBuilder textString = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                textString.append(line).append("\n");
            }
        }
        return textString.toString();
    }
}