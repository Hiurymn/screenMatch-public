package br.com.alura.screenmatch.modelos;

public class Series extends Titulos{
    private int temporadas;
    private boolean ativa;
    private int episodiosPorTemporada;
    private int minutosPorEpisodios;

    public Series(int anoDeLancamento, String name) {
        super(anoDeLancamento, name);
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public int getEpisodiosPorTemporada() {
        return episodiosPorTemporada;
    }

    public void setEpisodiosPorTemporada(int episodiosPorTemporada) {
        this.episodiosPorTemporada = episodiosPorTemporada;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public int getMinutosPorEpisodios() {
        return minutosPorEpisodios;
    }

    public void setMinutosPorEpisodios(int minutosPorEpisodios) {
        this.minutosPorEpisodios = minutosPorEpisodios;
    }

    @Override
    public double getDuracaoEmMinutos() {
        return temporadas * episodiosPorTemporada * minutosPorEpisodios;
    }

    @Override
    public String toString() {
        return "Série: " + this.getName() + "(" + this.getAnoDeLancamento() + ")";
    }
}
