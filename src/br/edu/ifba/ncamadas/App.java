package br.edu.ifba.ncamadas;

import java.util.List;

import br.edu.ifba.ncamadas.apresentacao.Formulario;
import br.edu.ifba.ncamadas.apresentacao.FormularioUsuarioMock;
import br.edu.ifba.ncamadas.controle.Controlador;
import br.edu.ifba.ncamadas.controle.ControladorListener;
import br.edu.ifba.ncamadas.controle.ControladorUsuario;
import br.edu.ifba.ncamadas.modelo.Usuario;
import br.edu.ifba.ncamadas.persistencia.Persistencia;
import br.edu.ifba.ncamadas.persistencia.PersistenciaUsuario;
import br.edu.ifba.ncamadas.persistencia.Resultado;

public class App {
    public static void main(String[] args) throws Exception {
        Formulario<Usuario> formularioUsuario = new FormularioUsuarioMock();

        Usuario usuario = formularioUsuario.cadastrar();
        System.out.println(usuario);

        Persistencia<Usuario> persistencia = new PersistenciaUsuario();
        Controlador<Usuario> controlador = new ControladorUsuario();

        controlador.iniciar(persistencia, new ControladorListener<Usuario>() {

            @Override
            public void entidadeGravada(Resultado resultado, List<String> erros, Usuario entidade) {

                if (resultado == Resultado.SUCESSO) {
                    System.out.println("Usuário cadastrado com sucesso!");
                } else {
                    System.out.println("Erro ao cadastrar usuário!");
                }
            }

            @Override
            public void entidadeListada(List<Usuario> lista) {
                lista.forEach(System.out::println);
            }

        });
        controlador.gravar(usuario);

        controlador.listar();
    }
}
