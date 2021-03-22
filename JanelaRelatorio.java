/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendaIngresso;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bianc
 */
public class JanelaRelatorio extends JInternalFrame {

    private JTable tabelaVendas;
    private DefaultTableModel modelo;
    private JPanel panel;
    private JButton btnGerar;
    private JScrollPane scroll;
    private JanelaPrincipal janela;
    private List<Venda> vendas;

    JanelaRelatorio(JanelaPrincipal aThis, List<Venda> vendas) {
        super("Relatório de vendas", true, true, true, true);
        this.janela = janela;
        this.vendas = vendas;
        criarComponentes();
        ajustarJanela();

    }

    private void criarComponentes() {

        // botao
        panel = new JPanel();
        btnGerar = new JButton();

        // tabela
        modelo = new DefaultTableModel();
        tabelaVendas = new JTable(modelo);
        scroll = new JScrollPane(tabelaVendas);
        modelo.addColumn("Código");
        modelo.addColumn("Nome");
        modelo.addColumn("Tipo do ingresso");
        modelo.addColumn("Valor Unitário");
        modelo.addColumn("Valor total");
        modelo.addColumn("Data e hora da compra");

        btnGerar = new JButton("Gerar Relatório");
        btnGerar.addActionListener((e) -> {
            carregarDados(modelo);
        });

        adicionarComponentes();

    }

    private void adicionarComponentes() {
        panel.add(btnGerar);
        panel.add(scroll);
        add(panel);
    }

    private void ajustarJanela() {

        pack();
        setVisible(true);
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);

    }

    private void carregarDados(DefaultTableModel modelo) {
        //usar a classe object to array para carregar os dados desta forma.

        for (Venda v : vendas) {
            modelo.addRow(new Object[]{v.getCodigo(), v.getComprador().getNome(), v.getTipoIngresso(), v.getValorUnitario(),
                v.getValorTotal(), new SimpleDateFormat("dd/MM/yyyy").format(v.getDataCompra())});
        }

    }

}
