package models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("OfertaDeConveni")
final public class OfertaDeConveni extends Oferta {

//    private ContracteDeConveni contracteDeConveni;

    public OfertaDeConveni() {

    }
}