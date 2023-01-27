import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;

public class FrequencyProg {

    private static final String Map = null;

    public void highestFreq (String csvPath) throws IOException, FileNotFoundException {

        File csvFile = new File(csvPath);
        BufferedReader br = new BufferedReader(new FileReader(csvFile));

        //Defining variables
        String line;
        List<String> wordList = new ArrayList<>();
        int count = 0;
        int maxCount = 0;
        
        //Read text file from the first line down to EOF, splitting the words and storing in an array 
        while ((line = br.readLine()) != null) {
            if (line.length() > 0) {
                String[] words = line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
                //Add individual words into a list of words
                for (int i = 0; i < words.length; i++) {
                    wordList.add(words[i]);
                }
            }
        }

        //Iterate through individual words in the list 
        for (int i = 0; i < wordList.size(); i++) {
            count = 1;
            for (int j = i + 1; j < wordList.size(); j++) {
                if (wordList.get(i) == wordList.get(j)) {
                    count++; 
                }
            }
            if (count > maxCount) {
                maxCount = count;
                String hfWord = wordList.get(i);
                System.out.println("The word that appeared in highest frequency is: " + hfWord);
            }
        } 

        //Store words as keys and wordcount as values in a hashmap
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : wordList) {
            if (!wordCount.containsKey(word)){
                wordCount.put(word, 0);
            } else {
                int counter = wordCount.get(word);
                wordCount.put(word, counter++);
            }
        }

    //     Map<String, Integer> wordcount = new HashMap<>();
    //    //after assigning keys and values
    //     wordcount.entrySet()
    //             .stream()
    //             .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
    //             .limit(10)
    //             .collect(Collectors.toMap(
    //                     Map.Entry::getKey,
    //                     Map.Entry::getValue,
    //                     (e1, e2) -> e1,
    //                     LinkedHashMap::new
    //             )).forEach((s, integer) -> System.out.println(String.format("%s : %s", s, integer)));
        
    }
} 

