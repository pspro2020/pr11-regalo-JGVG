package Regalo;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CountDownLatch;

public class HermanoMayor implements Runnable{
    static  final int HUCHA = 10;
    private final CountDownLatch countDownLatch;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public HermanoMayor() {
        countDownLatch = new CountDownLatch(HUCHA);
    }

    @Override
    public void run() {
        System.out.printf("%s -> La recolección de dinero va a empezar.\n", LocalTime.now().format(dateTimeFormatter));
        try {
            countDownLatch.await();
            System.out.printf("%s -> La recolección del dinero ha finalizado, voy a la tienda a comprar el regalo.\n", LocalTime.now().format(dateTimeFormatter));

        } catch (InterruptedException e) {
            System.out.println("He sido interrumpido mientras esperaba recolectar 10€");
        }
    }

    public void entregar_dinero(int cantidad) {
        System.out.printf("%s -> Un alumno ha conseguido %d€\n", LocalTime.now().format(dateTimeFormatter), cantidad);
        for (int i = 0; i < cantidad; i++) {
            countDownLatch.countDown();
        }
    }
}
