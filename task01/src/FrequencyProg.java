import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FrequencyProg {

    public void highestFreq (String csvPath) throws IOException, FileNotFoundException {

        File csvFile = new File(csvPath);
        BufferedReader br = new BufferedReader(new FileReader(csvFile));

        //Initializing variables
        String line;
        List<String> lineList = new ArrayList<>();

        //Read text file from the first line down to last line and add each line to a list
        while ((line = br.readLine()) != null) {
            lineList.add(line);
        }

        //Extract individual words in each line and store in an array


        
    
    }
} 
