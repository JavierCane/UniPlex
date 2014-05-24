package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {

    public static Result index() {
        bool isTest = true;
        return ok( index.render( "Your new application is ready." ) );
    }

    public static Result badRequestResult() {
        return badRequest( "Ooops" );
    }

    public static Result simpleResult() {
        return ok( "Hello world" );
    }

    public static Result viewJobDetails( String urlize, long id ) {
        return ok( "Job details for job ID: " + id + ", urlize: " + urlize );
    }
}
