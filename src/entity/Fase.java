package entity;

import service.Recorde;
import service.ContaTempo;
import service.Sons;
import service.Dicas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import service.Dicas.Dica;

public class Fase extends JDesktopPane implements ActionListener {

    private Image fundo;
    private Image explose;
    private Nave nave;
    private Timer timer;
    private int fase;
    private int cont = 0;
    private int superCont = 0;
    private boolean emJogo;
    private boolean gameOver;
    private boolean finalJogo;
    private boolean ifMorto;
    private List<InimigoFacil> inimigos1;
    private List<InimigoMedio> inimigos2;
    private List<InimigoBoss> inimigoBoss;
    private List num = new ArrayList();
    ContaTempo contarTempo = new ContaTempo();
    private static int pontos;
    Sons s = new Sons();
    //Criador de coordenadas
    private short[][] coordenadas = {{338, 29}, {3600, 79}, {2380, 109},
        {1780, 129}, {1580, 159}, {1880, 239}, {1790, 259},
        {760, 50}, {790, 150}, {1980, 209}, {560, 45}, {510, 70},
        {930, 159}, {1590, 80}, {530, 60}, {940, 59}, {990, 30},
        {920, 200}, {900, 259}, {660, 50}, {1540, 90}, {810, 220},
        {860, 20}, {1740, 380}, {1820, 328}, {490, 370}, {700, 30},
        {920, 520}, {1856, 498}, {456, 480}};

    public Fase() {

        setFocusable(true);
        setDoubleBuffered(true);

        //leitor de teclado para teclas de movimento
        addKeyListener(new TecladoAdapter());

        //adiciona imagem de fundo
        ImageIcon referencia = new ImageIcon("res//fundo.jpg");
        fundo = referencia.getImage();



        //boleano em jogo.
        emJogo = false;

        //metodo de administracao do som
        soundManager();



    }
    //metodo para inciar jogo

    private void iniciaJogo() {
        emJogo = true;
        inicializaInimigos();
        nave = new Nave();
        timer = new Timer(5, this);
        timer.start();
        contarTempo = new ContaTempo();

    }
    //metodo para finalizar jogo

    private void finalizaJogo() {
        emJogo = false;
        timer.stop();

    }

    public void inicializaInimigos() {
        //Array de inimigos das classes InimigoFacil e InimigoMedio
        //pontos=0;

        inimigos1 = new ArrayList<InimigoFacil>();
        inimigos2 = new ArrayList<InimigoMedio>();
        inimigoBoss = new ArrayList<InimigoBoss>();


        //Inicializa os inimigos faceis  pegando o tamanho das cordenadas
        if (fase <= 9) {
            for (int i = 0; i < coordenadas.length; i++) {
                //seta a posicao do inimigo pega com o i a coordenada x e y;
                inimigos1.add(new InimigoFacil(coordenadas[i][0], coordenadas[i][1]));

            }

            if (fase == 2) {
                for (int i = 0; i < 10; i++) {
                    inimigos2.add(new InimigoMedio(coordenadas[i][0], coordenadas[i][1]));
                }
            }
            if (fase == 3) {
                for (int i = 0; i < 15; i++) {
                    inimigos2.add(new InimigoMedio(coordenadas[i][0], coordenadas[i][1]));
                }
            }
            if (fase == 5) {
                for (int i = 0; i < 20; i++) {
                    inimigos2.add(new InimigoMedio(coordenadas[i][0], coordenadas[i][1]));
                }
                
            }
            if (fase >= 7 && fase <10) {
                    for (int i = 0; i < 30; i++) {
                        inimigos2.add(new InimigoMedio(coordenadas[i][0], coordenadas[i][1]));
                        
                    }
                }
            }else if(fase>9){
                for (int i = 0; i < 1; i++) {

                inimigoBoss.add(new InimigoBoss(coordenadas[i][0], coordenadas[i][1]));
                 
                }
        }

    }

