import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GeradoraDeFigurinhas {

    public void cria() throws Exception {
        // leitura da imagem

        BufferedImage imagemOriginal = ImageIO.read(new File("entradas/filme.jpg"));

        // cria nova em memoria com transparencia e com tamanho novo
        // copiar imagem original para nova imagem
        // escrever uma msg na nova imagem
        // escrever a img em uma novo arquivo
    }

}
