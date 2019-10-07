/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openiptools;

import java.util.Arrays;

/**
 *
 * @author jaime
 */
public class Treatment {
    public static String[] input(String i){
        String r[] = new String[4];
        Arrays.fill(r, "0");
        if(i.length() >= 7 && i.length() <=15 && i.replaceAll("[^.]","").length() == 3){
            r = i.split("[.]",4);
            for(int c  = 0 ; c < r.length ; c++){
                if(r[c].length() < 3 && r[c].length() > 0){

                    if(r[c].length() == 2){
                        r[c] = String.format("0%s", r[c]);
                    }
                    else{
                        r[c] = String.format("00%s", r[c]);
                    }
                }
                else{
                    //verificado de ip invalido adiciona pedente
                    if(r[c].length() > 3 || r[c].length() <= 0){
                        r[c] = "erro";
                        //correçao sera aplicada
                    }
                }
            }
        } 
        return r;
    }
}
