package br.com.wentzel.persistencia.main;

import br.com.wentzel.persistencia.clauses.Where;
import java.util.ArrayList;

/**
 *
 * @author Matheus
 */
public class Script {

    public static String getInsert(Object obj) {
        ArrayList<String[]> aColumnsDataType = new ArrayList();
        ArrayList<String> aValues = new ArrayList();

        String table = ManipulateClass.getTableClass(obj);
        String primarykey = ManipulateClass.getPrimaryKeyClass(obj);
        String valuePrimaryKey = ManipulateClass.getValuePrimaryKey(obj);
        aColumnsDataType = DaoUtil.getDataColumns(table);
        aValues = ManipulateClass.getValuesClass(obj, aColumnsDataType);

        int i = 0;
        String query = "INSERT INTO " + table + " (";
        for (String[] string : aColumnsDataType) {
            if ((i < (aColumnsDataType.size() - 1))
                    && (!aColumnsDataType.get(i)[0].equals(primarykey))) {
                query += aColumnsDataType.get(i)[0] + ", ";
            } else if (!aColumnsDataType.get(i)[0].equals(primarykey)) {
                query += aColumnsDataType.get(i)[0] + ")";
            }
            i++;
        }
        query += " VALUES (";
        i = 0;
        for (String string : aValues) {
            if ((i < aValues.size() - 1) && (!aColumnsDataType.get(i)[0].equals(primarykey))) {
                if (aColumnsDataType.get(i)[1].equals("varchar") || aColumnsDataType.get(i)[1].equals("char")
                        || aColumnsDataType.get(i)[1].equals("date") || aColumnsDataType.get(i)[1].equals("datetime")
                        || aColumnsDataType.get(i)[1].equals("text") || aColumnsDataType.get(i)[1].equals("time")
                        || aColumnsDataType.get(i)[1].equals("timestamp")) {
                    if (!aValues.get(i).equals("CURRENT_TIMESTAMP") 
                            && !aValues.get(i).equals("NULL")
                            && !aValues.get(i).equals("NOW()")) {
                        query += "'" + aValues.get(i) + "', ";
                    } else {
                        query += aValues.get(i) + ", ";
                    }
                } else {
                    query += aValues.get(i) + ", ";
                }
            } else if (!aColumnsDataType.get(i)[0].equals(primarykey)) {
                if (aColumnsDataType.get(i)[1].equals("varchar") || aColumnsDataType.get(i)[1].equals("char")
                        || aColumnsDataType.get(i)[1].equals("date") || aColumnsDataType.get(i)[1].equals("datetime")
                        || aColumnsDataType.get(i)[1].equals("text") || aColumnsDataType.get(i)[1].equals("time")
                        || aColumnsDataType.get(i)[1].equals("timestamp")) {
                    if (!aValues.get(i).equals("CURRENT_TIMESTAMP") 
                            && !aValues.get(i).equals("NULL")
                            && !aValues.get(i).equals("NOW()")) {
                        query += "'" + aValues.get(i) + "')";
                    } else {
                        query += aValues.get(i) + ")";
                    }
                } else {
                    query += aValues.get(i) + ") ";
                }
            }
            i++;
        }
        return query;
    }

