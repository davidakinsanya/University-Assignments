import java.io.IOException;

class DestinationStoreTest {
    public static void main(String[] args) throws IOException {
        DestinationStore d = new DestinationStore("C:\\Users\\david\\Assignment2\\src\\countries.txt", 3);
        CityStore c = new CityStore("C:\\Users\\david\\Assignment2\\src\\cities.txt");
        HeritageSiteStore h = new HeritageSiteStore("C:\\Users\\david\\Assignment2\\src\\heritage_sites.txt");
    }
}
