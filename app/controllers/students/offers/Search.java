// TODO: Cache: http://www.playframework.com/documentation/2.2.x/JavaCache
// TODO: i18n: http://www.playframework.com/documentation/2.2.x/JavaI18N
package controllers.students.offers;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Query;
import models.Oferta;
import org.apache.commons.lang3.StringUtils;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import views.html.Students.Offers.search;

import java.util.ArrayList;
import java.util.List;

import static play.data.Form.form;

public class Search extends Controller {

    public static Result index( String tipusOferta, String jornadaLaboral, String destinataris ) {
        boolean isAnyFilterSet = false;
        boolean isAnySearchSet = false;

        // Check if the user has specified any param on the search input field
        String cerca = form().bindFromRequest().get( "cerca" );

        List<String> searchSqlSentences = new ArrayList<>();
        List<Object> searchSqlValues = new ArrayList<>();

        if ( cerca != null ) {
            cerca = cerca.toLowerCase();

            searchSqlSentences.add( "titol like ?" );
            searchSqlValues.add( "%" + cerca + "%" );

            searchSqlSentences.add( "informacio_oferta like ?" );
            searchSqlValues.add( "%" + cerca + "%" );

            searchSqlSentences.add( "empresa.nom like ?" );
            searchSqlValues.add( "%" + cerca + "%" );

            isAnySearchSet = true;
        }

        // Check if the user has specified any other filters
        List<String> filtersSqlSentences = new ArrayList<>();
        List<Object> filtersSqlValues = new ArrayList<>();

        // Tipus Oferta
        if ( !tipusOferta.equals( "Indiferent" ) ) {
            filtersSqlSentences.add( "tipus_oferta IN( 'Indiferent', ? )" );
            filtersSqlValues.add( tipusOferta );

            isAnyFilterSet = true;
        }

        // Jornada Laboral
        if ( !jornadaLaboral.equals( "Indiferent" ) ) {
            filtersSqlSentences.add( "jornada_laboral IN( 'Indiferent', ? )" );
            filtersSqlValues.add( jornadaLaboral );

            isAnyFilterSet = true;
        }

        System.out.println( destinataris );
        // Destinataris
        if ( !destinataris.equals( "Indiferent" ) ) {
            filtersSqlSentences.add( "destinatari IN( 'Indiferent', ? )" );
            filtersSqlValues.add( destinataris );

            isAnyFilterSet = true;
        }

        // Construct the Ebean query making an OR of the search terms and an AND of the specifiedfilters
        Query<Oferta> query = Ebean.createQuery( Oferta.class );

        String sqlSentence= StringUtils.join( searchSqlSentences, " OR " );
        if ( isAnyFilterSet ) {
            if ( isAnySearchSet ) {
                sqlSentence += " AND ";
            }
            sqlSentence += StringUtils.join( filtersSqlSentences, " AND " );
        }

        query.where( sqlSentence );

        // Set search SQL values
        int i = 1;
        for ( Object param : searchSqlValues ) {
            query.setParameter( i, param );
            i++;
        }

        // Set filters SQL values
        i = 1;
        for ( Object param : filtersSqlValues ) {
            query.setParameter( i, param );
            i++;
        }

//      ofertes_filtrades = Oferta.find
//              .orderBy( "data_insercio desc" ) // TODO Parametrizar orden
//              .findPagingList( RESULTS_PER_PAGE ) // Limitamos el número de resultados
//              .setFetchAhead( ENABLE_FETCH_AHEAD ) // Deshabilitamos el fetch de la siguiente página automático en background
//              .getPage( paginaActual * RESULTS_PER_PAGE ) // Calculamos el offset de los resultados en función de la página actual y el # de resultados por página
//              .getList();


        // Assign the URL base depending on if the current URI has any querystring or not
//        String urlBasePerParametritzar;
//        if ( request().uri().contains( "?" ) ) {
//            urlBasePerParametritzar = request().uri() + "&";
//        } else {
//            urlBasePerParametritzar = request().uri() + "?";
//        }

        return ok( search.render( query.findList(), cerca, tipusOferta, jornadaLaboral, destinataris ) );
    }
}
