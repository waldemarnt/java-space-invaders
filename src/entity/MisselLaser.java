package entity;

import javax.swing.ImageIcon;

/**
 *
 * @author Waldema
 */
public class MisselLaser extends Missel implements InterfaceMisselInimigos{
    
    MisselLaser(int x, int y) {
        super(x, y);
        
        
        setImagem();
        
    }

    @Override
    public void setImagem() {
        ImageIcon referencia = new ImageIcon("res//misselSuper.png");
        setImagem(referencia.getImage());

        setAltura(getImagem().getWidth(null));
        setLargura(getImagem().getHeight(null));

        setVisivel(true);

    }

    @Override
    public void mexer() {
        //pega a posicao e adiciona os pixels de velocidade a ela, caso sega maior que os pixels da tela o missel some
        
        setX(getX()+VELOCIDADE);
        
        if(getX() > LARGURA_TELA){
            setVisivel(false);
        }
        }
    
}
