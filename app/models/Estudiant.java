package models;

import java.util.Date;

public class Estudiant extends Usuari {

    private String altresDades;
    private String cognom1;
    private String cognom2;
    private Date dataActualitzacio;
    private String dni;
    private String email;
    private String fotografia;
    private String nom;
    private Integer nss;
    private String telefon;
    public Oferta m_Oferta;
    public CodiPostal m_CodiPostal;
    public Idioma m_Idioma;
    public Alerta m_Alerta;
    public Coneixement m_Coneixement;

    public Estudiant() {

    }
}