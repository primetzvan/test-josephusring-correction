package at.htl.josephus.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Blob;

@Entity
public class Round extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String outputline;

    @Lob
    private Blob uuid;

    public Round(String outputline, Blob uuid) {
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

    public Blob getUuid() {
        return uuid;
    }

    public void setUuid(Blob uuid) {
        this.uuid = uuid;
    }
}
