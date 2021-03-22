/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendacarros;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JFrame;

/**
 *
 * @author bianc
 */
public class JanelaGrafica extends JFrame {
    private final ArrayList<Carro> carros;
    private JPanel panel;
    private JLabel labelCarro;
    private JTextField fieldNomeCarro;
    private JLabel labelFabricante;
    private JTextField fieldFabricante;
    private JLabel labelEstoque;
    private JTextField fieldEstoque;
    private JLabel labelAcessorio;
    private JCheckBox checkCamera;
    private JCheckBox checkAlarme;
    private JCheckBox checkTrava; 
    private JButton btnCadastrar;
    private JButton btnVender;
    private JScrollPane scroll;
    private JList listCarros;
   

     public JanelaGrafica () {
        criarComponentes();
        carros = new ArrayList<>();
        ajustarJanela();
    }

    private void criarComponentes() {
     
     panel = new JPanel();
     scroll = new JScrollPane();
     
     labelCarro = new JLabel("Nome do carro:");
     fieldNomeCarro = new JTextField(10);
     
     labelFabricante = new JLabel("Fabricante:");
     fieldFabricante = new JTextField(8); 
     labelEstoque = new JLabel ("Quantidade em estoque:");
     fieldEstoque = new JTextField (5);
     
     labelAcessorio = new JLabel("Acessório:");
     checkCamera = new JCheckBox ("Camêra de ré");
     checkAlarme = new JCheckBox ("Alarme");
     checkTrava = new JCheckBox ("Trava Elétrica");
     
      //ação  com uso do lambda
     listCarros= new JList(); 
     btnCadastrar = new JButton("Cadastrar"); 
     btnCadastrar.addActionListener((e) ->{
         cadastrarCarro();
         listCarros.setListData(carros.toArray()); // colocar no vetor da lista 
         fieldNomeCarro.setText("");
         fieldEstoque.setText("");
         
     });
     btnVender= new JButton("Realizar venda");
     btnVender.addActionListener((ActionEvent e) -> {
         buscarCarro();        
     });
     
     adicionarComponentes(); 
    }

    private void adicionarComponentes() {
        panel.add(labelCarro);
        panel.add(fieldNomeCarro);
        panel.add(labelFabricante);
        panel.add(fieldFabricante);
        panel.add(labelEstoque);
        panel.add(fieldEstoque);
        panel.add(labelAcessorio);
        panel.add(checkCamera);
        panel.add(checkAlarme);
        panel.add(checkTrava);
        panel.add(btnCadastrar);
        panel.add(btnVender);
        panel.add(listCarros);
        panel.add(scroll);
        scroll.setViewportView(listCarros);
        add(panel);
    }

    private void ajustarJanela() {
        setVisible(true);
        pack();
        setSize(600,240);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void cadastrarCarro() {
        // recuperar dados
        Carro carro = new Carro(); 
        boolean alarme,camera,trava;
        alarme = checkAlarme.isSelected();
        camera = checkCamera.isSelected();
        trava=checkTrava.isSelected();
        carro.setNome(fieldNomeCarro.getText());
        carro.setFabricante(fieldFabricante.getText());
        carro.setQuantEstoque(Integer.parseInt(fieldEstoque.getText())); 
        carros.add(carro);
         
    }

    private void buscarCarro() {
         String carro;
         int quantidade;
         int contCarro=0;
         
         carro =JOptionPane.showInputDialog("Digite o nome do carro:");
         quantidade =Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade a ser comprada:"));
        
         for (int i = 0; i<carros.size(); i++) {
             if(carro.equalsIgnoreCase(carros.get(i).getNome())){
                 contCarro++;
                 if(quantidade<=carros.get(i).getQuantEstoque()){
                     JOptionPane.showMessageDialog(null,"Venda Realizada!");
                     carros.get(i).setQuantEstoque(carros.get(i).getQuantEstoque()-quantidade);
                     
                 }
                 else {
                     JOptionPane.showMessageDialog(null,"Venda não pode ser realizada!");
                     
                 }
             }                  
        }
        if (contCarro==0) {
            JOptionPane.showMessageDialog(null,"Venda não pode ser realizada!");   
        }

    }
}
    
    
    

