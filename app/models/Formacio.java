import Types.String;

/**
 * dataIni: Date
 * dataFi: Date
 * institucio: String
 * titol: String
 * esFinalitzat: Boolean
 * dataActualizacio: Date
 * @version 1.0
 * @created 15-may-2014 8:52:30
 */
public class Formacio {

	private Date dataActualitzacio;
	private Date dataFi;
	private Date dataIni;
	private boolean esFinalitzat;
	private String institucio;
	private String titol;
	public Estudiant m_Estudiant;

	public Formacio(){

	}

	public void finalize() throws Throwable {

	}
}//end Formacio