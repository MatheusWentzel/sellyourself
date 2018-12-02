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
public class NotaItem extends PObjectDAO {

    private final String TABLE = "nota_item";
    private final String PRIMARYKEY = "";

    private final String[] FIELDS_SELECT = new String[]{
        "nota_id",
        "item",
        "produto_id",
        "quantidade",
        "valor_unitario",
        "valor_total"
    };

    private final String[] FIELDS_INSERT = new String[]{
        "nota_id",
        "item",
        "produto_id",
        "quantidade",
        "valor_unitario",
        "valor_total"
    };

    private int nota_id;
    private int item;
    private int produto_id;
    private double quantidade;
    private double valor_unitario;
    private double valor_total;

    public NotaItem() {
    }

    public NotaItem(int nota_id, int item, int produto_id, double quantidade, double valor_unitario, double valor_total) {
        this.nota_id = nota_id;
        this.item = item;
        this.produto_id = produto_id;
        this.quantidade = quantidade;
        this.valor_unitario = valor_unitario;
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
    public int getNota_id() {
        return nota_id;
    }

    @Bd
    public int getItem() {
        return item;
    }

    @Bd
    public int getProduto_id() {
        return produto_id;
    }

    @Bd
    public double getQuantidade() {
        return quantidade;
    }

    @Bd
    public double getValor_unitario() {
        return valor_unitario;
    }

    @Bd
    public double getValor_total() {
        return valor_total;
    }

    public void setNota_id(int nota_id) {
        this.nota_id = nota_id;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public void setProduto_id(int produto_id) {
        this.produto_id = produto_id;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public void setValor_unitario(double valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }

}
