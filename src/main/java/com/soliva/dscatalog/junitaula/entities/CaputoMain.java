package com.soliva.dscatalog.junitaula.entities;


public class CaputoMain {

    public static String format(double x) {
        return String.format("%.2f", x);
    }

    public static void main(String[] args) {
          Double test = 12.00;

//        String test1 = test.toString();

//        var test2 = test1.replaceAll("\\D+", "");

        String resultado = format(test);

        String atual = resultado.replaceAll("\\D+", "");

        System.out.println(atual);
    }
}
