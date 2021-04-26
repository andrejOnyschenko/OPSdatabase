package Main;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
public class Main implements Serializable {
    private String id, jmeno, druh, vaha;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDruh() {
        return druh;
    }
    public void setDruh(String druh) {
        this.druh = druh;
    }

    public String getJmeno() {
        return jmeno;
    }
    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getVaha() {
        return vaha;
    }
    public void setVaha(String vaha) {
        this.vaha = vaha;
    }

}