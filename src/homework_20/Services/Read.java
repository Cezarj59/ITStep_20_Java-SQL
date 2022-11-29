package homework_20.Services;

import java.util.Scanner;

public class Read {

    public static String texto() {
        Scanner read = new Scanner(System.in);

        return read.nextLine();
    }

    public static double numDouble() {

        double valor = 0;
        boolean acertou = false;
        
        while (!acertou) {

            try {
                Scanner read = new Scanner(System.in);
                valor = read.nextDouble();
                acertou = true;
            } catch (Exception e) {
                System.err.println("\nVocê digitou algo errado, digite um numero valido!!!\nTente novamente!!!\n");
                System.out.print("Preço:");
            }
        }

        return valor;
    }
}
