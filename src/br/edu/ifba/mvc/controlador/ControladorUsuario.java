package br.edu.ifba.mvc.controlador;

import br.edu.ifba.mvc.modelo.Modelo;
import br.edu.ifba.mvc.modelo.Usuario;

public class ControladorUsuario implements Controlador<Usuario> {

    private Modelo<Usuario> modelo;

    @Override
    public void iniciar(Modelo<Usuario> modelo) {
        this.modelo = modelo;
    }

    @Override
    public void cadastrar(Usuario entidade) {
        modelo.gravar(entidade);
    }

    @Override
    public void listar() {
        modelo.listar();
    }

}
