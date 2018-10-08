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
public class GroupBy extends ClauseSQL{

    private String groupBy;
    
    public GroupBy(String groupBy) {
        super(groupBy);
        this.groupBy = groupBy;
    }

    @Override
    public String getClause() {
        return "GROUP BY " + groupBy;
    }
    
}
