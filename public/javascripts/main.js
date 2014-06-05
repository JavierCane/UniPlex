var uniPlex = {
    commonFunctions : {
        initTooltips : function() {
            $('[data-toggle=tooltip]').each(function(){
                $(this).tooltip();
            });
        }
    },

    searchSidebar : {
        init : function() {
            /* Filtros lateral búsqueda de ofertas > Substituir icono desplegable */
            $('#search_filters').find('[data-toggle=collapse]').click(function (event) {
                event.preventDefault();
                $(this).find('i.replace-class').toggleClass('glyphicon-chevron-right glyphicon-chevron-down');
            });

            /* Click en resultados */
            $('#search_results').find('li').click(function() {
                document.location = $(this).find('#offer_link').attr('href');
            });
        }
    }
};

/**
 * Cuando el documento esté disponible, lanzamos las funciones de inicialización del apartado en el que estemos.
 */
$(document).ready( function() {
    uniPlex.commonFunctions.initTooltips();

    if ( $('#search_filters').length )
        uniPlex.searchSidebar.init();
});

