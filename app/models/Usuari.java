package models;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn( name = "tipus", discriminatorType = DiscriminatorType.STRING )
public class Usuari extends Model {

    @Id
    @GeneratedValue
    protected Integer id;

    @NotNull
    protected String nom;

    @NotNull
    protected String user;

    @NotNull
    protected String password;

    @NotNull
    @Constraints.Email
    @Column( unique = true )
    protected String email;

    @NotNull
    protected boolean esAdministrador;

    @NotNull
    protected boolean esBlocat;

    @NotNull
    protected boolean esDeganal;

    @Temporal( TemporalType.DATE )
    protected Date expiracioBlocatge;

    protected String motiuBlocatge;

    public Usuari( String nom, String user, String password, String email, boolean esAdministrador, boolean esBlocat, boolean esDeganal, Date expiracioBlocatge, String motiuBlocatge ) {
        this.nom = nom;
        this.user = user;
        this.password = password;
        this.email = email;
        this.esAdministrador = esAdministrador;
        this.esBlocat = esBlocat;
        this.esDeganal = esDeganal;
        this.expiracioBlocatge = expiracioBlocatge;
        this.motiuBlocatge = motiuBlocatge;
    }

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }

    public String getUser() {
        return user;
    }

    public void setUser( String user ) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public boolean isEsAdministrador() {
        return esAdministrador;
    }

    public void setEsAdministrador( boolean esAdministrador ) {
        this.esAdministrador = esAdministrador;
    }

    public boolean isEsBlocat() {
        return esBlocat;
    }

    public void setEsBlocat( boolean esBlocat ) {
        this.esBlocat = esBlocat;
    }

    public boolean isEsDeganal() {
        return esDeganal;
    }

    public void setEsDeganal( boolean esDeganal ) {
        this.esDeganal = esDeganal;
    }

    public Date getExpiracioBlocatge() {
        return expiracioBlocatge;
    }

    public void setExpiracioBlocatge( Date expiracioBlocatge ) {
        this.expiracioBlocatge = expiracioBlocatge;
    }

    public String getMotiuBlocatge() {
        return motiuBlocatge;
    }

    public void setMotiuBlocatge( String motiuBlocatge ) {
        this.motiuBlocatge = motiuBlocatge;
    }
}