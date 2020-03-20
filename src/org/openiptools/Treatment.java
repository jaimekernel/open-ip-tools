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
    
    public static String[] input(String[] i){
        /*
            i = {"ip Sem tratamento", "mascara Sem tratamento"};
        */
        String r[] = new String[4];
        Arrays.fill(r, "0");
        if(i[0].length() >= 7 && i[0].length() <=15 && i[0].replaceAll("[^.]","").length() == 3){
            r = i[0].split("[.]",4);
            for(int c  = 0 ; c < r.length ; c++){
                if(r[c].length() < 1){
                    r[c] = String.format("0%s", r[c]);
                    }
            }
            i[0] = Arrays.toString(r).replaceAll(", ", ".");
            i[0] = i[0].replaceAll("[\\[\\]]","");
        }
        else {
            i[0] = "erro cod(28)";
        }
        /*
            return  <<--- Aqui era
        */
        //falha e a onde?
        String fail = "";
        String msk = "";
        //Detector de Prefixo | Filtro de erros | substituição [/] por 0 evitar erro em teste de condições
        if (i[1].substring(0,1).contains("/") && Integer.parseInt(i[1].replaceAll("[/]", "0")) > 0 && Integer.parseInt(i[1].replaceAll("[/]", "0")) <=32 && i[1].length() <= 3){
            //Detector de Prefixo | impedir prefixo acima de 32
          msk = "mask em /**";
        }
        else{
            //Analisa tipo de mascara 255.255.255.255
           //Inicio 
           //
            String mskid[] = {"128","192","224","240","248","252","254","255","000"};
            if (i[1].replaceAll("[.]","").length() >= 6 && i[1].replaceAll("[.]", "").length() <= 12 && i[1].replaceAll("[^.]","").length() == 3){
                //verifica erros, e numero?
                int num = 0;
                //
                for(int c = 0 ; c < i[1].replaceAll("[.]", "").length(); c++){
                    if(Character.isDigit(i[1].replaceAll("[.]", "").charAt(c))==true)
                        num += 1;
                    if (num != c+1){
                        fail = "Caracter Invalido cod(67)";
                        break;
                    }
                }
                int z = 0;
                int u = 0;
                int x = 0;
                //
                if (fail == ""){
                    /*   Linha (17)
                    String r[] = new String[4];
                         Linha (17)       */
                    r = i[1].split("[.]",4);                
                    int bit = 0;
                    for(int oct = 0 ; oct <= 3;oct++){
                        if(r[oct].length() == 2){
                            r[oct] = String.format("0%s", r[oct]);
                        }
                        else if (r[oct].length() <= 1){
                            //""
                            r[oct] = (r[oct].length() < 1)?"0":r[oct];
                            //
                            r[oct] = String.format("00%s", r[oct]);
                        }
                        //Evitar erros Ex:255.129.260.400 mask invalida
                        if (Arrays.toString(mskid).contains(r[oct])){
                        //  255.0.128.0 << Erro vc tem que corregir jaime.....
                            if (Integer.parseInt(r[oct]) > 0 && Integer.parseInt(r[oct]) < 255){
                                u += 1;
                                fail = (u > 1 || z >= 1)?"Erro cod(85)":fail;
                            }
                            
                            if (r[oct].equals("255")){
                                x += 1;
                                fail = (u >= 1 || z >= 1)?"Erro cod(90)":fail;
                            }
                            if (r[oct].equals("000")){
                                z += 1;
                                fail = (x == 0 && u == 0 && z == 1)?"Erro cod(94)":fail;
                            }
                            
                            
                            for (int a = 1 ; a < mskid.length ; a++){
                                if (r[oct].equals(mskid[a-1].replaceAll("000", "0"))){
                                    bit = a+8*oct; 
                                    //bit = bit+a; //<--Equivalente a linha acima
                                    
                                        //Tenta evita 128.255.128.0                                        
                                }
                                 //fim do for mskid
                            
                            }
                        } //fim do evita erro
                        else{
                            fail = "Erro cod(102)";
                        }
                    }
                            i[1] = String.format("%s", bit);
                }
            }
            else{
                fail = "mascara invalida cod(157)";
            }
        /*
            Resultado ou falha
                Abaixo
            
            */
        }
        if(fail !=""){
            i[1] = fail;
        }
        return i;
        
    }
}