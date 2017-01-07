/**
 * Created by saba on 30/12/16.
 */
(function (win, container, spinner) {
    const offresLoader = {
        offresUrl: "/offres/load?",
        offreDetailsUrl: "/offres/details/",
        params: {
            page: 0,
            size: 4
        },
        loadedDataSize: 0,
        load: function () {
            const self = this;
            const url = this.offresUrl + $.param(this.params);
            let params = this.params;
            $.get(url,
                function (data, status) {
                    if (status === "success") {
                        params.page++;
                        self.createOffres(data.offres);
                        spinner.hide();

                        // on récup le nombre d'éléments chargé pour savoir si y a d'autres données
                        self.loadedDataSize = data.offres.length;
                    }
                });
        },
        createOffres: function (offres) {
            const self = this;
            offres.forEach(function (offre) {
                self.createOffre(offre);
            });
        },
        createOffre: function (offreData) {

            const offre = $("<div></div>").addClass('card-box');
            const row = $("<div></div>").addClass('row');

            const detailsColumn = $("<div></div>").addClass('col-xs-9');
            const imageColumn = $("<div></div>").addClass('col-xs-3');

            // DETAILS COLUMN
            const offreDetailsUrl = this.offreDetailsUrl + offreData.id;
            const url = $("<a></a>").attr("href", offreDetailsUrl).html(offreData.title);
            const title = $("<h3></h3>").append(url);
            const datePublished = $("<h5></h5>").addClass("").html("Publié le: " + offreData.datePublished);

            // IMAGE COLUMN

            detailsColumn.append(title);
            detailsColumn.append(datePublished);
            imageColumn.html("image");
            row.append(detailsColumn);
            row.append(imageColumn);
            offre.append(row);

            container.append(offre);
        },
        infiniteScroll: function () {
            const self = this;
            spinner.hide();
            win.scroll(function () {
                if (self.noMoreData()) {
                    if(!self.isEndOfDataDivDisplayed()) {
                        self.displayEndOfDataDiv();
                    }
                } else {
                    // End of the document reached?
                    if ($(document).height() - win.height() == win.scrollTop()) {
                        spinner.show();
                        self.load();
                    }
                }
            });
        },
        noMoreData: function () {
            return (this.loadedDataSize < this.params.size);
        },
        displayEndOfDataDiv: function() {
            const endOfDataDiv = $("<div></div>").addClass('card-box')
                                                 .attr("id","endOfDataDiv")
                                                 .html("No more data to display");
            container.append(endOfDataDiv);
        },
        isEndOfDataDivDisplayed: function() {
            return $('#endOfDataDiv').length === 1;
        }
    };

    offresLoader.load();
    offresLoader.infiniteScroll();



})($(window), $('#offresDiv'), $('#loading'));