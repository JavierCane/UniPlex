package models;

import models.types.JornadaLaboral;

import java.util.Date;

public class Oferta {

    private Date dataCaducitat;
    private Date dataCaducitatPromocio;
    private Date dataInsercio;
    private String descripcioTfg;
    private String emailContacte;
    private String informacioOferta;
    private JornadaLaboral jornadaLaboral;
    private String personaContacte;
    public Poblacio poblacio;
    public CodiPostal codiPostal;

    public Oferta() {

    }
}