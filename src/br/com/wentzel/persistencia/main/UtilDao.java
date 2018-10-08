/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wentzel.persistencia.main;

import br.com.wentzel.util.Util;
import br.com.wentzel.persistencia.clauses.Limit;
import br.com.wentzel.persistencia.clauses.Where;
import br.com.wentzel.persistencia.query.Select;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matheus
 */
public class UtilDao implements Serializable {

    public static int selectProxId(String tabela, String campoId) {

        int id = 0;

        ArrayList<String[]> value = Dao.get(new Select(
                tabela + " AS F",
                new String[]{"(MIN(" + campoId + ") + 1)"},
                new Where("NOT EXISTS (SELECT " + campoId + " FROM " + tabela + " AS F1 WHERE F1." + campoId + " = (F." + campoId + " + 1))"),
                new Limit("1")));

        if (value != null) {

            id = Integer.parseInt(value.get(0)[0]);

        } else {

            id = 1;

        }

        return id;

    }

    public static int getAutoIncrement(String tabela) {

        ArrayList<String> ret = new ArrayList<>();
        String query = "SHOW TABLE STATUS LIKE '" + tabela + "'";
        String retorno = "";
        int proxId = 0;

        System.out.println(query);
        try (Connection con = ConFactory.getConnection()) {
            Statement statement = con.createStatement();
            statement.execute(query);
            ResultSet rs = statement.getResultSet();
            while (rs.next()) {
                retorno = rs.getString("Auto_increment");
            }

            if (retorno != null) {
                if (retorno.toLowerCase().equals("null")) {
                    proxId = 1;
                } else {
                    if (Util.isNumber(retorno)) {
                        proxId = Integer.parseInt(retorno);
                    } else {
                        proxId = 1;
                    }
                }
            } else {
                proxId = 1;
            }

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return proxId;

    }

    public static String selectCurrentDate() {

        ArrayList<String[]> value = Dao.get(new Select(
                "funcionario",
                new String[]{"CURRENT_DATE"},
                new Limit("1")));

        String data = value.get(0)[0];

        return data;

    }

    public static String returnAlias(String campo) {

        String spQuery[] = campo.split(" ");

        if (spQuery.length > 1) {

            if (spQuery[spQuery.length - 2].equals("AS")) {

                return spQuery[spQuery.length - 1];

            }

        }

        return campo;

    }
    
    public static Where geraWhere(ArrayList<String> filtros) {

        String query = "";

        if (filtros != null) {

            for (int i = 0; i < filtros.size(); i++) {

                query += filtros.get(i) + " ";

                if (filtros.size() - 1 != i) {

                    query += " AND ";

                }

            }

        }

        return new Where(query);

    }

}
