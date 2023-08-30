
import java.util.List;

public class Album {
    private long id;
    private String artist;
    private int releaseDate;
    private double sales;
    private String genre;


    public Album(String artist, String name, int releaseDate, double sales, String genre){
        this.artist = artist;
//        this.name = name;
        this.releaseDate = releaseDate;
        this.sales = sales;
        this. genre = genre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getSales() {
        return sales;
    }

    public void setSales(double sales) {
        this.sales = sales;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }




}
