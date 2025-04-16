package br.edu.ifba.ncamadas.persistencia;

import java.util.List;

public interface Persistencia<T> {
    Resultado gravar(T entidade);
    List<T> listar();
}
