package Ahorcado;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {
        char letras;
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
                        System.out.println("Perdiste :((");
                        juegoTerminado = true;
                    }
                }
                else {
                    boolean juegoGanado = !hayGuiones(palabraGuiones);
                    if (juegoGanado) {
                        System.out.println("Ganaste UwU");
                        juegoTerminado = true;
                    };
                }
            }while (!juegoTerminado);

            lector.close();
            System.out.println("Programa realizdo por Rivas Gutierrez Leonardo 3Iv8");
            System.out.println("Si deseas volver a intentar, entonces introduce s");

            Scanner entrada = new Scanner(System.in);

            letras = entrada.next().charAt(0);
        }while (letras == 's');

    }

        static String getpalabraSecreta(){
            String[]palabras = {"relampago", "sapo", "gato", "dragon", "spider", "pokemon", "tortuga", "libro", "program", "java"};  //PALABRA A ELEGIR
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