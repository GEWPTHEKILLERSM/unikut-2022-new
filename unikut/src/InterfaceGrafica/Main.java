package InterfaceGrafica;
import Logica.Conta;
import Logica.Contas;

import java.util.Locale;
import java.util.Scanner;

import static java.lang.Character.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Contas contas = new Contas();
        char op,op2;
        Conta c;

        System.out.println("Starting...");

        do {
            menu();
            op = input.next().charAt(0);
            while(!isDigit(op)){
                op = input.next().charAt(0);
            }
            switch(op){
                case '1':
                    System.out.println("Criar conta como convidado?");
                    System.out.println("S/N");
                    op2 = input.next().toLowerCase(Locale.ROOT).charAt(0);
                    while(op2 != 's' && op2 != 'n'){
                        System.out.println("Opção inválida!");
                        System.out.println("Criar conta como convidado?");
                        System.out.println("S/N");
                        op2 = input.next().toLowerCase(Locale.ROOT).charAt(0);
                    }
                    input.nextLine();

                    if(op2 == 's'){
                        c = criaConta(true);
                    }else{
                        c = criaConta(false);
                    }

                    System.out.println("Criando conta...");

                    contas.newAccount(c);
                    break;
                case '2':
                    System.out.println("O login será aqui!");
                    break;
                case '3':
                    System.out.println("Exibindo contas...");
                    contas.exibirContas();
                    break;
                case '4':
                    recuperarSenha(contas);
                    break;
                default:
                    break;
            }
        } while (op != '0');
    }
    public static void menu() {
        System.out.println("1 - Criar conta");
        System.out.println("2 - Login");
        System.out.println("3 - Login (Exibir contas temporario)");
        System.out.println("4 - Recuperar senha");
        System.out.println("5 - Sair");
    }

    public static Conta criaConta(Boolean op){
        Scanner input = new Scanner(System.in);
        String nome, login, senha;
        Conta c;

        System.out.println("/Interface de criação de conta/");
        if(op) {
            System.out.println("Convidado.");

            System.out.println("Insira o Login");
            login = input.nextLine();

            System.out.println("Insira a Senha");
            senha = input.nextLine();

            c = new Conta(login, senha);
        }else{

            System.out.println("Insira o nome");
            nome = input.nextLine();

            System.out.println("Insira o Login");
            login = input.nextLine();

            System.out.println("Insira a Senha");
            senha = input.nextLine();

            c = new Conta(login, nome, senha);
        }
        return c;
    }

    public static void recuperarSenha(Contas contas){
        Scanner input  = new Scanner(System.in);
        String login;
        int codigo;
        System.out.println("/Interface de recuperação de conta/");
        System.out.println("Digite o login: ");
        login = input.nextLine();
        Conta c = contas.login(login);
        if(c != null){
            System.out.println("Digite o codigo de recuperação: ");
            codigo = input.nextInt();
            c.recuperarSenha(login, codigo);
        }
    }
}