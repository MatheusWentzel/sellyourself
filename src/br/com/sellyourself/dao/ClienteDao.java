/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sellyourself.dao;

import br.com.sellyourself.entities.Cliente;
import br.com.wentzel.persistencia.main.IDAO;
import br.com.wentzel.persistencia.main.PDAO;
import br.com.wentzel.persistencia.main.PObjectDAO;
import java.util.ArrayList;
import net.sf.dynamicreports.report.datasource.DRDataSource;

/**
 *
 * @author wentzelmatheus
 */
public class ClienteDao extends PDAO implements IDAO {

    @Override
    public ArrayList<PObjectDAO> toObject(ArrayList<String[]> values) {

        ArrayList<PObjectDAO> object = null;

        if (values != null) {

            object = new ArrayList();

            for (int i = 0; i < values.size(); i++) {

                object.add(new Cliente(
                        Integer.parseInt(values.get(i)[0]),
                        values.get(i)[1],
                        values.get(i)[2],
                        values.get(i)[3],
                        values.get(i)[4],
                        values.get(i)[5],
                        values.get(i)[6],
                        values.get(i)[7],
                        values.get(i)[8],
                        values.get(i)[9],
                        values.get(i)[10],
                        values.get(i)[11]
                ));

            }
        }

        return object;

    }
    
    public DRDataSource getDataSource(PObjectDAO obj) {

        if (obj instanceof Cliente) {

            ArrayList<Cliente> values = select(obj);

            DRDataSource dataSource = new DRDataSource(
                    "Cod",
                    "Nome",
                    "NomeFantasia",
                    "Telefone",
                    "Tipo",
                    "Doc",
                    "Rua",
                    "Bairro",
                    "Cidade",
                    "Cep"
            );

            if (values != null) {

                for (int i = 0; i < values.size(); i++) {

                    dataSource.add(
                            values.get(i).getId_cliente(),
                            values.get(i).getNome(),
                            values.get(i).getNome_fantasia(),
                            values.get(i).getTelefone(),
                            values.get(i).getTipo(),
                            values.get(i).getDocumento(),
                            values.get(i).getRua(),
                            values.get(i).getBairro(),
                            values.get(i).getCidade(),
                            values.get(i).getCep()
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
