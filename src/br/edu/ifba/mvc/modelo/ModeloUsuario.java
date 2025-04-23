package br.edu.ifba.mvc.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ModeloUsuario extends Modelo<Usuario> {

    private List<Usuario> usuarios = new ArrayList<>();

    @Override
    public void gravar(Usuario t) {
        Resultado resultado = Resultado.SUCESSO;
        List<String> erros = new ArrayList<>();

        if (t.getNome() == null || t.getNome().isEmpty()) {
            erros.add("O nome do usuário não pode ser vazio.");
            resultado = Resultado.ERRO;
        }

        if (t.getEmail() == null || !t.getEmail().contains("@")) {
            erros.add("O email do usuário é inválido.");
            resultado = Resultado.ERRO;
        }

        if (erros.isEmpty()) {
            String id = UUID.randomUUID().toString();
            t.setId(id);

            usuarios.add(t);
            System.out.println("Usuário gravado com sucesso: " + t);

        } else {
            System.out.println("Erro ao gravar usuário: " + erros);
        }

        this.notificarVisoes(resultado, erros);
    }

    @Override
    public void listar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listar'");
    }

}
