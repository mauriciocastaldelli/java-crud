package scroll.projects.jakarta.bean;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import scroll.projects.jakarta.model.Usuario;
import scroll.projects.jakarta.service.UsuarioService;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class UsuarioBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private UsuarioService usuarioService;

    private String name;
    private String email;

    public void salvar(){

        Usuario newUser = new Usuario(name, email);

        try {
            usuarioService.salvar(newUser);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário cadastrado com sucesso!", null));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar usuário!", e.getMessage()));
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // não é necessário ter atributo
    // o JSF procura automaticamente esse get quando #{usuarioBean.usuarios}
    public List<Usuario> getUsuarios() {
        return usuarioService.listar();
    }
}
