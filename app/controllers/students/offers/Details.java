package controllers.students.offers;

import models.Oferta;
import play.db.ebean.Model;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.Students.Offers.details;

public class Details extends Controller {

    public static Result viewOfferDetails( String companyUrlize, String offerUrlize, long offerId ) {
        // TODO: Comprobar urlize empresa y oferta con respecto a los del ID de la oferta, si no coinciden, 301 al correcto.

        Oferta oferta = Oferta.find.byId( 1 );

        String headerText = "Job details for offer ID: " + offerId + ", companyUrlize: " + companyUrlize + ", offerUrlize: " + offerUrlize;

        return ok( details.render( offerUrlize + " a " + companyUrlize, headerText, oferta ) );
    }
}
