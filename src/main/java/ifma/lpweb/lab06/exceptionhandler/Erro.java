package ifma.lpweb.lab06.exceptionhandler;


import lombok.Getter;



@Getter
public class Erro {
    private String campo;
    private String mensagem;
    public Erro(String campo, String mensagem) {
        this.campo = campo;
        this.mensagem = mensagem;
    }
}
