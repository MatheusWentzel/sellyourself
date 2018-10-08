/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wentzel.persistencia.query;

import br.com.wentzel.persistencia.main.Script;

/**
 *
 * @author Matheus
 */
public class Insert implements SetQuery {
    
    private String query;
    private Object obj;
    private String table;
    private String[] columns;
    private String[] values;

    public Insert(String table, String[] columns, String[] values) {
        this.table = table;
        this.columns = columns;
        this.values = values;
        
        query = Script.getInsert(table, columns, values);
    }
    
    public Insert(Object obj) {
        this.obj = obj;
        
        query = Script.getInsert(obj);
        
    }
    
    public Insert(String query) {
        
        this.query = query;
        
    }
    
    @Override
    public String getQuery() {
        return query;
    }
   
}
