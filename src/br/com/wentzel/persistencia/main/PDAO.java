/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wentzel.persistencia.main;

import br.com.wentzel.util.Util;
import br.com.wentzel.persistencia.clauses.Where;
import br.com.wentzel.persistencia.query.Delete;
import br.com.wentzel.persistencia.query.Insert;
import br.com.wentzel.persistencia.query.Select;
import br.com.wentzel.persistencia.query.Update;

import java.util.ArrayList;

/**
 *
 * @author Matheus
 */
public abstract class PDAO implements IDAO {

    public boolean insert(Object o) {

        boolean result = Dao.set(new Insert(o));

        return result;

    }

    public int insertRetId(Object o) {

        int result = Dao.setRetId(new Insert(o));

        return result;

    }

    public boolean update(Object o) {

        boolean result = Dao.set(new Update(o));

        return result;

    }
    
        public boolean update(Object o, Where where) {

        boolean result = Dao.set(new Update(o, where));

        return result;

    }

    public boolean delete(PObjectDAO o, Where where) {

        boolean result = Dao.set(new Delete(o.getTABLE(), where));

        return result;

    }

    public ArrayList select(PObjectDAO o) {

        ArrayList<String[]> values;
        ArrayList<PObjectDAO> object;

        values = Dao.get(new Select(
                o.getTABLE(),
                o.getFIELDS_SELECT()
        ));

        object = toObject(values);

        return object;

    }

    public ArrayList select(PObjectDAO o, Where where) {

        ArrayList<String[]> values;
        ArrayList<PObjectDAO> object;

        values = Dao.get(new Select(
                o.getTABLE(),
                o.getFIELDS_SELECT(),
                where
        ));

        object = toObject(values);

        return object;

    }

    public ArrayList selectId(PObjectDAO o, String id) {

        ArrayList<String[]> values;
        ArrayList<PObjectDAO> object;        

        if (Util.isNumeric(id)) {

            values = Dao.get(new Select(
                    o.getTABLE(),
                    o.getFIELDS_SELECT(),
                    new Where(o.getPRIMARYKEY() + " = " + id)
            ));

        } else {
            values = null;
        }

        object = toObject(values);

        return object;

    }

    @Override
    public abstract ArrayList<PObjectDAO> toObject(ArrayList<String[]> values);

}
