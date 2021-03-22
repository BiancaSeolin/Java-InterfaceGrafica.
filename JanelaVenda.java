/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendaIngresso;

import java.text.NumberFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author bianc
 */
public class JanelaVenda extends JInternalFrame {

    private JanelaPrincipal janela;
    private List<Venda> vendas;
    private JPanel panel;
    private JLabel labelNome;
    private JTextField txtNome;
    private JLabel labelQuantIngresso;
    private JTextField txtQuantIngresso;
    private final String[] Setores = {"Setor amarelo", "Setor azul",
        "Setor branco", "Setor verde"};
    private JComboBox<String> cbxSetores;
    private final String[] Tipo = {"Estudante", "Idoso",
        "Comum"};
    private JComboBox<String> cbxTipo;
    private JButton btnComprarIngresso;
    private GerenciaVenda gerencia;

    JanelaVenda(JanelaPrincipal janela, List<Venda> vendas) {
        super("Comprar Ingresso", true, true, true, true); // x, minimiza
        this.janela = janela;
        this.vendas = vendas;
        criarComponentes();
        ajustarJanela();
    }

    private void criarComponentes() {
        panel = new JPanel();
        gerencia = new GerenciaVenda(vendas);
        labelNome = new JLabel("Nome:");
        txtNome = new JTextField(7);
        cbxSetores = new JComboBox(Setores);
        cbxTipo = new JComboBox(Tipo);
        labelQuantIngresso = new JLabel("Quantidade:");
        txtQuantIngresso = new JTextField(7);

        btnComprarIngresso = new JButton("Realizar Compra!!");
        btnComprarIngresso.addActionListener((e) -> {
            realizarVenda();
        });

        adicionarComponentes();
    }

    private boolean validarCampos(String... campos) {

        for (String s : campos) {
            // validar se tem coisa. 
            if (s.trim().isBlank()) {

                return false;
            }

        }
        return true;

    }

    private void realizarVenda() {
        System.out.println((validarCampos(txtNome.getText(), txtQuantIngresso.getText())));
        if (validarCampos(txtNome.getText(), txtQuantIngresso.getText())) {
            // recuperar dados 

            Venda v = new Venda();

            int quantidade = Integer.parseInt(txtQuantIngresso.getText());

            if (cbxSetores.getSelectedItem().equals("Setor amarelo") && quantidade <= Ingresso.quant_amarelo) {

                if (cbxTipo.getSelectedItem() == "Idoso" || cbxTipo.getSelectedItem() == "Estudante") {

                    v.setValorTotal(NumberFormat.getCurrencyInstance().format(Ingresso.SETOR_AMARELO * quantidade * Ingresso.TIPO_IDOSO_CRIANCA));

                } else if (cbxTipo.getSelectedItem().equals("Comum")) {

                    v.setValorTotal(NumberFormat.getCurrencyInstance().format(Ingresso.SETOR_AMARELO * quantidade));

                }
                v.setComprador(new Comprador(txtNome.getText()));
                v.setCodigo(Venda.cod++);
                v.setTipoIngresso("Setor amarelo");
                Ingresso.quant_amarelo -= quantidade;
                v.setValorUnitario(NumberFormat.getCurrencyInstance().format(Ingresso.SETOR_AMARELO));
                v.setDataCompra(new Date());
                gerencia.realizarVenda(v);
            } else if (cbxSetores.getSelectedItem().equals("Setor azul") && quantidade <= Ingresso.quant_azul) {

                if (cbxTipo.getSelectedItem().equals("Idoso") || cbxTipo.getSelectedItem().equals("Estudante")) {

                    v.setValorTotal(NumberFormat.getCurrencyInstance().format(Ingresso.SETOR_AZUL * quantidade * Ingresso.TIPO_IDOSO_CRIANCA));

                } else if (cbxTipo.getSelectedItem().equals("Comum")) {

                    v.setValorTotal(NumberFormat.getCurrencyInstance().format(Ingresso.SETOR_AZUL * quantidade));

                }
                v.setComprador(new Comprador(txtNome.getText()));
                v.setCodigo(Venda.cod++);
                v.setTipoIngresso("Setor azul");
                Ingresso.quant_azul -= quantidade;
                v.setValorUnitario(NumberFormat.getCurrencyInstance().format(Ingresso.SETOR_AZUL));
                v.setDataCompra(new Date());
                gerencia.realizarVenda(v);

            } else if (cbxSetores.getSelectedItem().equals("Setor branco") && quantidade <= Ingresso.quant_branco) {

                if (cbxTipo.getSelectedItem().equals("Idoso") || cbxTipo.getSelectedItem().equals("Estudante")) {

                    v.setValorTotal(NumberFormat.getCurrencyInstance().format(Ingresso.SETOR_BRANCO * quantidade * Ingresso.TIPO_IDOSO_CRIANCA));

                } else if (cbxTipo.getSelectedItem().equals("Comum")) {
                    v.setValorTotal(NumberFormat.getCurrencyInstance().format(Ingresso.SETOR_BRANCO * quantidade));

                }
                v.setComprador(new Comprador(txtNome.getText()));
                v.setCodigo(Venda.cod++);
                v.setTipoIngresso("Setor branco");
                Ingresso.quant_branco -= quantidade;
                v.setValorUnitario(NumberFormat.getCurrencyInstance().format(Ingresso.SETOR_BRANCO));
                v.setDataCompra(new Date());
                gerencia.realizarVenda(v);
            } else if (cbxSetores.getSelectedItem().equals("Setor verde") && quantidade <= Ingresso.quant_verde) {

                if (cbxTipo.getSelectedItem().equals("Idoso") || cbxTipo.getSelectedItem().equals("Estudante")) {
                    v.setValorTotal(NumberFormat.getCurrencyInstance().format(Ingresso.SETOR_VERDE * quantidade * Ingresso.TIPO_IDOSO_CRIANCA));

                } else if (cbxTipo.getSelectedItem().equals("Comum")) {
                    v.setValorTotal(NumberFormat.getCurrencyInstance().format(Ingresso.SETOR_VERDE * quantidade));

                }
                v.setComprador(new Comprador(txtNome.getText()));
                v.setCodigo(Venda.cod++);
                v.setTipoIngresso("Setor verde");
                v.setValorUnitario(NumberFormat.getCurrencyInstance().format(Ingresso.SETOR_VERDE));
                Ingresso.quant_verde -= quantidade;
                v.setDataCompra(new Date());
                gerencia.realizarVenda(v);

            } else {
                JOptionPane.showMessageDialog(null, "ERROR!! INGRESSOS ESGOTADOS");
            }

        } else {
            JOptionPane.showMessageDialog(null, "ERROR!! PREENCHA NOVAMENTE!!!");
        }

    }

    private void adicionarComponentes() {
        panel.add(labelNome);
        panel.add(txtNome);
        panel.add(cbxSetores);
        panel.add(cbxTipo);
        panel.add(labelQuantIngresso);
        panel.add(txtQuantIngresso);
        panel.add(btnComprarIngresso);
        add(panel);

    }

    private void ajustarJanela() {
        pack();
        setVisible(true);
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);

    }
}
