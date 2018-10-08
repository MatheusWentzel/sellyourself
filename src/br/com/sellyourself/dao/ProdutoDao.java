/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sellyourself.dao;

import br.com.sellyourself.entities.Produto;
import br.com.wentzel.persistencia.main.IDAO;
import br.com.wentzel.persistencia.main.PDAO;
import br.com.wentzel.persistencia.main.PObjectDAO;
import java.util.ArrayList;

/**
 *
 * @author wentzelmatheus
 */
public class ProdutoDao extends PDAO implements IDAO {

    @Override
    public ArrayList<PObjectDAO> toObject(ArrayList<String[]> values) {

        ArrayList<PObjectDAO> object = null;

        if (values != null) {

            object = new ArrayList();

            for (int i = 0; i < values.size(); i++) {

                object.add(new Produto(
                        Integer.parseInt(values.get(i)[0]),
                        Integer.parseInt(values.get(i)[1]),
                        values.get(i)[2],
                        values.get(i)[3],
                        values.get(i)[4],
                        Double.parseDouble(values.get(i)[5])
                ));

            }
        }

        return object;

    }

}
