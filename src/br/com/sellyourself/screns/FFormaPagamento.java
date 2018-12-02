/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sellyourself.screns;

import br.com.sellyourself.controls.CadArmazem;
import br.com.sellyourself.controls.CadFormaPagamento;
import br.com.sellyourself.dao.ArmazemDao;
import br.com.sellyourself.dao.FormaPagamentoDao;
import br.com.sellyourself.entities.Armazem;
import br.com.sellyourself.entities.FormaPagamento;
import br.com.sellyourself.reports.RepArmazem;
import br.com.sellyourself.reports.RepFormaPagamento;
import br.com.wentzel.persistencia.clauses.Where;
import br.com.wentzel.persistencia.main.UtilDao;
import br.com.wentzel.util.UtilTable;
import br.com.wentzel.views.ConsultaCad;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.sf.dynamicreports.report.datasource.DRDataSource;

/**
 *
 * @author Matheus
 */
public class FFormaPagamento extends javax.swing.JInternalFrame {

    /**
     * Creates new form CadTipoServico
     */
    private CadFormaPagamento controle;
    private FormaPagamentoDao dao;
    private FormaPagamento object;
    private ArrayList<FormaPagamento> objects;
    private int estado; //1 = inserindo / 2 = editando

    public FFormaPagamento() {
        initComponents();
        init();
    }

    private void init() {

        this.dao = new FormaPagamentoDao();
        this.object = new FormaPagamento();
        this.objects = new ArrayList();
        this.controle = new CadFormaPagamento(this, dao, object, objects);
        this.estado = 1;

        this.Id_forma_pagamento.setText(UtilDao.selectProxId(object.getTABLE(), object.getPRIMARYKEY()) + "");

    }

    private void updateControl() {

        this.controle = new CadFormaPagamento(this, dao, object, objects);

    }

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        Descricao = new javax.swing.JTextField();
        jbOk = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Id_forma_pagamento = new javax.swing.JTextField();
        jbProcurar = new javax.swing.JButton();
        jbDeletar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jbProcurar1 = new javax.swing.JButton();
        Prazo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setTitle("Cadastro | Forma de Pagamento");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jLabel2.setText("Descrição:*");

        jbOk.setText("Salvar");
        jbOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbOkActionPerformed(evt);
            }
        });

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jLabel1.setText("Cod.:");

        Id_forma_pagamento.setEditable(false);
        Id_forma_pagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Id_forma_pagamentoActionPerformed(evt);
            }
        });

        jbProcurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sellyourself/icons/search.png"))); // NOI18N
        jbProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbProcurarActionPerformed(evt);
            }
        });

        jbDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sellyourself/icons/trash.png"))); // NOI18N
        jbDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeletarActionPerformed(evt);
            }
        });

        jLabel3.setText("* - Campos Obrigatórios");

        jbProcurar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sellyourself/icons/printer.png"))); // NOI18N
        jbProcurar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbProcurar1ActionPerformed(evt);
            }
        });

        Prazo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrazoActionPerformed(evt);
            }
        });

        jLabel4.setText("Prazo*:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(207, 207, 207))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(Id_forma_pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbProcurar1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jbProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbOk, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(Prazo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Id_forma_pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbProcurar1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Prazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbCancelar)
                            .addComponent(jbOk))
                        .addContainerGap())
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbOkActionPerformed

        if (controle.validView()) {

            if (estado == 1) {

                updateControl();
                controle.insert();
                controle.cleanView();

                JOptionPane.showMessageDialog(rootPane, "Forma de Pagamento adicionado com sucesso!");

            } else if (estado == 2) {

                updateControl();
                controle.update();
                controle.cleanView();

                JOptionPane.showMessageDialog(rootPane, "Forma de Pagamento com sucesso!");

                this.estado = 1;

            }

        }

    }//GEN-LAST:event_jbOkActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed

        controle.cleanView();

        this.Id_forma_pagamento.setText(UtilDao.selectProxId(object.getTABLE(), object.getPRIMARYKEY()) + "");

        this.estado = 1;


    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbProcurarActionPerformed

        ConsultaCad cc = new ConsultaCad(null, true, object, dao) {
            @Override
            public void configTable() {

                UtilTable.centerTable(getJtTabela(), 0);

                UtilTable.setSizeColumn(getJtTabela(), 0, 30);
                UtilTable.setSizeColumn(getJtTabela(), 1, 200);

            }
        };
        cc.setSize(400, 300);
        cc.setVisible(true);

        if (cc.getObject() instanceof FormaPagamento && cc.getObject() != null) {
            this.object = (FormaPagamento) cc.getObject();

            updateControl();
            this.controle.setView();
            this.estado = 2;
        } else {
            System.err.println("Erro ao retornar o Forma Pagamento");
            this.object = new FormaPagamento();
            init();

            this.estado = 1;
        }

    }//GEN-LAST:event_jbProcurarActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing

        controle.cleanView();

        this.Id_forma_pagamento.setText(UtilDao.selectProxId(object.getTABLE(), object.getPRIMARYKEY()) + "");

        this.estado = 1;

    }//GEN-LAST:event_formInternalFrameClosing

    private void Id_forma_pagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Id_forma_pagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Id_forma_pagamentoActionPerformed

    private void jbDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeletarActionPerformed

        if (estado == 2) {

            if (JOptionPane.showConfirmDialog(this, "Você deseja excluir este registro?") == 0) {

                dao.delete(object, new Where(object.getPRIMARYKEY() + " = " + object.getId_forma_pagamento()));

                controle.cleanView();

                this.Id_forma_pagamento.setText(UtilDao.selectProxId(object.getTABLE(), object.getPRIMARYKEY()) + "");

                this.estado = 1;

            }

        }

    }//GEN-LAST:event_jbDeletarActionPerformed

    private void jbProcurar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbProcurar1ActionPerformed

        int escolha = 0;
        escolha = JOptionPane.showConfirmDialog(this, "Você deseja imprimir uma listagem do cadastro de Forma de Pagamento?");

        if (escolha == 0) {
            RepFormaPagamento rGP = new RepFormaPagamento();
            FormaPagamento obj = new FormaPagamento();
            FormaPagamentoDao gpDao = new FormaPagamentoDao();

            DRDataSource drDS = gpDao.getDataSource(obj);

            rGP.build(drDS);
        }


    }//GEN-LAST:event_jbProcurar1ActionPerformed

    private void PrazoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrazoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrazoActionPerformed

    //Getters and Setters
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public JTextField getDescricao() {
        return Descricao;
    }

    public void setDescricao(JTextField Descricao) {
        this.Descricao = Descricao;
    }

    public JTextField getId_forma_pagamento() {
        return Id_forma_pagamento;
    }

    public void setId_forma_pagamento(JTextField Id_forma_pagamento) {
        this.Id_forma_pagamento = Id_forma_pagamento;
    }

    public JTextField getPrazo() {
        return Prazo;
    }

    public void setPrazo(JTextField Prazo) {
        this.Prazo = Prazo;
    }

    
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Descricao;
    private javax.swing.JTextField Id_forma_pagamento;
    private javax.swing.JTextField Prazo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbDeletar;
    private javax.swing.JButton jbOk;
    private javax.swing.JButton jbProcurar;
    private javax.swing.JButton jbProcurar1;
    // End of variables declaration//GEN-END:variables
}
