import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Route implements ISaveable {
    private String id;
    private String name;
    private List<Customer> stops;
    private int numberOfStops;
    // Constructor
    public Route(String id, String name, int numberOfStops) {
        this.id = id;
        this.name = name;
        this.numberOfStops = numberOfStops;
        this.stops = new ArrayList<>();
    }
    // Copy Constructor
    public Route(Route source) {
        this.id = source.id;
        this.name = source.name;
        this.stops = source.stops;
        this.numberOfStops = source.numberOfStops;
    }

    // Getters

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public int getNumberOfStops() {
        return numberOfStops;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Setters

    public void setName(String name) {
        this.name = name;
    }

    // Methods

    public void addStop(Customer customer) {
        this.stops.add(customer);
    }

    @Override
    public String toString() {
        return "Route{" + "\n" +
               "\tid='" + id + '\'' + "," + "\n" +
               "\tname='" + name + '\'' + "," + "\n" +
               "\tstops=" + stops + "," + "\n" +
               "\tnumberOfStops=" + numberOfStops + "," + "\n" +
               '}';
    }

    @Override
    public List<Object> write() {
        List<Object> values = new ArrayList<>();
        values.add(0, this.id);
        values.add(1, this.name);
        values.add(2, this.stops);
        values.add(3, this.numberOfStops);
        return values;
    }

    @Override
    public void read(List<Object> data) {
        if (data != null && data.size() > 0) {
            this.id = (String) data.get(0);
            this.name = (String) data.get(1);
            if (data.get(2) != null) {
                this.stops = new ArrayList<>();
                Customer[] incoming = (Customer[]) data.get(2);
                this.stops.addAll(Arrays.asList(incoming));
            }
            this.numberOfStops = (Integer) data.get(3);
        }
    }

}
