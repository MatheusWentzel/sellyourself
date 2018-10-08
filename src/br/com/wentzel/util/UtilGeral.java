/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wentzel.util;

/**
 *
 * @author Matheus
 */
public class UtilGeral {

    public static String removeSpaces(String word) {

        String[] vet = word.split(" ");
        String[] vet2 = new String[vet.length];
        for (int i = 0; i < vet.length; i++) {
            vet2[i] = vet[i].replaceAll(" ", "");
        }
        word = "";
        for (int i = 0; i < vet.length; i++) {
            word = word + vet2[i] + " ";
        }

        return word;

    }

    public static String returnIdFromIdDesc(String idDesc) {

        String[] parse = idDesc.split("-");

        String id = parse[0].trim();

        return id;

    }

}
