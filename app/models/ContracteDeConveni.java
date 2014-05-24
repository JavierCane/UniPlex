package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

public class ContracteDeConveni extends Model {

    private Integer ajutPerHora;
    private Date dataFi;
    private Date dataIni;
    private String descripcioCompetenciesTecniques;
    private String descripcioTreball;
    private String documentPDF;
    private String emailEmp;
    private String emailFac;
    private boolean esFirmatPerDeganal;
    private boolean esFirmatPerEmpresa;
    private boolean esFirmatPerEstudiant;
    private List<Coneixement> coneixementsAdquirits;
    private Integer totalDHores;
    private boolean treballaEnComunicacioEficac;
    private boolean treballaEnEmprenadoria;
    private boolean treballaEnSostenibilitat;
    private boolean treballaEnTerceraLlengua;
    private boolean treballaraEnActitudAdequadaDavantElTreball;
    private boolean treballaraEnAprenentatgeAutonom;
    private boolean treballaraEnTreballEnEquip;
    private boolean treballaraEnUsSolventRecursosInformacio;
    private Integer tutorEmpresa;
    private String tutorFacultat;

    public ContracteDeConveni() {

    }
}