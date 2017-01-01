package com.erecrutement.Helpers;

import com.erecrutement.Entities.Candidat;
import com.erecrutement.Entities.Offres.*;

/**
 * Created by saba on 31/12/16.
 */
public class OffreHelper {

    public static final String ENATTENTE = "en attente";

    public static String offreType(Offre offre) {

        String type = null;

        if( offre instanceof OffreCDI) {
            type = "cdi";
        } else if ( offre instanceof OffreCDD) {
            type = "cdd";
        } else if ( offre instanceof OffrePFE) {
            type = "pfe";
        }

        return type;
    }

    public static boolean hasApplied (Offre offre, Candidat candidat) {

        for(OffreCandidat offreCandidat: candidat.getOffreCandidats()) {
            if (offreCandidat.getOffre().equals(offre)) {
                return true;
            }
        }
        return false;
    }
}
