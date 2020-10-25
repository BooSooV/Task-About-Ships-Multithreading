package com.bsv.ships;

public class ControlDate {
    private static long countCreatedShips = 0;
    private static long countReleasedShips = 0;
    private static int countExistShips = 0;

//    private static ControlDate instance;

    private ControlDate () { }
//    public static ControlDate controlDate() {
//        if (instance == null) {
//            instance = new ControlDate();
//        }
//        return instance;
//    }

    public static long getDiffCreatedReleased() {
        return countReleasedShips - countCreatedShips;
    }
    public static synchronized void addCreatedShip() {
        countCreatedShips++;
        countExistShips++;
    }
    public static synchronized void addReleasedShips() {
        countReleasedShips++;
        countExistShips--;
    }
    public static int getCountExistShips() {
        return countExistShips;
    }

}
