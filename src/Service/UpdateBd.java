package Service;
import Model.Cliente;

import java.util.ArrayList;
import java.util.Scanner;

public class UpdateBd {

    private final ArrayList<Cliente> clientes;
    private final Scanner optionbd;

    public UpdateBd(ArrayList<Cliente> conta, Scanner option) {
        this.clientes = conta;
        this.optionbd = option;
    }

    public void depositar() {
        boolean encontrado = false;
        System.out.println("Digite seu CPF:");
        String cpfBusca = optionbd.nextLine();

        for (Cliente c : clientes)
            if (c.getCpf().equals(cpfBusca)) {
                encontrado = true;
                System.out.println("Nome: " + c.getNome());
                System.out.println("CPF: " + c.getCpf());
                System.out.println("Idade: " + c.getIdade());
                System.out.println("Telefone: " + c.getTelefone());
                System.out.println();
                System.out.print("Valor do depósito: ");
                double deposito = optionbd.nextDouble();
                optionbd.nextLine();
                c.getCont().depositar(deposito);
                break;
            }
        if (!encontrado) {
            System.out.println("CPF não encontrado.");
            return;
        }
    }

    public void verSaldo() {
        boolean encontrado = false;
        System.out.println("Digite seu CPF:");
        String cpfBusca = optionbd.nextLine();

        for (Cliente c : clientes)
            if (c.getCpf().equals(cpfBusca)) {
                encontrado = true;
                System.out.println("Nome: " + c.getNome());
                System.out.println("CPF: " + c.getCpf());
                System.out.println("Saldo " + c.getCont().getSaldo());
                break;
            }
        if (!encontrado) {
            System.out.println("CPF não encontrado.");
            return;
        }
    }

    public void Sacar() {
        boolean encontrado = false;
        System.out.println("Digite seu CPF:");
        String cpfBusca = optionbd.nextLine();

        for (Cliente c : clientes)
            if (c.getCpf().equals(cpfBusca)) {
                encontrado = true;
                System.out.print("Valor do saque: ");
                double sacar = optionbd.nextDouble();
                optionbd.nextLine();
                c.getCont().sacar(sacar);
                break;
            }
        if (!encontrado) {
            System.out.println("CPF não encontrado.");
            return;
        }
    }

    public void transferir() {
        System.out.println("Digite o CPF de origem:");
        String cpfOrigem = optionbd.nextLine();
        System.out.println("Digite o CPF de destino:");
        String cpfDestino = optionbd.nextLine();

        if (cpfOrigem.equals(cpfDestino)) {
            System.out.println("A conta de origem e destino não podem ser iguais.");
            return;
        }

        Cliente origem = null;
        Cliente destino = null;

        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpfOrigem)) {
                origem = c;
                break;
            }
        }
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpfDestino)) {
                destino = c;
                break;
            }
        }

        if (origem == null || destino == null) {
            System.out.println("CPF de origem ou destino não encontrado.");
            return;
        }

        System.out.println("Digite o valor da transferencia: ");
        double transferir = optionbd.nextDouble();
        optionbd.nextLine();

        if (origem.getCont().sacar(transferir)) {
            destino.getCont().depositar(transferir);
            System.out.println("Transferência realizada com sucesso!");
            System.out.println("DE: " + origem.getNome() + "PARA: " + destino.getNome()+".");
            System.out.println("No Valor de:R$ "+ transferir + ".");
        }
    }
}
