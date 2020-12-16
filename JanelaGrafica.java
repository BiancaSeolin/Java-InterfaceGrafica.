/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
/**
 *
 * @author bianc
 */
class JanelaGrafica extends JFrame implements ActionListener {
    private Numeros numero;
    private JPanel panel;
    private JLabel TextNum1;
    private JTextField num1;
    private JLabel TextNum2;
    private JTextField num2;
    private JTextField exibir;
    private JLabel Exibir;
    private JButton soma;
    private JButton subt;
    private JButton div;
    private JButton mult;
    

    public JanelaGrafica() {
        CriarComponentes();
        
    }

    private void CriarComponentes() {
        panel= new JPanel();
        TextNum1=new JLabel("Número:");
        num1=new JTextField(5);
        TextNum2=new JLabel("Número:");
        num2= new JTextField(5);
        soma= new JButton("+");
        subt= new JButton("-");
        div= new JButton("/");
        mult= new JButton("*");
        exibir= new JTextField(5);
        Exibir=new JLabel("=");
       
        soma.addActionListener(this);
        subt.addActionListener(this);
        div.addActionListener(this);
        mult.addActionListener(this);
        panel.add(TextNum1);
        panel.add(num1);
        panel.add(TextNum2);
        panel.add(num2);
        panel.add(soma);
        panel.add(subt);
        panel.add(div);
        panel.add(mult);
        panel.add(Exibir);
        panel.add(exibir);
        add(panel);
        
        setTitle("Calculadora");
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        
        
       
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        Numeros numero = new Numeros();
            float n1;
            float n2;
            float somaExibi;
    
        if(e.getSource()==soma){
       
            n1=(Float.parseFloat(num1.getText()));
            n2=(Float.parseFloat(num2.getText()));
            somaExibi= numero.Soma(n1, n2);
            exibir.setText(String.valueOf(somaExibi));
        }
        else if(e.getSource()==subt){
            n1=(Float.parseFloat(num1.getText()));
            n2=(Float.parseFloat(num2.getText()));
            somaExibi= numero.Subtrair(n1, n2);
            exibir.setText(String.valueOf(somaExibi));
        }
        else if(e.getSource()==div) {
            n1=(Float.parseFloat(num1.getText()));
            n2=(Float.parseFloat(num2.getText()));
            somaExibi= numero.Dividi(n1, n2);
            exibir.setText(String.valueOf(somaExibi));
            
            
        }
        else if (e.getSource()==mult){
            n1=(Float.parseFloat(num1.getText()));
            n2=(Float.parseFloat(num2.getText()));
            somaExibi= numero.Multiplica(n1, n2);
            exibir.setText(String.valueOf(somaExibi));
            
            
        }
        
        
    }
    
    
    
    
}
