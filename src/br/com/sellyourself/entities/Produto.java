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
public class Produto extends PObjectDAO {

    private final String TABLE = "produto";
    private final String PRIMARYKEY = "id_produto";

    private final String[] FIELDS_SELECT = new String[]{
        "id_produto",
        "grupo_id",
        "descricao",
        "ean",
        "unidade",
        "valor"
    };

    private final String[] FIELDS_INSERT = new String[]{
        "id_produto",
        "grupo_id",
        "descricao",
        "ean",
        "unidade",
        "valor"
    };

    private int id_produto;
    private int grupo_id;
    private String descricao;
    private String ean;
    private String unidade;
    private double valor;

    public Produto() {
    }

    public Produto(int id_produto, int grupo_id, String descricao, String ean, String unidade, double valor) {
        this.id_produto = id_produto;
        this.grupo_id = grupo_id;
        this.descricao = descricao;
        this.ean = ean;
        this.unidade = unidade;
        this.valor = valor;
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
    public int getId_produto() {
        return id_produto;
    }

    @Bd
    @Register
    public int getGrupo_id() {
        return grupo_id;
    }

    @Bd
    @TouchStone(index = 1, mask = "Descrição", where = "UPPER(descricao) LIKE '%")
    @Consult(index = 1, mask = "Descrição")
    @Register
    public String getDescricao() {
        return descricao;
    }

    @Bd
    @Register
    public String getEan() {
        return ean;
    }

    @Bd
    @Register
    public String getUnidade() {
        return unidade;
    }

    @Bd
    @Register
    public double getValor() {
        return valor;
    }

    @Register
    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    @Register
    public void setGrupo_id(int grupo_id) {
        this.grupo_id = grupo_id;
    }

    @Register
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Register
    public void setEan(String ean) {
        this.ean = ean;
    }

    @Register
    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    @Register
    public void setValor(double valor) {
        this.valor = valor;
    }

}
