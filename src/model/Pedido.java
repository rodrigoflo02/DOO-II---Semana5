package model;

import States.Estado;

public class Pedido {
    private int id;
    private  String direccionEntrega;
    private Estado estado;

    public Pedido(int id, String direccionEntrega, Estado estado) {
        this.id = id;
        this.direccionEntrega = direccionEntrega;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "ID: " + id + " - Direccion de entrega: " + direccionEntrega + " - States.Estado del pedido: " + estado;
    }
}
