package models;

import models.types.NivellIdioma;
import play.db.ebean.Model;

public class Idioma extends Model {

    private String acreditacio;
    private NivellIdioma nivellIdioma;
    private String nom;

    public Idioma() {

    }
}