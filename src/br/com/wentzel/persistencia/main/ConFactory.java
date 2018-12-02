package br.com.wentzel.persistencia.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matheus
 */
public class ConFactory {

    /**
     *
     * @return Retorna uma conexão com o BD
     * @throws ClassNotFoundException
     */
    public static Connection getConnection() {

        try {

            String path = "";

            // Carrega informações do arquivo de propriedades
            Properties prop = new Properties();
            prop.load(new FileInputStream(path + "db.properties"));

            String servidor = prop.getProperty("db.servidor");
            String banco = prop.getProperty("db.banco");
            String login = prop.getProperty("db.user");
            String senha = prop.getProperty("db.senha");

            String url = "jdbc:mysql://" + servidor + "/" + banco + "?useSSL=false";

            Connection connection;

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, login, senha);

            return connection;

        } catch (SQLException ex) {
            Logger.getLogger(ConFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao conectar com o BD!!!", ex);
        } catch (FileNotFoundException ex) {
            System.out.println("Erro ao conectar com o BD!!! " + ex);
            Logger.getLogger(ConFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao conectar com o BD!!! " + ex);
            Logger.getLogger(ConFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Erro ao conectar com o BD!!! " + ex);
            Logger.getLogger(ConFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    public static String getBanco() {

        try {
            
            String path = "";

            Properties prop = new Properties();
            prop.load(new FileInputStream(path + "db.properties"));

            if (prop.getProperty("db.banco") != null) {

                return prop.getProperty("db.banco");

            } else {

                return "dbprices";

            }

        } catch (Exception e) {
            System.err.print(e);
        }

        return null;
    }

}
