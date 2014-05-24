package models;

import play.db.ebean.Model;

public class Poblacio extends Model {

    private String nom;
    public CodiPostal codiPostal;
    public Oferta oferta;

    public Poblacio() {

    }
}