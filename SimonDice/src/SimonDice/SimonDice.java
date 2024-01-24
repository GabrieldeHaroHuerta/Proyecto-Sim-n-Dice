package SimonDice;

import java.util.Random;
import java.util.Scanner;
//Colores que tiene el Simon dice
enum tColores {
    ROJO, VERDE, AZUL, MORADO
}

class SimonDice {
    private static final int MAX_COLORES_SEQ = 12;
    private tColores[] secuenciaColores = new tColores[MAX_COLORES_SEQ];
    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);
    private String nombreJugador;
//La constructora del SimonDice para el nombre del jugador
    public SimonDice(String nombreJugador) {
        this.nombreJugador = nombreJugador;
        for (int i = 0; i < MAX_COLORES_SEQ; i++) {
            secuenciaColores[i] = null;
        }
    }
//Los switch para que desarrolle la secuencia que el jugador tendra que adivinar
    public tColores charToColor(char _color) {
        switch (_color) {
            case 'R':
                return tColores.ROJO;
            case 'V':
                return tColores.VERDE;
            case 'A':
                return tColores.AZUL;
            case 'M':
                return tColores.MORADO;
            default:
                return null;
        }
    }
  //El switch para detecte los colores pone el jugador 
    public tColores intToColor(int _numero) {
        switch (_numero) {
            case 0:
                return tColores.ROJO;
            case 1:
                return tColores.VERDE;
            case 2:
                return tColores.AZUL;
            case 3:
                return tColores.MORADO;
            default:
                return null;
        }
    }
   // El comando para generar la secuencia y que vaya aumentando la secuencia
    public void generarSecuencia(int _numColores) {
        for (int i = 0; i < _numColores; i++) {
            secuenciaColores[i] = intToColor(random.nextInt(4));
        }
    }
  // El comando que comprueba los colores pone el jugador
    public boolean comprobarColor(int _index, tColores _color) {
        return secuenciaColores[_index] == _color;
    }
  // El comando para que muestra la secuencia que se ha generado en el comando generarSecuencia
    public void mostrarSecuencia(int _numero) {
        System.out.println("Secuencia " + _numero + ":");
        for (int i = 0; i < MAX_COLORES_SEQ; i++) {
            if (secuenciaColores[i] != null) {
                System.out.print(secuenciaColores[i] + " ");
            }
        }
        System.out.println();
    }
  // El comando que desarrolla en juego 
    public void play() {
        int numColores = 0;
        int numSecuencias = 0;
        boolean seguirJugando = true;
  // La presentacion del juego
        System.out.println("Bienvenido al juego del Simon Dice, " + this.nombreJugador + "!");
        System.out.println("El objetivo del juego es repetir la secuencia de colores entre ellos Rojo(R), Verde(V), Azul(A) y Morado(M) que te mostramos.");
        System.out.println("Pulsa enter 5 veces una vez hayas visto la secuencia y luego escribe la secuencia para comprobar si has acertado.");
        System.out.println("Tienes que repetir 12 secuencias para ganar el juego.");
        System.out.println();
  // Los comandos que controlan cuando muestran la secuencia y que el jugador al darle al enter pueda escribir la secuencia
        while (seguirJugando && numSecuencias < 12) {
            numColores = Math.min(numColores + 1, MAX_COLORES_SEQ);
            generarSecuencia(numColores);
            mostrarSecuencia(numSecuencias);
            System.out.println("Pulsa enter para continuar...");
            scanner.nextLine();
            scanner.nextLine();
            scanner.nextLine();
            scanner.nextLine();
            scanner.nextLine();
            System.out.println("Introduce la secuencia:");
            String entrada = scanner.nextLine();
            String[] colores = entrada.split(" ");
            boolean acierto = true;
            for (int i = 0; i < colores.length; i++) {
                tColores color = charToColor(colores[i].charAt(0));
                if (color == null || !comprobarColor(i, color)) {
                    acierto = false;
                    break;
                }
            }
  //Los controles que controlan si el jugador ha acertado o a fallado y el ultimo que le da la enhorabuna por ganar el juego
            if (acierto) {
                System.out.println("¡Has acertado!");
            } else {
                System.out.println("Lo siento, has fallado.");
                seguirJugando = false;
            }
            numSecuencias++;
            System.out.println();
        }
        if (numSecuencias == 12) {
            System.out.println("¡Enhorabuena, " + this.nombreJugador + "! Has ganado el juego.");
        }
    }
}

