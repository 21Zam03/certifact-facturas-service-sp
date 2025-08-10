package com.certicom.certifact_facturas_service_sp.util;

import com.certicom.certifact_facturas_service_sp.exceptions.ExcepcionInterno;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UtilDate {

    public static Date getDateWithoutTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }


    public static Date setTimeToDate(Date fecha, int h, int m, int s){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.set(Calendar.HOUR, h);
        calendar.set(Calendar.MINUTE, m);
        calendar.set(Calendar.SECOND, s);
        return calendar.getTime();
    }

    public static Date stringToDate(String sDate1, String format) {
        try {
            Date date1 = new SimpleDateFormat(format).parse(sDate1);
            return date1;
        } catch (ParseException e) {
            throw new ExcepcionInterno("Error en formato de fecha " + sDate1);
        }
    }

    public static Date sumarDiasAFecha(Date fecha, int dias) {
        if (dias == 0) return fecha;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_YEAR, dias);
        return calendar.getTime();
    }

    public static String dateNowToString(String format) {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat(format);
        String strDate = dateFormat.format(date);
        return strDate;
    }


    public static String dateToString(Date fecha, String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        String strDate = dateFormat.format(fecha);
        return strDate;
    }

}
