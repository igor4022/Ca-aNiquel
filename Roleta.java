import java.util.Random;
import java.util.Scanner;

public class Roleta extends Saldo{
    String[] simbulos = {"@","#","$","%","&"};
    String[] cores = {
    "\u001B[37m",
    "\u001B[33m",
    "\u001B[32m",
    "\u001B[34m",
    "\u001B[36m"
};
    String[] sorteio = new String[3];
    Random random = new Random();
    int numero = 3;
    int resposta;

    Scanner scanner = new Scanner(System.in);

    public void apostar() {

        do {
            System.out.println("\u001B[37m******************************");
            System.out.println("Simbulos: @, #, $, %, &");
            System.out.println("Você pode apostar a quantia que estiver disposto");
            System.out.println("Seu saldo é de: " + cores[2] + saldo + cores[0]);
            boolean entrada = false;
            boolean saida = false;

            while (!entrada) {
                try {
                    System.out.print("Apostar:");
                    aposta = scanner.nextDouble();
                    System.out.println();
                    entrada = true;
                    
                } catch (Exception e) {
                    System.out.println("******************************");
                    System.out.println("Erro, resposta invalida");
                    System.out.println("******************************");
                    scanner.nextLine();
                }
            }
            

            if(aposta < 0 || aposta > saldo || aposta == 0) {
                System.out.println("Erro, aposta invalida");
            } else {
                for(int rodada=0; rodada < 20; rodada++) {
                    String simbolo1 = simbulos[random.nextInt(simbulos.length)];
                    String simbolo2 = simbulos[random.nextInt(simbulos.length)];
                    String simbolo3 = simbulos[random.nextInt(simbulos.length)];

                    
                    System.out.println(simbolo1 + "\u001B[37m | " + simbolo2 + "\u001B[37m | " + simbolo3);
                    try {
                        Thread.sleep(100);
                    } catch(InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                for(int i=0; i < 3; i++) {
                    int aleatorio = (int) (Math.random() * simbulos.length);
                    sorteio[i] = simbulos[aleatorio];
                    System.out.print(cores[aleatorio] + simbulos[aleatorio] + "\u001B[37m | ");
                }

                if(sorteio[0].equals(sorteio[1]) && sorteio[1].equals(sorteio[2])) {
                    double multiplicador = 0;

                    System.out.println();
                    System.out.println("\u001B[33m!!!Parabéns você ganhou!!!");
                    
                    switch (sorteio[0]) {
                        case "@":
                            multiplicador += 2;
                            break;
                        case "#":
                            multiplicador += 3;
                            break;
                        case "%":
                            multiplicador += 5;
                            break;
                        case "&":
                            multiplicador += 7;
                            break;
                        case "$":
                            multiplicador += 10;
                            break;
                        default:
                            break;
                    }

                    double premio = aposta * multiplicador;
                    saldo += premio;
                    System.out.println("\u001B[37mSeu saldo agora é de " + cores[2] + saldo + cores[0]);

                } else {
                    saldo -= aposta;
                    System.out.println("\u001B[37mSeu saldo agora é de " + cores[2] + saldo + cores[0]);
                }

            }

            while (!saida) {
                try {
                    System.out.print("Se deseja sair dijite 1: ");
                    resposta = scanner.nextInt();

                    saida = true;
                } catch (Exception e) {
                    System.out.println("******************************");
                    System.out.println("Erro, resposta invalida");
                    System.out.println("******************************");
                    scanner.nextLine();
                }
            }
            
        } while(resposta != 1);
    }

    public void sair() {
        System.out.println("******************************");
        System.out.println("Saindo do programa...");
        scanner.close();
    }
}
