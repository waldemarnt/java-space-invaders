package view;

import entity.Fase;
//import entity.Recorde;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import org.w3c.dom.css.RGBColor;

public class ContainerDeJanela extends JFrame {

    public ContainerDeJanela() {

        JMenuBar barraMenu = new JMenuBar();

        JMenu menu = new JMenu("Menu");

        JMenuItem sobre = new JMenuItem("Sobre");

        JMenuItem recorde = new JMenuItem("Recorde");




        sobre.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(rootPane, "Waldemar", "Infos", JOptionPane.INFORMATION_MESSAGE);


            }
        });

        JMenuItem sair = new JMenuItem("Sair");
        sair.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });






        menu.add(sobre);
        menu.add(new JSeparator());
        menu.add(sair);
        barraMenu.add(menu);

        setJMenuBar(barraMenu);




        add(new Fase());
        setTitle("Space Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);




    }

    public static void main(String[] args) {
        new ContainerDeJanela();
    }
}
