package br.com.tasklist.exception;

public class AlterarTarefaException extends BaseException {

    private static final long serialVersionUID = 1L;

    public AlterarTarefaException(String message) {
        super(message);
    }

    public AlterarTarefaException(String message, Throwable cause) {
        super(message, cause);
    }

}