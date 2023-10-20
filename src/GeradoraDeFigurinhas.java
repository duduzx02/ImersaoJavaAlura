import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GeradoraDeFigurinhas {

    public void cria() throws Exception {
        // leitura da imagem

        BufferedImage imagemOriginal = ImageIO.read(new File("entradas/Chefao.jpg"));

        // cria nova em memoria com transparencia e com tamanho novo

        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;

        //BufferedImage novaImagem = new BufferedImage(largura, novaAltura, Transparency.TRANSLUCENT);
         BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar imagem original para nova imagem

        Graphics2D grafics = (Graphics2D) novaImagem.getGraphics();
        grafics.drawImage(imagemOriginal, 0, 0, null);

        // Configurando a fonte do texto
        var fonte = new Font(Font.MONOSPACED, Font.BOLD, 120);
        grafics.setFont(fonte);
        grafics.setBackground(Color.GREEN);
        grafics.setColor(Color.BLUE);
        // escrever uma msg na nova imagem

        grafics.drawString("TOPZERA", 450, novaAltura - 75);

        // escrever a img em uma novo arquivo

        ImageIO.write(novaImagem, "png", new File("saida/figurinha1.png"));


    }

    public static void main(String[] args) throws Exception {
        GeradoraDeFigurinhas gera = new GeradoraDeFigurinhas();

        gera.cria();
    }

}
