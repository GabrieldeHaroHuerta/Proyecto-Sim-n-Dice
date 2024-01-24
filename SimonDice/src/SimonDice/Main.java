package SimonDice;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
  //Los controles que producen que el jugador pueda poner su nombre
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce tu nombre:");
        String nombreJugador = scanner.nextLine();
        SimonDice simonDice = new SimonDice(nombreJugador);
        simonDice.play();
    }
}