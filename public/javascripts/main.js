/**
 * Funciones del sidebar de la búsqueda
 */
var searchSidebar = {

    init : function() {
        /* Filtros lateral búsqueda de ofertas > Substituir icono desplegable */
        $('[data-toggle=collapse]').click(function (event) {
            event.preventDefault();
            $(this).find('i.replace-class').toggleClass('glyphicon-chevron-right glyphicon-chevron-down');
        });
    }
};

/**
 * Cuando el documento esté disponible, lanzamos las funciones de inicialización del apartado en el que estemos.
 */
$(document).ready( function() {
    if ( $('#search_sidebar').length )
        searchSidebar.init();
});

