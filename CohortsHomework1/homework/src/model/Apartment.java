package model;

public class Apartment extends House {

    public Apartment(double price, double area, int roomCount, int livingRoomCount) {
        super(price, area, roomCount, livingRoomCount);
    }

    @Override
    public String getType() {
        return "Apartment";
    }
}