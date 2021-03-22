/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendaIngresso;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author bianc
 */
public class JanelaPrincipal extends JFrame {
     private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem itemVenda, itemRelatorio, itemSair;
    private JDesktopPane desktop;
    private JanelaVenda janelaVenda;
    private JanelaRelatorio janelaRelatorio;
    private final List<Venda> vendas;
    public JanelaPrincipal() {

        this.vendas = new ArrayList<>();
        criarComponentes();
        ajustarPropriedadesJanela();
    }

    private void criarComponentes() {
        desktop = new JDesktopPane();

        menuBar = new JMenuBar();

        menu = new JMenu();
        menu.setText("Compra ingresso");

        itemVenda = new JMenuItem();
        itemVenda.setText("Realizar compra");
        itemVenda.addActionListener((ActionEvent e) -> {
            janelaVenda = new JanelaVenda(this, vendas);
            addInternalFrame(janelaVenda);
        });

        itemRelatorio = new JMenuItem();
        itemRelatorio.setText("Relatório");
        itemRelatorio.addActionListener((e) -> {
            janelaRelatorio = new JanelaRelatorio(this, vendas);
            addInternalFrame(janelaRelatorio);
        });

        itemSair = new JMenuItem();
        itemSair.setText("Sair");
        itemSair.addActionListener((e) -> {
            System.exit(0);
        });

        adicionarComponentes();
    }

    private void adicionarComponentes() {
        menu.add(itemVenda);
        menu.add(itemRelatorio);
        menu.addSeparator(); // linha de separação de itens
        menu.add(itemSair);
        menuBar.add(menu);
        setJMenuBar(menuBar);
        add(desktop);
    }

    private void ajustarPropriedadesJanela() {
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addInternalFrame(JInternalFrame internalFrame) {
        desktop.add(internalFrame);
        desktop.moveToFront(internalFrame);
    }

}

    
    

