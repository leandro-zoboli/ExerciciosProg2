package Prog_4_7;

import java.io.File;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        requestFile();
    }

    public static void menu(File file) {
        Scanner tec = new Scanner(System.in);
        System.out.println("1 - Inserir conta");
        System.out.println("2 - Consultar conta por número");
        System.out.println("3 - Consultar conta por titular");
        System.out.println("4 - Exibir quantidade de contas");
        System.out.println("5 - Encessar execução");
        try {
            String resposta = tec.nextLine();

            switch (resposta) {
                case "1":
                    inserirConta(file);
                    break;
                case "2":
                    consultarContaPorNumero(file);
                    break;
                case "3":
                    consultarContaPorTitular(file);
                    break;
                case "4":
                    exibirQuantidadeContas(file);
                    System.out.println("-----------------------------------");
                    menu(file);
                    break;
                case "5":
                    break;
                default:
                    throw new Exception();
            }

        } catch (Exception error) {
            System.out.println("Entrada inválida");
            System.out.println("-----------------------------------");
            menu(file);
        }
    }

    private static void inserirConta(File file) {
        Scanner tec = new Scanner(System.in);
        String titular = "";
        double saldo = 0.0;

        System.out.println("Insira o nome do titular da nova conta:");
        titular = tec.nextLine();

        System.out.println("Insira o saldo da nova conta (númerico)");
        try {
            saldo = tec.nextDouble();
        } catch (Exception error) {
            System.out.println("Saldo inválido!");
            System.out.println("-----------------------------------");
            inserirConta(file);
        }

        ContaBancaria conta = new ContaBancaria(String.valueOf((exibirQuantidadeContas(file) + 1)), titular, saldo);
        PersistidorContasBancariasBin utils = new PersistidorContasBancariasBin(file);
        utils.gravar(conta);
        System.out.println("Conta gravada!");
        System.out.println("-----------------------------------");
        menu(file);
    }

    private static void consultarContaPorNumero(File file) {
        Scanner tec = new Scanner(System.in);
        String numero = "";

        System.out.println("Digite o número da conta a ser consultada");
        numero = tec.nextLine();

        PersistidorContasBancariasBin utils = new PersistidorContasBancariasBin(file);
        ContaBancaria contaEncontrada = utils.consultarPorNumero(numero);
        if (contaEncontrada == null) {
            System.out.println("Conta não encontrada!");
        } else {
            System.out.println("Titular: " + contaEncontrada.getTitular() + "|Saldo: " + contaEncontrada.getSaldo());

        }
        System.out.println("-----------------------------------");
        menu(file);
    }

    private static void consultarContaPorTitular(File file) {
        Scanner tec = new Scanner(System.in);
        String titular = "";

        System.out.println("Digite o titular da conta a ser consultada");
        titular = tec.nextLine();

        PersistidorContasBancariasBin utils = new PersistidorContasBancariasBin(file);
        ContaBancaria contaEncontrada = utils.consultarPorTitular(titular);
        if (contaEncontrada == null) {
            System.out.println("Conta não encontrada!");
        } else {
            System.out.println("Numero: " + contaEncontrada.getTitular() + "|Saldo: " + contaEncontrada.getSaldo());
        }
        System.out.println("-----------------------------------");
        menu(file);
    }

    private static int exibirQuantidadeContas(File file) {
        int quantidadeContas = 0;

        PersistidorContasBancariasBin utils = new PersistidorContasBancariasBin(file);
        quantidadeContas = utils.quantidadeContas();

        System.out.println("Existem, no total, " + quantidadeContas + " contas cadastradas");
        return quantidadeContas;
    }

    private static void requestFile() {
        Scanner tec = new Scanner(System.in);
        System.out.println("Digite o caminho absoluto do arquivo");
        String path = tec.nextLine();
        try {
            File file = new File(path);
            if (!file.exists()) {
                throw new Exception();
            }
            menu(file);
        } catch (Exception error) {
            System.out.println("Caminho inválido!");
            System.out.println("-----------------------------------");
            requestFile();
        }

    }
}
