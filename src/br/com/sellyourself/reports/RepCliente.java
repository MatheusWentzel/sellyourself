/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sellyourself.reports;

import java.awt.Color;
import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.constant.VerticalTextAlignment;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;

/**
 *
 * @author wentzelmatheus
 */
public class RepCliente {

    public void build(DRDataSource dataSource) {

        StyleBuilder boldStyle = stl.style().bold();
        StyleBuilder boldCenteredStyle = stl.style(boldStyle).setHorizontalTextAlignment(HorizontalTextAlignment.CENTER);
        StyleBuilder columnTitleStyle = stl.style(boldCenteredStyle)
                .setBorder(stl.pen1Point())
                .setBackgroundColor(Color.LIGHT_GRAY);

        StyleBuilder titleStyle = stl.style(boldCenteredStyle)
                .setVerticalTextAlignment(VerticalTextAlignment.MIDDLE)
                .setFontSize(15);

        //                                                           title,     field name     data type
        TextColumnBuilder<Integer> cod = col.column("Cod.", "Cod", type.integerType())
                .setFixedWidth(50)
                .setHorizontalTextAlignment(HorizontalTextAlignment.CENTER);
        TextColumnBuilder<String> nome = col.column("Nome", "Nome", type.stringType())
                .setHorizontalTextAlignment(HorizontalTextAlignment.LEFT);
        TextColumnBuilder<String> nome_fantasia = col.column("NomeFantasia", "NomeFantasia", type.stringType())
                .setHorizontalTextAlignment(HorizontalTextAlignment.LEFT);
        TextColumnBuilder<String> telefone = col.column("Telefone", "Telefone", type.stringType())
                .setHorizontalTextAlignment(HorizontalTextAlignment.LEFT);
        TextColumnBuilder<String> tipo = col.column("Tipo", "Tipo", type.stringType())
                .setHorizontalTextAlignment(HorizontalTextAlignment.LEFT);
        TextColumnBuilder<String> documento = col.column("Doc", "Doc", type.stringType())
                .setHorizontalTextAlignment(HorizontalTextAlignment.LEFT);
        TextColumnBuilder<String> rua = col.column("Rua", "Rua", type.stringType())
                .setHorizontalTextAlignment(HorizontalTextAlignment.LEFT);
        TextColumnBuilder<String> bairro = col.column("Bairro", "Bairro", type.stringType())
                .setHorizontalTextAlignment(HorizontalTextAlignment.LEFT);
        TextColumnBuilder<String> cidade = col.column("Cidade", "Cidade", type.stringType())
                .setHorizontalTextAlignment(HorizontalTextAlignment.LEFT);
        TextColumnBuilder<String> cep = col.column("Cep", "Cep", type.stringType())
                .setHorizontalTextAlignment(HorizontalTextAlignment.LEFT);

        try {

            report()//create new report design
                    .setColumnTitleStyle(columnTitleStyle)
                    //.setPageFormat(PageType.A4, PageOrientation.PORTRAIT)
                    .setSubtotalStyle(boldStyle)
                    .highlightDetailEvenRows()
                    .columns(//add columns
                            cod,
                            nome,
                            nome_fantasia,
                            telefone,
                            tipo,
                            documento,
                            rua,
                            bairro,
                            cidade,
                            cep
                    )
                    .title(
                            cmp.horizontalList()
                                    .add(
                                            cmp.text("  SELL YOURSELF").setStyle(titleStyle).setHorizontalTextAlignment(HorizontalTextAlignment.LEFT),
                                            cmp.text(" Listagem Cliente").setStyle(titleStyle).setHorizontalTextAlignment(HorizontalTextAlignment.RIGHT))
                                    .newRow()
                                    .add(cmp.filler().setStyle(stl.style().setTopBorder(stl.pen2Point())).setFixedHeight(10)))
                    .pageFooter(cmp.pageXofY().setStyle(boldCenteredStyle))//shows number of page at page footer
                    .setDataSource(dataSource) //set datasource
                    .show(false);

        } catch (DRException e) {
            e.printStackTrace();
        }

    }

}
