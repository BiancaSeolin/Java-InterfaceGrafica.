/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleempregados1;

import java.util.ArrayList;

/**
 *
 * @author bianc
 */
class GerenciarEmpregados {

    
    private final ArrayList<Empregado> empregados;

    public GerenciarEmpregados() {
        empregados = new ArrayList<>();
    }
    public ArrayList<Empregado> getEmpregados() {
        return empregados;
    }
    public boolean inserirEmpregado(Empregado empregado){   
        if (empregado != null) {
            empregados.add(empregado);
            return true;
        }
        return false;
        
    }
    public Empregado getEmpregadoPorNome (String nome){
        Empregado empregado= null;
        for (Empregado emp:empregados){
            if(emp.getNome().equals(nome)){
                empregado= emp;
            }
            
        }
        
        return empregado;
        
    }
    public ArrayList<Empregado> listaOrdenadaPorSalario(float salario){
        ArrayList listaOrdenada= new ArrayList<Empregado>();
        float auxSalario= 0;
        for (Empregado emp:empregados){
            if(emp.getSalario()>auxSalario){
                auxSalario = emp.getSalario();
                listaOrdenada.add(auxSalario);
                
            }
            
        }       
        
        return listaOrdenada;
        
    }


    

    
    
}
