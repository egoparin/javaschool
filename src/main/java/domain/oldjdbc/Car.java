package domain.oldjdbc;

/**
 * @author egor.oparin@x5.ru
 */
public class Car {
    private String vin;
    private String color;
    private String model;
    private double price;

    public Car(String vin, String model) {
        this.vin = vin;
        this.model = model;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
