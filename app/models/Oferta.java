package models;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Query;
import models.types.Destinatari;
import models.types.JornadaLaboral;
import org.apache.commons.lang3.StringUtils;
import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn( name = "tipus_oferta", discriminatorType = DiscriminatorType.STRING )
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
    @Constraints.Required
    @Enumerated( EnumType.STRING )
    protected Destinatari destinatari;

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
            inverseJoinColumns = @JoinColumn( name = "conexiement_id" ) )
    protected List<Coneixement> coneixementList;

    @ManyToOne( cascade = CascadeType.ALL, targetEntity = Empresa.class )
    protected Empresa empresa;

    public static Finder<Integer, Oferta> find = new Finder( Integer.class, Oferta.class );

//    private String descripcioTfg;
//    private CodiPostal codiPostal;
//    private List<Candidatura> candidaturaList;

    public Oferta( String titol,
                   String informacioOferta,
                   JornadaLaboral jornadaLaboral,
                   Destinatari destinatari,
                   Date dataInsercio,
                   Date dataCaducitat,
                   String nomPersonaContacte,
                   String emailPersonaContacte,
                   List<Coneixement> coneixementList,
                   Empresa empresa ) {
        this.titol = titol;
        this.informacioOferta = informacioOferta;
        this.jornadaLaboral = jornadaLaboral;
        this.destinatari = destinatari;
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

    public Destinatari getDestinatari() {
        return destinatari;
    }

    public void setDestinatari( Destinatari destinatari ) {
        this.destinatari = destinatari;
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

    public static List<Oferta> getOfertesList( String tipusOferta,
                                               String jornadaLaboral,
                                               String destinataris,
                                               String cerca ) {
        List<String> searchSqlSentences = new ArrayList<String>();
        List<Object> searchSqlValues = new ArrayList<Object>();

        // Establecer los parámetros de filtrado de la consulta SQL en cuanto a búsqueda.
        setSearchSql( cerca, searchSqlSentences, searchSqlValues );

        List<String> filtersSqlSentences = new ArrayList<String>();
        List<Object> filtersSqlValues = new ArrayList<Object>();

        // Establecer los parámetros de filtrado de la consulta SQL en cuanto a filtros.
        setFilterSql( tipusOferta, "tipus_oferta", filtersSqlSentences, filtersSqlValues );
        setFilterSql( jornadaLaboral, "jornada_laboral", filtersSqlSentences, filtersSqlValues );
        setFilterSql( destinataris, "destinatari", filtersSqlSentences, filtersSqlValues );

        // Obtener la query en base a los parámetros de filtrado construidos.
        Query<Oferta>
                query =
                getOfertaQuery( searchSqlSentences, searchSqlValues, filtersSqlSentences, filtersSqlValues );

        // Retornar resultado de query.
        return query.findList();
    }

    private static void setSearchSql( String cerca, List<String> searchSqlSentences, List<Object> searchSqlValues ) {
        if ( cerca != null ) {
            cerca = cerca.toLowerCase();

            searchSqlSentences.add( "titol like ?" );
            searchSqlValues.add( "%" + cerca + "%" );

            searchSqlSentences.add( "informacio_oferta like ?" );
            searchSqlValues.add( "%" + cerca + "%" );

            searchSqlSentences.add( "empresa.nom like ?" );
            searchSqlValues.add( "%" + cerca + "%" );
        }
    }

    private static void setFilterSql( String filterValue,
                                      String filterDbTable,
                                      List<String> filtersSqlSentences,
                                      List<Object> filtersSqlValues ) {
        if ( !filterValue.equals( "Indiferent" ) ) {
            filtersSqlSentences.add( filterDbTable + " IN( 'Indiferent', ? )" );
            filtersSqlValues.add( filterValue );
        }
    }

    private static Query<Oferta> getOfertaQuery( List<String> searchSqlSentences,
                                                 List<Object> searchSqlValues,
                                                 List<String> filtersSqlSentences,
                                                 List<Object> filtersSqlValues ) {
        // Construct the Ebean query making an OR of the search terms and an AND of the specifiedfilters
        Query<Oferta> query = Ebean.createQuery( Oferta.class );

        String sqlSentence = "";
        if ( !searchSqlSentences.isEmpty() ) {
            sqlSentence = "(" + StringUtils.join( searchSqlSentences, " OR " ) + ")";
        }

        if ( !filtersSqlSentences.isEmpty() ) {
            if ( !searchSqlSentences.isEmpty() ) {
                sqlSentence += " AND ";
            }
            sqlSentence += StringUtils.join( filtersSqlSentences, " AND " );
        }

        query.where( sqlSentence );

        // Set search SQL values
        int i = 1;
        for ( Object param : searchSqlValues ) {
            query.setParameter( i, param );
            i++;
        }

        // Set filters SQL values
        for ( Object param : filtersSqlValues ) {
            query.setParameter( i, param );
            i++;
        }
        return query;
    }
}