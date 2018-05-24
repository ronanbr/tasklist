package br.com.tasklist.uteis;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Uteis {

    public static void Mensagem(String mensagem) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null, new FacesMessage("Alerta", mensagem));
    }

    public static void mensagemAtencao(String mensagem) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção:", mensagem));
    }

    public static void mensagemInfo(String mensagem) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", mensagem));
    }

}
