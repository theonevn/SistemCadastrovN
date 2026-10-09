package Repository;

import Model.Cliente;
import java.util.List;

public interface ClienteRepository {

    List<Cliente> listar();

    Cliente buscarPorCpf(String cpf);   // devolve null se não achar

    void inserir(Cliente cliente);

    boolean atualizar(Cliente cliente); // true se o CPF existia

    boolean excluir(String cpf);        // true se apagou
}