package com.bsv.ships;

public class Dock extends Thread{
    private final int loaderPower;
    private final ProductType productType;
    private Ship ship;
    private QueueOfShips queueOfShips = QueueOfShips.getInstance();

    public Dock (int loaderPower, ProductType productType) {
        this.loaderPower = loaderPower;
        this.productType = productType;
    }
    public void setShip(Ship ship) {
        this.ship = ship;
    }
    private void releaseShip() {
//        System.out.println(productType + " - Released" + ship);
        ship = null;
        ControlDate.addReleasedShips();
    }
    public void loadShip() {
        if(ship.getFreeSpace() >= loaderPower) {
            ship.load(loaderPower);
        } else {
            ship.load(ship.getFreeSpace());
        }
    }
    public ProductType getProductType(){
        return this.productType;
    }

    @Override
    public void run() {
        while (true) {
            if(ship == null) {
                setShip(queueOfShips.getShip(productType));
            }
            if(ship != null) {
                loadShip();
                if(ship.isLoad()){
                    releaseShip();
                }
            }
            try {
                Thread.sleep(2L);
            } catch (Exception e) {}
        }
    }
}
