package Ahorcado;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {
        char salida;

        Scanner entrada = new Scanner(System.in);


        do {
            String palabraSecreta=getpalabraSecreta();
            char [] palabraGuiones = getGuionesFromPalabra(palabraSecreta);

            boolean juegoTerminado = false;
            Scanner lector = new Scanner(System.in);
            int intentos = 5;

            do {
                System.out.println("Tienes " +intentos+ " intentos");
                System.out.println(palabraGuiones);
                System.out.println("Introduce una letra");
                char letra = lector.next().charAt(0);
                boolean algunaLetraAcertada = false;

                for (int i = 0; i<palabraSecreta.length(); i++){
                    if (palabraSecreta.charAt(i) == letra){
                        palabraGuiones[i] = letra;
                        algunaLetraAcertada = true;
                    }
                }
                if (!algunaLetraAcertada){
                    System.out.println("Fallaste");
                    --intentos;
                    if (intentos==0) {
                        System.out.println("Gana el primer jugador");
                        juegoTerminado = true;
                    }
                }
                else {
                    boolean juegoGanado = !hayGuiones(palabraGuiones);
                    if (juegoGanado) {
                        System.out.println("Gana el segundo jugador");
                        juegoTerminado = true;
                    };
                }
            }while (!juegoTerminado);

            lector.close();

            System.out.println("Progrma realizado por 3IV8 Rivas Gutierrez Leonardo");
            System.out.println("¿Deseas volver a jugar?");
            salida = entrada.next().charAt(0);

        }while (salida == 's');
    }

        static String getpalabraSecreta(){
            String[]palabras = {"gato"};
            Random r = new Random();
            int n = r.nextInt(palabras.length);
            return palabras[n];
        }


        static char[]getGuionesFromPalabra(String palabra){

            int n_letras = palabra.length();

            char[] palabrasGuiones = new char[n_letras];

            for (int i = 0; i<palabrasGuiones.length; i++){
                palabrasGuiones[i] = '_';
            }
            return palabrasGuiones;
        }

        static boolean hayGuiones(char[] array){
            for (char l:array){
                if (l=='_')return true;
            }
            return false;
        }
}