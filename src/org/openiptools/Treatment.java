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
    public static String inputmask(String i){
        String msk = "";
        //Detector de Prefixo | Filtro de erros | substituição [/] por 0 evitar erro em teste de condições
        if (i.substring(0,1).contains("/") && Integer.parseInt(i.replaceAll("[/]", "0")) > 0 && Integer.parseInt(i.replaceAll("[/]", "0")) <=32 && i.length() <= 3){
            //Detector de Prefixo | impedir prefixo acima de 32
          msk = "mask em /**";
        }
        else{
            msk = "mask / com erro";
        }
        if (i.replaceAll("[.]","").length() >= 6 && i.replaceAll("[.]", "").length() <= 12 && i.replaceAll("[^.]","").length() == 3){
            
            int c = 0;
            String r[] = new String[4];
            r = i.split("[.]",4);
            
            for(int oct = 0 ; oct <= 3; oct++){
                
                if (r[oct].contains("255")){
                    continue;
                }
                else{
                    switch(r[oct]){
                        case "128":
                            break;
                        case "192":
                            break;
                        case "224":
                            break;
                        case "240":
                            break;
                        case "248":
                            break;
                        case "252":
                            break;
                        case "254":
                            break;
                        default:
                            msk = "erro";
                    }
                }
                /*if (r[oct].contains("128") || r[oct].contains("192") || r[oct].contains("224") || i.substring(c,c+4).contains("240") || i.substring(c,c+4).contains("248") || i.substring(c,c+4).contains("252") || i.substring(c,c+4).contains("254")){
                    k = "sub rede 128";
                }*/
                if (i.substring(c+3,c+4).contains(".")){
                    c =+ 4;
                    msk = "ponto ok";
                    
                    
                }
            }
        }
        
        return msk;
        
    }
}
