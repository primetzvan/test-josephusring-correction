package at.htl.josephus.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Blob;

//TODO: @Table hinzugefügt
@Entity
@Table(name = "J_ROUND")
public class Round extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //TODO: Blob zu String
    private String outputline;
    private String uuid;

    public Round(String outputline, String uuid) {
        this.outputline = outputline;
        this.uuid = uuid;
    }

    public Round() {
    }

    public String getOutputline() {
        return outputline;
    }

    public void setOutputline(String outputline) {
        this.outputline = outputline;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
