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
public class OrderBy extends ClauseSQL{
    
    private String orderBy;

    public OrderBy(String orderBy) {
        super(orderBy);
        this.orderBy = orderBy;
    }

    @Override
    public String getClause() {
        return "ORDER BY " + orderBy;
    }

  
    
}
