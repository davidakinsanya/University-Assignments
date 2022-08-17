import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

class CityStore extends DestinationStore {
    public CityStore() { this.map = new HashMap<String, List<String>>(); }

    public CityStore(String fileName) throws IOException {
        this.map = new HashMap<String, List<String>>();
        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String b;
        while ((b = br.readLine()) != null) this.put(b.substring(0,1).toLowerCase(), b);
        br.close();
    }

    public CityStore(String fileName, int prefix) throws IOException {
        this.map = new HashMap<String, List<String>>();
        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String b;
        while ((b = br.readLine()) != null) this.put(b.substring(0,1).toLowerCase(), b);
        br.close();
    }

    @Override
    public String getRandomDestination(String key) {
        if (map.containsKey(key)) {
            Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
            String[] city = map.get(key).get(0).split(" ");
            StringBuilder elem = new StringBuilder();
            for (String i : city) if (!pattern.matcher(i).matches()) elem.append(i).append(" ");
            int citySize = Integer.parseInt(city[city.length-1]);
            if (citySize >= 10000000) return String.valueOf(elem).trim() + " (megacity)";
            else if (citySize >= 5000000) return String.valueOf(elem).trim() + " (very large city)";
            else return String.valueOf(elem).trim() + " (large city)";
        }
        return null;
    }
}
