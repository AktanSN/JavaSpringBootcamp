import model.Apartment;
import model.House;
import model.SummerHouse;
import model.Villa;
import service.HouseService;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<House> houseList = new ArrayList<>();


        houseList.add(new Apartment(150000, 120, 3, 2 ));
        houseList.add(new Apartment(180000, 150, 3, 2));
        houseList.add(new Apartment(210000, 200, 4, 3));
        houseList.add(new Villa(300000, 250, 4, 3));
        houseList.add(new Villa(350000, 300, 5, 4));
        houseList.add(new Villa(400000, 350, 6, 5));
        houseList.add(new SummerHouse(120000, 130, 2, 1));
        houseList.add(new SummerHouse(150000, 160, 3, 2));
        houseList.add(new SummerHouse(180000, 190, 4, 3));

        HouseService houseService = new HouseService(houseList);

        System.out.println("----------------------------------------------");
        System.out.println("Total price of apartments: $" + houseService.getTotalPriceByType("Apartment"));
        System.out.println("Total price of villas: $" + houseService.getTotalPriceByType("Villa"));
        System.out.println("Total price of summer houses: $" + houseService.getTotalPriceByType("SummerHouse"));
        System.out.println("Total price of all houses: $" + houseService.getTotalPrice());
        System.out.println("----------------------------------------------");
        System.out.println("Average square meters of apartments: " + houseService.getAverageAreaByType("Apartment"));
        System.out.println("Average square meters of villas: " + houseService.getAverageAreaByType("Villa"));
        System.out.println("Average square meters of summer houses: " + houseService.getAverageAreaByType("SummerHouse"));
        System.out.println("Average square meters of all houses: " + houseService.getAverageArea());
        System.out.println("----------------------------------------------");
        List<House> filteredHouses = houseService.filterByRoomAndLivingRoom(3, 2);
        System.out.println("Houses with 3 rooms and 2 living rooms:");
        for (House house : filteredHouses) {
            System.out.println(house.getType() + " - $" + house.getPrice() + " - " + house.getArea() + " square meters");
        }

    }
}
