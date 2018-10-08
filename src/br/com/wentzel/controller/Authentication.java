/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wentzel.controller;


import br.com.wentzel.persistencia.clauses.Limit;
import br.com.wentzel.persistencia.clauses.Where;
import br.com.wentzel.persistencia.main.Dao;
import br.com.wentzel.persistencia.query.Select;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 *
 * @author Matheus
 */
public class Authentication {
//
//    public static boolean validation(String login, String senha) {
//        Usuario usuario = new Usuario();
//
//        try {
//
//            senha = convertPasswordToMD5(senha);
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//        //Busca no banco se existe o usuario
//        ArrayList<String[]> array = Dao.get(new Select(
//                usuario,
//                new Where("login = '" + login + "' AND senha = '" + senha + "'"),
//                new Limit("1")));
//
//        if (array != null) {
//
//            usuario = new Usuario(
//                    Integer.parseInt(array.get(0)[0]),
//                    array.get(0)[1],
//                    array.get(0)[2],
//                    array.get(0)[3],
//                    array.get(0)[4]
//            );
//
//            //Verifica se está bloqueado
//            if (array.get(0)[4].equals("1")) {
//                return false;
//            }
//
//            return true;
//
//        } else {
//
//            return false;
//
//        }
//
//    }

    public static String convertPasswordToMD5(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");

        BigInteger hash = new BigInteger(1, md.digest(password.getBytes()));

        return String.format("%32x", hash);
    }

}
