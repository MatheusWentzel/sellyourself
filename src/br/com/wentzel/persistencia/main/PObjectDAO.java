/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wentzel.persistencia.main;

/**
 *
 * @author wentzelmatheus
 */
public abstract class PObjectDAO {
    
    public abstract String getTABLE();

    public abstract String getPRIMARYKEY();
    
    public abstract String[] getFIELDS_SELECT();
    
    public abstract String[] getFIELDS_INSERT();
    
}
