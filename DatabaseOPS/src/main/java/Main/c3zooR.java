package Main;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.*;

@Produces(MediaType.APPLICATION_JSON)
@Path("zoo")
public class c3zooR {

    @Inject
    private M manager;

    @GET
    public Response getAll() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/c3zoo", "root", ""
        );

        Statement statement = connection.createStatement();
        ResultSet vysledek = statement.executeQuery("SELECT Z.id, Z.jmeno, D.nazev, Z.vaha FROM Zvirata AS Z JOIN Druhy AS D ON (Z.druh = D.id) WHERE D.nazev like ('pes') LIMIT 7");

        while(vysledek.next()){
            Main animal = new Main();
            String id = vysledek.getString("id");
            animal.setId(id);
            String jmeno = vysledek.getString("jmeno");
            animal.setJmeno(jmeno);
            String druh = vysledek.getString("nazev");
            animal.setDruh(druh);
            String vaha = vysledek.getString("vaha");
            animal.setVaha(vaha);
            manager.animals.add(animal);

        }
        connection.close();
        return Response.ok(manager.getAnimal()).build();
    }
}