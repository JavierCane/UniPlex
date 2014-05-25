/* Filtros lateral búsqueda de ofertas > Substituir icono desplegable */
$('[data-toggle=collapse]').click(function (event) {
    event.preventDefault();
    $(this).find('i.replace-class').toggleClass('glyphicon-chevron-right glyphicon-chevron-down');
});