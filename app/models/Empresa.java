import Types.Integer;

/**
 * @version 1.0
 * @created 15-may-2014 8:52:30
 */
public class Empresa extends Usuari {

	private String altresDades;
	private String cognom2;
	private Date dataActualitzacio;
	private String dni;
	private String email;
	private String fotografia;
	private String logo;
	private String nom;
	private Integer nss;
	private String telefon;
	public Alerta m_Alerta;
	public Oferta m_Oferta;

	public Empresa(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
}//end Empresa