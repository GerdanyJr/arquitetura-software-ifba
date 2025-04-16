package br.edu.ifba.ncamadas.apresentacao;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

import br.edu.ifba.ncamadas.controle.ControladorListener;
import br.edu.ifba.ncamadas.modelo.Usuario;
import br.edu.ifba.ncamadas.persistencia.Resultado;

public class FormularioUsuarioMock implements Formulario<Usuario> {

    @Override
    public Usuario cadastrar() {
        String dados = "João da Silva\nJoaosilva@gmail.com\n123456";
        InputStream entradaSimulada = new ByteArrayInputStream(dados.getBytes());
        Usuario usuario = new Usuario();
        Scanner scanner = new Scanner(entradaSimulada);
        
        setField("nome", usuario, scanner, (nome) -> { usuario.setNome(nome); });
        setField("Email", usuario, scanner, (email) -> { usuario.setEmail(email); });
        setField("Senha", usuario, scanner, (senha) -> { usuario.setSenha(senha); });

        return usuario;

    }


    private void setField(String fieldName, Usuario usuario, Scanner scanner, Consumer<String> setter) {
        System.out.print("Digite " + fieldName + ":");
        setter.accept(scanner.nextLine());
    }

}
