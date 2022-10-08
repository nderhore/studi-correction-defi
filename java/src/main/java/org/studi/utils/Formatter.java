package org.studi.utils;

public class Formatter {



    public static String clean(String text){
        return text.replace('à','a').replace('é','e').replace('è','e')
                .replace('ê','e').toLowerCase();
    }

    public static int updateIndexInsideBounds(int nouveauIndice,char[] alphabet){

        //tableau = 26 longueur
        // nouveauIndice = 35

        if(0<nouveauIndice && nouveauIndice< alphabet.length) return nouveauIndice; // 9

            //nouveauIndice = 35
        else if(nouveauIndice > alphabet.length){
            nouveauIndice = nouveauIndice - alphabet.length;
            // nouveau Indice = 35 - 26 = 9
            return updateIndexInsideBounds(nouveauIndice,alphabet);
        }
        else if(nouveauIndice < 0){
            nouveauIndice = nouveauIndice + alphabet.length;
            return updateIndexInsideBounds(nouveauIndice,alphabet);
        }
        else {
            return nouveauIndice;
        }
    }
}
