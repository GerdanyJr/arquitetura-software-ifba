package br.edu.ifba.mvc.controlador;

import java.util.UUID;

import br.edu.ifba.mvc.modelo.Modelo;

public interface Controlador<T> {

    public void iniciar(Modelo<T> modelo);

    public void cadastrar(T entidade);

    public void listar();

}
