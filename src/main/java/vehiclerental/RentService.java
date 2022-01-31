package vehiclerental;

import java.time.LocalTime;
import java.util.*;

public class RentService {

    Set<Rentable> rentables = new HashSet<>();
    Set<User> users = new HashSet<>();
    Map<Rentable, User> actualRenting = new TreeMap<>();

    public void registerUser(User user) {
        if (users.contains(user)) {
            throw new UserNameIsAlreadyTakenException("Username is taken!");
        } else {
            users.add(user);
        }
    }

    public void rent(User user, Rentable rentable, LocalTime time) {

        if (rentable.calculateSumPrice(180) <= user.getBalance() && rentable.getRentingTime() == null) {
            rentable.rent(time);
            actualRenting.put(rentable, user);
        } else {
            throw new IllegalStateException("Something wrong...");
        }
    }

    public void closeRent(Rentable rentable, int minutes) {
        if (checkError(rentable, minutes)) {
            throw new IllegalStateException("Something wrong...");
        }
        actualRenting.get(rentable).minusBalance(rentable.calculateSumPrice(minutes));
        actualRenting.remove(rentable);
        rentable.closeRent();
    }

    public boolean checkError(Rentable rentable, int minutes) {
        return rentable.getRentingTime() == null && minutes > 180;
    }

    public void addRentable(Rentable rentable) {
        rentables.add(rentable);
    }

    public Set<Rentable> getRentables() {
        return rentables;
    }

    public Set<User> getUsers() {
        return users;
    }

    public Map<Rentable, User> getActualRenting() {
        return actualRenting;
    }
}
