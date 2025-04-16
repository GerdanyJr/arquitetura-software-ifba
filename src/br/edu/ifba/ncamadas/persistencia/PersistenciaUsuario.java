package br.edu.ifba.ncamadas.persistencia;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

import br.edu.ifba.ncamadas.modelo.Usuario;

public class PersistenciaUsuario implements Persistencia<Usuario> {

    private Map<String, Usuario> usuarios;

    public PersistenciaUsuario() {
        this.usuarios = new TreeMap<>();
    }

    @Override
    public Resultado gravar(Usuario entidade) {
        String id = UUID.randomUUID().toString();
        entidade.setId(id); 
        usuarios.put(id, entidade);
        return Resultado.SUCESSO;
    }

    @Override
    public List<Usuario> listar() {
        return new ArrayList<>(usuarios.values());
    }
    
}
