import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class HeritageSiteStore extends DestinationStore {
    public HeritageSiteStore() { this.map = new HashMap<String, List<String>>(); }

    public HeritageSiteStore(String fileName) throws IOException {
        this.map = new HashMap<String, List<String>>();
        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String b;
        while ((b = br.readLine()) != null) this.put(b.substring(0,1).toLowerCase(), b);
        br.close();
    }

    public HeritageSiteStore(String fileName, int prefix) throws IOException {
        this.map = new HashMap<String, List<String>>();
        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String b;
        while ((b = br.readLine()) != null) {
            for (int i = 1; i <= prefix; i++) {
                this.put(b.substring(0, i).toLowerCase(), b);
            }
        }
        br.close();
    }


    @Override
    public String getRandomDestination(String key) {
        if (map.containsKey(key)) {
            String str = map.get(key).get(0);
            return str.substring(0, 1).toUpperCase() + str.substring(1) + " (UNESCO World Heritage Site)";
        }
        return null;
    }
}
