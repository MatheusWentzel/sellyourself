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
public class EstoqueProduto extends PObjectDAO {

    private final String TABLE = "estoque_produto";
    private final String PRIMARYKEY = "";

    private final String[] FIELDS_SELECT = new String[]{
        "armazem_id",
        "produto_id",
        "quantidade"
    };

    private final String[] FIELDS_INSERT = new String[]{
        "armazem_id",
        "produto_id",
        "quantidade"
    };

    private int armazem_id;
    private int produto_id;
    private double quantidade;

    public EstoqueProduto() {
    }

    public EstoqueProduto(int armazem_id, int produto_id, double quantidade) {
        this.armazem_id = armazem_id;
        this.produto_id = produto_id;
        this.quantidade = quantidade;
    }

    //Getters And Setters
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
    public int getArmazem_id() {
        return armazem_id;
    }

    @Bd
    public int getProduto_id() {
        return produto_id;
    }

    @Bd
    public double getQuantidade() {
        return quantidade;
    }

    public void setArmazem_id(int armazem_id) {
        this.armazem_id = armazem_id;
    }

    public void setProduto_id(int produto_id) {
        this.produto_id = produto_id;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

}
