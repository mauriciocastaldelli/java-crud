package scroll.projects.jakarta.dao;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import scroll.projects.jakarta.model.Usuario;

import java.util.List;

@ApplicationScoped
public class UsuarioDAO {

    @PersistenceContext(unitName = "meuPU")
    private EntityManager em;

    public void salvar(Usuario user){
        em.persist(user);
    }

    public void atualizar(Usuario user){
        em.merge(user);
    }

    public void deletar(Usuario user){
        Usuario u = this.pesquisar(user.getId());
        if (u != null){
            em.remove(u);
        }
    }

    public List<Usuario> listar(){
        return em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
    }

    public Usuario pesquisar(Long id){
        return em.find(Usuario.class, id);
    }
}
