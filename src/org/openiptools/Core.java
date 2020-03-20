/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openiptools;

/**
 *
 * @author jaime
 */
public class Core {
    public static String[] input(String[] i) {
        int bit = 32;
        //previnir jaime o erro de string erro TEMOS UMA FALHA AQUI!!!! 
        int msk = Integer.parseInt(i[1]);
        Integer[] ip = new Integer[4];
        
        int andress = (2^(bit-msk)); 
        
        //Script de contagens
        /*if

        for(int oct=3;oct>=0;oct--){
            for(int ct = 0;ct<=andress-1;ct++){
                ip[oct] = ++ip[oct];
                
                
            }
            
            
        }*/
        return i;
    }
    
}
