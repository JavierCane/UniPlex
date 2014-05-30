// TODO: Cache: http://www.playframework.com/documentation/2.2.x/JavaCache
// TODO: i18n: http://www.playframework.com/documentation/2.2.x/JavaI18N
package controllers.students.offers;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Query;
import models.Oferta;
import org.apache.commons.lang3.StringUtils;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.Students.Offers.search;

import java.util.ArrayList;
import java.util.List;

import static play.data.Form.form;

public class Search extends Controller {

    public static Result index() {
        String cerca = form().bindFromRequest().get( "cerca" );

        List<String> sqlList = new ArrayList<>();
        List<Object> paramsList = new ArrayList<>();

        if ( cerca != null ) {
            cerca = cerca.toLowerCase();

            sqlList.add( "titol like ?" );
            paramsList.add( "%" + cerca + "%" );

            sqlList.add( "informacio_oferta like ?" );
            paramsList.add( "%" + cerca + "%" );

            sqlList.add( "empresa.nom like ?" );
            paramsList.add( "%" + cerca + "%" );
        }

        Query<Oferta> query = Ebean.createQuery( Oferta.class );
        query.where( StringUtils.join( sqlList, " OR " ) );

        int i = 1;
        for ( Object param : paramsList ) {
            query.setParameter( i, param );
            i++;
        }

//      ofertes_filtrades = Oferta.find
//              .orderBy( "data_insercio desc" ) // TODO Parametrizar orden
//              .findPagingList( RESULTS_PER_PAGE ) // Limitamos el número de resultados
//              .setFetchAhead( ENABLE_FETCH_AHEAD ) // Deshabilitamos el fetch de la siguiente página automático en background
//              .getPage( paginaActual * RESULTS_PER_PAGE ) // Calculamos el offset de los resultados en función de la página actual y el # de resultados por página
//              .getList();

        return ok( search.render( query.findList(), cerca ) );
    }
}
