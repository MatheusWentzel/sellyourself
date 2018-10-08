/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sellyourself.reports;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;

/**
 *
 * @author wentzelmatheus
 */
public class RepGrupoProduto {

    public void build(DRDataSource data) {

        JasperReportBuilder report = DynamicReports.report();//a new report
        report
                .columns(
                        Columns.column("Cód", "Cod", DataTypes.integerType()),
                        Columns.column("Descrição", "Descricao", DataTypes.stringType()))
                                .title(//title of the report
                                        Components.text("SimpleReportExample")
                                                .setHorizontalAlignment(HorizontalAlignment.CENTER))
                                .pageFooter(Components.pageXofY())//show page number on the page footer
                                .setDataSource(data);

        try {
            //show the report
            report.show();

        } catch (DRException e) {
            e.printStackTrace();
        }

    }

//    public void build(DRDataSource dataSource) {
//
//        StyleBuilder boldStyle = stl.style().bold();
//        StyleBuilder boldCenteredStyle = stl.style(boldStyle).setHorizontalTextAlignment(HorizontalTextAlignment.CENTER);
//        StyleBuilder columnTitleStyle = stl.style(boldCenteredStyle)
//                .setBorder(stl.pen1Point())
//                .setBackgroundColor(Color.LIGHT_GRAY);
//
//        StyleBuilder titleStyle = stl.style(boldCenteredStyle)
//                .setVerticalTextAlignment(VerticalTextAlignment.MIDDLE)
//                .setFontSize(15);
//
//        //                                                           title,     field name     data type
//        TextColumnBuilder<Integer> cod = col.column("Cod.", "Cod", type.integerType())
//                .setFixedWidth(50)
//                .setHorizontalTextAlignment(HorizontalTextAlignment.CENTER);
//        TextColumnBuilder<String> descricao = col.column("Tarefa", "Descricao", type.stringType())
//                .setHorizontalTextAlignment(HorizontalTextAlignment.LEFT);
//
//        try {
//
//                report()//create new report design
//                        .setColumnTitleStyle(columnTitleStyle)
//                        //.setPageFormat(PageType.A4, PageOrientation.PORTRAIT)
//                        .setSubtotalStyle(boldStyle)
//                        .highlightDetailEvenRows()
//                        .columns(//add columns
//                                cod,
//                                descricao
//                        )
//                        .title(
//                                cmp.horizontalList()
//                                        .add(
//                                                cmp.text("  SELL YOURSELF").setStyle(titleStyle).setHorizontalTextAlignment(HorizontalTextAlignment.LEFT),
//                                                cmp.text(" GrupoProduto").setStyle(titleStyle).setHorizontalTextAlignment(HorizontalTextAlignment.RIGHT))
//                                        .newRow()
//                                        .add(cmp.filler().setStyle(stl.style().setTopBorder(stl.pen2Point())).setFixedHeight(10)))
//                        .pageFooter(cmp.pageXofY().setStyle(boldCenteredStyle))//shows number of page at page footer
//                        .setDataSource(dataSource) //set datasource
//                        .show();
//
//            
//        } catch (DRException e) {
//            e.printStackTrace();
//        }
//
//
//    }
}
