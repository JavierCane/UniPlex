package models;

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
    private Integer nss;
    private String telefon;
    private CodiPostal codiPostal;
    private List<Idioma> idiomaList;
    private List<Alerta> alertaList;
    private List<Coneixement> coneixementList;
    private List<ExperienciaLaboral> experienciaLaboralList;
    private List<Formacio> formacioList;
    private List<Candidatura> candidaturaList;

    public Estudiant( String nom,
                      String user,
                      String password,
                      String email,
                      boolean esAdministrador,
                      boolean esBlocat,
                      boolean esDeganal,
                      Date expiracioBlocatge,
                      String motiuBlocatge,
                      List<Candidatura> candidaturaList,
                      String dni,
                      String altresDades,
                      String cognom1,
                      String cognom2,
                      Date dataActualitzacio,
                      String fotografia,
                      Integer nss,
                      String telefon,
                      CodiPostal codiPostal,
                      List<Idioma> idiomaList,
                      List<Alerta> alertaList,
                      List<Coneixement> coneixementList,
                      List<ExperienciaLaboral> experienciaLaboralList,
                      List<Formacio> formacioList ) {
        super( nom, user, password, email, esAdministrador, esBlocat, esDeganal, expiracioBlocatge, motiuBlocatge );
        this.candidaturaList = candidaturaList;
        this.dni = dni;
        this.altresDades = altresDades;
        this.cognom1 = cognom1;
        this.cognom2 = cognom2;
        this.dataActualitzacio = dataActualitzacio;
        this.fotografia = fotografia;
        this.nss = nss;
        this.telefon = telefon;
        this.codiPostal = codiPostal;
        this.idiomaList = idiomaList;
        this.alertaList = alertaList;
        this.coneixementList = coneixementList;
        this.experienciaLaboralList = experienciaLaboralList;
        this.formacioList = formacioList;
    }
}