/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sellyourself.dao;

import br.com.sellyourself.entities.FormaPagamento;
import br.com.wentzel.persistencia.main.IDAO;
import br.com.wentzel.persistencia.main.PDAO;
import br.com.wentzel.persistencia.main.PObjectDAO;
import java.util.ArrayList;
import net.sf.dynamicreports.report.datasource.DRDataSource;

/**
 *
 * @author wentzelmatheus
 */
public class FormaPagamentoDao extends PDAO implements IDAO {

    @Override
    public ArrayList<PObjectDAO> toObject(ArrayList<String[]> values) {

        ArrayList<PObjectDAO> object = null;

        if (values != null) {

            object = new ArrayList();

            for (int i = 0; i < values.size(); i++) {

                object.add(new FormaPagamento(
                        Integer.parseInt(values.get(i)[0]),
                        values.get(i)[1],
                        Integer.parseInt(values.get(i)[2])
                ));

            }
        }

        return object;

    }
    
       public DRDataSource getDataSource(PObjectDAO obj) {

        if (obj instanceof FormaPagamento) {

            ArrayList<FormaPagamento> values = select(obj);

            DRDataSource dataSource = new DRDataSource(
                    "Cod",
                    "Descricao",
                    "Prazo"
            );

            if (values != null) {

                for (int i = 0; i < values.size(); i++) {

                    dataSource.add(
                            values.get(i).getId_forma_pagamento(),
                            values.get(i).getDescricao(),
                            values.get(i).getPrazo()
                    );

                }

                return dataSource;

            } else {
                return null;
            }

        } else {
            return null;
        }

    }
    
    
    
}