    @Override
    public void paint(Graphics g) {

        //Inicio da biblioteca grafica.

        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(fundo, 0, 0, null);
        
        if (emJogo) {

            graficos.drawImage(nave.getImagem(), nave.getX(), nave.getY(), this);

            List<Missel> misseis = nave.getMisseis();

            List<Missel> misseisLaser = nave.getMisseisLaser();

            //Seta imagem para os misseis com um for que pega os misseis
            for (int i = 0; i < misseis.size(); i++) {

                Missel m = (MisselBasico) misseis.get(i);
                graficos.drawImage(m.getImagem(), m.getX(), m.getY(), this);

            }
            for (int i = 0; i < misseisLaser.size(); i++) {

                Missel ms = (MisselLaser) misseisLaser.get(i);
                graficos.drawImage(ms.getImagem(), ms.getX(), ms.getY(), this);

            }

            //Seta imagem para os inimigos na tela
            for (int i = 0; i < inimigos1.size(); i++) {
                
                InimigoFacil in = inimigos1.get(i);
                graficos.drawImage(in.getImagem(), in.getX(), in.getY(), this);
                
                }
            for (int i = 0; i < inimigos2.size(); i++) {

                InimigoMedio in = inimigos2.get(i);
                graficos.drawImage(in.getImagem(), in.getX(), in.getY(), this);

            }
            for (int i = 0; i < inimigoBoss.size(); i++) {
                InimigoBoss boss = inimigoBoss.get(i);
                graficos.drawImage(boss.getImagem(), boss.getX(), boss.getY(), this);
            }
            //Texto superior na tela com a contagem de inimigos restantes , fase, powerup e tempo ,  e dicas
            graficos.setColor(Color.WHITE);
            graficos.drawString("PONTOS : " + pontos, 5, 15);
            graficos.drawString("NIVEL: " + fase, 215, 15);
            graficos.drawString("POWERUP: " + nave.getPowerUp(), 415, 15);
            graficos.drawString("TEMPO: " + contarTempo.getAtual(), 650, 15);
            if (fase == 0) {
                graficos.drawString("*Dica: " + Dica.DICA1.getDicaEscolhida(), 145, 540);
            } else if (fase == 2) {
                graficos.drawString("*Dica: " + Dica.DICA2.getDicaEscolhida(), 145, 540);
            } else if (fase == 5) {
                graficos.drawString("*Dica: " + Dica.DICA3.getDicaEscolhida(), 145, 540);

            } else if (fase == 8) {
                graficos.drawString("*Dica: " + Dica.DICA4.getDicaEscolhida(), 145, 540);
            }
        } else if (finalJogo) {
            //Caso o booleano emJogo retorne false ele mostra a imagem de gameover
            ImageIcon fimJogo = new ImageIcon("res//overgame.jpg");

            graficos.drawImage(fimJogo.getImage(), 0, 0, null);


        } else if (gameOver) {
            ImageIcon fimJogo = new ImageIcon("res//gamedead.jpg");

            graficos.drawImage(fimJogo.getImage(), 0, 0, null);

        } else {
            ImageIcon fimJogo = new ImageIcon("res//gameover.jpg");

            graficos.drawImage(fimJogo.getImage(), 0, 0, null);
        }


        g.dispose();

    }

    //metodo herdado do java com recursividade para ficar rodando entre si.
    @Override
    public void actionPerformed(ActionEvent arg0) {
        //Testa pelo numero de inimigos se o jogo ainda esta rodando se nao tiver mais inimigos seta o booleano emJogo para false

        if (inimigos1.size() + inimigos2.size()+inimigoBoss.size() == 0 && fase <=10) {
            //emJogo = false;
            fase++;
            nave.setPowerUp(nave.getPowerUp() + 1);
            inicializaInimigos();
            soundManager();
        
        }if(fase>10) {
            finalJogo = true;
            finalizaJogo();
        }


        List<Missel> misseis = nave.getMisseis();

        List<Missel> misseisLaser = nave.getMisseisLaser();

        for (int i = 0; i < misseis.size(); i++) {

            Missel m = (MisselBasico) misseis.get(i);


            //Testa com o booleano da classe missel se o missel esta dentro da tela ou colidiu se nao ele remove o missel
            if (m.isVisivel()) {
                m.mexer();
            } else {
                misseis.remove(i);
            }

        }
        for (int i = 0; i < misseisLaser.size(); i++) {

            Missel ms = (MisselLaser) misseisLaser.get(i);


            //Testa com o booleano da classe missel se o missel esta dentro da tela ou colidiu se nao ele remove o missel
            if (ms.isVisivel()) {
                ms.mexer();
            } else {
                misseisLaser.remove(i);
            }

        }


        for (int i = 0; i < inimigos1.size(); i++) {

            InimigoFacil in = (InimigoFacil) inimigos1.get(i);
            //Testa com o booleano da classe InimigoFacil se o Inimigo Facil esta dentro da tela ou colidiu se nao ele remove o Inimigo

            if (in.isVisivel()) {
                in.mexer();
            } else {
                inimigos1.remove(i);
            }


        }
        for (int i = 0; i < inimigos2.size(); i++) {

            InimigoMedio in2 = (InimigoMedio) inimigos2.get(i);
            //Testa com o booleano da classe InimigoFacil se o Inimigo Facil esta dentro da tela ou colidiu se nao ele remove o Inimigo

            if (in2.isVisivel()) {
                in2.mexer();
            } else {
                inimigos2.remove(i);
            }
        }
        for (int i = 0; i < inimigoBoss.size(); i++) {

            InimigoBoss boss = (InimigoBoss) inimigoBoss.get(i);
            //Testa com o booleano da classe InimigoFacil se o Inimigo Facil esta dentro da tela ou colidiu se nao ele remove o Inimigo

            if (boss.isVisivel()) {
                boss.mexer();
            } else {
                inimigoBoss.remove(i);
            }


        }

        nave.mexer();
        try {
            checarColisoes();
        } catch (InterruptedException ex) {
            Logger.getLogger(Fase.class.getName()).log(Level.SEVERE, null, ex);
        }
        repaint();


    }

