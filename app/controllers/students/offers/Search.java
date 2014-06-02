package controllers.students.offers;

import models.Oferta;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.Students.Offers.search;

import static play.data.Form.form;

public class Search extends Controller {

    public static Result index( String tipusOferta, String jornadaLaboral, String destinataris ) {
        // Check if the user has specified any param on the search input field
        String cerca = form().bindFromRequest().get( "cerca" );

        return ok( search.render( Oferta.getOfertesList( tipusOferta, jornadaLaboral, destinataris, cerca ),
                cerca,
                tipusOferta,
                jornadaLaboral,
                destinataris ) );
    }

}
