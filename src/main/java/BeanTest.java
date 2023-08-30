import java.util.ArrayList;
import java.util.List;

public class BeanTest {
    public static void main(String[] args) {
        Album album = new Album("Biscuit", "Gravy", 2023, 100.50, "Delicious");
        System.out.println(album.getArtist());

//        Album emptyAlbum = new Album();

        Author author = new Author("Donald", "Twitty");
//        Quote quote = new Quote("Get in there!", author);
//        Quote quoteTwo = new Quote("ow-ah!", author);

//        List<Quote> donaldQuote = new ArrayList<>(List.of(qoute, qouteTwo));


    }
}
