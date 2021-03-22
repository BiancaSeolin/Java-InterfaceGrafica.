/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleempregados1;

/**
 *
 * @author bianc
 */
public class Empregado {
  
    private String nome;
    private String sexo;
    private String cpf;
    private String data;
    private float salario;
    
    public Empregado(){
       
      
    } 
    public Empregado(String nome, String sexo, String cpf, String data, float salario){
        this.nome = nome;
        this.sexo = sexo;
        this.cpf = cpf;
        this.data = data;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empregados{" + "nome=" + nome + ", sexo=" + sexo + ", cpf=" + cpf + 
                ", data=" + data + ", salario=" + salario + '}';
    }
    

   
    
}
