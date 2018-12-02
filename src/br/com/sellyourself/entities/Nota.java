/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sellyourself.entities;

import br.com.wentzel.persistencia.main.Bd;
import br.com.wentzel.persistencia.main.PObjectDAO;

/**
 *
 * @author wentzelmatheus
 */
public class Nota extends PObjectDAO {

    private final String TABLE = "nota";
    private final String PRIMARYKEY = "id_nota";

    private final String[] FIELDS_SELECT = new String[]{
        "id_nota",
        "forma_pagamento_id",
        "cliente_id",
        "data",
        "valor_total"
    };

    private final String[] FIELDS_INSERT = new String[]{
        "id_nota",
        "forma_pagamento_id",
        "cliente_id",
        "data",
        "valor_total"
    };

    private int id_nota;
    private int forma_pagamento_id;
    private int cliente_id;
    private String data;
    private double valor_total;

    public Nota() {
    }

    public Nota(int id_nota, int forma_pagamento_id, int cliente_id, String data, double valor_total) {
        this.id_nota = id_nota;
        this.forma_pagamento_id = forma_pagamento_id;
        this.cliente_id = cliente_id;
        this.data = data;
        this.valor_total = valor_total;
    }

    //Getters and Setters
    @Bd
    @Override
    public String getTABLE() {
        return TABLE;
    }

    @Bd
    @Override
    public String getPRIMARYKEY() {
        return PRIMARYKEY;
    }

    @Bd
    @Override
    public String[] getFIELDS_SELECT() {
        return FIELDS_SELECT;
    }

    @Bd
    @Override
    public String[] getFIELDS_INSERT() {
        return FIELDS_INSERT;
    }

    @Bd
    public int getId_nota() {
        return id_nota;
    }

    @Bd
    public int getForma_pagamento_id() {
        return forma_pagamento_id;
    }

    @Bd
    public int getCliente_id() {
        return cliente_id;
    }

    @Bd
    public String getData() {
        return data;
    }

    @Bd
    public double getValor_total() {
        return valor_total;
    }

    public void setId_nota(int id_nota) {
        this.id_nota = id_nota;
    }

    public void setForma_pagamento_id(int forma_pagamento_id) {
        this.forma_pagamento_id = forma_pagamento_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }

}
