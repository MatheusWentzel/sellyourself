/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sellyourself.controls;

import br.com.sellyourself.dao.GrupoProdutoDao;
import br.com.sellyourself.entities.GrupoProduto;
import br.com.sellyourself.screns.FGrupoProduto;
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
public class CadGrupoProduto extends PControl implements IControl {
 
    public CadGrupoProduto(FGrupoProduto view, GrupoProdutoDao dao, GrupoProduto object, ArrayList<GrupoProduto> objects) {
        super(view, dao, object, objects);
    }

    @Override
    public boolean validView() {

        if (view instanceof FGrupoProduto) {

            FGrupoProduto cc = (FGrupoProduto) view;

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
        }

        return true;

    }

    @Override
    public void cleanView() {

        if (view instanceof FGrupoProduto) {

            FGrupoProduto cad = (FGrupoProduto) view;

            cad.getDescricao().setText("");

            if (object instanceof GrupoProduto) {

                GrupoProduto tp = (GrupoProduto) object;

                cad.getId_grupo().setText(UtilDao.selectProxId(object.getTABLE(), object.getPRIMARYKEY())+"");

            }

        }

    }
    
}
