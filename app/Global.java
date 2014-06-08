// TODO: Revisar si esto funciona
// Basado en: https://github.com/playframework/playframework/tree/master/samples/java/zentasks

import com.avaje.ebean.Ebean;
import models.Empresa;
import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.libs.Yaml;

import java.util.List;
import java.util.Map;

public class Global extends GlobalSettings {

    public void onStart( Application app ) {
        Logger.info( "Application has started." );
        InitialData.insert( app );
        Logger.info( "Initial data has been inserted." );
    }

    public void onStop( Application app ) {
        Logger.info( "Application shutdown..." );
    }

    static class InitialData {

        public static void insert( Application app ) {
            if ( Ebean.find( Empresa.class ).findRowCount() == 0 ) {

                @SuppressWarnings( "unchecked" ) Map<String, List<Object>>
                        all =
                        ( Map<String, List<Object>> ) Yaml.load( "initial-data.yml" );

                Ebean.save( all.get( "Coneixement" ) );
                Ebean.save( all.get( "Empresa" ) );

                // OfertaLaboral y oferta_coneixement
                Ebean.save( all.get( "OfertaLaboral" ) );
                for ( Object ofertaLaboral : all.get( "OfertaLaboral" ) ) {
                    // Insert the OfertaLaboral - Conexiement relation
                    Ebean.saveManyToManyAssociations( ofertaLaboral, "coneixementList" );
                }

                // OfertaDeConveni y oferta_coneixement
                Ebean.save( all.get( "OfertaDeConveni" ) );
                for ( Object ofertaLaboral : all.get( "OfertaDeConveni" ) ) {
                    // Insert the OfertaDeConveni - OfertaDeConveni relation
                    Ebean.saveManyToManyAssociations( ofertaLaboral, "coneixementList" );
                }
            }
        }

    }

}