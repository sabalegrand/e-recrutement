/**
 * Created by nunna on 07/01/17.
 */
(function () {
    const typeSelect = $('#type'),
        secteurSelect = $('#secteur'),
        niveauSelect = $('#niveau'),
        metierSelect = $('#metier')
        ;

    $.each(types, function (key, value) {
        typeSelect.append("<option value ="+key+">"+ value + "</option>");
    });
    $.each(sectors, function (key, value) {
        secteurSelect.append('<option value =' + key + '>' + value + '</option>');
    });
    $.each(niveaux, function (key, value) {
        niveauSelect.append('<option value='+ key + '>' + value + '</option>')
    });
    $.each(metiers, function (key, value) {
        metierSelect.append('<option value='+key+'>' + value + '</option>')
    });



    const advancedSearchLink = $('#advancedSearchLink'),
        advancedSearch = $('#advancedSearch');

    advancedSearch.hide();
    advancedSearchLink.click(function (e) {
        advancedSearch.css('display') === 'none' ? advancedSearch.css('display', '') : advancedSearch.css('display', 'none');
    })   ;
})();
