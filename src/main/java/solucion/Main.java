package solucion;

import java.util.Scanner;

public class Main {
    // https://www.aceptaelreto.com/problem/submission.php?id=565095
    public static void main(String[] args) {
        ConstanteKaprekar constanteKaprekar = new ConstanteKaprekar();
        Scanner entrada = new Scanner(System.in);
        int cantidad = entrada.nextInt();
        for (int i = 0; i < cantidad; i++) {
            System.out.println(constanteKaprekar.comprobarNumero(entrada.nextInt()));
        }

    }

}