    public void checarColisoes() throws InterruptedException {

        Rectangle formaNave = nave.getBounds();
        Rectangle formaInimigo;
        Rectangle formaMissel;

        for (int i = 0; i < inimigos1.size(); i++) {

            Inimigos tempInimigo = inimigos1.get(i);

            //Pega a forma do inimigo
            formaInimigo = tempInimigo.getBounds();

            //se o rectangle da nave colidir com o rectangle do inimigo ele passa o booleano emJogo para false
            if (formaNave.intersects(formaInimigo)) {

                isDown();
            }

        }
        for (int i = 0; i < inimigos2.size(); i++) {

            Inimigos tempInimigo = inimigos2.get(i);

            //Pega a forma do inimigo
            formaInimigo = tempInimigo.getBounds();

            //se o rectangle da nave colidir com o rectangle do inimigo ele passa o booleano emJogo para false
            if (formaNave.intersects(formaInimigo)) {

                isDown();


            }

        }
        for (int i = 0; i < inimigoBoss.size(); i++) {

            Inimigos tempInimigo = inimigoBoss.get(i);

            //Pega a forma do inimigo
            formaInimigo = tempInimigo.getBounds();

            //se o rectangle da nave colidir com o rectangle do inimigo ele passa o booleano emJogo para false
            if (formaNave.intersects(formaInimigo)) {
                isDown();


            }

        }
        List<Missel> misseis = nave.getMisseis();

        for (int i = 0; i < misseis.size(); i++) {

            Missel tempMissel = misseis.get(i);
            formaMissel = tempMissel.getBounds();

            for (int j = 0; j < inimigos1.size(); j++) {

                Inimigos tempInimigo = inimigos1.get(j);
                formaInimigo = tempInimigo.getBounds();

                //se a forma do missel tocar na forma do inimigo ele seta o array de missel pra invisiveis e os inimigos tambem e adicona 10 pontos - 5% do tempo;
                if (formaMissel.intersects(formaInimigo)) {

                    tempMissel.setVisivel(false);
                    tempInimigo.setVisivel(false);
                    pontos = (int) (pontos + 20 - contarTempo.getAtual() * 5 / 100);
                    ifMorto=true;

                }

            }
            for (int j = 0; j < inimigos2.size(); j++) {

                Inimigos tempInimigo = inimigos2.get(j);
                formaInimigo = tempInimigo.getBounds();

                if (formaMissel.intersects(formaInimigo)) {

                    pontos = (int) (pontos + 25 - contarTempo.getAtual() * 5 / 100);
                    tempMissel.setVisivel(false);
                    nave.setVisivel(false);
                    tempInimigo.setVisivel(false);

                }

            }

            for (int j = 0; j < inimigoBoss.size(); j++) {

                Inimigos tempInimigo = inimigoBoss.get(j);
                formaInimigo = tempInimigo.getBounds();

                if (formaMissel.intersects(formaInimigo)) {
                    cont++;
                    tempMissel.setVisivel(false);

                    nave.setVisivel(false);
                    if (cont > 15) {
                        pontos = (int) (pontos + 25 - contarTempo.getAtual() * 5 / 100);
                        tempInimigo.setVisivel(false);
                    }
                }

            }
        }

//poder special
        List<Missel> misseisLaser = nave.getMisseisLaser();

        for (int i = 0; i < misseisLaser.size(); i++) {

            Missel tempMissel = misseisLaser.get(i);
            formaMissel = tempMissel.getBounds();

            for (int j = 0; j < inimigos1.size(); j++) {

                Inimigos tempInimigo = inimigos1.get(j);
                formaInimigo = tempInimigo.getBounds();

                //se a forma do missel tocar na forma do inimigo ele seta o array de missel pra invisiveis e os inimigos tambem e adicona 10 pontos;
                if (formaMissel.intersects(formaInimigo)) {

                    tempInimigo.setVisivel(false);
                    pontos = pontos + 10;
                    repaint();

                }

            }
            for (int j = 0; j < inimigos2.size(); j++) {

                Inimigos tempInimigo = inimigos2.get(j);
                formaInimigo = tempInimigo.getBounds();

                if (formaMissel.intersects(formaInimigo)) {

                    pontos = pontos + 15;
                    nave.setVisivel(false);
                    tempInimigo.setVisivel(false);

                }

            }

            for (int j = 0; j < inimigoBoss.size(); j++) {

                Inimigos tempInimigo = inimigoBoss.get(j);
                formaInimigo = tempInimigo.getBounds();

                if (formaMissel.intersects(formaInimigo)) {
                    {
                        superCont++;
                        tempMissel.setVisivel(false);

                        nave.setVisivel(false);

                        //2 super ataques matam o boss
                        if (superCont > 2) {
                            pontos = pontos + 250;

                            tempInimigo.setVisivel(false);
                        }
                    }
                }
            }

        }


    }