    public static String getInsert(String table, String[] columns, String[] values) {
        ArrayList<String[]> aColumnsDataType = DaoUtil.getDataColumns(table);

        String query = "INSERT INTO " + table + " (";
        for (int i = 0; i < columns.length; i++) {
            if ((columns.length - 1) > i) {
                query += columns[i] + ", ";
            } else {
                query += columns[i] + ") ";
            }
        }
        query += "VALUES (";
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
            if ((columns.length - 1) > i) {
                if (aColumnsDataType.get(i)[1].equals("varchar") || aColumnsDataType.get(i)[1].equals("char")
                        || aColumnsDataType.get(i)[1].equals("date") || aColumnsDataType.get(i)[1].equals("datetime")
                        || aColumnsDataType.get(i)[1].equals("text") || aColumnsDataType.get(i)[1].equals("time")
                        || aColumnsDataType.get(i)[1].equals("timestamp")) {
                    if (!values[i].equals("CURRENT_TIMESTAMP") 
                            && !values[i].equals("NULL")
                            && !values[i].equals("NOW()")) {
                        query += "'" + values[i] + "', ";
                    } else {
                        query += values[i] + ", ";
                    }
                } else {
                    query += values[i] + ", ";
                }
            } else if (aColumnsDataType.get(i)[1].equals("varchar") || aColumnsDataType.get(i)[1].equals("char")
                    || aColumnsDataType.get(i)[1].equals("date") || aColumnsDataType.get(i)[1].equals("datetime")
                    || aColumnsDataType.get(i)[1].equals("text") || aColumnsDataType.get(i)[1].equals("time")
                    || aColumnsDataType.get(i)[1].equals("timestamp")) {
                if (!values[i].equals("CURRENT_TIMESTAMP") 
                        && !values[i].equals("NULL")
                        && !values[i].equals("NOW()")) {
                    query += "'" + values[i] + "') ";
                } else {
                    query += values[i] + ") ";
                }
            } else {
                query += values[i] + ") ";
            }
        }
        return query;

    }

    public static String getUpdate(Object obj) {
        ArrayList<String[]> aColumnsDataType = new ArrayList();
        ArrayList<String> aValues = new ArrayList();
        String query;

        String table = ManipulateClass.getTableClass(obj);
        String primaryKey = ManipulateClass.getPrimaryKeyClass(obj);
        String valuePrimaryKey = ManipulateClass.getValuePrimaryKey(obj);

        aColumnsDataType = DaoUtil.getDataColumns(table);
        aValues = ManipulateClass.getValuesClass(obj, aColumnsDataType);

        query = "UPDATE " + table + " SET ";
        int i = 0;
        for (String string : aValues) {
            if ((i < aValues.size() - 1) && (!aColumnsDataType.get(i)[0].equals(primaryKey))) {
                if (aColumnsDataType.get(i)[1].equals("varchar") || aColumnsDataType.get(i)[1].equals("char")
                        || aColumnsDataType.get(i)[1].equals("date") || aColumnsDataType.get(i)[1].equals("datetime")
                        || aColumnsDataType.get(i)[1].equals("text") || aColumnsDataType.get(i)[1].equals("time")
                        || aColumnsDataType.get(i)[1].equals("timestamp")) {
                    if (!aValues.get(i).equals("CURRENT_TIMESTAMP") 
                            && !aValues.get(i).toUpperCase().equals("NULL")
                            && !aValues.get(i).equals("NOW()")) {
                        query += aColumnsDataType.get(i)[0] + " = '" + aValues.get(i) + "', ";
                    } else {
                        query += aColumnsDataType.get(i)[0] + " = " + aValues.get(i) + ", ";
                    }
                } else {
                    query += aColumnsDataType.get(i)[0] + " = " + aValues.get(i) + ", ";
                }
            } else if (!aColumnsDataType.get(i)[0].equals(primaryKey)) {
                if (aColumnsDataType.get(i)[1].equals("varchar") || aColumnsDataType.get(i)[1].equals("char")
                        || aColumnsDataType.get(i)[1].equals("date") || aColumnsDataType.get(i)[1].equals("datetime")
                        || aColumnsDataType.get(i)[1].equals("text") || aColumnsDataType.get(i)[1].equals("time")
                        || aColumnsDataType.get(i)[1].equals("timestamp")) {
                    if (!aValues.get(i).equals("CURRENT_TIMESTAMP") 
                            && !aValues.get(i).toUpperCase().equals("NULL")
                            && !aValues.get(i).equals("NOW()")) {
                        query += aColumnsDataType.get(i)[0] + " = '" + aValues.get(i) + "' ";
                    } else {
                        query += aColumnsDataType.get(i)[0] + " = " + aValues.get(i) + " ";
                    }
                } else {
                    query += aColumnsDataType.get(i)[0] + " = " + aValues.get(i) + " ";
                }
            }
            i++;
        }
        query += "WHERE " + primaryKey + " = " + valuePrimaryKey;
        return query;
    }
    
    public static String getUpdate(Object obj, Where where) {
        ArrayList<String[]> aColumnsDataType = new ArrayList();
        ArrayList<String> aValues = new ArrayList();
        String query;

        String table = ManipulateClass.getTableClass(obj);
        String primaryKey = ManipulateClass.getPrimaryKeyClass(obj);
        String valuePrimaryKey = ManipulateClass.getValuePrimaryKey(obj);

        aColumnsDataType = DaoUtil.getDataColumns(table);
        aValues = ManipulateClass.getValuesClass(obj, aColumnsDataType);

        query = "UPDATE " + table + " SET ";
        int i = 0;
        for (String string : aValues) {
            if ((i < aValues.size() - 1) && (!aColumnsDataType.get(i)[0].equals(primaryKey))) {
                if (aColumnsDataType.get(i)[1].equals("varchar") || aColumnsDataType.get(i)[1].equals("char")
                        || aColumnsDataType.get(i)[1].equals("date") || aColumnsDataType.get(i)[1].equals("datetime")
                        || aColumnsDataType.get(i)[1].equals("text") || aColumnsDataType.get(i)[1].equals("time")
                        || aColumnsDataType.get(i)[1].equals("timestamp")) {
                    if (!aValues.get(i).equals("CURRENT_TIMESTAMP") 
                            && !aValues.get(i).toUpperCase().equals("NULL")
                            && !aValues.get(i).equals("NOW()")) {
                        query += aColumnsDataType.get(i)[0] + " = '" + aValues.get(i) + "', ";
                    } else {
                        query += aColumnsDataType.get(i)[0] + " = " + aValues.get(i) + ", ";
                    }
                } else {
                    query += aColumnsDataType.get(i)[0] + " = " + aValues.get(i) + ", ";
                }
            } else if (!aColumnsDataType.get(i)[0].equals(primaryKey)) {
                if (aColumnsDataType.get(i)[1].equals("varchar") || aColumnsDataType.get(i)[1].equals("char")
                        || aColumnsDataType.get(i)[1].equals("date") || aColumnsDataType.get(i)[1].equals("datetime")
                        || aColumnsDataType.get(i)[1].equals("text") || aColumnsDataType.get(i)[1].equals("time")
                        || aColumnsDataType.get(i)[1].equals("timestamp")) {
                    if (!aValues.get(i).equals("CURRENT_TIMESTAMP") 
                            && !aValues.get(i).toUpperCase().equals("NULL")
                            && !aValues.get(i).equals("NOW()")) {
                        query += aColumnsDataType.get(i)[0] + " = '" + aValues.get(i) + "' ";
                    } else {
                        query += aColumnsDataType.get(i)[0] + " = " + aValues.get(i) + " ";
                    }
                } else {
                    query += aColumnsDataType.get(i)[0] + " = " + aValues.get(i) + " ";
                }
            }
            i++;
        }
        query += where.getClause();
        return query;
    }

    public static String getUpdate(String table, String[] aColumns, String[] aValues, String pK, String valuePK) {
        ArrayList<String[]> aColumnsDataType = getColunas(table, aColumns);

        String query = "";

        query = "UPDATE " + table + " SET ";
        for (int i = 0; i < aValues.length; i++) {
            if ((i < aValues.length - 1)) {
                if (aColumnsDataType.get(i)[1].equals("varchar") || aColumnsDataType.get(i)[1].equals("char")
                        || aColumnsDataType.get(i)[1].equals("date") || aColumnsDataType.get(i)[1].equals("datetime")
                        || aColumnsDataType.get(i)[1].equals("text") || aColumnsDataType.get(i)[1].equals("time")
                        || aColumnsDataType.get(i)[1].equals("timestamp")) {
                    if (!aValues[i].equals("CURRENT_TIMESTAMP") 
                            && !aValues[i].equals("NULL")
                            && !aValues[i].equals("NOW()")) {
                        query += aColumnsDataType.get(i)[0] + " = '" + aValues[i] + "', ";
                    } else {
                        query += aColumnsDataType.get(i)[0] + " = " + aValues[i] + ", ";
                    }
                } else {
                    query += aColumnsDataType.get(i)[0] + " = " + aValues[i] + ", ";
                }
            } else if (aColumnsDataType.get(i)[1].equals("varchar") || aColumnsDataType.get(i)[1].equals("char")
                    || aColumnsDataType.get(i)[1].equals("date") || aColumnsDataType.get(i)[1].equals("datetime")
                    || aColumnsDataType.get(i)[1].equals("text") || aColumnsDataType.get(i)[1].equals("time")
                    || aColumnsDataType.get(i)[1].equals("timestamp")) {
                if (!aValues[i].toUpperCase().equals("CURRENT_TIMESTAMP") 
                        && !aValues[i].toUpperCase().equals("NULL")
                        && !aValues[i].equals("NOW()")) {
                    query += aColumnsDataType.get(i)[0] + " = '" + aValues[i] + "' ";
                } else {
                    query += aColumnsDataType.get(i)[0] + " = " + aValues[i] + " ";
                }
            } else {
                query += aColumnsDataType.get(i)[0] + " = " + aValues[i] + " ";
            }

        }

        query += "WHERE " + pK + " = " + valuePK;
        return query;
    }

    public static String getUpdate(String table, String[] aColumns, String[] aValues) {
        ArrayList<String[]> aColumnsDataType = getColunas(table, aColumns);

        String query = "";

        query = "UPDATE " + table + " SET ";
        for (int i = 0; i < aValues.length; i++) {
            if ((i < aValues.length - 1)) {
                if (aColumnsDataType.get(i)[1].equals("varchar") || aColumnsDataType.get(i)[1].equals("char")
                        || aColumnsDataType.get(i)[1].equals("date") || aColumnsDataType.get(i)[1].equals("datetime")
                        || aColumnsDataType.get(i)[1].equals("text") || aColumnsDataType.get(i)[1].equals("time")
                        || aColumnsDataType.get(i)[1].equals("timestamp")) {
                    if (!aValues[i].equals("CURRENT_TIMESTAMP") 
                            && !aValues[i].equals("NULL")
                            && !aValues[i].equals("NOW()")) {
                        query += aColumnsDataType.get(i)[0] + " = '" + aValues[i] + "', ";
                    } else {
                        query += aColumnsDataType.get(i)[0] + " = " + aValues[i] + ", ";
                    }
                } else {
                    query += aColumnsDataType.get(i)[0] + " = " + aValues[i] + ", ";
                }
            } else if (aColumnsDataType.get(i)[1].equals("varchar") || aColumnsDataType.get(i)[1].equals("char")
                    || aColumnsDataType.get(i)[1].equals("date") || aColumnsDataType.get(i)[1].equals("datetime")
                    || aColumnsDataType.get(i)[1].equals("text") || aColumnsDataType.get(i)[1].equals("time")
                    || aColumnsDataType.get(i)[1].equals("timestamp")) {
                if (!aValues[i].toUpperCase().equals("CURRENT_TIMESTAMP") 
                        && !aValues[i].toUpperCase().equals("NULL")
                        && !aValues[i].equals("NOW()")) {
                    query += aColumnsDataType.get(i)[0] + " = '" + aValues[i] + "' ";
                } else {
                    query += aColumnsDataType.get(i)[0] + " = " + aValues[i] + " ";
                }
            } else {
                query += aColumnsDataType.get(i)[0] + " = " + aValues[i] + " ";
            }

        }

        return query;
    }

    public static String getSelect(String[] colunas) {
        String ret = "";

        for (int k = 0; k < colunas.length; k++) {
            if (k < colunas.length - 1) {
                ret += colunas[k] + ", ";
            } else {
                ret += colunas[k];
            }
        }

        return ret;
    }

    public static ArrayList<String[]> getColunas(String table, String[] aColumns) {
        ArrayList<String[]> aColumnsDataType = DaoUtil.getDataColumns(table);
        ArrayList<String[]> ret = new ArrayList();

        int y = 0;
        for (int k = 0; k < aColumnsDataType.size(); k++) {
            for (int i = 0; i < aColumns.length; i++) {
                if (aColumns[i].equals(aColumnsDataType.get(k)[0])) {
                    ret.add(new String[]{aColumnsDataType.get(k)[0], aColumnsDataType.get(k)[1], aColumnsDataType.get(k)[2]});
                }
            }
        }

        return ret;
    }
}
