package domain.jpa;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * @author egor.oparin@x5.ru
 */
@Entity
public class Car {



    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "CAR_DRIVER",
            joinColumns = {@JoinColumn(name = "CAR_ID")},
            inverseJoinColumns = {@JoinColumn(name = "DRIVER_ID")})

    @Fetch(FetchMode.SUBSELECT)
    private List<Driver> drivers = new ArrayList<Driver>();


    private String color;
    private String model;
    @Column(precision = 10, scale = 2)
    private double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
