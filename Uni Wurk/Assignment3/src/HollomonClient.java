import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HollomonClient {

    private String server;
    private int port;
    private long credits;
    private BufferedReader reader;
    private BufferedWriter writer;
    private Socket socket;
    private CardInputStream stream;

    public HollomonClient(String server, int port) throws IOException {
        this.server = server;
        this.port = port;
        this.socket = new Socket(this.getServer(), this.getPort());
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        this.stream = new CardInputStream(socket.getInputStream());
        this.credits = 0;
    }

    public String getServer() { return this.server; }
    public int getPort() { return this.port; }

    public List<Card> login(String username, String password) throws IOException {
        writer.write(username);
        writer.newLine();
        writer.write(password);
        writer.newLine();
        writer.flush();
        String temp = reader.readLine();
        if (temp.equals("User " + username + " logged in successfully.")) {
            List<Card> cardList = stream.getList(new ArrayList<>());
            Collections.sort(cardList);
            return cardList;
        }
        return null;
    }

    public Long getCredits() throws IOException {
        writer.write("CREDITS");
        writer.newLine();
        writer.flush();
        String n = stream.readResponse();
        this.credits += Long.parseLong(n);
        return Long.parseLong(n);
    }

    public List<Card> getCards() throws IOException {
        writer.write("CARDS");
        writer.newLine();
        writer.flush();
        return stream.getList(new ArrayList<>());
    }

    public List<Card> getOffers() throws IOException {
        writer.write("OFFERS");
        writer.newLine();
        writer.flush();
        return stream.getList(new ArrayList<>());
    }

    public boolean buyCard(Card card) throws IOException {
        if (this.credits >= card.getPrice()) {
            writer.write( "BUY " + card.getID());
            writer.newLine();
            writer.flush();
        }
        return stream.readResponse().equals("OK");
    }

    public boolean sellCard(Card card, int price) throws IOException {
        card.setPrice(price);
        writer.write( "SELL " + card.getID() + " " + card.getPrice());
        writer.newLine();
        writer.flush();
        return stream.readResponse().equals("OK");
    }

    public void close() throws IOException {
        socket.close();
        reader.close();
        writer.close();
    }

    public static void main(String[] args) {
        try {
            HollomonClient h = new HollomonClient("netsrv.cim.rhul.ac.uk", 1812);
            h.login("number", "pricebadstore");
            System.out.println(h.getOffers().toString());
            h.close();
        } catch (IOException e) { e.printStackTrace(); }
    }
}
// h.login("bottest", "testpass");