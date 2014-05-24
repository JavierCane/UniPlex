package controllers.students.offers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.Students.Offers.details;

public class Details extends Controller {

    public static Result viewOfferDetails( String companyUrlize, String offerUrlize, long offerId ) {
        String headerText = "Job details for offer ID: " + offerId + ", companyUrlize: " + companyUrlize + ", offerUrlize: " + offerUrlize;

        return ok( details.render( companyUrlize + " offer details | UniPlex", headerText ) );
    }
}
