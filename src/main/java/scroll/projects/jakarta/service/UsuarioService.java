package scroll.projects.jakarta.service;

import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import scroll.projects.jakarta.dao.UsuarioDAO;
import scroll.projects.jakarta.model.Usuario;

import java.util.List;

@Stateless
public class UsuarioService {

    @Inject
    private UsuarioDAO usuarioDAO;

    public void salvar(Usuario user){
        usuarioDAO.salvar(user);
    }

    public void atualizar(Usuario user){
        usuarioDAO.atualizar(user);
    }

    public void deletar(Usuario user){
        usuarioDAO.deletar(user);
    }

    public List<Usuario> listar(){
        return usuarioDAO.listar();
    }

    public Usuario pesquisar(Long id){
        return usuarioDAO.pesquisar(id);
    }
}
