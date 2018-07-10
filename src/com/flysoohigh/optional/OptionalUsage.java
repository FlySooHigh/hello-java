package com.flysoohigh.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalUsage {
    public static void main(String[] args) {
        User user0 = new User("Alex", 25, new Address("Russia", "Samara"),
                              Optional.of(new Hobby("Chess", 10)));
        User user1 = new User("Axel", 35, new Address("Netherlands", "Amsterdam"),
                              Optional.of(new Hobby("soccer", 5)));

        List<Optional<User>> users = new ArrayList<>();

        users.add(Optional.ofNullable(user0));
        users.add(Optional.ofNullable(user1));
        users.add(Optional.ofNullable(null));
        users.add(Optional.empty());

        System.out.println("---------- ifPresent(...)");

        for (Optional<User> optionalUser: users) {
            optionalUser.ifPresent(user -> {
                System.out.println(user.toString());
            });
        }

        System.out.println("---------- orElseGet(...)");

        for (Optional<User> optionalUser: users) {
            User orElseGetUser = optionalUser.orElseGet(() -> {
                return new User("Stub", 0, new Address("Stub", "Stub"));
            });
            System.out.println(orElseGetUser.toString());
        }

        System.out.println("---------- filter(...)");

        for (Optional<User> optionalUser: users) {
            optionalUser.filter(user -> user.getAddress().getCountry().equalsIgnoreCase("Russia"))
                        .ifPresent( user -> System.out.println("User from Russia"));
        }

        System.out.println("---------- map(...)");

        for (Optional<User> optionalUser: users) {
            optionalUser.map(User::getAddress)
                        .filter(address -> address.getCity().equalsIgnoreCase("Samara"))
                        .ifPresent(address -> System.out.println("User from Samara"));
        }

        System.out.println("---------- flatMap(...)");

        for (Optional<User> optionalUser: users) {
            optionalUser.flatMap(User::getHobby)
                        .filter(hobby -> hobby.getHobby().equalsIgnoreCase("chess"))
                        .ifPresent(user -> System.out.println(optionalUser.toString()));
        }
    }
}
