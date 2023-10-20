import java.net.URI;
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

        for (Map<String, String> filme: listaDeFilmes){
            System.out.println("Nome do filme: " + filme.get("title"));
            System.out.println("Poster: " + filme.get("image"));
            System.out.println("Nota: " + filme.get("imDbRating"));
            System.out.println("Ano: " + filme.get("year"));
            System.out.println();
        }

    }
}
