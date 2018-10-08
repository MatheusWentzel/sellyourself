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
public class GrupoProduto extends PObjectDAO {

    private static final String TABLE = "produto_grupo";
    private static final String PRIMARYKEY = "id_grupo";

    private final String[] FIELDS_SELECT = new String[]{
        "id_grupo",
        "descricao"
    };

    private final String[] FIELDS_INSERT = new String[]{
        "id_grupo",
        "descricao"
    };

    private int id_grupo;
    private String descricao;

    public GrupoProduto() {
    }

    public GrupoProduto(int id_grupo, String descricao) {
        this.id_grupo = id_grupo;
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
    public int getId_grupo() {
        return id_grupo;
    }

    @Bd
    @Consult(index = 1, mask = "Descrição")
    @TouchStone(index = 1, mask = "Descrição", where = "UPPER(descricao) LIKE '%")
    @Register
    public String getDescricao() {
        return descricao;
    }

    @Register
    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }

    @Register
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    

}
