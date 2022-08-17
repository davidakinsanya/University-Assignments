import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Itinerary {
    private DestinationStore destination;
    private CityStore city;
    private HeritageSiteStore heritage;
    private List<String> list;

    public Itinerary(DestinationStore d, CityStore c, HeritageSiteStore h) {
        this.destination = d;
        this.city = c;
        this.heritage = h;
        this.list = new ArrayList<>();
    }

    public List<String> generate(String input) {
        String[] arr = input.toLowerCase().split("");
        DestinationStore[] obj = new DestinationStore[]{destination, heritage, city};
        int objectCount = 0;
        for (String s : arr) {
            if (obj[objectCount].containsKey(s)) list.add(obj[objectCount].getRandomDestination(s));
            objectCount++;
            if (objectCount == obj.length) objectCount = 0;
        }
        for (String l: list) System.out.println(l);
        return list;
    }

    public List<String> generate2(String input, int prefix) {
        String[] arr = input.toLowerCase().split("");
        DestinationStore[] obj = new DestinationStore[]{heritage, destination, city};
        int objectCount = 0;
        int prefixCopy = prefix;

        while(prefixCopy >= 1) {
            String s = input.substring(0, prefixCopy).toLowerCase();
            if (obj[objectCount].containsKey(s)) {
                String newStr = obj[objectCount].getRandomDestination(s);
                list.add(newStr.substring(0, prefixCopy).toUpperCase() + newStr.substring(prefixCopy));
                objectCount++;
                break;
            }
            prefixCopy--;
        }

        for (int i = prefixCopy; i < arr.length; i++) {
            if (obj[objectCount].containsKey(arr[i])) list.add(obj[objectCount].getRandomDestination(arr[i]));
            objectCount++;
            if (objectCount == obj.length) objectCount = 0;
        }
        for (String l: list) System.out.println(l);
        return list;
    }

    public static void main(String[] args) throws IOException {
        DestinationStore d = new DestinationStore("C:\\Users\\david\\Assignment2\\src\\countries.txt", 3);
        CityStore c = new CityStore("C:\\Users\\david\\Assignment2\\src\\cities.txt", 3);
        HeritageSiteStore h = new HeritageSiteStore("C:\\Users\\david\\Assignment2\\src\\heritage_sites.txt", 3);

        Itinerary i = new Itinerary(d, c, h);
        List<String> l = i.generate("Tommy");
        //List<String> l2 = i.generate2("Tommy", 3);
    }
}
