package br.edu.ifba.ncamadas.controle;

import java.util.List;

import br.edu.ifba.ncamadas.persistencia.Persistencia;
import br.edu.ifba.ncamadas.persistencia.Resultado;

public abstract class Controlador<Entidade> {
    private Persistencia<Entidade> persistencia;
    private ControladorListener<Entidade> listener;

    public void iniciar(Persistencia<Entidade> persistencia, ControladorListener<Entidade> listener) {
        this.persistencia = persistencia;
        this.listener = listener;
    }

    public void gravar(Entidade entidade) {
        Resultado resultado = Resultado.ERRO;
        
        List<String> erros = listarErros(entidade);
        
        if (erros.isEmpty()) {
            resultado = persistencia.gravar(entidade);
        } else {
            for (String erro : erros) {
                System.out.println(erro);
            }
        }

        listener.entidadeGravada(resultado, erros, entidade);

    }

    public abstract List<String> listarErros(Entidade entidade); 

    public void listar() {
        listener.entidadeListada(persistencia.listar());
    }
}
