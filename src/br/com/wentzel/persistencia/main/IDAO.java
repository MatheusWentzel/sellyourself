/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wentzel.persistencia.main;

import java.util.ArrayList;

/**
 *
 * @author pretto
 */
public interface IDAO{
    
    public ArrayList<PObjectDAO> toObject(ArrayList<String[]> values);

//    public ArrayList select();
//
//    public ArrayList select(int criterio, String filtro);
//
//    public ArrayList selectId(String id);
    
    
}
