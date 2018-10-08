/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wentzel.controller;

import br.com.wentzel.persistencia.clauses.Where;
import br.com.wentzel.persistencia.main.PDAO;
import br.com.wentzel.persistencia.main.PObjectDAO;
import java.util.ArrayList;
import javax.swing.JInternalFrame;

/**
 *
 * @author Matheus
 */
public abstract class PControl {

    protected JInternalFrame view;
    protected PDAO dao;
    protected PObjectDAO object;
    protected ArrayList objects;

    public PControl(JInternalFrame view, PDAO dao, PObjectDAO object, ArrayList objects) {
        this.view = view;
        this.dao = dao;
        this.object = object;
        this.objects = objects;
    }

    public void select() {

        objects = dao.select(object);

    }

    public void select(Where where) {

        objects = dao.select(object, where);

    }

    public void selectId(String id) {

        objects = dao.selectId(object, id);

        setView();

    }

    public boolean insert() {

        getView();

        return dao.insert(this.object);

    }

    public boolean update() {

        getView();
        
        return dao.update(this.object);

    }

    public void setView() {

        ObjectView.objectToView(object, view);

    }

    public void getView() {

        ObjectView.viewToObject(object, view);

    }

}
