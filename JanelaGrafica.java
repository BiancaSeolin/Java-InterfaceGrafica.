/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author bianc
 */
class JanelaGrafica extends JFrame implements ActionListener {
    private Cliente cliente;
    
    private JPanel panel;
    private JLabel LabelNome;
    private JTextField FieldNome;
    private JLabel LabelSexo;
    private JLabel LabelIdade;
    private JTextField FieldIdade;
    private JLabel LabelTelefone;
    private JTextField FieldTel;
    private JLabel LabelEmail;
    private JTextField FieldEmail;
    private JRadioButton RadioFem;
    private JRadioButton RadioMas;
    private ButtonGroup group;
    private JButton BtnCadastrar;
    private JButton BtnImprimirDados;
    
     public JanelaGrafica(){
        criarComponentes();
        ajustarPropriedadesJanela();
    }

    private void criarComponentes() {
        panel = new JPanel();
        group = new ButtonGroup();
        
        LabelNome = new JLabel("Nome:");
        FieldNome = new JTextField(8);
        LabelSexo = new JLabel ("Sexo:");
        
        RadioFem = new JRadioButton("Feminino");
        RadioFem.setEnabled(true);
        RadioMas = new JRadioButton("Masculino");
        RadioMas.setEnabled(true);
        group.add(RadioFem);
        group.add(RadioMas);
        
        LabelIdade = new JLabel("Idade:");
        FieldIdade = new JTextField(3);
        LabelTelefone = new JLabel ("Telefone:");
        FieldTel = new JTextField (8);
        LabelEmail = new JLabel("Email:");
        FieldEmail= new JTextField(8);
        
        BtnCadastrar= new JButton("Inserir Dados");
        BtnImprimirDados = new JButton("Imprimir dados");
        
        BtnCadastrar.setEnabled(true);
        BtnImprimirDados.setEnabled(false);
        
        BtnCadastrar.addActionListener(this);
        BtnImprimirDados.addActionListener(this);
        
         adicionarComponentes();
      
        
        
         
        
        
    }
     private void adicionarComponentes() {
       panel.add(LabelNome);
       panel.add(FieldNome);
       panel.add(LabelSexo);
       panel.add(RadioFem);
       panel.add(RadioMas);
       panel.add(LabelIdade);
       panel.add(FieldIdade);
       panel.add(LabelTelefone);
       panel.add(FieldTel);
       panel.add(LabelEmail);
       panel.add(FieldEmail);
       panel.add(BtnCadastrar);
       panel.add(BtnImprimirDados);
       
       
       add(panel);
    }

    private void ajustarPropriedadesJanela() {
        setVisible(true);
        setTitle("Cadastro ReFisio!");
        pack();
        setSize(394,331);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == BtnCadastrar){
            novoCliente();
        }
        if(e.getSource() == BtnImprimirDados){
            ImprimirDados();
        }
    }

    private void novoCliente() {
        String nome = FieldNome.getText();
        int idade = Integer.parseInt(FieldIdade.getText());
        int telefone = Integer.parseInt(FieldTel.getText());
        String email = FieldEmail.getText();
        cliente = new Cliente(nome, idade, telefone,email);
        BtnCadastrar.setEnabled(false);
        BtnImprimirDados.setEnabled(true);
    }

    private void ImprimirDados() {
       JOptionPane.showMessageDialog(null, cliente);
    }

   
    
    
    
    
}
