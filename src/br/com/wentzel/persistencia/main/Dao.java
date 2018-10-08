/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wentzel.persistencia.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.wentzel.persistencia.query.GetQuery;
import br.com.wentzel.persistencia.query.SetQuery;

/**
 *
 * @author Matheus
 */
public class Dao {

    public static ArrayList<String[]> get(GetQuery query) {
        //Variavel auxiliar
        int j = 0, i = 0;
        //Array de retorno
        ArrayList<String[]> aValues = null;
        //Busca: Número de Linhas a retornar na consulta
        int lines = DaoUtil.getContLinesSelect(query.getQuery());
        //Se a consulta não retornar nenhuma linha retorna null
        if (lines != 0) {
            aValues = new ArrayList();
            //Cria conexão
            try (Connection con = ConFactory.getConnection()) {
                Statement statement = con.createStatement();
                System.out.println("Query: " + query.getQuery());
                statement.execute(query.getQuery());

                ResultSet rs = statement.getResultSet();
                //Verifica o tipo de GetQuery (0 - Object / 1 - Manual)
                if (query.getTypeQuery() == 0) {
                    ArrayList<String> aColumns = DaoUtil.getNameColumns(query.getTable());
                    String[][] linha = new String[lines][aColumns.size()];

                    while (rs.next()) {

                        for (String string : aColumns) {
                            linha[j][i] = rs.getString(aColumns.get(i));
                            i++;
                        }
                        aValues.add(linha[j]);
                        j++;
                        i = 0;
                    }

                    con.close();
                } else if (query.getTypeQuery() == 1) {
                    String[] aColumns2 = query.getColumns();
                    String[][] linha = new String[lines][aColumns2.length];

                    while (rs.next()) {
                        for (int k = 0; k < aColumns2.length; k++) {
                            linha[j][k] = rs.getString(aColumns2[k]);
                        }

                        aValues.add(linha[j]);
                        j++;

                    }

                    con.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.out.println("Sem Registros!");
        }

        return aValues;
    }

    public static ArrayList<String[]> get(GetQuery query, int lines) {
        //Variavel auxiliar
        int j = 0, i = 0;
        //Array de retorno
        ArrayList<String[]> aValues = null;
        //Se a consulta não retornar nenhuma linha retorna null
        if (lines != 0) {
            aValues = new ArrayList();
            //Cria conexão
            try (Connection con = ConFactory.getConnection()) {
                Statement statement = con.createStatement();
                System.out.println("Query: " + query.getQuery());
                statement.execute(query.getQuery());

                ResultSet rs = statement.getResultSet();
                //Verifica o tipo de GetQuery (0 - Object / 1 - Manual)
                if (query.getTypeQuery() == 0) {
                    ArrayList<String> aColumns = DaoUtil.getNameColumns(query.getTable());
                    String[][] linha = new String[lines][aColumns.size()];

                    while (rs.next()) {

                        for (String string : aColumns) {
                            linha[j][i] = rs.getString(aColumns.get(i));
                            i++;
                        }
                        aValues.add(linha[j]);
                        j++;
                        i = 0;
                    }

                    con.close();
                } else if (query.getTypeQuery() == 1) {
                    String[] aColumns2 = query.getColumns();
                    String[][] linha = new String[lines][aColumns2.length];

                    while (rs.next()) {
                        for (int k = 0; k < aColumns2.length; k++) {
                            System.out.println(UtilDao.returnAlias(aColumns2[k]));
                            linha[j][k] = rs.getString(UtilDao.returnAlias(aColumns2[k]));
                        }

                        aValues.add(linha[j]);
                        j++;

                    }

                    con.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.out.println("Sem Registros!");
        }

        return aValues;
    }

    public static boolean set(SetQuery query) {
        //Variavel que vai retornar o sucesso
        boolean result = true;
        System.out.println(query.getQuery());

        //Cria a conexão
        try (Connection con = ConFactory.getConnection()) {

            Statement statement = con.createStatement();
            result = statement.execute(query.getQuery());

            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(Dao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    public static int setRetId(SetQuery query) {
        //Variavel que vai retornar o sucesso
        int ret = 0;
        System.out.println(query.getQuery());

        //Cria a conexão
        try (Connection con = ConFactory.getConnection()) {

            Statement statement = con.createStatement();
            statement.executeUpdate(query.getQuery(), Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                ret = rs.getInt(1);
            }

            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(Dao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return ret;
    }

}
