
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

/**
 *
 * @author bianc
 */
class Numeros {
    private  float n1;
    private  float n2;

    public Numeros(float n1, float n2) {
        this.n1 = n1;
        this.n2= n2;
    }

    Numeros() {
        
    }
    public float Soma(float n1, float n2){
       
       return n1+n2;
    }
    public float Subtrair(float n1, float n2){
      
       return n1-n2;
    }
    public float Multiplica(float n1, float n2){
    
       return n1*n2;
    }
    public float Dividi(float n1, float n2){
       
       return n1/n2;
    }

   
    
}

