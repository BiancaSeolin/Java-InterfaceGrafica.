/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author bianc
 */
class Cliente {
    private  String nome;
    private  int idade;
    private  int telefone;
    private  String email;

    public Cliente(String nome, int idade, int telefone, String email) {
        this.nome = nome;
        this.idade = idade;
        this.telefone = telefone;
        this.email = email;
        
    }
    

    public String getNome() {
        return nome;
    }
    public void setNome(String nome){
        this.nome=nome;
        
     }

    public int getIdade() {
        return idade;
    }
    public void setidade(int idade){
        this.idade=idade;
        
     }
    

    public int getTelefone() {
        return telefone;
    }
    public void setTelefone(int telefone){
        this.telefone=telefone;
        
     }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email){
        this.email=email;
        
     }

    @Override
    public String toString() {
        return  "Cliente " + "Nome=" + nome + 
                ", Idade=" + idade +
                ", Telefone=" + telefone +
                ", Email=" + email;
    }
    
    

   
    
    
}
