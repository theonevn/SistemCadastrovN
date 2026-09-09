package Service;

import Model.Cliente;
import Model.Conta;

import java.util.ArrayList;
import java.util.Scanner;

public class UpdateCadastro {

    private ArrayList<Cliente> clientes;
    private Scanner option;

    public UpdateCadastro(ArrayList<Cliente> clientes, Scanner option) {
        this.clientes = clientes;
        this.option = option;
    }

    public void listarClient() {

        for (Cliente c : clientes) {

            System.out.println("Nome: " + c.getNome());
            System.out.println("CPF: " + c.getCpf());
            System.out.println("Idade: " + c.getIdade());
            System.out.println("Telefone: " + c.getTelefone());
            System.out.println();
        }
    }


    public void cadastrarClient() {
        Cliente cliente = new Cliente();
        cliente.setConta(new Conta.InfConta());

        System.out.print("Digite o nome: ");
        cliente.setNome(option.nextLine());

        System.out.print("Digite o CPF: ");
        cliente.setCpf(option.nextLine());

        System.out.print("Digite a idade: ");
        cliente.setIdade(option.nextInt());
        option.nextLine();

        System.out.print("Digite o telefone: ");
        cliente.setTelefone(option.nextLine());

        clientes.add(cliente);
        System.out.println("Cliente cadastrado!");


    }

    public void buscarClient() {
        boolean encontrado = false;
        System.out.println("Digite seu CPF:");

        String cpfBusca = option.nextLine();

        for (Cliente c : clientes)
            if (c.getCpf().equals(cpfBusca)) {
                encontrado = true;
                System.out.println("Nome: " + c.getNome());
                System.out.println("CPF: " + c.getCpf());
                System.out.println("Idade: " + c.getIdade());
                System.out.println("Telefone: " + c.getTelefone());
                System.out.println();
            }
        if (!encontrado) {
            System.out.println("CPF não encontrado.");
        }
    }

    public void alterarClient() {
        System.out.println("Digite seu CPF:");
        String cpfRec = option.nextLine();
        boolean encontrado = false;

        for (Cliente c : clientes) {

            if (c.getCpf().equals(cpfRec)) {
                encontrado = true;

                System.out.print("Novo nome: ");
                c.setNome(option.nextLine());

                System.out.println("Nova Idade: ");
                c.setIdade(option.nextInt());
                option.nextLine();
                System.out.println("Novo Telefone: ");
                c.setTelefone(option.nextLine());
            }
        }
        if (!encontrado) {
            System.out.println("CPF não encontrado.");
        }
    }

    public void excluirClient() {

        System.out.println("Digite seu CPF:");
        String cpfRem = option.nextLine();
        boolean encontrado = false;


        for (int i = 0; i < clientes.size(); i++) {
            Cliente c = clientes.get(i);
            if (c.getCpf().equals(cpfRem)) {
                encontrado = true;

                System.out.print("Excluir Usuario Portador do CPF:" + c.getCpf());

                clientes.remove(i);

                System.out.println("Cliente Excluido com sucesso!");
                break;
            }
        }
        if (!encontrado) {
            System.out.println("CPF invalido.");
        }
    }
}

