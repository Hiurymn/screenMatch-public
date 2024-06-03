import br.com.alura.screenmatch.calculo.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculo.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Series;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso Chefão", 1970);
        //meuFilme.setName("O poderoso Chefão");
        //meuFilme.setAnoDeLancamento(1970);
        meuFilme.setDuracaoDeLancamento(180);

        System.out.println("Duração de filme " + meuFilme.getDuracaoEmMinutos());

        meuFilme.exibeFichatecnica();
        meuFilme.avalia(9);
        meuFilme.avalia(8);
        meuFilme.avalia(5);
        System.out.println("Tota de avaliações: " + meuFilme.getTotalDeAvaliacoes());

        System.out.println(meuFilme.pegaMedia());
        Series lost = new Series(2000, "Lost");
            //lost.setName("Lost"); usamos o construtor
            //lost.setAnoDeLancamento(2002); usamos o construtor
            lost.exibeFichatecnica();
            lost.setTemporadas(10);
            lost.setEpisodiosPorTemporada(10);
            lost.setMinutosPorEpisodios(50);
            System.out.println("Duração para maratonar Lost " + lost.getDuracaoEmMinutos());


            Filme outroFilme = new Filme("Avatar", 2012);
            //outroFilme.setName("Avatar");
            //outroFilme.setAnoDeLancamento(2012);
            outroFilme.setDuracaoDeLancamento(200);

            CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
            calculadora.inclui(meuFilme);
            calculadora.inclui(outroFilme);
            calculadora.inclui(lost);
            System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalVisualizacoes(300);
        filtro.filtra(episodio);

        var filmeDoPaulo = new Filme("DogVille", 2003);
        filmeDoPaulo.setDuracaoDeLancamento(200);
        //filmeDoPaulo.setName("DogVille"); não precisa escrever assim, usamos o construtor
        //filmeDoPaulo.setAnoDeLancamento(2003);
        filmeDoPaulo.avalia(10);


        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(meuFilme);
        listaDeFilmes.add(outroFilme);
        listaDeFilmes.add(filmeDoPaulo);
        System.out.println("Tamanho da lista de filme: " + listaDeFilmes.size());
        System.out.println("Primeiro Filme: " + listaDeFilmes.get(0).getName());
        System.out.println(listaDeFilmes);
        System.out.println("toString do Filme: " + listaDeFilmes.get(0).toString());




    }
}