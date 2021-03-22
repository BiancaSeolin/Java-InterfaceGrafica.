/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendaIngresso;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author bianc
 */
public class Venda {

    private Comprador comprador;
    private int codigo;
    private String tipoIngresso;
    private int ingressoComprado;
    private String valorUnitario;
    private String valorTotal;
    private Date dataCompra;
    public static int cod = 0;

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipoIngresso() {
        return tipoIngresso;
    }

    public void setTipoIngresso(String tipoIngresso) {
        this.tipoIngresso = tipoIngresso;
    }

    public int getIngressoComprado() {
        return ingressoComprado;
    }

    public void setIngressoComprado(int ingressoComprado) {
        this.ingressoComprado = ingressoComprado;
    }

    public String getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(String valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }
    
    // como recuperar dados em um list, usar esse metodo para transformar em int, strind, etc.
    public Object[] toArray() {
        return new Object[]{
            this.codigo,
            this.comprador.getNome(),
            this.tipoIngresso,
            this.ingressoComprado,
            this.valorUnitario,
            this.valorTotal,
            new SimpleDateFormat("dd/MM/yyyy").format(this.dataCompra) // formatar data.
        };
    
    }
    
}



