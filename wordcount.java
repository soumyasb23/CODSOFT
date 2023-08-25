import java.io.*;
import java.util.*;

public class WordCount {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Word Count App!");
        System.out.println("Please choose an option:");
        System.out.println("1. Enter text");
        System.out.println("2. Open a file");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        String text = "";
        if (choice == 1) {
            System.out.println("Enter your text:");
            text = scanner.nextLine();
        } else if (choice == 2) {
            System.out.println("Enter the file path:");
            String filePath = scanner.nextLine();
            try {
                text = readFile(filePath);
            } catch (IOException e) {
                System.out.println("Error reading the file: " + e.getMessage());
                System.exit(1);
            }
        } else {
            System.out.println("Invalid choice. Exiting.");
            System.exit(1);
        }

        String[] words = text.split("[\\s\\p{Punct}]+");
        List<String> ignoredWords = Arrays.asList("the", "and", "is", "of"); // Add more common words if needed

        int totalWords = words.length;
        int uniqueWords = 0;
        Map<String, Integer> wordFrequency = new HashMap<>();
        
        for (String word : words) {
            word = word.toLowerCase();
            if (!ignoredWords.contains(word)) {
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }

        uniqueWords = wordFrequency.size();
        
        System.out.println("Total words: " + totalWords);
        System.out.println("Unique words: " + uniqueWords);

        System.out.println("\nWord frequencies:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        scanner.close();
    }

    public static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
        }
        reader.close();
        return content.toString();
    }
}
