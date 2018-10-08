/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sellyourself.main;

import br.com.sellyourself.dao.GrupoProdutoDao;
import br.com.sellyourself.entities.GrupoProduto;
import br.com.wentzel.persistencia.clauses.Where;
import java.util.ArrayList;

/**
 *
 * @author wentzelmatheus
 */
public class TesteCrudGrupoProduto {
    
    public static void main(String[] args) {
        
        //Inicializa as variáveis
        boolean ret = false;
        
        //Inicializa os objetos
        GrupoProduto grupoProduto;
        GrupoProdutoDao dao = new GrupoProdutoDao();
        ArrayList<GrupoProduto> gruposProdutos = new ArrayList();
        
        //Cria o Objeto Produto para ser inserido
        grupoProduto = new GrupoProduto(
                2, 
                "ALIMENTOS"
        );
        
        //Insere no Banco o Objeto
        ret = dao.insert(grupoProduto);
        
        if (!ret){
            System.out.println("Objeto inserido com sucesso!");
        }
        
        //Seleciona os Objetos no Banco
        gruposProdutos = dao.select(grupoProduto, new Where("id_grupo = 2"));
        grupoProduto = gruposProdutos.get(0);
        
        System.out.println("Grupo: " + grupoProduto.getId_grupo()+ " - " + grupoProduto.getDescricao());
        
        //Atualiza o objeto na base de dados
        grupoProduto.setDescricao("ALIMENTOS SECOS");
        ret = dao.update(grupoProduto, new Where("id_grupo = 2"));
        
        if (!ret){
            System.out.println("Objeto atualizado com sucesso!");
        }
        
        //Deleta o objeto da base de dados
        ret = dao.delete(grupoProduto, new Where("id_grupo = 2"));
        
        if (!ret){
            System.out.println("Objeto deletado com sucesso!");
        }
        
    }
    
}
