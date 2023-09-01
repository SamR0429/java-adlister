

import com.mysql.cj.jdbc.Driver;

import java.sql.*;


public class JDBCAlbumsDao {

    private Connection connection;

    public JDBCAlbumsDao() {
        try {
            DriverManager.registerDriver(new Driver());
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/codeup_test_db?allowPublicKeyRetrieval=true&useSSL=false",
                    "root",
                    "codeup"
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int insertAlbum(Album album) {
        int lastInsertedId = 0;
        try {
            Statement statement = connection.createStatement();
            String insertQuery = String.format("INSERT INTO albums (artist, name, release_date, sales, genre) VALUES ('%s', '%s', %d, %f, '%s')",
                    album.getArtist(),
                    album.getName(),
                    album.getReleaseDate(),
                    album.getSales(),
                    album.getGenre()
            );
            statement.executeUpdate(insertQuery, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                lastInsertedId = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lastInsertedId;
    }


    public void deleteAlbum() {
        try {
            Statement statement = connection.createStatement();
            String deleteQuery = String.format("DELETE FROM albums WHERE id = 4");
            Statement.executeUpdate(deleteQuery);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        JDBCAlbumsDao albumDao = new JDBCAlbumsDao();
        Album album = new Album(
                "Kendrick Lamar",
                "To Pimp a Butterfly",
                2015,
                24.2,
                "Hip hop");
        int lastInsertedId = albumDao.insertAlbum(album);
        System.out.println("Added a new album with an id of..." + lastInsertedId);

//        deleteAlbum("");
    }
}