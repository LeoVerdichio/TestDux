package tenis;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static tenis.Services.Game.jugarSet;
import tenis.entity.Jugador;

public class Tenis {

    public static void main(String[] args) {
        int opcion=0;
        do {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        List<Integer> listaj1 = new ArrayList<>();
        List<Integer> listaj2 = new ArrayList<>();
        String torneo;
        
        float sets;
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el nombre del torneo");
        torneo = leer.next();
        System.out.println("Cantidad de sets");
        sets = leer.nextFloat();
        System.out.println("introduzca el nombre del jugador 1");
        jugador1.setName(leer.next());
        System.out.println("introduza el nombre del jugador 2");
        jugador2.setName(leer.next());
        String j1 = jugador1.getName().toUpperCase();
        String j2 = jugador2.getName().toUpperCase();           
            jugarSet(sets, j1, j2, listaj1, listaj2, torneo.toUpperCase());
            System.out.println("Quiere Jugar la revancha?");
            System.out.println("1.SI");
            System.out.println("2.NO");
            opcion=leer.nextInt();
        }while(opcion==1);
           
    }
}


