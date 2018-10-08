/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wentzel.util;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Matheus
 */
public class UtilTable {

    public static JTable setValues(JTable table, ArrayList<String[]> values, String[] columns) {

        if (values != null) {

            table.setModel(new DefaultTableModel(values.toArray(new String[values.size()][]), columns) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            });

        } else {

            System.err.println("O número de colunas não é igual ao tamanho do vetor de valores!");

            table.setModel(new DefaultTableModel(null, columns) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            });

        }

        return table;
    }
    

//Centraliza uma coluna da table
    public static JTable centerTable(JTable table, int column) {

        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        table.getColumnModel().getColumn(column).setCellRenderer(centralizado);

        return table;

    }

    //Define o tamamanho da coluna da table
    public static JTable setSizeColumn(JTable table, int colum, int size) {

        table.getColumnModel().getColumn(colum).setPreferredWidth(size);

        return table;

    }

    //Define a seleção única
    public static JTable setSingleSelection(JTable table) {

        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        return table;

    }

}
