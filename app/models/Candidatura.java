package models;

import models.types.EstatCandidatura;
import play.db.ebean.Model;

import javax.persistence.Entity;

final public class Candidatura extends Model {

    /**
     * Estado de la candidatura.
     */
    private EstatCandidatura estatCandidatura;

    /**
     * Comentario al respecto del por qué del estado actual de la candidatura.
     */
    private String comentari;

    private Estudiant estudiant;

    private Oferta oferta;

    public Candidatura() {

    }
}