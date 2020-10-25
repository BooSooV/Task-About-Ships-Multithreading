package com.bsv.ships;

import java.util.Random;

public class ShipGenerator extends Thread {
    private QueueOfShips queueOfShips = QueueOfShips.getInstance();

    public static synchronized Ship getRandomShip() {
        Random random = new Random();
        int randomNum1 = random.ints(1, 40).findFirst().getAsInt();
        int randomNum2 = random.ints(0, 3).findFirst().getAsInt();
        return new Ship(randomNum1, ProductType.values()[randomNum2]);
    }

    @Override
    public void run() {
        while (true) {
            while (queueOfShips.haveFreeSpace()) {
                queueOfShips.addShip(ShipGenerator.getRandomShip());
            }
            try {
                Thread.sleep(2L);
            } catch (Exception e) {

            }
        }
    }
}
