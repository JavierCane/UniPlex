package models;

import models.types.JornadaLaboral;
import play.db.ebean.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn( name = "type", discriminatorType = DiscriminatorType.STRING )
public abstract class Oferta extends Model {

    @Id
    @GeneratedValue
    private Integer id;

    /**
     * Nombre descriptivo de la oferta.
     */
    @NotNull
    private String titol;

    /**
     * Descripción ampliada de la oferta.
     */
    @NotNull
    private String informacioOferta;

    @ElementCollection( targetClass = JornadaLaboral.class )
    @CollectionTable( name = "jornadaLaboral", joinColumns = @JoinColumn( name = "ofertaId" ) )
    @Column( name = "jornadaLaboral", nullable = false )
    @Enumerated( EnumType.STRING )
    private List<JornadaLaboral> jornadaLaboralList;

//    private Date dataInsercio;
//    private Date dataCaducitat;
//    private String nomPersonaContacte;
//    private String emailPersonaContacte;
//    private List<Coneixement> coneixementList;
//    private Empresa empresa;

//    private String descripcioTfg;
//    private CodiPostal codiPostal;
//    private List<Candidatura> candidaturaList;

    public Oferta() {

    }

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }
}