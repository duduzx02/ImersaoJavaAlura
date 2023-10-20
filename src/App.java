import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;


public class App {
    public static void main(String[] args) throws Exception{

        // Fazer uma conexão HTTP e buscar os top 250 filmes

        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();

        System.out.println(body);


        // limpar os dados que interressam (titulo, img e rank) passear os dados
        var jsonParse = new JsonParse();
        List<Map<String, String>> listaDeFilmes = jsonParse.parse(body);
        System.out.println(listaDeFilmes.size());
        // Exibir e manipular os dados na aplicação

        for (Map<String, String> filme : listaDeFilmes){

            String urlImagem = filme.get("image");
            String titulo = filme.get("title");

            InputStream inputStream = new URL(urlImagem).openStream();
            String nomeArquivo = titulo + ".png";

            var geradora = new GeradoraDeFigurinhas();
            geradora.cria(inputStream, nomeArquivo);

            System.out.println("Nome do filme: " + titulo);
            System.out.println("Poster: " + urlImagem);
            System.out.println("Nota: " + filme.get("imDbRating"));
            System.out.println("Ano: " + filme.get("year"));
            System.out.println();
        }

    }
}
