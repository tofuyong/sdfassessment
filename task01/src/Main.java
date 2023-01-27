import java.io.FileNotFoundException;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        
        String csvFile = args[0];
        String csvPath = Paths.get("./", csvFile).toString();
        
        FrequencyProg fp = new FrequencyProg();
        fp.highestFreq(csvPath);

    }
}
