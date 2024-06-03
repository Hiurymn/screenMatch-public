package br.com.alura.screenmatch.calculo;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Series;
import br.com.alura.screenmatch.modelos.Titulos;

public class CalculadoraDeTempo {
    private int tempoTotal = 0;

    public int getTempoTotal() {
        return this.tempoTotal;
    }

//    public void inclui(Filme f){                        Codigo repetido, versão melhor abaixo
//        this.tempoTotal += f.getDuracaoEmMinutos();
//    }
//    public void inclui(Series s){
//        this.tempoTotal += s.getDuracaoEmMinutos();
//    }
    public void inclui(Titulos titulo){
        System.out.println("Adicionando a duração em minutos de " + titulo);
        this.tempoTotal += titulo.getDuracaoEmMinutos();
    }
}
