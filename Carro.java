/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendacarros;

/**
 *
 * @author bianc
 */
class Carro {
    private String nome;
    private String fabricante;  
    private int quantEstoque;
    private boolean cameradeRe ;
    private boolean trava;
    private boolean alarme;

    public Carro(String nome, String fabricante, int quantEstoque, boolean cameradeRe, boolean trava, boolean alarme) {
        this.nome = nome;
        this.fabricante = fabricante;
        this.quantEstoque = quantEstoque;
        this.cameradeRe = cameradeRe;
        this.trava = trava;
        this.alarme = alarme;
        
    }

    public Carro() {
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getQuantEstoque() {
        return quantEstoque;
    }

    public void setQuantEstoque(int quantEstoque) {
        this.quantEstoque = quantEstoque;
    }

    public boolean isCameradeRe() {
        return cameradeRe;
    }

    public void setCameradeRe(boolean cameradeRe) {
        this.cameradeRe = cameradeRe;
    }

    public boolean isTrava() {
        return trava;
    }

    public void setTrava(boolean trava) {
        this.trava = trava;
    }

    public boolean isAlarme() {
        return alarme;
    }

    public void setAlarme(boolean alarme) {
        this.alarme = alarme;
    }

    @Override
    public String toString() {
        return "Carro{" + "nome=" + nome + ", fabricante=" + fabricante + ", quantEstoque=" + quantEstoque + ", cameradeRe=" + cameradeRe + ", trava=" + trava + ", alarme=" + alarme + '}';
    }
    
    
    
    

    

    
    
    
    
    

   

    
    
    
}
