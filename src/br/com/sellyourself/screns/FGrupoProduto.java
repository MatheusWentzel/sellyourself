/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sellyourself.screns;

import br.com.sellyourself.controls.CadGrupoProduto;
import br.com.sellyourself.dao.GrupoProdutoDao;
import br.com.sellyourself.entities.GrupoProduto;
import br.com.wentzel.persistencia.clauses.Where;
import br.com.wentzel.persistencia.main.UtilDao;
import br.com.wentzel.util.UtilTable;
import br.com.wentzel.views.ConsultaCad;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Matheus
 */
public class FGrupoProduto extends javax.swing.JInternalFrame {

    /**
     * Creates new form CadTipoServico
     */
    private CadGrupoProduto controle;
    private GrupoProdutoDao dao;
    private GrupoProduto object;
    private ArrayList<GrupoProduto> objects;
    private int estado; //1 = inserindo / 2 = editando

    public FGrupoProduto() {
        initComponents();
        init();
    }

    private void init() {

        this.dao = new GrupoProdutoDao();
        this.object = new GrupoProduto();
        this.objects = new ArrayList();
        this.controle = new CadGrupoProduto(this, dao, object, objects);
        this.estado = 1;

        this.Id_grupo.setText(UtilDao.selectProxId(object.getTABLE(), object.getPRIMARYKEY()) + "");

    }

    private void updateControl() {

        this.controle = new CadGrupoProduto(this, dao, object, objects);

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
        Id_grupo = new javax.swing.JTextField();
        jbProcurar = new javax.swing.JButton();
        jbDeletar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setTitle("Cadastro | Grupo Produto");
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

        jLabel2.setText("Nome:*");

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

        Id_grupo.setEditable(false);
        Id_grupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Id_grupoActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(Id_grupo, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(207, 207, 207)
                                .addComponent(jbProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbOk, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                        .addComponent(Id_grupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

                JOptionPane.showMessageDialog(rootPane, "Grupo Produto adicionado com sucesso!");

            } else if (estado == 2) {

                updateControl();
                controle.update();
                controle.cleanView();

                JOptionPane.showMessageDialog(rootPane, "Grupo Produto alterado com sucesso!");

                this.estado = 1;

            }

        }

    }//GEN-LAST:event_jbOkActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed

        controle.cleanView();

        this.Id_grupo.setText(UtilDao.selectProxId(object.getTABLE(), object.getPRIMARYKEY()) + "");

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
        
        if (cc.getObject() instanceof GrupoProduto && cc.getObject() != null) {
            this.object = (GrupoProduto) cc.getObject();

            updateControl();
            this.controle.setView();
            this.estado = 2;
        } else {
            System.err.println("Erro ao retornar o Grupo Produto");
            this.object = new GrupoProduto();
            init();

            this.estado = 1;
        }

    }//GEN-LAST:event_jbProcurarActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing

        controle.cleanView();

        this.Id_grupo.setText(UtilDao.selectProxId(object.getTABLE(), object.getPRIMARYKEY()) + "");

        this.estado = 1;

    }//GEN-LAST:event_formInternalFrameClosing

    private void Id_grupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Id_grupoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Id_grupoActionPerformed

    private void jbDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeletarActionPerformed

        if (estado == 2) {

            if (JOptionPane.showConfirmDialog(this, "Você deseja excluir este registro?") == 0) {

                dao.delete(object, new Where(object.getPRIMARYKEY() + " = " + object.getId_grupo()));

                controle.cleanView();

                this.Id_grupo.setText(UtilDao.selectProxId(object.getTABLE(), object.getPRIMARYKEY()) + "");

                this.estado = 1;

            }

        }

    }//GEN-LAST:event_jbDeletarActionPerformed

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

    public JTextField getId_grupo() {
        return Id_grupo;
    }

    public void setId_grupo(JTextField Id_grupo) {
        this.Id_grupo = Id_grupo;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Descricao;
    private javax.swing.JTextField Id_grupo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbDeletar;
    private javax.swing.JButton jbOk;
    private javax.swing.JButton jbProcurar;
    // End of variables declaration//GEN-END:variables
}
