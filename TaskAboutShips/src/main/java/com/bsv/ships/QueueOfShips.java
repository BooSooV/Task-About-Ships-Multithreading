package com.bsv.ships;

import java.util.LinkedList;

public class QueueOfShips {
    private final int sizeQueue = 50;
    private LinkedList<Ship> queueOfShips = new LinkedList<>();
    private static QueueOfShips instance;

    private QueueOfShips () { }

    public static QueueOfShips getInstance() {
        if (instance == null) {
            instance = new QueueOfShips();
        }
        return instance;
    }

    public boolean haveFreeSpace() {
        return sizeQueue > queueOfShips.size()  ? true : false;
    }

    public synchronized void addShip(Ship ship) {
        queueOfShips.add(ship);
    }

    public synchronized Ship getShip(ProductType type) {
        for(int i = 0; i < queueOfShips.size(); i++) {
            if(queueOfShips.get(i).getProductType() == type) {
                Ship ship = queueOfShips.get(i);
                queueOfShips.remove(i);
                return ship;
            }
        }
        return null;
    }
    public int getNumberOfShips() {
        return queueOfShips.size();
    }

    @Override
    public String toString() {
        return "QueueOfShips{" +
                queueOfShips +
                '}';
    }
}
