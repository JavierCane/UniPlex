package models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("Empresa")
final public class Empresa extends Usuari {

    @NotNull
    @Column(unique = true)
    private String cif;

    @NotNull
    private String nom;

    private String logo;

//    private String telefon;
//    private Date dataActualitzacio;
//    private String altresDades;
//    private List<Oferta> oferta;
//    private CodiPostal codiPostal;

    public Empresa() {

    }
}