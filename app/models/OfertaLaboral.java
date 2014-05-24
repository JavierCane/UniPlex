package models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("OfertaLaboral")
final public class OfertaLaboral extends Oferta {

    public OfertaLaboral() {

    }
}