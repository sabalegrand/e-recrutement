/**
* Theme: Zircos Admin Template
* Author: Coderthemes
* Form wizard page
*/

!function($) {
    "use strict";

    var FormWizard = function() {};
    
    //creates vertical form
    FormWizard.prototype.createVertical = function($form_container) {
        $form_container.steps({
            headerTag: "h3",
            bodyTag: "section",
            transitionEffect: "fade",
            stepsOrientation: "vertical",
            onFinished: function (event, currentIndex) {
                //NOTE: Submit the form, if all validation passed.
                $("#signup-entreprise").submit();
            }
        });
        return $form_container;
    },
    FormWizard.prototype.init = function() {
        //initialzing various forms
        //vertical form
        this.createVertical($("#signup-entreprise"));
    },
    //init
    $.FormWizard = new FormWizard, $.FormWizard.Constructor = FormWizard
}(window.jQuery),

//initializing 
function($) {
    "use strict";
    $.FormWizard.init()
}(window.jQuery);