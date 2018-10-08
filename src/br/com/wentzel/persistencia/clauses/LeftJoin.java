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
public class LeftJoin extends ClauseSQL{

    private String leftJoin;
    private String tabela;
    
    public LeftJoin(String tabela, String leftJoin) {
        super(leftJoin);
        this.leftJoin = leftJoin;
        this.tabela = tabela;
    }
    
    @Override
    public String getClause() {
        return "LEFT JOIN " + tabela + " ON " + leftJoin;
    }
    
    
    
}
