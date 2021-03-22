/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendaIngresso;

import java.util.Date;
import java.util.List;

/**
 *
 * @author bianc
 */
public class GerenciaVenda {

    private List<Venda> vendas;

    GerenciaVenda(List<Venda> vendas) {
        this.vendas = vendas;
    }

    public void realizarVenda(Venda v) {
        vendas.add(v);
    }

}
