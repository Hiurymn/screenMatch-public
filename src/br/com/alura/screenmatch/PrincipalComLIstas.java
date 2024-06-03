package br.com.alura.screenmatch;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Series;
import br.com.alura.screenmatch.modelos.Titulos;

import java.util.*;

public class PrincipalComLIstas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso Chefão", 1970);
        meuFilme.avalia(7);

        Filme outroFilme = new Filme("Avatar", 2012);
        outroFilme.avalia(5);

        var filmeDoPaulo = new Filme("DogVille", 2003);
        filmeDoPaulo.avalia(10);

        Series lost = new Series(2000, "Lost");
        lost.avalia(8);
        List<Titulos> lista = new LinkedList<>();
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(filmeDoPaulo);
        lista.add(lost);

        for (Titulos item: lista){ //A forma mais comum de percorrer uma lista no Java é utilizando o laço foreach
            System.out.println(item.getName());
            if (item instanceof Filme filme && filme.getClassificacao() > 2){
                System.out.println("Classificação " + filme.getClassificacao());
            }
        }

        ArrayList<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Paulo");
        buscaPorArtista.add("jacqueline");
        System.out.println(buscaPorArtista);

        Collections.sort(buscaPorArtista);
        System.out.println("Depois da ordenação :");
        System.out.println(buscaPorArtista);
        System.out.println("Lista de Titulos ordenados por nome");
        Collections.sort(lista);
        System.out.println(lista);

        lista.sort(Comparator.comparing(Titulos::getAnoDeLancamento));


    }
}
