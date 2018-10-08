package br.com.wentzel.util;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Util {

    public static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    //Retira espaços em brancos desnecessarios
    public static String retiraEspacos(String palavra) {

        String[] vet = palavra.split(" ");
        String[] vet2 = new String[vet.length];
        for (int i = 0; i < vet.length; i++) {
            vet2[i] = vet[i].replaceAll(" ", "");
        }
        palavra = "";
        for (int i = 0; i < vet.length; i++) {
            palavra = palavra + vet2[i] + " ";
        }

        return palavra;

    }

    public static String formataData(Date data) {

        String dataF;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        dataF = sdf.format(data);

        return dataF;
    }

    public static String formataDataToBD(Date data) {

        String dataF;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        dataF = sdf.format(data);

        return dataF;
    }

    public static String formataDataToBD(Date data, String bd) {

        String dataF;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");;

        if (bd.equals("MSSQL")) {
            sdf = new SimpleDateFormat("yyyy-MM-dd");
        } else if (bd.equals("MYSQL")) {
            sdf = new SimpleDateFormat("yyyyMMdd");
        }

        dataF = sdf.format(data);

        return dataF;
    }

    public static String formataDataDMA(Date data) {

        String dataF;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        dataF = sdf.format(data);

        return dataF;
    }

    public static String formataDataDMAHS(Date data) {

        String dataF;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        dataF = sdf.format(data);

        return dataF;
    }

    public static String formataData(String data) throws ParseException {

        String dataF;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = sdf.parse(data);
        dataF = output.format(d);

        return dataF;
    }

    public static int getDiaSemana(Date data) {

        //1 - Seg / 2 - Ter / 3 - Qua / 4 - Qui / 5 - Sex / 6 - Sab / 7 - Dom   
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        int diaSemana = cal.get(Calendar.DAY_OF_WEEK);

        if (diaSemana == 2 || diaSemana == 3 || diaSemana == 4
                || diaSemana == 5 || diaSemana == 6 || diaSemana == 7) {
            diaSemana = diaSemana - 1;
        } else if (diaSemana == 1) {
            diaSemana = diaSemana + 6;
        }

        return diaSemana;

    }

    public static Date getSegunda(Date data) {

        int nSemana = getDiaSemana(data);

        switch (nSemana) {
            case 1:
                return data;
            case 2:
                return somaData(data, - 1);
            case 3:
                return somaData(data, - 2);
            case 4:
                return somaData(data, - 3);
            case 5:
                return somaData(data, - 4);
            case 6:
                return somaData(data, - 5);
            default:
                return somaData(data, - 6);
        }

    }

    public static Date somaData(Date data, int valorASomar) {

        Calendar c = Calendar.getInstance();
        c.setTime(data);
        c.add(Calendar.DATE, +(valorASomar));

        return c.getTime();

    }

    public static Date getDate(String data) {

        try {
            java.text.SimpleDateFormat sdf
                    = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            return sdf.parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    public static Date getDateYMD(String data) {

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Date date = sdf.parse(data);

            Calendar c = Calendar.getInstance();
            c.setTime(date);

            return c.getTime();
        } catch (ParseException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    public static Date formataDataDMA(String dataT) {

        if (dataT.replace("/", "").trim().equals("")) {
            return null;
        }

        String[] data = dataT.split("/");
        int ano = Integer.parseInt(data[2]) - 1900;
        int mes = Integer.parseInt(data[1]) - 1;
        int dia = Integer.parseInt(data[0]);
        java.sql.Date newDate = new java.sql.Date(ano, mes, dia);

        return newDate;
    }

    public static Date formataDataBancoToDate(String yyyymmaahhmmss) {

        try {
            Date data;

            data = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(yyyymmaahhmmss);

            return data;
        } catch (ParseException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public static String formataDataBancoToDMA(String yyyymmaahhmmss) {

        try {

            String dt = yyyymmaahhmmss;

            String[] aDt = dt.split(" ");

            dt = Util.ajustaDataDMA(aDt[0]);

            return dt;

        } catch (Exception e) {

            return "";

        }

    }

    public static String formataDataBancoToDMAHH(String yyyymmaahhmmss) {

        try {

            String dt = yyyymmaahhmmss;

            String[] aDt = dt.split(" ");

            dt = Util.ajustaDataDMA(aDt[0]) + " " + aDt[1];

            return dt;

        } catch (Exception e) {

            return "";

        }

    }

    public static String ajustaDataDMA(String data) {
        String dataFormatada = null;
        try {
            java.util.Date dataAMD = new SimpleDateFormat("yyyy-MM-dd").parse(data);
            dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(dataAMD);
        } catch (Exception e) {
            System.err.println(e);
        }
        return (dataFormatada);
    }

    public static boolean validarDataDMA(int d, int m, int a) {
        boolean correto = true;
        try {
            int[] dias = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            if (m < 1 || m > 12) {
                correto = false;
            } else if (a < 1500 || a > 2500) {
                correto = false;
            } else {
                // valida o dia
                if (a % 4 == 0 && (a % 100 != 0 || a % 400 == 0)) {
                    dias[1] = 29;
                }
                if (d < 1 || d > dias[m - 1]) {
                    correto = false;
                }
            }

        } catch (Exception e) {
            System.out.println(e);
            correto = false;
        }
        return correto;
    }

    public static boolean validaHorario(String horario) {

        boolean retorno = false;
        String[] h = {};

        try {

            h = horario.split(":");

        } catch (Exception e) {
            System.err.println("Erro ao executar o SPLIT!!!!");
            System.err.println(e);

        }

        if (h.length == 3) {

            if ((Integer.parseInt(h[0]) >= 0 && Integer.parseInt(h[0]) <= 23)
                    && (Integer.parseInt(h[1]) >= 0 && Integer.parseInt(h[1]) <= 59)
                    && (Integer.parseInt(h[2]) >= 0 && Integer.parseInt(h[2]) <= 50)) {

                retorno = true;

            } else {
                System.err.println("Valores acima do permitido");
            }
        } else {
            System.err.println("Não possuí estrutura correta");
        }

        return retorno;

    }

    public static boolean verificaNumeroInt(String s) {

        char[] c = s.toCharArray();
        boolean d = true;
        for (int i = 0; i < c.length; i++) // verifica se o char não é um dígito
        {
            if (!Character.isDigit(c[i])) {
                d = false;
                break;
            }
        }
        return d;
    }

    public static boolean isNumber(String string) {

        string = string.replaceAll("[,.]", "");
        char[] c = string.toCharArray();
        boolean result = true;
        for (int i = 0; i < c.length; i++) { // verifica se o char não é um dígito

            if (!Character.isDigit(c[i])) {
                result = false;
                break;
            }

        }

        return result;
    }

    public static boolean validarDataFormatada(String dataComFormato) {
        try {
            String[] data = dataComFormato.split("/");
            return (validarDataDMA(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])));
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

    public static String returnData() {
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date = new java.util.Date();
        calendar.setTime(date);

        return "" + out.format(calendar.getTime());
    }

    public static String returnDataBD() {
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat out = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = new java.util.Date();
        calendar.setTime(date);

        return "" + out.format(calendar.getTime());
    }

    public static String returnTime() {

        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat out = new SimpleDateFormat("HH:mm:ss");
        java.util.Date date = new java.util.Date();
        calendar.setTime(date);

        return "" + out.format(calendar.getTime());

    }

    public static Date returnDate() {
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date = new java.util.Date();
        calendar.setTime(date);

        return calendar.getTime();
    }

    public static int returnDayOfWeek(Date data) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(data);

        return cal.get(Calendar.DAY_OF_WEEK);

    }

    public static String formataPlaca(String placa) {

        String p[] = placa.split("");

        placa = "";
        for (int i = 0; i < p.length; i++) {
            placa += p[i];
            if (i == 2) {
                placa += "-";
            }
        }

        return placa;
    }

    public static String formataCPF(String cpf) {

        if (cpf.length() == 11) {

            cpf = cpf.substring(0, 3) + "."
                    + cpf.substring(3, 6) + "."
                    + cpf.substring(6, 9) + "-"
                    + cpf.substring(9, 11);

        }

        return cpf;
    }

    public static String desformataCPF(String cpf) {

        if (cpf.length() == 14) {

            cpf = cpf.replace(".", "");
            cpf = cpf.replace("-", "");

        }

        return cpf;
    }

    public static boolean validaValor(String valor) {

        try {

            double valorDouble = Double.parseDouble(valor.replace(",", "."));

        } catch (Exception e) {

            System.out.println("Não conseguiu transformar");

            return false;

        }

        return true;
    }

    public static double duracaoParaSegundos(String duracao) {

        double segundos = 0;
        String aTempo[] = duracao.split(":");

        for (int i = 0; i < aTempo.length; i++) {

            if (i == 0 && aTempo.length == 3) {
                double horaParaSegundos = Double.parseDouble(aTempo[0]) * 60 * 60;
                segundos += horaParaSegundos;
            } else if (i == aTempo.length - 2) {
                double minutoParaSegundos = Double.parseDouble(aTempo[aTempo.length - 2]) * 60;
                segundos += minutoParaSegundos;
            } else if (i == aTempo.length - 1) {
                double segundosParaSegundos = Double.parseDouble(aTempo[aTempo.length - 1]);
                segundos += segundosParaSegundos;
            }

        }

        return segundos;

    }

    public static String segundosParaDuracao(double segundos) {

        String duracao = "";
        int hora = 0;
        int minuto = 0;
        int segundo = 0;

        for (int i = 0; i < (int) segundos; i++) {

            segundo++;

            if (segundo == 60) {
                minuto++;
                segundo = 0;
            }

            if (minuto == 60) {
                hora++;
                minuto = 0;
            }

        }

        if ((hora + "").length() == 1) {
            duracao += "0" + hora + ":";
        } else {
            duracao += hora + ":";
        }

        if ((minuto + "").length() == 1) {
            duracao += "0" + minuto + ":";
        } else {
            duracao += minuto + ":";
        }

        if ((segundo + "").length() == 1) {
            duracao += "0" + segundo;
        } else {
            duracao += segundo;
        }

        return duracao;
    }

    public static boolean validaHorarios(String hr1, String hr2, String hr3, String hr4) {

        boolean result = true;

        double iniJorSec = duracaoParaSegundos(hr1);
        double iniIntSec = duracaoParaSegundos(hr2);
        double fimIntSec = duracaoParaSegundos(hr3);
        double fimJorSec = duracaoParaSegundos(hr4);

        if (iniJorSec < iniIntSec
                && iniJorSec < fimIntSec
                && iniJorSec < fimJorSec) {

            if (iniIntSec < fimIntSec
                    && iniIntSec < fimJorSec) {

                if (fimIntSec < fimJorSec) {

                    return true;

                } else {

                    return false;

                }

            } else {

                return false;

            }

        } else {

            return false;

        }

    }

    public static boolean validaHorarios(String hr1, String hr2) {

        double iniJorSec = duracaoParaSegundos(hr1);
        double fimJorSec = duracaoParaSegundos(hr2);

        if (iniJorSec < fimJorSec) {
            return true;
        } else {
            return false;
        }

    }

    public static String returnHora(String yyyymmddhhmmss) {

        try {

            String dt = yyyymmddhhmmss;

            String[] aDt = dt.split(" ");

            aDt[1] = aDt[1].substring(0, 8);

            return aDt[1];

        } catch (Exception e) {

            return "";

        }

    }

    public static String diferencaPeriodoToTime(String dataIni, String horaIni, String dataFim, String horaFim) {

        SimpleDateFormat fPeriodoIni = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        SimpleDateFormat fPeriodoFim = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        Date periodoIni = new Date();
        Date periodoFim = new Date();

        try {
            periodoIni = fPeriodoIni.parse(dataIni + " " + horaIni);
            periodoFim = fPeriodoFim.parse(dataFim + " " + horaFim);

        } catch (ParseException p) {
            System.out.println(p.getMessage());
        }

        long difMilli = periodoIni.getTime() - periodoFim.getTime();
        int timeInSeconds = (int) difMilli / 1000;
        int hours, minutes, seconds;
        String tempo = "";

        hours = timeInSeconds / 3600;
        timeInSeconds = timeInSeconds - (hours * 3600);
        minutes = timeInSeconds / 60;
        timeInSeconds = timeInSeconds - (minutes * 60);
        seconds = timeInSeconds;

        if (hours < 0) {
            hours = hours * -1;
        }

        if (minutes < 0) {
            minutes = minutes * -1;
        }

        if (seconds < 0) {
            seconds = seconds * -1;
        }

        System.out.println(hours);

        if ((hours + "").length() == 1) {

            tempo = "0" + hours + ":";

        } else if ((hours + "").length() == 2) {

            tempo = hours + ":";

        }

        if ((minutes + "").length() == 1) {

            tempo = tempo + "0" + minutes + ":";

        } else if ((minutes + "").length() == 2) {

            tempo = tempo + minutes + ":";

        }

        if ((seconds + "").length() == 1) {

            tempo = tempo + "0" + seconds;

        } else if ((seconds + "").length() == 2) {

            tempo = tempo + seconds;

        }

        return tempo;

    }

    public static String diferencaPeriodoToTime(String dataIni, String dataFim) {

        SimpleDateFormat fPeriodoIni = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        SimpleDateFormat fPeriodoFim = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        Date periodoIni = new Date();
        Date periodoFim = new Date();

        try {
            periodoIni = fPeriodoIni.parse(dataIni);
            periodoFim = fPeriodoFim.parse(dataFim);

        } catch (ParseException p) {
            System.out.println(p.getMessage());
        }

        long difMilli = periodoIni.getTime() - periodoFim.getTime();
        int timeInSeconds = (int) difMilli / 1000;
        int hours, minutes, seconds;
        String tempo = "";

        hours = timeInSeconds / 3600;
        timeInSeconds = timeInSeconds - (hours * 3600);
        minutes = timeInSeconds / 60;
        timeInSeconds = timeInSeconds - (minutes * 60);
        seconds = timeInSeconds;

        if (hours < 0) {
            hours = hours * -1;
        }

        if (minutes < 0) {
            minutes = minutes * -1;
        }

        if (seconds < 0) {
            seconds = seconds * -1;
        }

        if ((hours + "").length() == 1) {

            tempo = "0" + hours + ":";

        } else if ((hours + "").length() == 2) {

            tempo = hours + ":";

        }

        if ((minutes + "").length() == 1) {

            tempo = tempo + "0" + minutes + ":";

        } else if ((minutes + "").length() == 2) {

            tempo = tempo + minutes + ":";

        }

        if ((seconds + "").length() == 1) {

            tempo = tempo + "0" + seconds;

        } else if ((seconds + "").length() == 2) {

            tempo = tempo + seconds;

        }

        return tempo;

    }

    public static String diferencaTimeToTime(String horaIni, String horaFim) {

        String dataIni = "01-01-2012";
        String dataFim = "01-01-2012";

        SimpleDateFormat fPeriodoIni = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        SimpleDateFormat fPeriodoFim = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        Date periodoIni = new Date();
        Date periodoFim = new Date();

        try {
            periodoIni = fPeriodoIni.parse(dataIni + " " + horaIni);
            periodoFim = fPeriodoFim.parse(dataFim + " " + horaFim);

        } catch (ParseException p) {
            System.out.println(p.getMessage());
        }

        long difMilli = periodoIni.getTime() - periodoFim.getTime();
        int timeInSeconds = (int) difMilli / 1000;
        int hours, minutes, seconds;
        String tempo = "";

        hours = timeInSeconds / 3600;
        timeInSeconds = timeInSeconds - (hours * 3600);
        minutes = timeInSeconds / 60;
        timeInSeconds = timeInSeconds - (minutes * 60);
        seconds = timeInSeconds;

        if (hours < 0) {
            hours = hours * -1;
        }

        if (minutes < 0) {
            minutes = minutes * -1;
        }

        if (seconds < 0) {
            seconds = seconds * -1;
        }

        if ((hours + "").length() == 1) {

            tempo = "0" + hours + ":";

        } else if ((hours + "").length() == 2) {

            tempo = hours + ":";

        }

        if ((minutes + "").length() == 1) {

            tempo = tempo + "0" + minutes + ":";

        } else if ((minutes + "").length() == 2) {

            tempo = tempo + minutes + ":";

        }

        if ((seconds + "").length() == 1) {

            tempo = tempo + "0" + seconds;

        } else if ((seconds + "").length() == 2) {

            tempo = tempo + seconds;

        }

        return tempo;

    }

    public static String multiplicaDuracao(String horaIni, double xVezes) {

        String tempo = "";

        String parserTime[] = horaIni.split(":");

        int hours = Integer.parseInt(parserTime[0]);
        int minutes = Integer.parseInt(parserTime[1]);
        Double seconds = Double.parseDouble(parserTime[2]);

        seconds += (hours * 60) * 60;
        seconds += minutes * 60;

        seconds = seconds * xVezes;

        hours = seconds.intValue() / 3600;
        seconds = seconds - (hours * 3600);
        minutes = seconds.intValue() / 60;
        seconds = seconds - (minutes * 60);
        seconds = seconds;

        if ((hours + "").length() == 1) {
            tempo = "0" + hours + ":";
        } else if ((hours + "").length() == 2) {
            tempo = hours + ":";
        }

        if ((minutes + "").length() == 1) {
            tempo = tempo + "0" + minutes + ":";
        } else if ((minutes + "").length() == 2) {
            tempo = tempo + minutes + ":";
        }

        if ((seconds.intValue() + "").length() == 1) {
            tempo = tempo + "0" + seconds.intValue();
        } else if ((seconds.intValue() + "").length() == 2) {
            tempo = tempo + seconds.intValue();
        }

        return tempo;

    }

    public static String returnIdFromIdDesc(String idDesc) {

        String id = "";

        if (idDesc.contains("-")) {

            String[] parse = idDesc.split("-");

            id = parse[0].trim();

        }

        return id;

    }

    public static ArrayList<String> CSVToArray(String values) {

        ArrayList<String> array = new ArrayList();
        String[] split = values.split(";");

        for (int i = 0; i < split.length; i++) {

            array.add(split[i]);

        }

        return array;

    }

    public static String arrayToCSV(ArrayList<String> array) {

        String values = "";

        for (int i = 0; i < array.size(); i++) {

            if (array.size() == i + 1) {
                values += array.get(i);
            } else {
                values += array.get(i) + ";";
            }

        }

        return values;

    }

    public static HashMap<String, String> CSVToHash(String values) {

        HashMap<String, String> hash = new HashMap();
        String[] split = values.split(";");

        for (int i = 0; i < split.length; i++) {

            hash.put(split[i], split[i]);
            //System.out.println(split[i]);
        }

        return hash;

    }    

    /**
     * Método criado para verificar se existe uma palavra dentro de uma cadeia
     * de caracteres separados por "|"
     *
     * @param value - Valor a ser Procurado
     * @param matrix - Cadeia de caracteres separados por "|"
     * @return retorno - Retorna se existe a palavra na cadeia ou não
     */
    public static boolean containsValue(String value, String matrix) {

        boolean retorno = false;

        String[] split = matrix.split(";");

        for (int i = 0; i < split.length; i++) {
            if (split[i].equals(value)) {
                return true;
            }
        }

        return retorno;

    }

    public static String[] addTopSQL(String[] campos, int top) {

        String[] campos2 = campos;

        for (int i = 0; i < campos.length; i++) {

            if (i == 0) {

                campos2[i] = "TOP " + top + " " + campos[i] + " AS fieldTop";

            }
            break;
        }

        return campos2;

    }

    public static String formataDataToDate(String yyyymmaahhmmss, String formatIn, String formatOut) {

        try {
            Date data;
            String dataF;
            
            data = new SimpleDateFormat(formatIn).parse(yyyymmaahhmmss);

            SimpleDateFormat sdf = new SimpleDateFormat(formatOut);

            dataF = sdf.format(data);

            return dataF;
        } catch (ParseException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }

    }

}
