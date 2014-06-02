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

        String realCompanyUrlize = oferta.getEmpresa().getNom();
        try {
            realCompanyUrlize = URLEncoder.encode( realCompanyUrlize, "UTF-8" );
        } catch ( UnsupportedEncodingException e ) {
            e.printStackTrace();
        }

        String realOfferUrlize = oferta.getTitol();
        try {
            realOfferUrlize = URLEncoder.encode( realOfferUrlize, "UTF-8" );
        } catch ( UnsupportedEncodingException e ) {
            e.printStackTrace();
        }

        if ( !companyUrlize.equals( realCompanyUrlize ) || !offerUrlize.equals( realOfferUrlize ) ) {
            return movedPermanently( controllers.students.offers.routes.Details.viewOfferDetails( realCompanyUrlize, realOfferUrlize, offerId ) );
        }

        String headerText = "Job details for offer ID: " + offerId + ", companyUrlize: " + companyUrlize + ", offerUrlize: " + offerUrlize;

        return ok( details.render( offerUrlize + " a " + companyUrlize, headerText, oferta ) );
    }
}
