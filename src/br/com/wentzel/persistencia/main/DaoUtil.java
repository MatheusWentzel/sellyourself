package br.com.wentzel.persistencia.main;

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
public class DaoUtil {

    public static int getContLinesSelect(String query) {
        int ret = 0;
        boolean c = false, d = false;

        if (query.contains("*")) {
            query = query.replace("*", "COUNT(*)");
            System.out.println(query);
        } else {
            String[] q = query.split(" ");
            for (int i = 0; i < q.length; i++) {
                if (q[i].equals("SELECT") && c == false) {
                    query = q[i] + " COUNT(*) ";
                    c = true;
                } else if (q[i].equals("FROM") && d == false) {
                    for (int j = i; j < q.length; j++) {
                        query += q[j] + " ";
                    }
                    d = true;
                }
            }
        }
        System.out.println(query);
        try (Connection con = ConFactory.getConnection()) {
            Statement statement = con.createStatement();
            statement.execute(query);

            ResultSet rs = statement.getResultSet();
            rs.next();

            ret = Integer.parseInt(rs.getString("COUNT(*)"));

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ret;

    }

    public static String GetLastId() {

        String ret = "";
        String query = "SELECT LAST_INSERT_ID()";
        try (Connection con = ConFactory.getConnection()) {
            Statement statement = con.createStatement();
            statement.execute(query);
            ResultSet rs = statement.getResultSet();
            if (rs.next()) {
                ret = rs.getString("LAST_INSERT_ID()");
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return ret;

    }

    public static ArrayList<String> getNameColumns(String tabela) {

        ArrayList<String> ret = new ArrayList<>();
        String query = "SELECT COLUMN_NAME FROM information_schema.COLUMNS WHERE TABLE_SCHEMA = '" + ConFactory.getBanco() + "' AND TABLE_NAME = '" + tabela + "' ORDER BY ORDINAL_POSITION";
        try (Connection con = ConFactory.getConnection()) {
            Statement statement = con.createStatement();
            statement.execute(query);
            ResultSet rs = statement.getResultSet();
            while (rs.next()) {
                ret.add(rs.getString("COLUMN_NAME"));
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return ret;

    }

    public static String[] getNameColumnsVet(String tabela) {

        String[] ret = new String[200];
        int count = 0;
        String query = "SELECT COLUMN_NAME FROM information_schema.COLUMNS WHERE TABLE_SCHEMA = '" + ConFactory.getBanco() + "' AND TABLE_NAME = '" + tabela + "' ORDER BY ORDINAL_POSITION";
        System.out.println(query);
        try (Connection con = ConFactory.getConnection()) {
            Statement statement = con.createStatement();
            statement.execute(query);
            ResultSet rs = statement.getResultSet();
            while (rs.next()) {
                ret[count] = rs.getString("COLUMN_NAME");
                count++;
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        String[] campos = new String[count];

        for (int i = 0; i < campos.length; i++) {

            campos[i] = ret[i];

        }

        return campos;

    }

    public static ArrayList<String> getTDataColumns(String tabela) {

        ArrayList<String> ret = new ArrayList<>();
        String query = "SELECT DATA_TYPE FROM information_schema.COLUMNS WHERE TABLE_SCHEMA = '" + ConFactory.getBanco() + "' AND TABLE_NAME = '" + tabela + "' ORDER BY ORDINAL_POSITION";
        try (Connection con = ConFactory.getConnection()) {
            Statement statement = con.createStatement();
            statement.execute(query);
            ResultSet rs = statement.getResultSet();
            while (rs.next()) {
                ret.add(rs.getString("DATA_TYPE"));
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return ret;

    }

    public static ArrayList<String[]> getDataColumns(String tabela) {

        ArrayList<String[]> ret = new ArrayList<>();

        String query = "SELECT COLUMN_NAME, DATA_TYPE, EXTRA, IS_NULLABLE FROM information_schema.COLUMNS WHERE TABLE_SCHEMA = '" + ConFactory.getBanco() + "' AND TABLE_NAME = '" + tabela + "' ORDER BY ORDINAL_POSITION";
        System.out.println(query);
        try (Connection con = ConFactory.getConnection()) {
            Statement statement = con.createStatement();
            statement.execute(query);
            ResultSet rs = statement.getResultSet();
            while (rs.next()) {
                ret.add(new String[]{
                    rs.getString("COLUMN_NAME"),
                    rs.getString("DATA_TYPE"),
                    rs.getString("EXTRA"),
                    rs.getString("IS_NULLABLE")
                });
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return ret;

    }

    public static ArrayList<String[]> getAutoIncrement(String tabela) {

        ArrayList<String[]> ret = new ArrayList<>();
        String query = "SELECT COLUMN_NAME, EXTRA FROM information_schema.COLUMNS WHERE TABLE_SCHEMA = '" + ConFactory.getBanco() + "' AND TABLE_NAME = '" + tabela + "' ORDER BY ORDINAL_POSITION";
        System.out.println(query);
        try (Connection con = ConFactory.getConnection()) {
            Statement statement = con.createStatement();
            statement.execute(query);
            ResultSet rs = statement.getResultSet();
            while (rs.next()) {
                ret.add(new String[]{
                    rs.getString("COLUMN_NAME"),
                    rs.getString("EXTRA")
                });
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return ret;

    }

}
