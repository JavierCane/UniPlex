package models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

//@Entity
//@DiscriminatorValue("Estudiant")
final public class Estudiant extends Usuari {

//    @NotNull
//    @Column(unique = true)
    private String dni;

    private String altresDades;
    private String cognom1;
    private String cognom2;
    private Date dataActualitzacio;
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