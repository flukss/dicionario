public class PalavraNaoEncontradaException extends RuntimeException{
    public PalavraNaoEncontradaException() {
        super("Palavra não encontrada no dicionário");
    }
}
