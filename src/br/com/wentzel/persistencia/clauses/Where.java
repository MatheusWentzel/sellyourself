/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wentzel.persistencia.clauses;

/**
 *
 * @author Matheus
 */
public class Where extends ClauseSQL{
    
    private String where;

    public Where(String where) {
        super(where);
        this.where = where;
    }
    
    @Override
    public String getClause(){
        return "WHERE " + where;
    }   
    
}
