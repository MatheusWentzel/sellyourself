/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wentzel.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matheus
 */
public class UtilDate {

    public static String formatDateDMAtoBD(String data) {

        String dataF = "";

        try {
            
            java.util.Date dateBD = new SimpleDateFormat("dd/MM/yyyy").parse(data);
            dataF = new SimpleDateFormat("yyyy-MM-dd").format(dateBD);

        } catch (ParseException ex) {
            return null;
        }

        return dataF;

    }

    public static String formatDateBDtoDMA(String data) {

        String dataF = "";

        try {
            
            java.util.Date dateBD = new SimpleDateFormat("yyyy-MM-dd").parse(data);
            dataF = new SimpleDateFormat("dd/MM/yyyy").format(dateBD);

        } catch (ParseException ex) {
            Logger.getLogger(UtilDate.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dataF;

    }

}
