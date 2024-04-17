/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestion;

import com.mycompany.sistemagestion.forms.Formulario3;

/*import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;*/

/**
 *
 * @author MAICOL
 */
public class Main {
    public static void main (String[] agrs) {
         Formulario3 ventana = new Formulario3();
         ventana.show();
    }
    /*
     private static Integer cargarNumero () throws IOException{
        // codigo para cargar numeros desde la consola para realixar pruebas
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        
        String strNum = reader.readLine();
        Integer num = Integer.valueOf(strNum);
        
        return num;        
    }
    */
     
    /*public static void main (String[] agrs) throws IOException {
    //programa para saber si un numero es primo o no
        String resultado = "";
       
        int contador = 0;
        int numero = 1; 
        while (contador < 100) {
            if (esPrimo(numero)) {
                resultado += numero + ", ";
                contador++;

            }
            numero++;
        }
        System.out.println("Los primeros 100 numeros primos son: " + resultado);
    } 
    
    private static Boolean esPrimo(Integer numero) {
        Boolean esUnNumeroPrimo = true;
        
        for (int i = 2; i < numero; i++) {
            
            if (numero % i == 0) {
                esUnNumeroPrimo = false;
            }
        }
        return esUnNumeroPrimo;
    }*/
}
