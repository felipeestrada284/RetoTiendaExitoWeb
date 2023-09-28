package com.exito.utils;


public class Limpiar {

    String Texto;

    public Limpiar(String texto) {
            Texto = texto;
    }
    public static String numero(String Texto) {
        String[] arreglo = Texto.split("\\$");
        String l = arreglo[1];
        String k = l.replaceAll(" ", "");
        String f = k.replaceAll("\\.", "");
        System.out.println(f);

        return f;
    }
    public static String LimpiarNumeroDecimal(String Texto) {
        String arreglar = Texto.replaceAll("\\.","");

        return arreglar.substring(0,arreglar.length()-1);
    }

}







