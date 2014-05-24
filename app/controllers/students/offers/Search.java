package controllers.students.offers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.Students.Offers.search;

public class Search extends Controller {

    public static Result index() {
        return ok( search.render( "Your new application is ready." ) );
    }

    public static Result badRequestResult() {
        return badRequest( "Ooops" );
    }

    public static Result simpleResult() {
        return ok( "Hello world" );
    }
}
