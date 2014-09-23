package entity;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public abstract class Inimigos implements InterfaceMisselInimigos {

    private Image imagem;
    private int x, y;
    public int largura, altura;
    private boolean isVisivel;
    private static final int LARGURA_TELA = 500;
    private static final int VELOCIDADE = 1;
    private static int contador = 0;

    public Inimigos(int x, int y) {

        setX(x);
        setY(y);

    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setVisivel(boolean visivel) {
        this.isVisivel = visivel;
    }

    public void setImagem(Image image) {
        this.imagem = image;
    }

    public Image getImagem() {
        return imagem;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisivel() {
        return isVisivel;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public Rectangle getBounds() {

        return new Rectangle(getX(), getY(), largura, altura);
    }

}