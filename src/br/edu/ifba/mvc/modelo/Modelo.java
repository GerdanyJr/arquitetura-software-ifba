package br.edu.ifba.mvc.modelo;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.mvc.visao.Visao;

public abstract class Modelo<T> {
    private final List<Visao<T>> visoes = new ArrayList<>();

    public void adicionarVisao(Visao<T> visao) {
        this.visoes.add(visao);
    }

    public void removerVisao(Visao<T> visao) {
        this.visoes.remove(visao);
    }

    public void notificarVisoes(Resultado resultado, List<String> erros) {
        for (Visao<T> visao : this.visoes) {
            visao.atualizar(resultado, erros);
        }
    }

    public void notificarVisoes(List<T> entidads) {
        for (Visao<T> visao : this.visoes) {
            visao.atualizar(entidads);
        }
    }

    public abstract void gravar(T t);

    public abstract void listar();
}
