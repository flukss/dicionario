import java.util.HashMap;
import java.util.Map;
public class Dicionario {
    private  Map<String, String> palavraIngles = new HashMap<String, String>();
    private  Map<String, String> palavraPortugues = new HashMap<String, String>();
    private TipoDeDicionario tipoDeDicionario;

    public void adicionarPalavra( String palavra, String traducao, TipoDeDicionario tipoDeDicionario) {
        this.tipoDeDicionario = tipoDeDicionario;
        if (TipoDeDicionario.PORTUGUES.equals(getTipoDeDicionario())) {
            this.palavraPortugues.put(palavra.toLowerCase(), traducao.toLowerCase());
        }
        if (TipoDeDicionario.INGLES.equals(getTipoDeDicionario())) {
            this.palavraIngles.put(palavra.toLowerCase(), traducao.toLowerCase());
        }
    }

    public String traduzir(String palavra, TipoDeDicionario tipoDeDicionario){
        String traducao;
        if (tipoDeDicionario.equals(TipoDeDicionario.PORTUGUES)){
            traducao = this.palavraPortugues.get(palavra.toLowerCase());
        } else {
            traducao = this.palavraIngles.get(palavra.toLowerCase());
        }
        if (traducao == null){
            throw new PalavraNaoEncontradaException();
        }
        return traducao;
    }

    public TipoDeDicionario getTipoDeDicionario() {
        return tipoDeDicionario;
    }
}
