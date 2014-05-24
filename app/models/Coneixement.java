package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
final public class Coneixement extends Model {

    @Id
    @GeneratedValue
    private Integer id;

    /**
     * Nombre del conocimiento.
     */
    @NotNull
    private String nom;

    public Coneixement() {

    }
}