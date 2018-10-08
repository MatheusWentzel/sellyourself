/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wentzel.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;

/**
 *
 * @author Matheus
 */
public class ObjectView {

    public static boolean objectToView(Object object, JInternalFrame view) {

        try {

            Class cObject = object.getClass();
            Class cView = view.getClass();
            Class cAux;
            Method mView;
            Method mAux;
            Object oAux;
            
            //Insere as mascaras na view
            UtilControler.maskJFormattedTextField(view, object);
            
            for (Method m : cObject.getDeclaredMethods()) {
                if (m.isAnnotationPresent(Register.class)) {
                    if (m.getName().contains("get")) {
                        System.out.println(m.getName());

                        mView = cView.getMethod(m.getName());

                        oAux = mView.invoke(view);

                        cAux = oAux.getClass();

                        //Seleciona o Tipo do Objeto e o parâmetro de entrada do método interno
                        if (oAux.getClass().toString().contains("JTextField")) {

                            mAux = cAux.getMethod("setText", String.class);
                            mAux.invoke(oAux, m.invoke(object) + "");

                        } else if (oAux.getClass().toString().contains("JFormattedTextField")) {

                            mAux = cAux.getMethod("setText", String.class);
                            mAux.invoke(oAux, m.invoke(object) + "");

                        } else if (oAux.getClass().toString().contains("JComboBox")) {

                            mAux = cAux.getMethod("setSelectedIndex", int.class);
                            mAux.invoke(oAux, Integer.parseInt(m.invoke(object) + ""));

                        }

                    }
                }
            }

            return true;

        } catch (IllegalAccessException ex) {
            Logger.getLogger(ObjectView.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(ObjectView.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (InvocationTargetException ex) {
            Logger.getLogger(ObjectView.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(ObjectView.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (SecurityException ex) {
            Logger.getLogger(ObjectView.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public static boolean viewToObject(Object object, JInternalFrame view) {
        try {

            Class cObject = object.getClass();
            Class cView = view.getClass();
            Class cAux;
            Method mView;
            Method mAux;
            Object oAux;

            for (Method m : cObject.getDeclaredMethods()) {
                if (m.isAnnotationPresent(Register.class)) {
                    if (m.getName().contains("set")) {
                        System.out.println(m.getName().replace("set", "get"));
                        mView = cView.getMethod(m.getName().replace("set", "get"));

                        oAux = mView.invoke(view);

                        cAux = oAux.getClass();

                        System.out.print("NOME: " + m.getName() + " - ");
                        System.out.println("TIPO: " + m.getParameterTypes()[0]);

                        if (oAux.getClass().toString().contains("JTextField") ||
                                oAux.getClass().toString().contains("JFormattedTextField")) {

                            mAux = cAux.getMethod("getText");

                            //Verifica o tipo de dado utilizado
                            if (m.getParameterTypes()[0].equals(String.class)) {

                                System.out.println("AQUI");

                                m.invoke(object, mAux.invoke(oAux));

                            } else if (m.getParameterTypes()[0].equals(int.class)) {

                                System.out.println("AQUI");

                                m.invoke(object, Integer.parseInt(mAux.invoke(oAux) + ""));

                            } else if (m.getParameterTypes()[0].equals(double.class)) {

                                System.out.println("AQUI");

                                m.invoke(object, Double.parseDouble(mAux.invoke(oAux) + ""));

                            }

                        }
                        if (oAux.getClass().toString().contains("JComboBox")) {

                            mAux = cAux.getMethod("getSelectedIndex");

                            //Verifica o tipo de dado utilizado
                            if (m.getParameterTypes()[0].equals(String.class)) {

                                m.invoke(object, mAux.invoke(oAux) + "");

                            } else if (m.getParameterTypes()[0].equals(int.class)) {

                                m.invoke(object, Integer.parseInt(mAux.invoke(oAux) + ""));

                            } else if (m.getParameterTypes()[0].equals(double.class)) {

                                m.invoke(object, Double.parseDouble(mAux.invoke(oAux) + ""));

                            }

                        }

                    }
                }
            }

            //Retira as mascaras do objeto
            UtilControler.desmaskJFormattedTextField(view, object);
            
            return true;

        } catch (SecurityException ex) {
            Logger.getLogger(ObjectView.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(ObjectView.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ObjectView.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(ObjectView.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (InvocationTargetException ex) {
            Logger.getLogger(ObjectView.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

}
