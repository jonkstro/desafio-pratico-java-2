package com.example.entities;

import java.util.Date;

import com.example.enums.TipoMoeda;
import com.example.enums.TipoTransacao;

public class Transacao {
    private int cliente;
    private double valor;
    private TipoMoeda tipoMoeda;
    private TipoTransacao tipoTransacao;
    private Date data;
    public Transacao(int cliente, double valor, TipoMoeda tipoMoeda, TipoTransacao tipoTransacao, Date data) {
        this.cliente = cliente;
        this.valor = valor;
        this.tipoMoeda = tipoMoeda;
        this.tipoTransacao = tipoTransacao;
        this.data = data;
    }
    public int getCliente() {
        return cliente;
    }
    public void setCliente(int cliente) {
        this.cliente = cliente;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public TipoMoeda getTipoMoeda() {
        return tipoMoeda;
    }
    public void setTipoMoeda(TipoMoeda tipoMoeda) {
        this.tipoMoeda = tipoMoeda;
    }
    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }
    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return "Transacao [cliente=" + cliente + ", valor=" + valor + ", tipoMoeda=" + tipoMoeda + ", tipoTransacao="
                + tipoTransacao + ", data=" + data + "]";
    }   

    

}
