package Ui;

import Model.Cliente;
import Model.Conta;
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
                    // Clientes
                    break;

                case "2":
                    // Banco
                    break;

                case "3":
                    executando = false;
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

            switch () {

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
                    executando = false;
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
    public class BdMain {

        public static void main(String[] args) {

            Scanner option = new Scanner(System.in);
            Conta.InfConta conta = new Conta.InfConta();

            System.out.print("=======  Seja bem-vindo ao BancoVlux  =======");
            System.out.println();
            System.out.println("Digite seu nome:");
            conta.setTitular(option.nextLine());

            System.out.println("Bem-vindo, " + conta.getTitular());

            boolean executando = true;

            while (executando) {
                Menu.BdMenu.BdmostrarMenu();
                String sel = option.nextLine();


                switch (sel) {

                    case "1":
                        System.out.println("Saldo: R$ " + conta.getSaldo());
                        break;

                    case "2":

                        System.out.print("Valor do depósito: ");
                        double deposito = option.nextDouble();
                        option.nextLine();

                        conta.depositar(deposito);
                        break;

                    case "3":

                        System.out.print("Valor do saque: ");
                        double saque = option.nextDouble();
                        option.nextLine();

                        conta.sacar(saque);
                        break;

                    case "4":

                        System.out.print("Valor da transferência: ");
                        double transferencia = option.nextDouble();
                        option.nextLine();

                        conta.transferir(transferencia);
                        break;

                    case "5":

                        executando = false;

                        System.out.println("Obrigado por utilizar o BancoVlux!");
                        break;

                    default:

                        System.out.println("Opção inválida.");

                }

            }
        }
    }
}




