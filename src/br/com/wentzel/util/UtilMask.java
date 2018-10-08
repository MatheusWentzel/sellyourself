package br.com.wentzel.util;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Matheus
 */
public class UtilMask {

    public static void maskCpf(JFormattedTextField campo) {

        try {
            MaskFormatter m = new MaskFormatter("###.###.###-##");
            m.setValidCharacters("0123456789");
            campo.setColumns(11);
            campo.setFormatterFactory(null);
            campo.setFormatterFactory(new DefaultFormatterFactory(m));
            campo.setValue(null);
        } catch (ParseException ex) {
            Logger.getLogger(UtilMask.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void maskCelular(JFormattedTextField campo) {

        try {
            MaskFormatter m = new MaskFormatter("(##)#####-####");
            m.setValidCharacters("0123456789");
            campo.setColumns(11);
            campo.setFormatterFactory(null);
            campo.setFormatterFactory(new DefaultFormatterFactory(m));
            campo.setValue(null);
        } catch (ParseException ex) {
            Logger.getLogger(UtilMask.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void maskTelefone(JFormattedTextField campo) {

        try {
            MaskFormatter m = new MaskFormatter("(##)####-####");
            m.setValidCharacters("0123456789");
            campo.setColumns(10);
            campo.setFormatterFactory(null);
            campo.setFormatterFactory(new DefaultFormatterFactory(m));
            campo.setValue(null);
        } catch (ParseException ex) {
            Logger.getLogger(UtilMask.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void maskCnpj(JFormattedTextField campo) {

        try {
            MaskFormatter m = new MaskFormatter("##.###.###/####-##");
            m.setValidCharacters("0123456789");
            campo.setColumns(14);
            campo.setFormatterFactory(null);
            campo.setFormatterFactory(new DefaultFormatterFactory(m));
            campo.setValue(null);
        } catch (ParseException ex) {
            Logger.getLogger(UtilMask.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void maskPlaca(JFormattedTextField campo) {

        try {
            MaskFormatter m = new MaskFormatter("UUU-####");
            m.setValidCharacters("0123456789abcdefghijklmnopqrstuvxywzABCDEFGHIJKLMNOPQRSTUVXYWZ");
            campo.setColumns(7);
            campo.setFormatterFactory(null);
            campo.setFormatterFactory(new DefaultFormatterFactory(m));
            campo.setValue(null);
        } catch (ParseException ex) {
            Logger.getLogger(UtilMask.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void mask(JFormattedTextField camp, String format, int lenght, String validCharacters) {

        try {
            MaskFormatter m = new MaskFormatter(format);
            m.setValidCharacters(validCharacters);
            camp.setFormatterFactory(null);
            camp.setFormatterFactory(new DefaultFormatterFactory(m));
            camp.setValue(null);
        } catch (ParseException ex) {
            Logger.getLogger(UtilMask.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void maskData(JFormattedTextField campo) {

        try {
            MaskFormatter m = new MaskFormatter("##/##/####");
            m.setValidCharacters("0123456789");
            campo.setColumns(6);
            campo.setFormatterFactory(null);
            campo.setFormatterFactory(new DefaultFormatterFactory(m));
            campo.setValue(null);
        } catch (ParseException ex) {
            Logger.getLogger(UtilMask.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void maskValor(JFormattedTextField campo) {

        try {

            DecimalFormat dFormat = new DecimalFormat("#######.00");
            NumberFormatter formatter = new NumberFormatter(dFormat);
            formatter.setFormat(dFormat);
            formatter.setAllowsInvalid(false);
            campo.setFormatterFactory(new DefaultFormatterFactory(formatter));

        } catch (Exception e) {
            
        }

    }

    public static void desmaskData(JFormattedTextField campo) {

        String texto = campo.getText();

        texto = texto.replaceAll("/", "");

        campo.setText(texto);

    }

    public static JFormattedTextField desmaskCpf(JFormattedTextField cpf) {

        String texto = cpf.getText();

        texto = texto.replaceAll("[./-]", "");

        cpf.setText(texto);

        System.out.println("TEXTO DESMASCARADO: " + texto);

        return cpf;

    }

}
