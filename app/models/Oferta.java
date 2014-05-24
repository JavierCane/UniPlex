package models;

import models.types.JornadaLaboral;
import play.db.ebean.Model;

import java.util.Date;
import java.util.List;

public abstract class Oferta extends Model {

    /**
     * Nombre descriptivo de la oferta.
     */
    private String titol;

    /**
     * Descripción ampliada de la oferta.
     */
    private String informacioOferta;

    private List<JornadaLaboral> jornadaLaboralList;
    private Date dataInsercio;
    private Date dataCaducitat;
    private String nomPersonaContacte;
    private String emailPersonaContacte;
    private List<Coneixement> coneixementList;
    private Empresa empresa;

//    private String descripcioTfg;
//    private CodiPostal codiPostal;
//    private List<Candidatura> candidaturaList;

    public Oferta() {

    }
}