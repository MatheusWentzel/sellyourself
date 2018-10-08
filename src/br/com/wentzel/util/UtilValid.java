package br.com.wentzel.util;

import java.util.InputMismatchException;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Matheus
 */
public class UtilValid {

    public static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean validDate(int d, int m, int a) {
        boolean correto = true;
        try {
            int[] dias = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            if (m < 1 || m > 12) {
                correto = false;
            } else if (a < 1500 || a > 2500) {
                correto = false;
            } else {
                // valida o dia
                if (a % 4 == 0 && (a % 100 != 0 || a % 400 == 0)) {
                    dias[1] = 29;
                }
                if (d < 1 || d > dias[m - 1]) {
                    correto = false;
                }
            }

        } catch (Exception e) {
            System.err.println(e);
            correto = false;
        }
        return correto;
    }

    public static boolean validDate(JFormattedTextField jft) {

        boolean correto = true;
        try {

            String[] days = jft.getText().split("/");

            int d = Integer.parseInt(days[0]);
            int m = Integer.parseInt(days[1]);
            int a = Integer.parseInt(days[2]);

            int[] dias = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            if (m < 1 || m > 12) {
                correto = false;
            } else if (a < 1500 || a > 2500) {
                correto = false;
            } else {
                // valida o dia
                if (a % 4 == 0 && (a % 100 != 0 || a % 400 == 0)) {
                    dias[1] = 29;
                }
                if (d < 1 || d > dias[m - 1]) {
                    correto = false;
                }
            }

        } catch (Exception e) {
            System.err.println(e);
            correto = false;
        }
        return correto;
    }

    public static boolean validCelPhone(JFormattedTextField jtf) {

        String tel = jtf.getText();

        if (tel == null) {
            return false;
        } else if (tel.length() != 15) {
            return false;
        } 

        return true;

    }

    public static boolean validTelephone(JFormattedTextField jtf) {

        String tel = jtf.getText();

        String formato = "([0-9]{2}?)[0-9]{4}?-[0-9]{4}?";

        if ((tel == null) || (tel.length() != 14)) {
            return false;
        } else {
            return true;
        }

    }

    public static boolean validJFormattedText(JFormattedTextField jt) {

        String dados = jt.getText().replaceAll("[.-/()]", "").replace("-", "");
        dados = UtilGeral.removeSpaces(dados);
        dados = dados.trim();

        if (dados.equals("") || dados.equals(" ")) {
            return false;
        } else {
            return true;
        }

    }

    public static boolean validJTextField(JTextField jt) {

        String dados = jt.getText().replaceAll(" ", "");
        
        if (dados.equals("")) {
            return false;
        } else {
            return true;
        }

    }

    public static boolean validCPF(JFormattedTextField jft) {

        String CPF = jft.getText().replaceAll("[..-]", "");

        if (CPF.equals("00000000000") || CPF.equals("11111111111")
                || CPF.equals("22222222222") || CPF.equals("33333333333")
                || CPF.equals("44444444444") || CPF.equals("55555555555")
                || CPF.equals("66666666666") || CPF.equals("77777777777")
                || CPF.equals("88888888888") || CPF.equals("99999999999")
                || (CPF.length() != 11)) {
            return (false);
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {

            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {

                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48);
            }

            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }

            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) {
                return (true);
            } else {
                return (false);
            }
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

}
