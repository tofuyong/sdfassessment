import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class FrequencyProg {

    public void highestFreq(String csvPath) throws IOException, FileNotFoundException {

        File csvFile = new File(csvPath);
        BufferedReader br = new BufferedReader(new FileReader(csvFile));

        // Defining variables
        String line;
        List<String> wordList = new ArrayList<>();
        int count = 0;

        // Read text file from the first line down to EOF, splitting the words and
        // storing in an array
        while ((line = br.readLine()) != null) {
            if (line.length() > 0) {
                String[] words = line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
                // Add individual words into a list of words
                for (int i = 0; i < words.length; i++) {
                    wordList.add(words[i]);
                }
            }
        }

        // Store words as keys and wordcount as values in a hashmap
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : wordList) {
            if (!wordCount.containsKey(word)) {
                wordCount.put(word, 1);
            } else if (wordCount.containsKey(word)) {
                count = wordCount.get(word);
                wordCount.put(word, count + 1);
            }
        }

        // Print out top 10 words of highest frequency and their Term-frequency
        wordCount.entrySet().stream()
                .sorted((one, another) -> -one.getValue().compareTo(another.getValue())) 
                .limit(10)
                .forEach(entry -> System.out
                        .println(entry.getKey() + " : " + (float) entry.getValue() / wordList.size()));

        br.close();
    }
}
