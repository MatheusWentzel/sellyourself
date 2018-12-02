/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sellyourself.controls;

import br.com.sellyourself.dao.ArmazemDao;
import br.com.sellyourself.entities.Armazem;
import br.com.sellyourself.screns.FArmazem;
import br.com.wentzel.controller.IControl;
import br.com.wentzel.controller.PControl;
import br.com.wentzel.persistencia.main.UtilDao;
import br.com.wentzel.util.UtilValid;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author wentzelmatheus
 * 
 */
public class CadArmazem extends PControl implements IControl {
 
    public CadArmazem(FArmazem view, ArmazemDao dao, Armazem object, ArrayList<Armazem> objects) {
        super(view, dao, object, objects);
    }

    @Override
    public boolean validView() {

        if (view instanceof FArmazem) {

            FArmazem cc = (FArmazem) view;

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

        if (view instanceof FArmazem) {

            FArmazem cad = (FArmazem) view;
            
            cad.getDescricao().setText("");

            if (object instanceof Armazem) {

                Armazem tp = (Armazem) object;

                cad.getId_armazem().setText(UtilDao.selectProxId(object.getTABLE(), object.getPRIMARYKEY())+"");                

            }

        }

    }
    
}
