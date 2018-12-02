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
public class Cliente extends PObjectDAO {

    private final String TABLE = "cliente";
    private final String PRIMARYKEY = "id_cliente";

    private final String[] FIELDS_SELECT = new String[]{
        "id_cliente",
        "nome",
        "nome_fantasia",
        "telefone",
        "tipo",
        "documento",
        "rua",
        "bairro",
        "cidade",
        "cep",
        "dt_cad",
        "dt_ult_compra"
    };

    private final String[] FIELDS_INSERT = new String[]{
        "id_cliente",
        "nome",
        "nome_fantasia",
        "telefone",
        "tipo",
        "documento",
        "rua",
        "bairro",
        "cidade",
        "cep",
        "dt_cad",
        "dt_ult_compra"
    };

    private int id_cliente;
    private String nome;
    private String nome_fantasia;
    private String telefone;
    private String tipo;
    private String documento;
    private String rua;
    private String bairro;
    private String cidade;
    private String cep;
    private String dt_cad;
    private String dt_ult_compra;

    public Cliente() {
    }

    public Cliente(int id_cliente, String nome, String nome_fantasia, String telefone, String tipo, String documento, String rua, String bairro, String cidade, String cep, String dt_cad, String dt_ult_compra) {
        this.id_cliente = id_cliente;
        this.nome = nome;
        this.nome_fantasia = nome_fantasia;
        this.telefone = telefone;
        this.tipo = tipo;
        this.documento = documento;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.dt_cad = dt_cad;
        this.dt_ult_compra = dt_ult_compra;
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
    public int getId_cliente() {
        return id_cliente;
    }

    @Bd
    @Consult(index = 1, mask = "Nome")
    @TouchStone(index = 1, mask = "Nome", where = "UPPER(nome) LIKE '%")
    @Register
    public String getNome() {
        return nome;
    }

    @Bd
    @Consult(index = 2, mask = "Nome Fantasia")
    @TouchStone(index = 2, mask = "Nome Fantasia", where = "UPPER(nome_fantasia) LIKE '%")
    @Register
    public String getNome_fantasia() {
        return nome_fantasia;
    }

    @Bd
    @Register
    public String getTelefone() {
        return telefone;
    }

    @Bd
    @Register
    public String getTipo() {
        return tipo;
    }

    @Bd
    @Consult(index = 3, mask = "Documento")
    @TouchStone(index = 3, mask = "Documento", where = "UPPER(documento) LIKE '%")
    @Register
    public String getDocumento() {
        return documento;
    }

    @Bd
    @Register
    public String getRua() {
        return rua;
    }

    @Bd
    @Register
    public String getBairro() {
        return bairro;
    }

    @Bd
    @Register
    public String getCidade() {
        return cidade;
    }

    @Bd
    @Register
    public String getCep() {
        return cep;
    }

    @Bd
    public String getDt_cad() {
        return dt_cad;
    }

    @Bd
    public String getDt_ult_compra() {
        return dt_ult_compra;
    }

    @Register
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    @Register
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Register
    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    @Register
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Register
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Register
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    @Register
    public void setRua(String rua) {
        this.rua = rua;
    }

    @Register
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Register
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Register
    public void setCep(String cep) {
        this.cep = cep;
    }


    public void setDt_cad(String dt_cad) {
        this.dt_cad = dt_cad;
    }


    public void setDt_ult_compra(String dt_ult_compra) {
        this.dt_ult_compra = dt_ult_compra;
    }
    

}
