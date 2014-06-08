package controllers.students.offers;

import models.Oferta;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.Students.Offers.details;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Details extends Controller {

    public static Result viewOfferDetails( String companyUrlize, String offerUrlize, Integer offerId ) {
        Oferta oferta = Oferta.find.byId( offerId );

        if ( oferta == null ) {
            return notFound( "Oferta " + offerId + " no encontrada." );
        }

        String realCompanyUrlize = normalize( oferta.getEmpresa().getNom() );
        String realOfferUrlize = normalize( oferta.getTitol() );

        if ( !companyUrlize.equals( realCompanyUrlize ) || !offerUrlize.equals( realOfferUrlize ) ) {
            return movedPermanently( routes.Details.viewOfferDetails( realCompanyUrlize, realOfferUrlize, offerId ) );
        }

        return ok( details.render( offerUrlize + " a " + companyUrlize, oferta ) );
    }

    private static String normalize( String value ) {
        try {
            value = URLEncoder.encode( value, "UTF-8" );
        } catch ( UnsupportedEncodingException e ) {
            e.printStackTrace();
        }

        return value;
    }
}
