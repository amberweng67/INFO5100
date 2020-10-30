import javax.sound.midi.SysexMessage;
import java.lang.reflect.Array;
import java.util.*;

public class Mreview implements Comparable<Mreview> {
    private String title;
    private ArrayList<Integer> ratings;

    public Mreview() {
        this.title = "";
        this.ratings = new ArrayList<>();
    }

    public Mreview(String title) {
        this.title = title;
        this.ratings = new ArrayList<>();
    }

    public Mreview(String title, int firstRating) {
        this.title = title;
        this.ratings = new ArrayList<>(List.of(firstRating));
    }

    public String getTitle() {
        return this.title;
    }

    public void addRating(int r) {
        this.ratings.add(r);
    }

    public double aveRating() {
        double sum = 0;
        for (int rating : this.ratings) {
            sum += rating;
        }
        return sum / this.ratings.size();
    }

    public int numRatings() {
        return this.ratings.size();
    }

    public int compareTo(Mreview obj) {
        return this.title.compareTo(obj.title);
    }

    public boolean equals(Mreview obj) {
        return obj.title.equals(this.title);
    }

    public String toString() {
        return  String.format("%s, average %.2f out of %d ratings",
                this.title,
                this.aveRating(),
                this.numRatings());
    }

    public static void main(String[] args) {
        Mreview m = new Mreview("Kill Bill", 3);
        m.addRating(4);
        m.addRating(3);
        System.out.println(m.toString());
        System.out.println(m.aveRating());
    }
}
