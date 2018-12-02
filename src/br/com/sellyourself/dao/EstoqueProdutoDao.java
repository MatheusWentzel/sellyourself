/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sellyourself.dao;

import br.com.sellyourself.entities.EstoqueProduto;
import br.com.wentzel.persistencia.main.IDAO;
import br.com.wentzel.persistencia.main.PDAO;
import br.com.wentzel.persistencia.main.PObjectDAO;
import java.util.ArrayList;

/**
 *
 * @author wentzelmatheus
 */
public class EstoqueProdutoDao extends PDAO implements IDAO {

    @Override
    public ArrayList<PObjectDAO> toObject(ArrayList<String[]> values) {

        ArrayList<PObjectDAO> object = null;

        if (values != null) {

            object = new ArrayList();

            for (int i = 0; i < values.size(); i++) {

                object.add(new EstoqueProduto(
                        Integer.parseInt(values.get(i)[0]),
                        Integer.parseInt(values.get(i)[1]),
                        Double.parseDouble(values.get(i)[2])
                ));

            }
        }

        return object;

    }
    
    
}
