package models;

import play.db.ebean.Model;

import javax.persistence.Entity;

final public class CodiPostal extends Model {

    /**
     * Número del código postal.
     */
    private Integer numero;

    /**
     * Población a la que pertenece el código postal.
     */
    private Poblacio poblacio;

    public CodiPostal() {

    }
}