package br.com.wentzel.controller;

import br.com.wentzel.persistencia.main.PObjectDAO;
import br.com.wentzel.util.UtilDate;
import br.com.wentzel.util.UtilMask;
import br.com.wentzel.views.ConsultaCad;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Matheus
 */
public class UtilControler {

    public static void desmaskJFormattedTextField(JInternalFrame view, Object object) {

        Class cCliente = object.getClass();
        Class cCadCliente = view.getClass();

        Annotation annotation;
        Mask mask;

        ArrayList<String[]> masks = new ArrayList();

        Object oAux;
        JFormattedTextField jft = new JFormattedTextField();
        String val;

        for (Method m : cCliente.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Mask.class)) {

                try {

                    annotation = m.getAnnotation(Mask.class);
                    mask = (Mask) annotation;

                    val = (String) m.invoke(object);

                    masks.add(new String[]{
                        mask.mask(),
                        mask.length() + "",
                        mask.validCharacters(),
                        m.getName(),
                        val,
                        mask.date() + ""
                    });

                    mask = null;
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(UtilControler.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(UtilControler.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(UtilControler.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }

        for (Method m : cCliente.getDeclaredMethods()) {
            for (int i = 0; i < masks.size(); i++) {
                if (m.getName().equals(masks.get(i)[3].replace("get", "set"))) {
                    if (masks.get(i)[4] != null && masks.get(i)[0] != null) {

                        try {

                            if (masks.get(i)[5].equals("false")) {

                                val = masks.get(i)[4].replaceAll("[" + masks.get(i)[0].replaceAll("[#]", "") + "]", "");

                            } else {

                                val = UtilDate.formatDateDMAtoBD(masks.get(i)[4]);

                            }

                            m.invoke(object, val);
                        } catch (IllegalAccessException ex) {
                            Logger.getLogger(UtilControler.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IllegalArgumentException ex) {
                            Logger.getLogger(UtilControler.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InvocationTargetException ex) {
                            Logger.getLogger(UtilControler.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                }
            }
        }

    }

    public static void maskJFormattedTextField(JInternalFrame view, Object object) {

        Class cCliente = object.getClass();
        Class cCadCliente = view.getClass();

        Annotation annotation;
        Mask mask;

        ArrayList<String[]> masks = new ArrayList();

        Object oAux;
        Method mAux;
        JFormattedTextField jft = new JFormattedTextField();
        String val;

        for (Method m : cCliente.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Mask.class)) {

                annotation = m.getAnnotation(Mask.class);
                mask = (Mask) annotation;

                //Desmascara variáveis com Exceções
                if (mask.date()) {

                    try {

                        val = (String) m.invoke(object);

                        if (val != null) {

                            val = UtilDate.formatDateBDtoDMA(val);

                            mAux = cCliente.getMethod(m.getName().replace("get", "set"), String.class);

                            mAux.invoke(object, val);

                        }

                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(UtilControler.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalArgumentException ex) {
                        Logger.getLogger(UtilControler.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InvocationTargetException ex) {
                        Logger.getLogger(UtilControler.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (NoSuchMethodException ex) {
                        Logger.getLogger(UtilControler.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SecurityException ex) {
                        Logger.getLogger(UtilControler.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

                masks.add(new String[]{
                    mask.mask(),
                    mask.length() + "",
                    mask.validCharacters(),
                    m.getName()
                });

                mask = null;

            }
        }

        for (Method m : cCadCliente.getDeclaredMethods()) {
            for (int i = 0; i < masks.size(); i++) {
                if (m.getName().equals(masks.get(i)[3])) {

                    try {

                        System.out.println(m.getName());

                        oAux = m.invoke(view);
                        jft = (JFormattedTextField) oAux;

                        UtilMask.mask(
                                jft,
                                masks.get(i)[0],
                                Integer.parseInt(masks.get(i)[1]),
                                masks.get(i)[2]
                        );

                    } catch (IllegalArgumentException ex) {
                        Logger.getLogger(UtilControler.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(UtilControler.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InvocationTargetException ex) {
                        Logger.getLogger(UtilControler.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        }

    }

    //Retorna em um ArrayList<String[]> as duas colunas da consulta - Utilizando as anotations @Consult
    public static ArrayList<String[]> returnValues(ArrayList<PObjectDAO> array, String[] columns, PObjectDAO object) {

        if (array != null) {
        if (array.size() > 0) {

            try {

                Class cObject = array.get(0).getClass();
                Class cAux;
                Method mAux;
                Annotation annotation;
                Consult consult;

                String[] metodos = new String[columns.length];
                String[] values = new String[columns.length];
                ArrayList<String[]> a = new ArrayList();

                for (int i = 0; i < columns.length; i++) {
                    for (Method m : cObject.getDeclaredMethods()) {
                        if (m.isAnnotationPresent(Consult.class)) {

                            annotation = m.getAnnotation(Consult.class);
                            consult = (Consult) annotation;

                            if (consult.mask().equals(columns[i])) {

                                System.out.println(consult.mask());
                                System.out.println(m.getName());

                                metodos[i] = m.getName();

                            }

                        }
                    }
                }

                for (int j = 0; j < array.size(); j++) {

                    for (int i = 0; i < metodos.length; i++) {

                        cAux = array.get(j).getClass();

                        mAux = cAux.getMethod(metodos[i]);

                        values[i] = mAux.invoke(array.get(j)) + "";

                    }

                    System.out.println(values[0] + values[1]);
                    a.add(values);

                    values = new String[columns.length];

                }

                return a;

            } catch (NoSuchMethodException ex) {
                Logger.getLogger(ConsultaCad.class.getName()).log(Level.SEVERE, null, ex);
                return new ArrayList<String[]>();
            } catch (SecurityException ex) {
                Logger.getLogger(ConsultaCad.class.getName()).log(Level.SEVERE, null, ex);
                return new ArrayList<String[]>();
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ConsultaCad.class.getName()).log(Level.SEVERE, null, ex);
                return new ArrayList<String[]>();
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(ConsultaCad.class.getName()).log(Level.SEVERE, null, ex);
                return new ArrayList<String[]>();
            } catch (InvocationTargetException ex) {
                Logger.getLogger(ConsultaCad.class.getName()).log(Level.SEVERE, null, ex);
                return new ArrayList<String[]>();
            }

        } else {

            return new ArrayList<String[]>();

        }
        
        } else {
            
            return new ArrayList<String[]>();
            
        }

    }

    //Retorna os critérios do objeto
    public static String[] returnTouchStone(Object object) {

        Class cObject = object.getClass();
        Annotation annotation;
        TouchStone touchStone;
        int y = 0;
        int i = 0;

        for (Method m : cObject.getDeclaredMethods()) {
            if (m.isAnnotationPresent(TouchStone.class)) {
                y++;
            }
        }

        String[] desc = new String[y];
        int[] index = new int[y];

        for (Method m : cObject.getDeclaredMethods()) {
            if (m.isAnnotationPresent(TouchStone.class)) {

                annotation = m.getAnnotation(TouchStone.class);
                touchStone = (TouchStone) annotation;

                index[i] = touchStone.index();
                desc[i] = touchStone.mask();

                i++;

            }
        }

        return UtilControler.bubbleSort(index, desc);

    }
    
    //Retorna os critérios do objeto
    public static String returnWhereTouchStone(Object object, int indexSelect) {

        Class cObject = object.getClass();
        String [] vetor;
        Annotation annotation;
        TouchStone touchStone;
        int y = 0;
        int i = 0;

        for (Method m : cObject.getDeclaredMethods()) {
            if (m.isAnnotationPresent(TouchStone.class)) {
                y++;
            }
        }

        String[] desc = new String[y];
        int[] index = new int[y];

        for (Method m : cObject.getDeclaredMethods()) {
            if (m.isAnnotationPresent(TouchStone.class)) {

                annotation = m.getAnnotation(TouchStone.class);
                touchStone = (TouchStone) annotation;

                index[i] = touchStone.index();
                desc[i] = touchStone.where();

                i++;

            }
        }

        vetor = UtilControler.bubbleSort(index, desc);
        
        return vetor[indexSelect];

    }

    //Retorna as colunas do objeto - Utilizando as anotations @Consult
    public static String[] returnColumns(Object object) {

        Class cObject = object.getClass();
        Annotation annotation;
        Consult consult;
        int y = 0;
        int i = 0;

        for (Method m : cObject.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Consult.class)) {
                y++;
            }
        }

        String[] desc = new String[y];
        int[] index = new int[y];

        for (Method m : cObject.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Consult.class)) {

                annotation = m.getAnnotation(Consult.class);
                consult = (Consult) annotation;

                index[i] = consult.index();
                desc[i] = consult.mask();

                i++;

            }
        }

        return bubbleSort(index, desc);

    }   

    //Coloca em ordem numérica referente ao vetor 1
    public static String[] bubbleSort(int[] vet1, String[] vet2) {

        String auxS;
        int aux;

        for (int i = 0; i < vet1.length; i++) {
            for (int j = 0; j < vet1.length - 1; j++) {
                if (vet1[j] > vet1[j + 1]) {
                    aux = vet1[j];
                    vet1[j] = vet1[j + 1];
                    vet1[j + 1] = aux;

                    auxS = vet2[j];
                    vet2[j] = vet2[j + 1];
                    vet2[j + 1] = auxS;

                }
            }
        }

        return vet2;

    }

}
