package desafio;

public class ParametrosInvalidosException extends RuntimeException{
    public ParametrosInvalidosException(){
        super("O valor do segundo parâmetro deve ser maior que o primeiro.");
    }
}
