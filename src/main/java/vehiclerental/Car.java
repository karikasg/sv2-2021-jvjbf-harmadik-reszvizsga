package vehiclerental;

import java.time.LocalTime;

public class Car implements Rentable {

    private String id;
    private LocalTime rentingTime;
    private int price;

    public Car(String id, int price) {
        this.id = id;
        this.price = price;
    }

    @Override
    public int calculateSumPrice(long minutes) {
        return (int) minutes * price;
    }

    @Override
    public LocalTime getRentingTime() {
        return rentingTime;
    }

    @Override
    public void rent(LocalTime time) {
        rentingTime = time;
    }

    @Override
    public void closeRent() {
        rentingTime = null;
    }
}
