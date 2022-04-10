import org.junit.Assert;
import org.junit.Test;

public class DicionarioTest {
    @Test
    public void deveTraduzirCarroELivroDoInglesParaPortuguesEDoPortuguesParaOIngles() {
        Dicionario dicionario = new Dicionario();
        dicionario.adicionarPalavra("Carro", "Car", TipoDeDicionario.INGLES);
        dicionario.adicionarPalavra("Livro", "Book", TipoDeDicionario.INGLES);
        dicionario.adicionarPalavra("Tiger", "Tigre", TipoDeDicionario.PORTUGUES);
        dicionario.adicionarPalavra("Paper", "Papel", TipoDeDicionario.PORTUGUES);

        Assert.assertEquals("car", dicionario.traduzir("carro", TipoDeDicionario.INGLES));
        Assert.assertEquals("book", dicionario.traduzir("lIVRO", TipoDeDicionario.INGLES));

        Assert.assertEquals("papel", dicionario.traduzir("pApEr", TipoDeDicionario.PORTUGUES));
        Assert.assertEquals("tigre", dicionario.traduzir("TIGER", TipoDeDicionario.PORTUGUES));

    }

    @Test(expected = PalavraNaoEncontradaException.class)
    public void deveLancarExceptionQuandoUmaPalavraNaoForEncontrada() {
        Dicionario dicionario = new Dicionario();
        dicionario.adicionarPalavra("Carro", "Car", TipoDeDicionario.INGLES);
        dicionario.adicionarPalavra("Livro", "Book", TipoDeDicionario.INGLES);

        String traducao = dicionario.traduzir("Caneta", TipoDeDicionario.INGLES);
    }
}
