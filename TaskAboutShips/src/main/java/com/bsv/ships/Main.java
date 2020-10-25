package com.bsv.ships;


public class Main {
    public static void main(String[] args) {
        ShipGenerator shipGenerator = new ShipGenerator();
        ShipGenerator shipGenerator2 = new ShipGenerator();

        Dock dockBread = new Dock(20, ProductType.BREADS);
        Dock dockBanana = new Dock(30, ProductType.BANANAS);
        Dock dockClothes = new Dock(30, ProductType.CLOTHES);
        Dock dockBread2 = new Dock(20, ProductType.BREADS);
        Dock dockBanana2 = new Dock(30, ProductType.BANANAS);
        Dock dockClothes2 = new Dock(30, ProductType.CLOTHES);

        shipGenerator.start();
        shipGenerator2.start();

        dockBread.start();
        dockBanana.start();
        dockClothes.start();
        dockBread2.start();
        dockBanana2.start();
        dockClothes2.start();

        while (true) {
            System.out.println(ControlDate.getCountExistShips());
            try {
                Thread.sleep(100L);
            } catch (Exception e) {

            }
        }
    }

}
