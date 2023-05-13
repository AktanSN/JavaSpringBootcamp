package model;

public class Villa extends House {

    public Villa(double price, double area, int roomCount, int livingRoomCount) {
        super(price, area, roomCount, livingRoomCount);
    }

    @Override
    public String getType() {
        return "Villa";
    }
}