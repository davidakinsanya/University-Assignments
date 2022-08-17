import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class DestinationStore {
    protected Map<String, List<String>> map;
    public DestinationStore() { this.map = new HashMap<String, List<String>>(); }

    public DestinationStore(String fileName) throws IOException {
        this.map = new HashMap<String, List<String>>();
        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String b;
        while ((b = br.readLine()) != null) this.put(b.substring(0,1).toLowerCase(), b);

        br.close();
    }

    public DestinationStore(String fileName, int prefix) throws IOException {
        this.map = new HashMap<String, List<String>>();
        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String b;
        while ((b = br.readLine()) != null) {
            for(int i = 1; i <= prefix; i++) this.put(b.substring(0, i).toLowerCase(), b);
        }
        br.close();
    }

    public Map<String, List<String>> getMap() { return map; }

    public boolean containsKey(String key) {
        return map.keySet().contains(key);
    }

    public void put(String key, String destination) {
        List<String> list = new ArrayList<String>();
        if (map.containsKey(key)) map.get(key).add(destination);
        else {
            list.add(destination);
            map.put(key, list);
        }
    }

    public String getRandomDestination(String key) {
        if (map.containsKey(key)) {
            Random rand = new Random();
            int index = rand.nextInt(map.get(key).size());
            String str = map.get(key).get(index);
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }
        return null;
    }
}