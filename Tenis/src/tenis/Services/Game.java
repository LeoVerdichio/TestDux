/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tenis.Services;

import java.util.List;
import java.util.Random;

public class Game {

    public static boolean jugarJuego(String j1, String j2) {

        Random rnd = new Random();
        int marcadorJug1 = 0;
        int marcadorJug2 = 0;
        int count = 0;
        String puntosJug1 = "0";
        String puntosJug2 = "0";
        boolean ganador = true;
        boolean finJuego = false;
        //System.out.println(j1+" "+j2+" ");
        while (finJuego != true) {
            count += +1;
            int randomGolpe = rnd.nextInt(2);
            String marcadorPuntos = "";
            if (randomGolpe == 0) {
                System.out.println(j1 + " ganador del punto");
            } else {
                System.out.println(j2 + " ganador del punto");
            }
            if (randomGolpe == 0 && count == 1) {
                System.out.println(j1 + " Tiene el saque");
            }

            if (randomGolpe == 0) {
                marcadorJug1 = marcadorJug1 + 1;

                if ((marcadorJug1 > 3) && (Math.abs(marcadorJug1 - marcadorJug2) > 1)) {
                    System.out.println();
                    System.out.println(j1 + " gana el juego");
                    System.out.println();
                    marcadorJug1 = 0;
                    marcadorJug2 = 0;
                    ganador = true;
                    finJuego = true;
                }
            }

            if (randomGolpe == 1 && count == 1) {
                System.out.println(j2 + " Tiene el saque");
            }
            if (randomGolpe == 1) {
                marcadorJug2 = marcadorJug2 + 1;

                if ((marcadorJug2 > 3) && (Math.abs(marcadorJug2 - marcadorJug1) > 1)) {
                    System.out.println();
                    System.out.println(j2 + " gana el juego");
                    System.out.println();
                    marcadorJug1 = 0;
                    marcadorJug2 = 0;
                    ganador = false;
                    finJuego = true;
                }
            }

            if (marcadorJug1 == 1) {
                puntosJug1 = "15";
                marcadorPuntos = puntosJug1 + " - " + puntosJug2;
            }
            if (marcadorJug1 == 2) {
                puntosJug1 = "30";
                marcadorPuntos = puntosJug1 + " - " + puntosJug2;
            }
            if (marcadorJug1 == 3) {
                puntosJug1 = "40";
                marcadorPuntos = puntosJug1 + " - " + puntosJug2;

            }

            if (marcadorJug2 == 1) {

                puntosJug2 = "15";
                marcadorPuntos = puntosJug1 + " - " + puntosJug2;
            }
            if (marcadorJug2 == 2) {
                puntosJug2 = "30";
                marcadorPuntos = puntosJug1 + " - " + puntosJug2;
            }
            if (marcadorJug2 == 3) {
                puntosJug2 = "40";
                marcadorPuntos = puntosJug1 + " - " + puntosJug2;
            }
            if (marcadorJug1 > 3 && marcadorJug2 > 3 && marcadorJug1 == marcadorJug2) {
                marcadorPuntos = " Deuce";
            }
            if (marcadorJug1 > 3 && marcadorJug1 > marcadorJug2) {
                puntosJug1 = "";
                puntosJug2 = "";
                marcadorPuntos = " Ventaja " + j1;
            }
            if (marcadorJug2 > 3 && marcadorJug2 > marcadorJug1) {
                puntosJug1 = "";
                puntosJug2 = "";
                marcadorPuntos = " Ventaja " + j2;
            }

            System.out.println(marcadorPuntos);

        }
        return ganador;
    }

    public static void jugarSet(float sets, String j1, String j2, List<Integer> lista1, List<Integer> lista2, String torneo) {

        int juegosJug1 = 0;
        int juegosJug2 = 0;
        int setJug1 = 0;
        int setJug2 = 0;
        float set1 = (sets / 2);
        double set = set1 + 0.5;
        int countset = 0;
        boolean finPartido = false;
String leo;
        while (!finPartido) {
            boolean resultadoJuego = jugarJuego(j1, j2);
            //countset+=+1;
            if (resultadoJuego) {
                juegosJug1 = juegosJug1 + 1;
            } else {
                juegosJug2 = juegosJug2 + 1;
            }

            if (juegosJug1 == 6 && juegosJug2 == 6) {
                System.out.println(" Tie Break");
            }

            if (juegosJug1 >= 6 && (Math.abs(juegosJug1 - juegosJug2) > 1) || juegosJug1 == 7 && juegosJug2 == 6) {
                setJug1 = setJug1 + 1;
                System.out.println(j1 + " Gana el set por " + juegosJug1 + " a " + juegosJug2);
                System.out.println("");
                if(setJug1>setJug2){
                System.out.println("Resultado parcial del partido: "+j1+" Gana por "+setJug1+ " sets a " + setJug2);
                }else if(setJug1==setJug2){
                     System.out.println("Resultado parcial del partido: EMPATADOS " + setJug1+ "sets a " + setJug2);
                }else{
                     System.out.println("Resultado parcial del partido:" +j2+" Gana por " + setJug2+ " sets a " + setJug1);
                }
                lista1.add(juegosJug1);
                lista2.add(juegosJug2);
                countset++;
                juegosJug1 = 0;
                juegosJug2 = 0;
                if (setJug1 + setJug2 == sets && setJug1 > setJug2) {
                    System.out.println("!!!!"+j1 + " GANA EL PARTIDO POR " + setJug1 + " SETS A " + setJug2+"!!!!");
                    System.out.println("");

                    finPartido = true;
                }
                if (countset == sets) {
                    finPartido = true;
                    System.out.println("Resultado en grafico");
                    System.out.println("");

                }

            }
            if (juegosJug2 >= 6 && (Math.abs(juegosJug2 - juegosJug1) > 1) || juegosJug2 == 7 && juegosJug1 == 6) {
                setJug2 = setJug2 + 1;
                System.out.println(j2 + " Gana el set por " + juegosJug2 + " a " + juegosJug1);
                System.out.println("");
                if(setJug2>setJug1){
                System.out.println("Resultado parcial del partido: "+j2+" Gana por "+setJug2+ " sets a " + setJug1);
                }else if(setJug2==setJug1){
                    System.out.println("Resultado parcial del partido: EMPATADOS" + setJug2+ "sets a " + setJug1);
                }else{
                 System.out.println("Resultado parcial del partido:" + j1 +" Gana por " + setJug1+ " sets a " + setJug2);
                }
                countset++;
                lista2.add(juegosJug2);
                lista1.add(juegosJug1);
                juegosJug1 = 0;
                juegosJug2 = 0;
                if (setJug1 + setJug2 == sets && setJug2 > setJug1) {
                    System.out.println("!!!!"+j2 + " GANA EL PARTIDO POR " + setJug2 + " SETS A " + setJug1+"!!!!!");
                    System.out.println("");

                    finPartido = true;
                }
                if (countset == sets) {
                    finPartido = true;
                    System.out.println("Resultado en grafico");
                    System.out.println("");

                }

            }
        }
        System.out.println("----------------RESULTADO FINAL DE " + torneo + " -----------------------");
        System.out.print(Character.toUpperCase(j1.charAt(0)) + " ");
        for (Integer integer1 : lista1) {
            System.out.print(integer1 + " ");

        }
        System.out.println("");
        System.out.print(Character.toUpperCase(j2.charAt(0)) + " ");
        for (Integer integer2 : lista2) {
            System.out.print(integer2 + " ");
        }
        System.out.println("");
    }

}
