package models;

import models.types.JornadaLaboral;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@DiscriminatorValue("OfertaDeConveni")
final public class OfertaDeConveni extends Oferta {

//    private ContracteDeConveni contracteDeConveni;

    public OfertaDeConveni( String titol, String informacioOferta, JornadaLaboral jornadaLaboral, Date dataInsercio, Date dataCaducitat, String nomPersonaContacte, String emailPersonaContacte, List<Coneixement> coneixementList, Empresa empresa ) {
        super( titol, informacioOferta, jornadaLaboral, dataInsercio, dataCaducitat, nomPersonaContacte, emailPersonaContacte, coneixementList, empresa );
    }
}