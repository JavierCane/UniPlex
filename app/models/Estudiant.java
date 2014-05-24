package models;

import java.util.Date;
import java.util.List;

final public class Estudiant extends Usuari {

    private String email;
    private String altresDades;
    private String cognom1;
    private String cognom2;
    private Date dataActualitzacio;
    private String dni;
    private String fotografia;
    private String nom;
    private Integer nss;
    private String telefon;
    private CodiPostal codiPostal;
    private List<Idioma> idiomaList;
    private List<Alerta> alertaList;
    private List<Coneixement> coneixementList;
    private List<ExperienciaLaboral> experienciaLaboralList;
    private List<Formacio> formacioList;
    private List<Candidatura> candidaturaList;

    public Estudiant() {

    }
}