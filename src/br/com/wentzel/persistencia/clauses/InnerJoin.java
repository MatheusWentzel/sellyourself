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
public class InnerJoin extends ClauseSQL{

    private String innerJoin;
    private String tabela;
    
    public InnerJoin(String tabela, String innerJoin) {
        super(innerJoin);
        this.innerJoin = innerJoin;
        this.tabela = tabela;
    }
    
    @Override
    public String getClause() {
        return "INNER JOIN " + tabela + " ON " + innerJoin;
    }
    
    
    
}
