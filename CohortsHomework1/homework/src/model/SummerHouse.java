package model;

public class SummerHouse extends House {
    public SummerHouse(double price, double area, int roomCount, int livingRoomCount) {
        super(price, area, roomCount, livingRoomCount);
    }

    @Override
    public String getType() {
        return "SummerHouse";
    }
}