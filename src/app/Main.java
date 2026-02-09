package app;

import States.Estado;
import model.Pedido;
import model.Repartidor;
import model.ZonaDeCarga;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ZonaDeCarga zonadecarga = new ZonaDeCarga(5);
        Random random = new Random();
        Pedido[] pedidos = {
                new Pedido(1, "Av. Vickuña Mackenna 2354", Estado.PENDIENTE),
                new Pedido(2, "Av. Siempre Viva 123", Estado.PENDIENTE),
                new Pedido(3, "Av. del valle  947", Estado.PENDIENTE),
                new Pedido(4, "Av. San Carlos 1340", Estado.PENDIENTE),
                new Pedido(5, "Los platanos 4589", Estado.PENDIENTE)
        };

        for (Pedido p : pedidos) {
            zonadecarga.agregarPedido(p);
        }

        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(new Repartidor("Rodrigo Flores", zonadecarga));
        executor.execute(new Repartidor("Lucas Astorga", zonadecarga));
        executor.execute(new Repartidor("Juan Ulloa", zonadecarga));

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        executor.shutdownNow();

        try {
            if (!executor.awaitTermination(3, TimeUnit.SECONDS)) {
                System.out.println("Algunos repartidores no terminaron a tiempo");
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("Todos los pedidos han sido entregados correctamente");
    }
}