package models;

import play.db.ebean.Model;

import java.util.Date;

final public class Formacio extends Model {

    private Date dataActualitzacio;
    private Date dataFi;
    private Date dataIni;
    private boolean esFinalitzat;
    private String institucio;
    private String titol;

    public Formacio() {

    }
}