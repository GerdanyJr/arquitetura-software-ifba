package br.edu.ifba.ncamadas.controle;

import java.util.List;

import br.edu.ifba.ncamadas.persistencia.Resultado;

public interface ControladorListener<Entidade> {
    public void entidadeGravada(Resultado resultado, List<String> erros, Entidade entidade);
    public void entidadeListada(List<Entidade> lista);
}
