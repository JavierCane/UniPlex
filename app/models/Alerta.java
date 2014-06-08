package models;

import models.types.Destinatari;
import models.types.JornadaLaboral;
import models.types.Periodicitat;
import play.db.ebean.Model;

import java.util.List;

final public class Alerta extends Model {

    /**
     * Periodicidad de notificación de la alerta.
     */
    private Periodicitat periodicitat;

    /**
     * Filtro de posibles destinatarios de las ofertas.
     */
    private List<Destinatari> destinatari;

    /**
     * Filtro de posibles jornadas laborales de las ofertas.
     */
    private List<JornadaLaboral> jornadaLaboral;

    /**
     * Filtro de posibles poblaciones de las ofertas.
     */
    private List<Poblacio> poblacio;

    /**
     * Filtro de posibles tipos de oferta.
     */
    private List<Oferta> tipusOferta;

    /**
     * Filtro de posibles idiomas requeridos por las ofertas.
     */
    private List<Idioma> idioma;

    /**
     * Filtro de posibles conocimientos requeridos por las ofertas.
     */
    private List<Coneixement> coneixement;

    public Alerta() {

    }
}