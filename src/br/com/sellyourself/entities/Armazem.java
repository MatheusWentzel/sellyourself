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
public class Armazem extends PObjectDAO {

    private final String TABLE = "armazem";
    private final String PRIMARYKEY = "id_armazem";

    private final String[] FIELDS_SELECT = new String[]{
        "id_armazem",
        "descricao"
    };

    private final String[] FIELDS_INSERT = new String[]{
        "id_armazem",
        "descricao"
    };

    private int id_armazem;
    private String descricao;

    public Armazem() {
    }

    public Armazem(int id_armazem, String descricao) {
        this.id_armazem = id_armazem;
        this.descricao = descricao;
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
    public int getId_armazem() {
        return id_armazem;
    }

    @Bd
    @Consult(index = 1, mask = "Descrição")
    @TouchStone(index = 1, mask = "Descrição", where = "UPPER(descricao) LIKE '%")
    @Register
    public String getDescricao() {
        return descricao;
    }

    @Register
    public void setId_armazem(int id_armazem) {
        this.id_armazem = id_armazem;
    }

    @Register
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
