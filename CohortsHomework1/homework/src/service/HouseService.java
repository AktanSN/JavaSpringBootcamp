package service;

import model.Apartment;
import model.House;
import model.SummerHouse;
import model.Villa;

import java.util.ArrayList;
import java.util.List;

public class HouseService {
    private List<House> houseList;

    public HouseService(List<House> houseList) {
        this.houseList = houseList;
    }

    public double getTotalPriceByType(String type) {
        double totalPrice = 0;
        for (House house : houseList) {
            if (house.getType().equals(type)) {
                totalPrice += house.getPrice();
            }
        }
        return totalPrice;
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (House house : houseList) {
            totalPrice += house.getPrice();
        }
        return totalPrice;
    }

    public double getAverageAreaByType(String type) {
        double totalArea = 0;
        int count = 0;
        for (House house : houseList) {
            if (house.getType().equals(type)) {
                totalArea += house.getArea();
                count++;
            }
        }
        return totalArea / count;
    }

    public double getAverageArea() {
        double totalArea = 0;
        for (House house : houseList) {
            totalArea += house.getArea();
        }
        return totalArea / houseList.size();
    }

    public List<House> filterByRoomAndLivingRoom(int roomCount, int livingRoomCount) {
        List<House> filteredHouses = new ArrayList<>();
        for (House house : houseList) {
            if (house instanceof Apartment) {
                Apartment apartment = (Apartment) house;
                if (apartment.getRoomCount() == roomCount && apartment.getLivingRoomCount() == livingRoomCount) {
                    filteredHouses.add(apartment);
                }
            } else if (house instanceof Villa) {
                Villa villa = (Villa) house;
                if (villa.getRoomCount() == roomCount && villa.getLivingRoomCount() == livingRoomCount) {
                    filteredHouses.add(villa);
                }
            } else if (house instanceof SummerHouse) {
                SummerHouse summerHouse = (SummerHouse) house;
                if (summerHouse.getRoomCount() == roomCount && summerHouse.getLivingRoomCount() == livingRoomCount) {
                    filteredHouses.add(summerHouse);
                }
            }
        }
        return filteredHouses;
    }
}