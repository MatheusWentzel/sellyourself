/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wentzel.persistencia.query;

import br.com.wentzel.persistencia.clauses.ClauseSQL;

/**
 *
 * @author Matheus
 */
public class Delete implements SetQuery {

    private String query;

    public Delete(String tabela, ClauseSQL where) {
        this.query = "DELETE FROM " + tabela + " " + where.getClause();
    }

    public String getQuery() {
        return query;
    }

}
