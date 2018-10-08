package br.com.wentzel.persistencia.main;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matheus
 */
public class ManipulateClass {

    public static String getTableClass(Object obj) {
        String ret = "";

        try {

            Class classe = obj.getClass();
            for (Method m : classe.getDeclaredMethods()) {
                if (m.isAnnotationPresent(Bd.class)) {
                    if (m.getName().toLowerCase().replace("get", "").equals("table")) {
                        ret = m.invoke(obj).toString();
                    }
                }
            }
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return ret;
    }

    public static String getPrimaryKeyClass(Object obj) {
        String ret = "";

        try {
            Class classe = obj.getClass();
            for (Method m : classe.getDeclaredMethods()) {
                if (m.isAnnotationPresent(Bd.class)) {
                    if (m.getName().toLowerCase().replace("get", "").equals("primarykey")) {
                        ret = m.invoke(obj).toString();
                    }
                }
            }
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return ret;
    }

    public static String getValuePrimaryKey(Object obj) {
        String ret = "";
        String primaryKey = getPrimaryKeyClass(obj);

        try {
            Class classe = obj.getClass();
            for (Method m : classe.getDeclaredMethods()) {
                if (m.isAnnotationPresent(Bd.class)) {
                    if (m.getName().toLowerCase().replace("get", "").equals(primaryKey.toLowerCase())) {
                        ret = m.invoke(obj).toString();
                    }
                }
            }
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return ret;

    }

    public static ArrayList<String> getValuesClass(Object obj, ArrayList<String[]> aColumns) {

        Class classe = obj.getClass();
        ArrayList<String> aValues = new ArrayList();
        int i = 0;
        try {
            for (String[] aColumn : aColumns) {
                for (Method m : classe.getDeclaredMethods()) {
                    if (m.getName().toLowerCase().replace("get", "").equals(aColumns.get(i)[0].toLowerCase())) {
                        if (m.invoke(obj) != null){
                            if(aColumn[3].equals("YES") && m.invoke(obj).toString().equals("0")){
                                aValues.add("NULL");
                            } else {
                                aValues.add(m.invoke(obj).toString());
                            }
                        } else {
                            aValues.add("NULL");
                        }
                    }
                }
                i++;
            }
        } catch (SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
        }

        return aValues;
    }
    
    public static void setValuesClass (Object obj, String fieldName, String fieldValue) {
        
        Class<?> classe = obj.getClass();
        try {
            Field field = classe.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, fieldValue);
        } catch (SecurityException | IllegalArgumentException | IllegalAccessException e) {
            throw new IllegalStateException(e);
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(ManipulateClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
