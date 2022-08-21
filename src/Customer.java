import java.util.ArrayList;
import java.util.List;

public class Customer implements ISaveable {
    private String name;
    private String location;
    private List<Integer> deliveryDays;
    private String window1;
    private String window2;

    public Customer(String name, String location) {
        this.name = name;
        this.location = location;
        this.deliveryDays = new ArrayList<>();
        this.window1 = null;
        this.window2 = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWindow1() {
        return window1;
    }

    public void setWindow1(String window1) {
        this.window1 = window1;
    }

    public String getWindow2() {
        return window2;
    }

    public void setWindow2(String window2) {
        this.window2 = window2;
    }
    // Methods


    @Override
    public String toString() {
        return "Customer{" + "\n" +
               "\tname='" + name + '\'' + "," + "\n" +
               "\tlocation='" + location + '\'' + "," + "\n" +
               "\tdeliveryDays=" + deliveryDays + "," + "\n" +
               "\twindow1='" + window1 + '\'' + "," + "\n" +
               "\twindow2='" + window2 + '\'' + "," + "\n" +
               '}';
    }

    public void setDeliveryDays(int[] days) {
       for (int i = 0; i < days.length; i++) {
           this.deliveryDays.add(days[i]);
       }
    }

    @Override
    public List<Object> write() {
        List<Object> values = new ArrayList<>();
        values.add(0, this.name);
        values.add(1, this.location);
        values.add(2, this.deliveryDays);
        values.add(3, this.window1);
        values.add(4, this.window2);
        return values;
    }

    @Override
    public void read(List<Object> data) {
        if (data != null && data.size() > 0) {
            this.name = (String) data.get(0);
            this.location = (String) data.get(1);
            if (data.get(2) != null) {
                int[] incoming = (int[]) data.get(2);
                this.deliveryDays = new ArrayList<>();
                for (int i = 0; i < incoming.length; i++) {
                    this.deliveryDays.add(incoming[i]);
                }
            }
            this.window1 = (String) data.get(3);
            if (data.get(4) != null) {
                this.window2 = (String) data.get(4);
            }
        }
    }
}
