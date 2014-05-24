package models;

import play.db.ebean.Model;

final public class Invitacio extends Model {

    /**
     * Oferta a la cual se le invita al alumno.
     */
    private Oferta oferta;

    /**
     * Estudiante al que se le invita a la oferta.
     */
    private Estudiant estudiant;


    public Invitacio() {

    }
}