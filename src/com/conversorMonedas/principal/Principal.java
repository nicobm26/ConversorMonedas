package com.conversorMonedas.principal;

import com.conversorMonedas.modelos.Conversion;
import com.conversorMonedas.modelos.ConversionRecord;
import com.conversorMonedas.modelos.ConvertidorApi;
import com.conversorMonedas.modelos.Menu;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ConvertidorApi convertidorApi = new ConvertidorApi();
        ConversionRecord c = null;
        Conversion conversion = null;

        System.out.println("Ingrese el valor que desea convertir");
        int opcion = teclado.nextInt();

        while (opcion != 7){
            Menu.menu();
            opcion = teclado.nextInt();
            System.out.println("Ingrese el valor que desea convertir");
            float cantidad = teclado.nextFloat();
            switch (opcion) {
                case 1 -> {
                    c = convertidorApi.convertir("USD", "ARS", cantidad);
                    conversion = new Conversion(c, cantidad);
                    System.out.println(conversion);
                }
                case 2 -> {
                    c = convertidorApi.convertir("ARS", "USD", cantidad);
                    conversion = new Conversion(c, cantidad);
                    System.out.println(conversion);
                }
                case 3 -> {
                    c = convertidorApi.convertir("USD", "BRL", cantidad);
                    conversion = new Conversion(c, cantidad);
                    System.out.println(conversion);
                }
                case 4 -> {
                    c = convertidorApi.convertir("BRL", "USD", cantidad);
                    conversion = new Conversion(c, cantidad);
                    System.out.println(conversion);
                }
                case 5 -> {
                    c = convertidorApi.convertir("USD", "COP", cantidad);
                    conversion = new Conversion(c, cantidad);
                    System.out.println(conversion);
                }
                case 6 -> {
                    c = convertidorApi.convertir("COP", "USD", cantidad);
                    conversion = new Conversion(c, cantidad);
                    System.out.println(conversion);
                }
                case 7 -> System.out.println("Hasta Luego");
                default -> System.out.println("Opcion no valida");
            }
        }
    }
}
