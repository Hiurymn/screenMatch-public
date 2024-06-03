package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.Excecao.ErroDeConversaoDeAnoException;
import com.google.gson.annotations.SerializedName;

public class Titulos implements Comparable<Titulos> {
    private String name;
    private int anoDeLancamento;
    private int duracaoEmMinutos;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;

    public Titulos(int anoDeLancamento, String name) {
        this.anoDeLancamento = anoDeLancamento; //elimina a cria~ção de nome e ano de lançamento no main
        this.name = name;
    }

    public Titulos(TituloOmdb meuTituloOmdb) {
        this.name = meuTituloOmdb.title();
        if (meuTituloOmdb.year().length() > 4){
            throw new ErroDeConversaoDeAnoException("não consegui converter o ano " +
                    "porque tem mais de 4 caracteres");
        }
        this.anoDeLancamento = Integer.valueOf(meuTituloOmdb.year());
        this.duracaoEmMinutos = Integer.valueOf(meuTituloOmdb.runtime().substring(0,2));
    }

    public String getName() {
        return name;
    }
    public void setName(String nome) {
        this.name = nome;
    }

    public double getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setDuracaoDeLancamento(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public int getTotalDeAvaliacoes(){
        return totalDeAvaliacoes;
    }

    public void exibeFichatecnica(){
        System.out.println("Nome do br.com.alura.screenmatch.modelos.Filme: " + name);
        System.out.println("Ano de Lançamento: " + anoDeLancamento);
    }

    public void avalia(double nota){
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes ++;
    }

    public double pegaMedia(){
        return somaDasAvaliacoes/totalDeAvaliacoes;
    }

    @Override
    public int compareTo(Titulos outroTitulo) {
        return this.getName().compareTo(outroTitulo.getName());
    }

    @Override
    public String toString() {
        return "(Nome = " + name +
                ", AnoDeLancamento = " + anoDeLancamento + ", " +
                "Duração = " + duracaoEmMinutos + "min )";
    }
}
