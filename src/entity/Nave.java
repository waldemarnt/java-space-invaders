package entity;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import service.Sons;
public class Nave {

    private int x, y;
    private int dx, dy;
    private int powerUp=1;
    private int naveVelocidade=7;
    private Image imagem;
    private int altura , largura;
    private List<Missel> misseis;
    private List<Missel> misseisLaser;
    private boolean isVisivel;
    
    

    public Nave() {
        
        
        
        //inicia o array de misseis
        misseis = new ArrayList<Missel>();
        misseisLaser = new ArrayList<Missel>();
        setX(100);
        setY(100);
        setImagem();
 
    }
    private void setX(int x){
        this.x=x;
        
    }
    private void setY(int y){
        this.y=y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    //seta a imagem para a nave
    public void setImagem(){
        ImageIcon referencia = new ImageIcon("res//nave.png");
        imagem = referencia.getImage();
        altura = imagem.getHeight(null);
        largura= imagem.getWidth(null);
    }

    public boolean isIsVisivel() {
        return isVisivel;
    }
    

    public void setVisivel(boolean isVisivel) {
        this.isVisivel = isVisivel;
    }
    
    public Rectangle getBounds(){
       
        return new Rectangle(x,y,largura,altura);
    }

    public void mexer() {

        x += dx;//1 e 462
        y += dy;//1 e 340
        
        //se a nave chegar a os valores da tela ela vai parar.
        if(getX() <1){
         setX(1);
        }
        if(getX()>800){
            setX(800);
        }
        
        if(getY()< -20){
            setY(-20);
        }
        if(getY()>490){
            setY(490);
        }
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

 
    public int getPowerUp(){
        return powerUp;
    }
    public void setPowerUp(int valor){
        this.powerUp=valor;
    }
    public Image getImagem() {
        return imagem;
    }

    public void atira(){
        this.misseis.add(new MisselBasico(getX() + getLargura(),getY() + getAltura()/2));
        
        
    }
    public void atiraSuper(){
        if(powerUp>0){
        this.misseisLaser.add(new MisselLaser(getX() + getLargura(),getY() + getAltura()/2));
        }
        
    }
    
    
    //Leitor de teclas
    public void keyPressed(KeyEvent tecla) throws InterruptedException {
            Sons s =  new Sons();
        //pega o codigo da telca da tabela ASCII
        int codigo = tecla.getKeyCode();

        //se o codigo for igual a tecla executa a funcao
        if(codigo == KeyEvent.VK_SPACE){
            s.playMisselSound();
            atira();
           }
        
        
        if(codigo == KeyEvent.VK_SHIFT){
        //o shift e o powerup , quando e usado ele vai diminuir em 1.    
            atiraSuper();
            if(powerUp>0){
            powerUp--;
           s.playSoundSuper();

            }
        }        
        
        if (codigo == KeyEvent.VK_UP) {
        ImageIcon referencia = new ImageIcon("res//navesuvir.png");
        imagem = referencia.getImage();
            
           setDy(-naveVelocidade); 
        }
        if (codigo == KeyEvent.VK_DOWN) {
        ImageIcon referencia = new ImageIcon("res//navedescer.png");
        imagem = referencia.getImage();
            setDy(naveVelocidade);
        }


        if (codigo == KeyEvent.VK_LEFT) {
        setDx(-naveVelocidade);
        }

        if (codigo == KeyEvent.VK_RIGHT) {
            setDx(naveVelocidade);
        }
    }

    public void keyReleased(KeyEvent tecla) {


        int codigo = tecla.getKeyCode();

        if (codigo == KeyEvent.VK_UP) {
        ImageIcon referencia = new ImageIcon("res//nave.png");
        imagem = referencia.getImage();
        setDy(0);  
        }
        if (codigo == KeyEvent.VK_DOWN) {
         ImageIcon referencia = new ImageIcon("res//nave.png");
         imagem = referencia.getImage();
   
            setDy(0);
        }


        if (codigo == KeyEvent.VK_LEFT) {
            setDx(0);
        }

        if (codigo == KeyEvent.VK_RIGHT) {
            setDx(0);
        }
    }

    public List<Missel> getMisseis() {
        return misseis;
    }
      public List<Missel> getMisseisLaser() {
        return misseisLaser;
    }
  
}
