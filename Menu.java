import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Roleta roleta = new Roleta();
        Scanner scanner = new Scanner(System.in);
        int resposta = 0;
        boolean saida = false;
        
        do {
            System.out.println( "\u001B[37m******************************");
            System.out.println("1- Jogar");
            System.out.println("2- Sair");
            System.out.println("******************************");

            while (!saida) {
                try {
                    System.out.print("Resposta: ");
                    resposta = scanner.nextInt();
                    saida = true;
                } catch (Exception e) {
                    System.out.println("******************************");
                    System.out.println("Erro, resposta invalida");
                    System.out.println("******************************");
                    scanner.nextLine();
                }
            }

            switch(resposta) {
                case 1:
                    roleta.apostar();
                    break;
                case 2:
                    roleta.sair();
                    break;
                default:
                    System.out.println("******************************");
                    System.out.println("Erro, resposta invalida");
                    System.out.println("******************************");
                    break;
            }
        } while(resposta != 2);

        System.out.println("******************************");
        System.out.println("Saindo do programa...");
        scanner.close();
    }
    
}