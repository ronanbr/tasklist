package br.com.tasklist.controller;

import br.com.tasklist.dto.TarefaDto;
import br.com.tasklist.exception.BaseException;
import br.com.tasklist.service.TarefaService;
import br.com.tasklist.uteis.Uteis;
import org.primefaces.context.RequestContext;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named(value = "tarefaController")
@SessionScoped
public class TarefaController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private TarefaDto tarefaSelecionada;

    @Inject
    private TarefaService tarefaService;

    private List<TarefaDto> tarefas;

    @PostConstruct
    public void inicializar(){
        listarTodasAsTarefas();
    }

    public void salvarNovaTarefa() {
        try {
            tarefaService.salvarNovaTarefa(tarefaSelecionada);

            this.listarTodasAsTarefas();
            RequestContext.getCurrentInstance().execute("PF('modalCadastro').hide();");
            Uteis.mensagemInfo("Tarefa cadastrada com sucesso");
            tarefaSelecionada = new TarefaDto();

        } catch (BaseException e) {
            Uteis.mensagemAtencao(e.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void alterarTarefa() {
        try {
            tarefaService.alterarTarefa(tarefaSelecionada);
            RequestContext.getCurrentInstance().execute("PF('tarefaDialog').hide();");
            Uteis.mensagemInfo("Tarefa alterada com sucesso");
            tarefaSelecionada = new TarefaDto();
        } catch (BaseException e) {
            Uteis.mensagemAtencao(e.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void excluirTarefa() {
        try {
            tarefaService.excluirTarefa(tarefaSelecionada);
            this.listarTodasAsTarefas();
            RequestContext.getCurrentInstance().execute("PF('tarefaDialog').hide();");
            Uteis.mensagemInfo("Tarefa excluida com sucesso");
            tarefaSelecionada = new TarefaDto();
        } catch (BaseException e) {
            Uteis.mensagemAtencao(e.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void listarTodasAsTarefas() {
        this.tarefas = tarefaService.listarTodasAsTarefas();
    }

    public void listarTodasAsTarefasEmAberto() {
        this.tarefas = tarefaService.listarTodasAsTarefasEmAberto();
    }

    public void listarTodasAsTarefasFinalizadas() {
        this.tarefas = tarefaService.listarTodasAsTarefasFinalizadas();
    }

    public List<TarefaDto> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<TarefaDto> tarefas) {
        this.tarefas = tarefas;
    }

    public TarefaDto getTarefaSelecionada() {
        return tarefaSelecionada;
    }

    public void setTarefaSelecionada(TarefaDto tarefaSelecionada) {
        this.tarefaSelecionada = tarefaSelecionada;
    }

}