    private class TecladoAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {


            //testa se o jogador apertar enter e o jogo estiver rolando ele não ira reiniciar.
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                if (emJogo) {
                } else {
                    iniciaJogo();
                    inicializaInimigos();
                    soundManager();
                }
            }
            //Pega letra R para ver o ranking
            if (e.getKeyCode() == KeyEvent.VK_R) {
                if (emJogo) {
                } else {
                    mostraRecorde();

                }
            }


            if (emJogo) {
                try {
                    nave.keyPressed(e);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Fase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (emJogo) {
                nave.keyReleased(e);
            }
        }
    }

    private void salvaRecorde() {
        
        String nome = JOptionPane.showInputDialog("Salve sua pontuação: " + pontos + " pontos" + "\n" + "Nome: ");
        FileWriter arquivo;


        //escreve o arquivo.txt como banco de dados
        try {
            arquivo = new FileWriter(new File("Arquivo.txt"), true);

            arquivo.write(nome + "," + pontos + "\r\n");
            arquivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
    //metodo para mostrar ranking

    public void mostraRecorde() {
        String[] mostrar = new String[10];

        //modelo padrao de leitura com try catch
        try {
            FileReader arq = new FileReader("Arquivo.txt");
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();



            while (linha != null) {
                //le a linha e separa o nome dos pontos por um split
                String[] separ = linha.split(",");
                //salva o split num Array da Classe Recorde
                num.add(new Recorde(separ[0], Short.parseShort(separ[1])));

                linha = lerArq.readLine(); // lê da segunda até a última linha

            }


            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
        //metodo sort , cria um comparador do array num , faz as comparacoes e retorna em ordem decrecente.
        Collections.sort(num, new Comparator() {

            public int compare(Object o1, Object o2) {
                Recorde r1 = (Recorde) o1;
                Recorde r2 = (Recorde) o2;
                //condicional tenario para fazer decrescente
                return r1.getPontos() < r2.getPontos() ? +1 : (r1.getPontos() > r2.getPontos() ? -1 : 0);
            }
        });
        //Faz um test se o array ja possui mais de 10 recordes, se nao possuir ele testa pelo numero de recordes no txt, pois ele nao pode ler linhas sem registro

        if (num.size() > 10) {
            for (int i = 0; i < 10; i++) {
                mostrar[i] = num.get(i) + "";

            }
        } else {
            for (int i = 0; i < num.size(); i++) {
                mostrar[i] = num.get(i) + "";

            }


        }

        JOptionPane.showMessageDialog(this, "Posicao 1:" + mostrar[0] + "\n" + "Posicao 2:" + mostrar[1] + "\n" + "Posicao 3:" + mostrar[2] + "\n"
                + "Posicao 4:" + mostrar[3] + "\n" + "Posicao 5:" + mostrar[4] + "\n" + "Posicao 6:" + mostrar[5] + "\n"
                + "Posicao 7:" + mostrar[6] + "\n" + "Posicao 8:" + mostrar[7] + "\n" + "Posicao 9:" + mostrar[8] + "\n" + "Posicao 10:" + mostrar[9], "RANKING TOP 10", 2);
    }

    private void isDown() throws InterruptedException {

        gameOver = true;
        emJogo = false;

        fase = 0;
        finalizaJogo();
        JOptionPane.showMessageDialog(this, "GAME OVER!!!", "Game Over", 0);
        if (pontos > 0) {

            Thread.sleep(100);
            salvaRecorde();
        }
        pontos = 0;
    }

    private void soundManager() {
        if (fase < 10) {
            s.somBG();
        } else {
            s.finalBgSound();
        }
    }
}
