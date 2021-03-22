/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleempregados1;

import java.text.DecimalFormat;
import java.text.ParseException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author bianc
 */
 

public class JanelaGrafica extends JFrame {
   private JPanel panel;
   private JScrollPane scroll;
   Empregado empregados = new Empregado();
   GerenciarEmpregados gerencia = new GerenciarEmpregados();
   private JLabel labelNomeEmpregado;
   private JTextField txtNome;
   private JLabel labelSexo;
   private JRadioButton radioFeminino;
   private JRadioButton radioMasculino;
   private ButtonGroup group;
   private JLabel labelCpf;
   private JFormattedTextField txtCpf;
   private JLabel labelDataNascimento;
   private JFormattedTextField txtDataNascimento;
   private JLabel labelSalario;
   private JFormattedTextField txtSalario;
   private JTextArea areaEmpregados;
   private JButton btnDados;
   private JButton btnMostrarDados;
   private JButton btnConsultarEmpregados;
    
   
   public JanelaGrafica(){
       gerencia = new GerenciarEmpregados();
       criarComponentes();
       ajustarJanela ();
    }
    
    private void criarComponentes() {
        panel = new JPanel ();
        scroll = new JScrollPane();
        areaEmpregados = new JTextArea(10, 30);
        areaEmpregados.setEditable(false);
        areaEmpregados.setAutoscrolls(true);
        scroll.setViewportView(areaEmpregados);
        //rotulos
        labelNomeEmpregado= new JLabel ("Nome:");
        labelSexo = new JLabel ("Sexo:");
        labelCpf= new JLabel ("CPF:");
        labelDataNascimento = new JLabel ("Data de nascimento");
        labelSalario = new JLabel ("Salário:");
        
        // campos de textos formatados 
        try {
            txtCpf = new JFormattedTextField(new DefaultFormatterFactory(
                    new MaskFormatter("###.###.###-##")));
            txtCpf.setColumns(10);
            
            txtDataNascimento = new JFormattedTextField(new DefaultFormatterFactory(
                    new MaskFormatter("##/##/####")));
            txtDataNascimento.setColumns(7);
             
            txtSalario = new JFormattedTextField(new DefaultFormatterFactory(
                   new NumberFormatter(new DecimalFormat("#,##0.00"))));
            txtSalario.setColumns(8);     
        } catch (ParseException ex) {
            System.out.println("Erro na máscara.");
        }
        txtNome = new JTextField(8);
        
        // botoes
        
        radioFeminino = new JRadioButton("Feminino");
        radioMasculino = new JRadioButton ("Masculino");
        group = new ButtonGroup();
        group.add(radioFeminino);
        group.add(radioMasculino);
           
        btnDados = new JButton("Inserir dados"); 
        btnDados.addActionListener((e) ->{
             CadastrarEmpregado();
             btnConsultarEmpregados.setEnabled(true);
             btnMostrarDados.setEnabled(true);  
           
         });
        btnMostrarDados = new JButton("Mostrar Dados");
        btnMostrarDados.setEnabled(false);
        btnMostrarDados.addActionListener((e)->{
             colocarEmOrdem();
            areaEmpregados.setText("");
            
         });
        
        btnConsultarEmpregados = new JButton("Consultar Dados");
        btnConsultarEmpregados.setEnabled(false);
        btnConsultarEmpregados.addActionListener((e)->{
            buscarEmpregado();
            
         });
        adicionarComponentes();
        
    }
    private void adicionarComponentes() {
        panel.add(labelNomeEmpregado);
        panel.add(txtNome);
        panel.add(labelSexo);
        panel.add(radioFeminino);
        panel.add(radioMasculino);
        panel.add(labelCpf);
        panel.add(txtCpf);
        panel.add(labelDataNascimento);
        panel.add(txtDataNascimento);
        panel.add(labelSalario);
        panel.add(txtSalario);
        panel.add(btnDados);
        panel.add(btnMostrarDados);
        panel.add(btnConsultarEmpregados);
        panel.add(scroll);
        add(panel);
        
    }
    private void ajustarJanela() {
        setVisible(true);
        setTitle("Cadastro de empregados!");
        pack();
        setSize(900,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public GerenciarEmpregados getEmpregados() {
        return gerencia;
    }

    private void CadastrarEmpregado() {
        // recuperar dados 

         String nome = txtNome.getText();
         String sexo = radioFeminino.isSelected()?"Feminino":"Masculino";
         String cpf = txtCpf.getText();
         String dataNascimento = txtDataNascimento.getText();
         //System.out.println(txtSalario.getText());
                 
         float salario = Float.parseFloat(txtSalario.getText().replace(".","").replace(",","."));
        //System.out.println(salario);
         Empregado empregado = new Empregado(nome,sexo,cpf,dataNascimento,salario);
         gerencia.inserirEmpregado(empregado);     
 
        // limpar tela
        txtNome.setText("");
        txtCpf.setText("");
        txtSalario.setText("");
        radioFeminino.setSelected(false);
        radioMasculino.setSelected(false);
 
    
    }

    private void colocarEmOrdem(){
        
        //areaEmpregados.append(gerencia.listaOrdenadaPorSalario());
        
        // colocar no txt area.
    }

    
    private void buscarEmpregado(){
        
        String procurarNome = JOptionPane.showInputDialog("Digite o nome do funcionário desejado:");
        Empregado empregado = gerencia.getEmpregadoPorNome(procurarNome);
        //System.out.println(empregado);
        if(empregado!=null){
            
            JOptionPane.showMessageDialog(null,"Funcionário encontrado!");
            JOptionPane.showMessageDialog(null,empregado);
        }
        else{
           JOptionPane.showMessageDialog(null,"Funcionário não encontado!");
            
        }
        
        
    }


    
    

    

    


}


    

