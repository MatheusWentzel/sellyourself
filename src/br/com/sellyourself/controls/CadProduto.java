/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sellyourself.controls;

import br.com.sellyourself.dao.ProdutoDao;
import br.com.sellyourself.entities.Produto;
import br.com.sellyourself.screns.FProduto;
import br.com.wentzel.controller.IControl;
import br.com.wentzel.controller.PControl;
import br.com.wentzel.persistencia.main.UtilDao;
import br.com.wentzel.util.UtilValid;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author wentzelmatheus
 */
public class CadProduto extends PControl implements IControl {
 
    public CadProduto(FProduto view, ProdutoDao dao, Produto object, ArrayList<Produto> objects) {
        super(view, dao, object, objects);
    }

    @Override
    public boolean validView() {

        if (view instanceof FProduto) {

            FProduto cc = (FProduto) view;

            //Nome
            if (!UtilValid.validJTextField(cc.getDescricao())) {
                JOptionPane.showMessageDialog(
                        cc.getRootPane(),
                        "Verifique os campos obrigatórios! Campo Descricao inválido!",
                        "Erro",
                        0
                );
                return false;
            }
            
            //Ean
            if (!UtilValid.validJTextField(cc.getEan())) {
                JOptionPane.showMessageDialog(
                        cc.getRootPane(),
                        "Verifique os campos obrigatórios! Campo Ean inválido!",
                        "Erro",
                        0
                );
                return false;
            }
            
            //Unidade
            if (!UtilValid.validJTextField(cc.getUnidade())) {
                JOptionPane.showMessageDialog(
                        cc.getRootPane(),
                        "Verifique os campos obrigatórios! Campo Unidade inválido!",
                        "Erro",
                        0
                );
                return false;
            }
            
            //Valor
            if (!UtilValid.validJTextField(cc.getValor())) {
                JOptionPane.showMessageDialog(
                        cc.getRootPane(),
                        "Verifique os campos obrigatórios! Campo Valor inválido!",
                        "Erro",
                        0
                );
                return false;
            }
            
            //Grupo Id
            if (!UtilValid.validJTextField(cc.getGrupo_id())) {
                JOptionPane.showMessageDialog(
                        cc.getRootPane(),
                        "Verifique os campos obrigatórios! Campo Grupo Produto inválido!",
                        "Erro",
                        0
                );
                return false;
            }
            
        }

        return true;

    }

    @Override
    public void cleanView() {

        if (view instanceof FProduto) {

            FProduto cad = (FProduto) view;

            cad.getDescricao().setText("");

            if (object instanceof Produto) {

                Produto tp = (Produto) object;

                cad.getId_produto().setText(UtilDao.selectProxId(object.getTABLE(), object.getPRIMARYKEY())+"");
                cad.getDescricao().setText("");
                cad.getEan().setText("");
                cad.getUnidade().setText("");
                cad.getValor().setText("");
                cad.getGrupo_id().setText("");

            }

        }

    }
    
}
