import java.util.*;
import java.util.stream.Stream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        //12.3.a - list of 10 users
        List<User> userList = Arrays.asList(
            new User("Robert", "De Niro", 80),
            new User("Scott","Eastwood", 35),
            new User("Jack", "Nicholson", 86),
            new User("Denzel", "Washington",  68),
            new User("Scarlet", "Johansson", 38),
            new User("Meryl","Streep", 74),
            new User("Tom","Hanks", 66),
            new User("Thomas",  "Cruise Mapother IV", 60),
            new User("Cate","Blanchett", 54),
            new User("Clinton","Eastwood", 93)
        );


        //12.3.b - sort by age and add to new collection
        List<User> sortedList = new ArrayList<>(userList.size());
        userList.sort(Comparator.comparing(User::getAge));
        sortedList.addAll(userList);
        System.out.println("List sorted by age: ");
        sortedList.forEach(user -> System.out.println(user.toString()));


        //12.3.c - calculate middle age of users
        OptionalDouble averageAgeOfUsers = userList.stream().mapToInt(e -> e.getAge()).average();
        System.out.println("\nMiddle age of users: " + averageAgeOfUsers.getAsDouble());


        //12.3.d - sort by some properies
        Comparator<User> comparatorOfUsers = (User u1, User u2) ->{
            if (u1.getLastName() == u2.getLastName()) {

                return u1.getFirstName().compareTo(u2.getFirstName());
            }
            return u1.getLastName().compareTo(u2.getLastName());
        };
        System.out.println("\nList sorted by last name and first name: ");
        userList.sort(comparatorOfUsers);
        for (User user: userList) {
            System.out.println(user);
        }

        //12.3.e - check if any surname starts with S or A
        boolean boolVar = userList.stream().anyMatch(user -> user.getLastName().startsWith("S"));
        if (boolVar == true) {
            System.out.println("\nThere are users with surname started by S");
        } else {
            System.out.println("\nThere are no  users with surname started by S");
        }
        boolVar = userList.stream().anyMatch(user -> user.getLastName().startsWith("A"));
        if (boolVar == true) {
            System.out.println("\nThere are users with surname started by A");
        } else {
            System.out.println("\nThere are no users with surname started by A");
        }


        //12.3.f - check if all users are older than 18
        boolVar = userList.stream().allMatch(user -> user.getAge() > 18);
        if (boolVar == true) {
            System.out.println("\nAll users are older than 18");
        }
        else {
            System.out.println("\nNot all users are older than 18");
        }
    }
}