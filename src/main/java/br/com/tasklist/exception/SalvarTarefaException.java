package br.com.tasklist.exception;

public class SalvarTarefaException extends BaseException {

    private static final long serialVersionUID = 1L;

    public SalvarTarefaException(String message) {
        super(message);
    }

    public SalvarTarefaException(String message, Throwable cause) {
        super(message, cause);
    }

}