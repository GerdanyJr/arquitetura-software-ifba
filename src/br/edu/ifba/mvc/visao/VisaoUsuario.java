package br.edu.ifba.mvc.visao;

import java.util.List;

import br.edu.ifba.mvc.modelo.Resultado;
import br.edu.ifba.mvc.modelo.Usuario;

public class VisaoUsuario implements Visao<Usuario> {

    @Override
    public Usuario getEntidade() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEntidade'");
    }

    @Override
    public void atualizar(Resultado resultado, List<String> erros) {
        if (resultado == Resultado.SUCESSO) {
            System.out.println("Usuário cadastrado com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar usuário!");
            erros.forEach(System.out::println);
        }
    }

    @Override
    public void atualizar(List<Usuario> entidads) {
        System.out.println("Lista de usuários cadastrados!");
    }

}
