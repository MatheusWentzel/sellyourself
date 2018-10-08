/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wentzel.persistencia.query;

/**
 *
 * @author Matheus
 */
public interface GetQuery {

    public String getQuery();
    
    public String getTable();
    
    public String [] getColumns();
    
    public int getTypeQuery();
    
    public Object getObj();
    
}
