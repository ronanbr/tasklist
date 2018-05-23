package br.com.tasklist.uteis;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Uteis {

    // MOSTRAR MENSAGEM ALERTA
    public static void Mensagem(String mensagem) {

        FacesContext facesContext = FacesContext.getCurrentInstance();

        facesContext.addMessage(null, new FacesMessage("Alerta", mensagem));
    }

    // MOSTRAR MENSAGEM WARN
    public static void MensagemAtencao(String mensagem) {

        FacesContext facesContext = FacesContext.getCurrentInstance();

        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção:", mensagem));
    }

    // MOSTRAR MENSAGEM INFO
    public static void MensagemInfo(String mensagem) {

        FacesContext facesContext = FacesContext.getCurrentInstance();

        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", mensagem));
    }

}
