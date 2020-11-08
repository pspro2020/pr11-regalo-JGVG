package Regalo;

import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        HermanoMayor hermanoMayor = new HermanoMayor();

        new Thread(hermanoMayor).start();

        for(int i = 0; i <= 5; i++){
            new Thread(new alumno((ThreadLocalRandom.current().nextInt(3)+2), hermanoMayor)).start();
        }

    }
}
