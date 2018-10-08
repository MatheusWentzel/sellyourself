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

public class Limit extends ClauseSQL {

    private String limit;

    public Limit(String limit) {
        super(limit);
        this.limit = limit;
    }

    @Override
    public String getClause() {
        return "LIMIT " + limit;
    }

}
