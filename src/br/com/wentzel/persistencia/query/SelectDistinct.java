/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wentzel.persistencia.query;

import br.com.wentzel.persistencia.main.ManipulateClass;
import br.com.wentzel.persistencia.main.Script;
import br.com.wentzel.persistencia.clauses.ClauseSQL;

/**
 *
 * @author Matheus
 */
public class SelectDistinct implements GetQuery {

    private String query;
    private Object obj;
    private String table;
    private String[] columns;
    private int type; //0 - Object / 1 - Manual

    public SelectDistinct(Object obj) {
        this.obj = obj;
        this.table = ManipulateClass.getTableClass(obj);
        this.query = "SELECT DISTINCT * FROM " + table;
        this.type = 0;
    }

    public SelectDistinct(Object obj, ClauseSQL clause1) {
        this.obj = obj;
        this.table = ManipulateClass.getTableClass(obj);
        this.query = "SELECT DISTINCT * FROM " + table + " "
                + clause1.getClause();
        this.type = 0;
    }

    public SelectDistinct(Object obj, ClauseSQL clause1, ClauseSQL clause2) {
        this.obj = obj;
        this.table = ManipulateClass.getTableClass(obj);
        this.query = "SELECT DISTINCT * FROM " + table + " "
                + clause1.getClause() + " "
                + clause2.getClause();
        this.type = 0;
    }

    public SelectDistinct(Object obj, ClauseSQL clause1, ClauseSQL clause2, ClauseSQL clause3) {
        this.obj = obj;
        this.table = ManipulateClass.getTableClass(obj);
        this.query = "SELECT DISTINCT * FROM " + table + " "
                + clause1.getClause() + " "
                + clause2.getClause() + " "
                + clause3.getClause();
        this.type = 0;
    }

    public SelectDistinct(Object obj, ClauseSQL clause1, ClauseSQL clause2, ClauseSQL clause3, ClauseSQL clause4) {
        this.obj = obj;
        this.table = ManipulateClass.getTableClass(obj);
        this.query = "SELECT DISTINCT * FROM " + table + " "
                + clause1.getClause() + " "
                + clause2.getClause() + " "
                + clause3.getClause() + " "
                + clause4.getClause();
        this.type = 0;
    }

    public SelectDistinct(String table, String[] columns) {
        this.table = table;
        this.columns = columns;
        this.query = "SELECT DISTINCT " + Script.getSelect(columns) + " FROM " + table + " ";
        this.type = 1;
    }

    public SelectDistinct(String table, String[] columns, ClauseSQL clause1) {
        this.table = table;
        this.columns = columns;
        this.query = "SELECT DISTINCT " + Script.getSelect(columns) + " FROM " + table + " "
                + clause1.getClause();
        this.type = 1;
    }

    public SelectDistinct(String table, String[] columns, ClauseSQL clause1, ClauseSQL clause2) {
        this.table = table;
        this.columns = columns;
        this.query = "SELECT DISTINCT " + Script.getSelect(columns) + " FROM " + table + " "
                + clause1.getClause() + " "
                + clause2.getClause();
        this.type = 1;
    }

    public SelectDistinct(String table, String[] columns, ClauseSQL clause1, ClauseSQL clause2, ClauseSQL clause3) {
        this.table = table;
        this.columns = columns;
        this.query = "SELECT DISTINCT " + Script.getSelect(columns) + " FROM " + table + " "
                + clause1.getClause() + " "
                + clause2.getClause() + " "
                + clause3.getClause();
        this.type = 1;
    }

    public SelectDistinct(String table, String[] columns, ClauseSQL clause1, ClauseSQL clause2, ClauseSQL clause3, ClauseSQL clause4) {
        this.table = table;
        this.columns = columns;
        this.query = "SELECT DISTINCT " + Script.getSelect(columns) + " FROM " + table + " "
                + clause1.getClause() + " "
                + clause2.getClause() + " "
                + clause3.getClause() + " "
                + clause4.getClause();
        this.type = 1;
    }

    public SelectDistinct(String table, String[] columns, ClauseSQL clause1, ClauseSQL clause2, ClauseSQL clause3, ClauseSQL clause4, ClauseSQL clause5) {
        this.table = table;
        this.columns = columns;
        this.query = "SELECT DISTINCT " + Script.getSelect(columns) + " FROM " + table + " "
                + clause1.getClause() + " "
                + clause2.getClause() + " "
                + clause3.getClause() + " "
                + clause4.getClause() + " "
                + clause5.getClause();
        this.type = 1;
    }

    public SelectDistinct(String table, String[] columns, ClauseSQL clause1, ClauseSQL clause2, ClauseSQL clause3, ClauseSQL clause4, ClauseSQL clause5, ClauseSQL clause6) {
        this.table = table;
        this.columns = columns;
        this.query = "SELECT DISTINCT " + Script.getSelect(columns) + " FROM " + table + " "
                + clause1.getClause() + " "
                + clause2.getClause() + " "
                + clause3.getClause() + " "
                + clause4.getClause() + " "
                + clause5.getClause() + " "
                + clause6.getClause();
        this.type = 1;
    }

    public SelectDistinct(String table, String[] columns, ClauseSQL clause1, ClauseSQL clause2, ClauseSQL clause3, ClauseSQL clause4, ClauseSQL clause5, ClauseSQL clause6, ClauseSQL clause7) {
        this.table = table;
        this.columns = columns;
        this.query = "SELECT DISTINCT " + Script.getSelect(columns) + " FROM " + table + " "
                + clause1.getClause() + " "
                + clause2.getClause() + " "
                + clause3.getClause() + " "
                + clause4.getClause() + " "
                + clause5.getClause() + " "
                + clause6.getClause() + " "
                + clause7.getClause();
        this.type = 1;
    }
    
    public SelectDistinct(String table, String[] columns, ClauseSQL clause1, ClauseSQL clause2, ClauseSQL clause3, ClauseSQL clause4, ClauseSQL clause5, ClauseSQL clause6, ClauseSQL clause7, ClauseSQL clause8) {
        this.table = table;
        this.columns = columns;
        this.query = "SELECT DISTINCT " + Script.getSelect(columns) + " FROM " + table + " "
                + clause1.getClause() + " "
                + clause2.getClause() + " "
                + clause3.getClause() + " "
                + clause4.getClause() + " "
                + clause5.getClause() + " "
                + clause6.getClause() + " "
                + clause7.getClause() + " "
                + clause8.getClause();
        this.type = 1;
    }

    @Override
    public String getQuery() {
        return query;
    }

    @Override
    public String getTable() {
        return table;
    }

    @Override
    public int getTypeQuery() {
        return type;
    }

    @Override
    public String[] getColumns() {
        return columns;
    }

    @Override
    public Object getObj() {
        return obj;
    }

}
