package br.edu.ifba.mvc.controlador;

import java.util.Scanner;
import java.util.function.Consumer;

import br.edu.ifba.mvc.modelo.Usuario;

public class FormularioUsuario implements Formulario<Usuario> {

    @Override
    public Usuario cadastrar() {
        Scanner scanner = new Scanner(System.in);
        Usuario usuario = new Usuario();

        setField("nome", usuario, scanner, (nome) -> { usuario.setNome(nome); });
        setField("Email", usuario, scanner, (email) -> { usuario.setEmail(email); });
        setField("Senha", usuario, scanner, (senha) -> { usuario.setSenha(senha); });

        scanner.close();
        return usuario;
    }

    private void setField(String fieldName, Usuario usuario, Scanner scanner, Consumer<String> setter) {
        System.out.print("Digite " + fieldName + ":");
        setter.accept(scanner.nextLine());
    }

}