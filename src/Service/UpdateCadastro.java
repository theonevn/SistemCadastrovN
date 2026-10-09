package Service;

import Model.Cliente;
import Model.Conta;
import Repository.ClienteRepository;

import java.util.Scanner;

public class UpdateCadastro {

    private final ClienteRepository repo;
    private final Scanner option;

    public UpdateCadastro(ClienteRepository repo, Scanner option) {
        this.repo = repo;
        this.option = option;
    }

    public void listarClient() {
        for (Cliente c : repo.listar()) {
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
        if (repo.buscarPorCpf(cliente.getCpf()) != null) {
            System.out.println("CPF já cadastrado");
            return;
        }

        System.out.print("Digite a idade: ");
        cliente.setIdade(option.nextInt());
        option.nextLine();
        if (cliente.getIdade() <= 16) {
            System.out.println("Idade inválida, precisa ser superior a 16 anos ou ter um responsável.");
            return;
        }

        System.out.print("Digite o telefone: ");
        cliente.setTelefone(option.nextLine());

        repo.inserir(cliente);
        System.out.println("Cliente cadastrado!");
    }

    public void buscarClient() {
        System.out.println("Digite seu CPF:");
        String cpfBusca = option.nextLine();

        Cliente c = repo.buscarPorCpf(cpfBusca);
        if (c == null) {
            System.out.println("CPF não encontrado.");
            return;
        }

        System.out.println("Nome: " + c.getNome());
        System.out.println("CPF: " + c.getCpf());
        System.out.println("Idade: " + c.getIdade());
        System.out.println("Telefone: " + c.getTelefone());
        System.out.println();
    }

    public void alterarClient() {
        System.out.println("Digite seu CPF:");
        String cpfRec = option.nextLine();

        Cliente c = repo.buscarPorCpf(cpfRec);
        if (c == null) {
            System.out.println("CPF não encontrado.");
            return;
        }

        System.out.print("Novo nome: ");
        c.setNome(option.nextLine());

        System.out.print("Nova idade: ");
        c.setIdade(option.nextInt());
        option.nextLine();

        System.out.print("Novo telefone: ");
        c.setTelefone(option.nextLine());

        if (repo.atualizar(c)) {
            System.out.println("Cliente atualizado com sucesso!");
        } else {
            System.out.println("Não foi possível atualizar esse CPF.");
        }
    }

    public void excluirClient() {
        System.out.println("Digite seu CPF:");
        String cpfRem = option.nextLine();

        if (repo.excluir(cpfRem)) {
            System.out.println("Cliente excluído com sucesso!");
        } else {
            System.out.println("CPF inválido.");
        }
    }
}