package br.edu.ifba.ncamadas.controle;

import java.util.List;

import br.edu.ifba.ncamadas.modelo.Usuario;

public class ControladorUsuario extends Controlador<Usuario> {

    @Override
    public List<String> listarErros(Usuario entidade) {
        List<String> erros = new java.util.ArrayList<>();

        if (!entidade.getEmail().contains("@")) {
            erros.add("Email inválido: " + entidade.getEmail());
        }
        if (entidade.getSenha().length() > 6) {
            erros.add("A senha tem que ter no mínimo 7 caracteres.");
        }

        return erros;
    }

}
