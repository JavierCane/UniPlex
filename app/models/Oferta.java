package models;

import models.types.JornadaLaboral;
import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn( name = "tipus", discriminatorType = DiscriminatorType.STRING )
public class Oferta extends Model {

    @Id
    @GeneratedValue
    protected Integer id;

    /**
     * Nombre descriptivo de la oferta.
     */
    @NotNull
    @Constraints.MinLength( 8 )
    @Constraints.MaxLength( 128 )
    protected String titol;

    /**
     * Descripción ampliada de la oferta.
     */
    @NotNull
    @Constraints.MinLength( 128 )
    @Lob
    protected String informacioOferta;

    @NotNull
    @Constraints.Required
    @Enumerated( EnumType.STRING )
    protected JornadaLaboral jornadaLaboral;

    @NotNull
    @Temporal( TemporalType.TIMESTAMP )
    protected Date dataInsercio;

    @Temporal( TemporalType.DATE )
    protected Date dataCaducitat;

    protected String nomPersonaContacte;

    @Constraints.Email
    protected String emailPersonaContacte;

    @ManyToMany
    @JoinTable(
            name = "oferta_conexiement",
            joinColumns = @JoinColumn( name = "oferta_id" ),
            inverseJoinColumns = @JoinColumn( name = "conexiement_id" )
    )
    protected List<Coneixement> coneixementList;

    @ManyToOne( cascade = CascadeType.ALL, targetEntity = Empresa.class )
    protected Empresa empresa;

    public static Finder<Integer, Oferta> find = new Finder(
            Integer.class, Oferta.class
    );

//    private String descripcioTfg;
//    private CodiPostal codiPostal;
//    private List<Candidatura> candidaturaList;

    public Oferta( String titol, String informacioOferta, JornadaLaboral jornadaLaboral, Date dataInsercio, Date dataCaducitat, String nomPersonaContacte, String emailPersonaContacte, List<Coneixement> coneixementList, Empresa empresa ) {
        this.titol = titol;
        this.informacioOferta = informacioOferta;
        this.jornadaLaboral = jornadaLaboral;
        this.dataInsercio = dataInsercio;
        this.dataCaducitat = dataCaducitat;
        this.nomPersonaContacte = nomPersonaContacte;
        this.emailPersonaContacte = emailPersonaContacte;
        this.coneixementList = coneixementList;
        this.empresa = empresa;
    }

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol( String titol ) {
        this.titol = titol;
    }

    public String getInformacioOferta() {
        return informacioOferta;
    }

    public void setInformacioOferta( String informacioOferta ) {
        this.informacioOferta = informacioOferta;
    }

    public JornadaLaboral getJornadaLaboral() {
        return jornadaLaboral;
    }

    public void setJornadaLaboral( JornadaLaboral jornadaLaboral ) {
        this.jornadaLaboral = jornadaLaboral;
    }

    public Date getDataInsercio() {
        return dataInsercio;
    }

    public void setDataInsercio( Date dataInsercio ) {
        this.dataInsercio = dataInsercio;
    }

    public Date getDataCaducitat() {
        return dataCaducitat;
    }

    public void setDataCaducitat( Date dataCaducitat ) {
        this.dataCaducitat = dataCaducitat;
    }

    public String getNomPersonaContacte() {
        return nomPersonaContacte;
    }

    public void setNomPersonaContacte( String nomPersonaContacte ) {
        this.nomPersonaContacte = nomPersonaContacte;
    }

    public String getEmailPersonaContacte() {
        return emailPersonaContacte;
    }

    public void setEmailPersonaContacte( String emailPersonaContacte ) {
        this.emailPersonaContacte = emailPersonaContacte;
    }

    public List<Coneixement> getConeixementList() {
        return coneixementList;
    }

    public void setConeixementList( List<Coneixement> coneixementList ) {
        this.coneixementList = coneixementList;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa( Empresa empresa ) {
        this.empresa = empresa;
    }
}