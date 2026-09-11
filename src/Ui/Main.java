package Ui;

import Model.Cliente;
import Service.UpdateBd;
import Service.UpdateCadastro;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner option = new Scanner(System.in);
        ArrayList<Cliente> clientes = new ArrayList<>();

        UpdateCadastro cadastro = new UpdateCadastro(clientes, option);
        UpdateBd banco = new UpdateBd(clientes, option);

        boolean executando = true;

        while (executando) {
            Menu.menuPrincipal();

            String escolha = option.nextLine();

            switch (escolha) {

                case "1":
                    boolean menuClientes = true;

                    while (menuClientes) {

                        Menu.mostrarMenu();

                        String opcaoCliente = option.nextLine();

                        switch (opcaoCliente) {


                            case "1":
                                cadastro.cadastrarClient();
                                break;

                            case "2":
                                cadastro.listarClient();
                                break;


                            case "3":
                                cadastro.buscarClient();
                                System.out.println();
                                break;

                            case "4":

                                cadastro.alterarClient();
                                break;


                            case "5":
                                cadastro.excluirClient();
                                break;

                            case "6":
                                menuClientes = false;
                                System.out.println("Saindo...");
                                break;

                            default:
                                System.out.println("Opção inválida.");
                        }
                    }
                case "2":

                    boolean menubanco = true;
                    while (menubanco) {

                        Menu.BdMenu.BdmostrarMenu();
                        String opcaobanco = option.nextLine();


                        switch (opcaobanco) {
                            case "1":
                                System.out.println("Saldo: R$ " + banco.verSaldo());
                                break;

                            case "2":

                                System.out.print("Valor do depósito: ");
                                double depositar = option.nextDouble();
                                option.nextLine();

                                banco.depositar();
                                break;

                            case "3":

                                System.out.print("Valor do saque: ");
                                double saque = option.nextDouble();
                                option.nextLine();

                                banco.Sacar();
                                break;

                            case "4":

                                System.out.print("Valor da transferência: ");
                                double transferencia = option.nextDouble();
                                option.nextLine();

                                banco.transferir();
                                break;

                            case "5":

                                menubanco = false;

                                System.out.println("Obrigado por utilizar o BancoVlux!");
                                break;

                            default:

                                System.out.println("Opção inválida.");
                        }
                    }
                case "3":
                    executando = false;
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}




