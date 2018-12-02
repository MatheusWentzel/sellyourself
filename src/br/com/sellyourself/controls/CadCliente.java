/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sellyourself.controls;

import br.com.sellyourself.dao.ClienteDao;
import br.com.sellyourself.entities.Cliente;
import br.com.sellyourself.screns.FCliente;
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
public class CadCliente  extends PControl implements IControl {
 
    public CadCliente(FCliente view, ClienteDao dao, Cliente object, ArrayList<Cliente> objects) {
        super(view, dao, object, objects);
    }

    @Override
    public boolean validView() {

        if (view instanceof FCliente) {

            FCliente cc = (FCliente) view;

            //Nome
            if (!UtilValid.validJTextField(cc.getNome())) {
                JOptionPane.showMessageDialog(
                        cc.getRootPane(),
                        "Verifique os campos obrigatórios! Campo Nome inválido!",
                        "Erro",
                        0
                );
                return false;
            }
            
            //Nome Fantasia
            if (!UtilValid.validJTextField(cc.getNome_fantasia())) {
                JOptionPane.showMessageDialog(
                        cc.getRootPane(),
                        "Verifique os campos obrigatórios! Campo Nome Fantasia inválido!",
                        "Erro",
                        0
                );
                return false;
            }
            
            //Telefone
            if (!UtilValid.validJTextField(cc.getTelefone())) {
                JOptionPane.showMessageDialog(
                        cc.getRootPane(),
                        "Verifique os campos obrigatórios! Campo Telefone inválido!",
                        "Erro",
                        0
                );
                return false;
            }
            
            //Documento
            if (!UtilValid.validJTextField(cc.getDocumento())) {
                JOptionPane.showMessageDialog(
                        cc.getRootPane(),
                        "Verifique os campos obrigatórios! Campo Documento inválido!",
                        "Erro",
                        0
                );
                return false;
            }
            
            //Rua
            if (!UtilValid.validJTextField(cc.getRua())) {
                JOptionPane.showMessageDialog(
                        cc.getRootPane(),
                        "Verifique os campos obrigatórios! Campo Rua inválido!",
                        "Erro",
                        0
                );
                return false;
            }
            
            //Bairro
            if (!UtilValid.validJTextField(cc.getBairro())) {
                JOptionPane.showMessageDialog(
                        cc.getRootPane(),
                        "Verifique os campos obrigatórios! Campo Bairro inválido!",
                        "Erro",
                        0
                );
                return false;
            }
            
            //Cidade
            if (!UtilValid.validJTextField(cc.getCidade())) {
                JOptionPane.showMessageDialog(
                        cc.getRootPane(),
                        "Verifique os campos obrigatórios! Campo Cidade inválido!",
                        "Erro",
                        0
                );
                return false;
            }
            
            //Cep
            if (!UtilValid.validJTextField(cc.getCep())) {
                JOptionPane.showMessageDialog(
                        cc.getRootPane(),
                        "Verifique os campos obrigatórios! Campo Cep inválido!",
                        "Erro",
                        0
                );
                return false;
            }
            
            //Tipo
            if (cc.getTipo().getSelectedItem().toString().equals("Selecione")){
                JOptionPane.showMessageDialog(
                        cc.getRootPane(),
                        "Verifique os campos obrigatórios! Campo Tipo inválido!",
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

        if (view instanceof FCliente) {

            FCliente cad = (FCliente) view;
            
            cad.getNome().setText("");
            cad.getNome_fantasia().setText("");
            cad.getTelefone().setText("");
            cad.getTipo().setSelectedIndex(0);
            cad.getDocumento().setText("");
            cad.getRua().setText("");
            cad.getBairro().setText("");
            cad.getCidade().setText("");
            cad.getCep().setText("");

            if (object instanceof Cliente) {

                Cliente tp = (Cliente) object;

                cad.getId_cliente().setText(UtilDao.selectProxId(object.getTABLE(), object.getPRIMARYKEY())+"");                

            }

        }

    }
    
}
