package br.edu.ifba.mvc;

import br.edu.ifba.mvc.controlador.Controlador;
import br.edu.ifba.mvc.controlador.ControladorUsuario;
import br.edu.ifba.mvc.modelo.Modelo;
import br.edu.ifba.mvc.modelo.ModeloUsuario;
import br.edu.ifba.mvc.modelo.Usuario;
import br.edu.ifba.mvc.visao.Visao;
import br.edu.ifba.mvc.visao.VisaoUsuarioMock;

public class App {
    public static void main(String[] args) throws Exception {
        Visao<Usuario> visao = new VisaoUsuarioMock();
        
        Modelo<Usuario> modelo = new ModeloUsuario();
        modelo.adicionarVisao(visao);

        Controlador<Usuario> controlador = new ControladorUsuario();
        controlador.iniciar(modelo);

        controlador.cadastrar(visao.getEntidade());
        controlador.listar();
    }
}
