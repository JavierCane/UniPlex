package models;

import models.types.Destinatari;
import models.types.JornadaLaboral;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@DiscriminatorValue( "OfertaLaboral" )
final public class OfertaLaboral extends Oferta {

    public OfertaLaboral( String titol, String informacioOferta, JornadaLaboral jornadaLaboral, Destinatari destinatari, Date dataInsercio, Date dataCaducitat, String nomPersonaContacte, String emailPersonaContacte, List<Coneixement> coneixementList, Empresa empresa ) {
        super( titol, informacioOferta, jornadaLaboral, destinatari, dataInsercio, dataCaducitat, nomPersonaContacte, emailPersonaContacte, coneixementList, empresa );
    }
}