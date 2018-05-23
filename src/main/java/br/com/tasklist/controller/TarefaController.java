package br.com.tasklist.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.tasklist.dto.TarefaDto;
import br.com.tasklist.enums.TiposDeTarefa;
import br.com.tasklist.exception.BaseException;
import br.com.tasklist.service.TarefaService;
import br.com.tasklist.uteis.Uteis;

@Named(value = "tarefaController")
@SessionScoped
public class TarefaController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private TarefaDto tarefaSelecionada;

    @Inject
    private TarefaService tarefaService;

    // Lista de tarefas que compõe o datatable no JSF
    private List<TarefaDto> tarefas;

    public void salvarNovaTarefa() {

        try {
            tarefaService.salvarNovaTarefa(tarefaSelecionada);

            this.listarTodasAsTarefas();
            RequestContext.getCurrentInstance().execute("PF('modalCadastro').hide();");
            Uteis.MensagemInfo("Tarefa cadastrada com sucesso");
            tarefaSelecionada = new TarefaDto();

        } catch (BaseException e) {
            Uteis.MensagemAtencao(e.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void alterarTarefa() {
        try {

            tarefaService.alterarTarefa(tarefaSelecionada);

            RequestContext.getCurrentInstance().execute("PF('tarefaDialog').hide();");
            Uteis.MensagemInfo("Tarefa alterada com sucesso");
            tarefaSelecionada = new TarefaDto();

        } catch (BaseException e) {
            Uteis.MensagemAtencao(e.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void excluirTarefa() {
        try {

            tarefaService.excluirTarefa(tarefaSelecionada);

            this.listarTodasAsTarefas();
            RequestContext.getCurrentInstance().execute("PF('tarefaDialog').hide();");
            Uteis.MensagemInfo("Tarefa excluida com sucesso");
            tarefaSelecionada = new TarefaDto();

        } catch (BaseException e) {
            Uteis.MensagemAtencao(e.getMessage());
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

    public TiposDeTarefa[] getTiposDeTarefas() {
        return TiposDeTarefa.values();
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
