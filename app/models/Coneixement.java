package models;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
final public class Coneixement extends Model {

    @Id
    @GeneratedValue
    private Integer id;

    /**
     * Nombre del conocimiento.
     */
    @NotNull
    @Constraints.Required
    @Column(unique = true)
    private String nom;

    public Coneixement( Integer id, String nom ) {
        this.id = id;
        this.nom = nom;
    }

    public Coneixement( String nom ) {
        this.nom = nom;
    }

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }
}