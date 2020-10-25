package com.bsv.ships;

public class Ship {
    private final int capacity;
    private int load;
    private final ProductType productType;

    public Ship (int capacity, ProductType productType) {
        this.capacity = capacity;
        this.load = 0;
        this.productType = productType;
        ControlDate.addCreatedShip();
    }
    public boolean isLoad (){
        if(load >= capacity) {
            return true;
        }
        return false;
    }
    public void load(int sizeLoad) {
        if(capacity - load >= sizeLoad) {
            load += sizeLoad;
        } else {
            System.out.println("Overload");
        }
    }
    public int getFreeSpace() {
        return capacity - load;
    }
    public ProductType getProductType(){
        return this.productType;
    }
    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "capacity=" + capacity +
                ", load=" + load +
                ", productType=" + productType +
                '}';
    }
}
