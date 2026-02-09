import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Repartidor implements Runnable{
    private final String nombre;
    private final ZonaDeCarga zonaDeCarga;


    public Repartidor(String nombre, ZonaDeCarga zonaDeCarga) {
        this.nombre = nombre;
        this.zonaDeCarga = zonaDeCarga;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            try{
                Pedido pedido = zonaDeCarga.retirarPedido();
                pedido.setEstado(Estado.EN_REPARTO);
                System.out.println(nombre + " ha retirado su pedido " + pedido.getId() + " y se dirige hacia su destino");
                System.out.println("Datos: [" + pedido + "]");
                //Thread.sleep(1000 + random.nextInt(2000));
                Thread.sleep(3000);
                pedido.setEstado(Estado.ENTREGADO);
                System.out.println("Pedido " + pedido.getId()+ " ha sido entregado exitosamente");
                System.out.println("Datos: [" + pedido + "]");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("El pedido ha sido interrumpido, lamentamos los inconvenientes....");
            }
        }
    }
}
