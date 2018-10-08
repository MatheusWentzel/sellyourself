/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sellyourself.main;

import br.com.sellyourself.dao.ProdutoDao;
import br.com.sellyourself.entities.Produto;
import br.com.wentzel.persistencia.clauses.Where;
import java.util.ArrayList;

/**
 *
 * @author wentzelmatheus
 */
public class TesteCrudProduto {
    
    public static void main(String[] args) {
        
        //Inicializa as variáveis
        boolean ret = false;
        
        //Inicializa os objetos
        Produto produto;
        ProdutoDao dao = new ProdutoDao();
        ArrayList<Produto> produtos = new ArrayList();
        
        //Cria o Objeto Produto para ser inserido
        produto = new Produto(
                1, 
                1, 
                "AGUA SEM GÁS 1L", 
                "99999999999999", 
                "UN", 
                3.50
        );
        
        //Insere no Banco o Objeto
        ret = dao.insert(produto);
        
        if (!ret){
            System.out.println("Objeto inserido com sucesso!");
        }
        
        //Seleciona os Objetos no Banco
        produtos = dao.select(produto, new Where("id_produto = 1"));
        produto = produtos.get(0);
        
        System.out.println("Produto: " + produto.getId_produto() + " - " + produto.getDescricao());
        
        //Atualiza o objeto na base de dados
        produto.setValor(1.45);
        produto.setDescricao("AGUA DA PEDRA 1L");
        ret = dao.update(produto, new Where("id_produto = 1"));
        
        if (!ret){
            System.out.println("Objeto atualizado com sucesso!");
        }
        
        //Deleta o objeto da base de dados
        ret = dao.delete(produto, new Where("id_produto = 1"));
        
        if (!ret){
            System.out.println("Objeto deletado com sucesso!");
        }
                       
    }
    
}
