package models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue( "Empresa" )
final public class Empresa extends Usuari {

    @Column( unique = true )
    private String cif;

    private String logo;

    private String telefon;

//    private Date dataActualitzacio;
//    private String altresDades;
//    private List<Oferta> oferta;
//    private CodiPostal codiPostal;

    public Empresa( String nom,
                    String user,
                    String password,
                    String email,
                    boolean esAdministrador,
                    boolean esBlocat,
                    boolean esDeganal,
                    Date expiracioBlocatge,
                    String motiuBlocatge,
                    String cif,
                    String logo,
                    String telefon ) {
        super( nom, user, password, email, esAdministrador, esBlocat, esDeganal, expiracioBlocatge, motiuBlocatge );

        this.cif = cif;
        this.logo = logo;
        this.telefon = telefon;
    }

    public String getCif() {
        return cif;
    }

    public void setCif( String cif ) {
        this.cif = cif;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo( String logo ) {
        this.logo = logo;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon( String telefon ) {
        this.telefon = telefon;
    }
}