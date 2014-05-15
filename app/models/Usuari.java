package models;

import java.util.Date;

public class Usuari {

    private boolean esAdministrador;
    private boolean esBlocat;
    private boolean esDeganal;
    private Date expiracioBlocatge;
    private String motiuBlocatge;
    private String password;
    private String username;

    public Usuari() {

    }
}