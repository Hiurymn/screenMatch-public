package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.calculo.Classificavel;

public class Filme extends Titulos implements Classificavel {
    private String diretor;

    public Filme(String name, int anoDeLancamento) {
        super(anoDeLancamento, name);
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public int getClassificacao() {
        return (int) (pegaMedia() / 2);
    }

    @Override
    public String toString() {
        return "Filme: " + this.getName() + "Ano de Lançamento " + this.getAnoDeLancamento();
    }
}