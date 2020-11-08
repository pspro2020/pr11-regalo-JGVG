package Regalo;

import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class alumno implements Runnable {
    private final int cantidad;
    private final HermanoMayor hermanoMayor;

    public alumno(int cantidad, HermanoMayor hermanoMayor) {
        if (cantidad < 1 || hermanoMayor == null) {
            throw new IllegalArgumentException();
        }
        this.cantidad = cantidad;
        this.hermanoMayor = hermanoMayor;
    }

    @Override
    public void run() {
        try {
            System.out.printf("Un alumno está buscando dinero.\n");
            TimeUnit.SECONDS.sleep((ThreadLocalRandom.current().nextInt(7+3)));
            hermanoMayor.entregar_dinero(cantidad);
        } catch (InterruptedException e) {
            System.out.println("He sido interrumpido mientras conseguía dinero.");
        }
    }
}
