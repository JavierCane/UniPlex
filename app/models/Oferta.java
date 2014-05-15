package models;

import java.util.Date;

public class Oferta {

	private Date dataCaducitat;
	private Date dataCaducitatPromocio;
	private Date dataInsercio;
	private String descripcioTfg;
	private String emailContacte;
	private String informacioOferta;
	private tipusJornada jornadaLaboral;
	private String personaContacte;
	public Poblacio m_Poblacio;
	public CodiPostal m_CodiPostal;

	public Oferta(){

	}

	public void finalize() throws Throwable {

	}
}//end Oferta