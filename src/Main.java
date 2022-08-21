import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Customer customer1 = new Customer("Alpha", "Sprinfield, MA");
        customer1.setWindow1("0700-1400");
        customer1.setDeliveryDays(new int[]{1, 3, 5});
        Customer customer2 = new Customer("Theta", "Waloosa, ZA");
        customer2.setWindow1("0800-1600");
        customer2.setDeliveryDays(new int[]{1, 2});

        System.out.println("\n=================CUSTOMER DATA INITIAL==================");
        System.out.println("\n" + customer1);
        saveData(customer1);
        List<Object> customerToLoad = new ArrayList<>();
        customerToLoad.add(0, "Beta");
        customerToLoad.add(1, "Perth, WA");
        customerToLoad.add(2, new int[]{2, 4, 6});
        customerToLoad.add(3, "0900:1200");
        customerToLoad.add(4, "1500:1900");
        loadData(customer1, customerToLoad);
        // Customer after loading values from list
        System.out.println("\n===============CUSTOMER DATA POST LOAD=================");
        System.out.println("\n" + customer1);

        Route newRoute = new Route("z001", "std001", 1);
        newRoute.addStop(customer1);
        System.out.println("\n==================ROUTE DATA INITIAL====================");
        System.out.println("\n" + newRoute);
        saveData(newRoute);
        List<Object> routeToLoad = new ArrayList<>();
        routeToLoad.add(0, "A345");
        routeToLoad.add(1, "A00PRODUCE");
        routeToLoad.add(2, new Customer[]{customer1, customer2});
        routeToLoad.add(3, 2);
        // Route after using loading interface
        loadData(newRoute, routeToLoad);
        System.out.println("\n=================ROUTE DATA POST LOAD===================");
        System.out.println("\n" + newRoute);

        System.out.println("\n====================END OF LINE=========================");
    }

    public static void saveData(ISaveable dataToSave) {
        for (int i = 0; i < dataToSave.write().size(); i++) {
            System.out.println("\t**Saving " + dataToSave.write().get(i) + " to storage**");
        }
    }

    public static void loadData(ISaveable object, List<Object> dataToLoad) {
        if (dataToLoad != null && dataToLoad.size() > 0) {
            object.read(dataToLoad);
        }
    }
}