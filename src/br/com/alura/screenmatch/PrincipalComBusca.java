package br.com.alura.screenmatch;


import br.com.alura.screenmatch.Excecao.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import br.com.alura.screenmatch.modelos.Titulos;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        String busca = "";
        List<Titulos> listaDeFilmes = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (!busca.equalsIgnoreCase("Sair")) {
            System.out.println("Digite um filme para busca: ");
            busca = leitura.nextLine();

            if(busca.equalsIgnoreCase("sair")){
                break;
            }

            String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=5ccaa92a";
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);


                TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println(meuTituloOmdb);
                //try{
                Titulos meuTitulos = new Titulos(meuTituloOmdb);
                System.out.println("Titulo já convertido: ");
                System.out.println(meuTitulos);

                listaDeFilmes.add(meuTitulos); //add filmes a lista de filmes

                FileWriter escrita = new FileWriter("Filme.txt");
                escrita.write(meuTitulos.toString());
                escrita.close();


            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Aconteceu um errro na busca: ");
                System.out.println(e.getMessage());
            } catch (ErroDeConversaoDeAnoException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(listaDeFilmes);

        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(listaDeFilmes));
        escrita.close();
        System.out.println("O programa finalizou corretamente! ");

    }
}
