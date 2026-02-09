package model;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ZonaDeCarga {
   private final BlockingQueue<Pedido> colapedido;
   private final int capacidadMaxima;

    public ZonaDeCarga(int capacidadMaxima) {
        this.colapedido = new ArrayBlockingQueue<>(capacidadMaxima);
        this.capacidadMaxima = capacidadMaxima;
    }

    public synchronized void agregarPedido(Pedido p) throws InterruptedException {
        colapedido.put(p);
        System.out.println("El pedido ha sido agregado...");
        System.out.println("Datos: [ID: " + p.getId() + " - Direccion de Entrega: " + p.getDireccionEntrega() + " - States.Estado del pedido: " + p.getEstado());
   }

   public synchronized Pedido retirarPedido() throws InterruptedException {
        return colapedido.take();
   }
}
