package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import java.util.List;

final public class Coneixement extends Model {

    /**
     * Nombre del conocimiento.
     */
    private String nom;

    public Coneixement() {

    }
}