import java.util.Objects;

public class Card implements Comparable<Card> {
    private long id;
    private long price;
    private String name;
    private Rank rank;

    public Card(long i, String n, Rank r) {
        this.name = n;
        this.rank = r;
        this.id = i;
        this.price = 0;
    }

    public Rank getRank() { return this.rank; }
    public String getName() { return this.name; }
    public long getID() { return this.id; }
    public Long getPrice() { return this.price; }
    public void setPrice(int p) { this.price = p; }

    @Override
    public String toString() { return "ID: " + this.id + "\nName: " + this.name + "\nRank: " + this.rank; }
    @Override
    public int hashCode() { return Objects.hash(this.name, this.id, this.rank); }
    public boolean equals(Card c) { return this.name.equals(c.getName()) && this.rank == c.getRank(); }

    @Override
    public int compareTo(Card c) {
        if (this.equals(c)) return 0;
        else if (!this.getName().equals(c.getName())) return 1;
        return -1;
    }
}