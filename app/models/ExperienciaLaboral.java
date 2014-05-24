package models;

import play.db.ebean.Model;

import java.util.Date;

final public class ExperienciaLaboral extends Model {

    private Date dataFi;
    private Date dataIni;
    private String nomEmpresa;
    private String ocupacio;

    public ExperienciaLaboral() {

    }
}