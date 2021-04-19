package Main;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/c3zoo", "root", ""
        );

        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(
                "SELECT druhy.nazev, zvirata.jmeno, zvirata.id FROM zvirata JOIN druhy ON (zvirata.druh = druhy.id) LIMIT 7"
        );

        while(result.next()) {

            int id = result.getInt("id");
            String title = result.getString("jmeno");
            String nazev = result.getString("nazev");
            System.out.println(nazev + "\t;" + title + "\t;" + id);
        }

        connection.close();

    }
}
