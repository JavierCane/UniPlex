package models;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class Usuari extends Model {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @Constraints.Email
    private String email;

    @NotNull
    private boolean esAdministrador;

    @NotNull
    private boolean esBlocat;

    @NotNull
    private boolean esDeganal;

    private Date expiracioBlocatge;

    private String motiuBlocatge;

    public Usuari() {

    }
}