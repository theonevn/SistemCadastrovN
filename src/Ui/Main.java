package Ui;

import Model.Cliente;
import Service.UpdateBd;
import Service.UpdateCadastro;
import Repository.ClienteRepository;
import Repository.ClienteRepositoryMemoria;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner option = new Scanner(System.in);
        ArrayList<Cliente> clientes = new ArrayList<>();

        ClienteRepository repo = new ClienteRepositoryMemoria(clientes);
        UpdateCadastro cadastro = new UpdateCadastro(repo, option);
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
                                break;
                        }
                    }
                    break;
                case "2":

                    boolean menubanco = true;
                    while (menubanco) {

                        Menu.BdMenu.BdmostrarMenu();
                        String opcaobanco = option.nextLine();


                        switch (opcaobanco) {
                            case "1":
                                banco.verSaldo();
                                break;

                            case "2":
                                banco.depositar();
                                break;

                            case "3":
                                banco.Sacar();
                                break;

                            case "4":
                                banco.transferir();
                                break;

                            case "5":
                                menubanco = false;

                                System.out.println("Obrigado por utilizar o BancoVlux!");
                                break;

                            default:

                                System.out.println("Opção inválida.");
                                break;
                        }
                    }
                    break;

                case "3":
                    executando = false;
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}





