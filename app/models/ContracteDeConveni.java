package models;

import play.db.ebean.Model;

import java.util.Date;
import java.util.List;

public class ContracteDeConveni extends Model {

    protected Integer ajutPerHora;
    protected Date dataFi;
    protected Date dataIni;
    protected String descripcioCompetenciesTecniques;
    protected String descripcioTreball;
    protected String documentPDF;
    protected String emailEmp;
    protected String emailFac;
    protected boolean esFirmatPerDeganal;
    protected boolean esFirmatPerEmpresa;
    protected boolean esFirmatPerEstudiant;
    protected List<Coneixement> coneixementsAdquirits;
    protected Integer totalDHores;
    protected boolean treballaEnComunicacioEficac;
    protected boolean treballaEnEmprenadoria;
    protected boolean treballaEnSostenibilitat;
    protected boolean treballaEnTerceraLlengua;
    protected boolean treballaraEnActitudAdequadaDavantElTreball;
    protected boolean treballaraEnAprenentatgeAutonom;
    protected boolean treballaraEnTreballEnEquip;
    protected boolean treballaraEnUsSolventRecursosInformacio;
    protected Integer tutorEmpresa;
    protected String tutorFacultat;

    public ContracteDeConveni() {

    }
}