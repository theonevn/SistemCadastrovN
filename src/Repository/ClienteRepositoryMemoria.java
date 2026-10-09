package Repository;

import Model.Cliente;
import java.util.List;

public class ClienteRepositoryMemoria implements ClienteRepository {

    private final List<Cliente> clientes;

    public ClienteRepositoryMemoria(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public List<Cliente> listar() {
        return clientes;
    }

    @Override
    public Cliente buscarPorCpf(String cpf) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void inserir(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public boolean atualizar(Cliente cliente) {
        // Na memória o objeto já foi alterado direto na lista,
        // então aqui só confirmamos que o CPF existe.
        return buscarPorCpf(cliente.getCpf()) != null;
    }

    @Override
    public boolean excluir(String cpf) {
        return clientes.removeIf(c -> c.getCpf().equals(cpf));
    }
}