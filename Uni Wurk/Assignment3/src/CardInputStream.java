import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class CardInputStream {
    private BufferedReader input;
    public CardInputStream(InputStream input) { this.input = new BufferedReader(new InputStreamReader(input)); }

    public Card readCard() throws IOException {
        String[] cardArgs = new String[4];
        String temp;
        int count = 0;
        if ((temp = this.readResponse()).equals("CARD")) {
            while (count != 4) {
                String s = input.readLine();
                cardArgs[count] = s;
                count++;
            }
        }
        Card c = new Card(Long.parseLong(cardArgs[0]), cardArgs[1], Rank.valueOf(cardArgs[2]));
        c.setPrice(Integer.parseInt(cardArgs[3]));
        return c;
    }


    public Card readCardtoList() throws IOException {
        String[] cardArgs = new String[4];
        int count = 0;
        while (count != 4) {
            String s = input.readLine();
            cardArgs[count] = s;
            count++;
        }
        Card c = new Card(Long.parseLong(cardArgs[0]), cardArgs[1], Rank.valueOf(cardArgs[2]));
        c.setPrice(Integer.parseInt(cardArgs[3]));
        return c;
    }

    public List<Card> getList(List<Card> c) throws IOException {
        String s;
        if ((s = this.readResponse()).equals("OK")) {
            return c;
        } else {
            Card card = this.readCardtoList();
            c.add(card);
            return this.getList(c);
        }
    }

    public String readResponse() throws IOException { return input.readLine(); }
}
