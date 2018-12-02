/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sellyourself.entities;

import br.com.wentzel.controller.Consult;
import br.com.wentzel.controller.Register;
import br.com.wentzel.controller.TouchStone;
import br.com.wentzel.persistencia.main.Bd;
import br.com.wentzel.persistencia.main.PObjectDAO;

/**
 *
 * @author wentzelmatheus
 */
public class FormaPagamento extends PObjectDAO {

    private final String TABLE = "forma_pagamento";
    private final String PRIMARYKEY = "id_forma_pagamento";

    private final String[] FIELDS_SELECT = new String[]{
        "id_forma_pagamento",
        "descricao",
        "prazo"
    };

    private final String[] FIELDS_INSERT = new String[]{
        "id_forma_pagamento",
        "descricao",
        "prazo"
    };

    private int id_forma_pagamento;
    private String descricao;
    private int prazo;

    public FormaPagamento() {
    }

    public FormaPagamento(int id_forma_pagamento, String descricao, int prazo) {
        this.id_forma_pagamento = id_forma_pagamento;
        this.descricao = descricao;
        this.prazo = prazo;
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
    @Consult(index = 0, mask = "Cód")
    @Register
    public int getId_forma_pagamento() {
        return id_forma_pagamento;
    }

    @Bd
    @Consult(index = 1, mask = "Descrição")
    @TouchStone(index = 1, mask = "Descrição", where = "UPPER(descricao) LIKE '%")
    @Register
    public String getDescricao() {
        return descricao;
    }

    @Bd
    @Register
    public int getPrazo() {
        return prazo;
    }

    @Register
    public void setId_forma_pagamento(int id_forma_pagamento) {
        this.id_forma_pagamento = id_forma_pagamento;
    }

    @Register
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Register
    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

}
