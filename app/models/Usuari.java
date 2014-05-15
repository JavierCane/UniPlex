

/**
 * username: String
 * password: String
 * esBlocat: Boolean
 * expiracioBlocatge: Date
 * motiuBlocatge: String
 * esDeganal: Boolean
 * esAdministrador: Boolean
 * @version 1.0
 * @created 15-may-2014 8:52:30
 */
public class Usuari {

	private boolean esAdministrador;
	private boolean esBlocat;
	private boolean esDeganal;
	private Date expiracioBlocatge;
	private String motiuBlocatge;
	private String password;
	private String username;

	public Usuari(){

	}

	public void finalize() throws Throwable {

	}
}//end Usuari