package controllers.students.offers;

import models.Oferta;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.Students.Offers.search;

import java.util.List;

public class Search extends Controller {

    public static Result index() {
        List<Oferta> ofertes = Oferta.find.all();

        return ok( search.render( ofertes ) );
    }

    public static Result badRequestResult() {
        return badRequest( "Ooops" );
    }

    public static Result simpleResult() {
        return ok( "Hello world" );
    }
}
