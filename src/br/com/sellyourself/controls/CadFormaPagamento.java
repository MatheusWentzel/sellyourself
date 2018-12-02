/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sellyourself.controls;

import br.com.sellyourself.dao.FormaPagamentoDao;
import br.com.sellyourself.entities.Armazem;
import br.com.sellyourself.entities.FormaPagamento;
import br.com.sellyourself.screns.FArmazem;
import br.com.sellyourself.screns.FFormaPagamento;
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
public class CadFormaPagamento extends PControl implements IControl {
 
    public CadFormaPagamento(FFormaPagamento view, FormaPagamentoDao dao, FormaPagamento object, ArrayList<FormaPagamento> objects) {
        super(view, dao, object, objects);
    }

    @Override
    public boolean validView() {

        if (view instanceof FFormaPagamento) {

            FFormaPagamento cc = (FFormaPagamento) view;

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
            
            //Prazo
            if (!UtilValid.validJTextField(cc.getPrazo())) {
                JOptionPane.showMessageDialog(
                        cc.getRootPane(),
                        "Verifique os campos obrigatórios! Campo Prazo inválido!",
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

        if (view instanceof FFormaPagamento) {

            FFormaPagamento cad = (FFormaPagamento) view;
            
            cad.getDescricao().setText("");
            cad.getPrazo().setText("");

            if (object instanceof FormaPagamento) {

                FormaPagamento tp = (FormaPagamento) object;

                cad.getId_forma_pagamento().setText(UtilDao.selectProxId(object.getTABLE(), object.getPRIMARYKEY())+"");                

            }

        }

    }

    
}
