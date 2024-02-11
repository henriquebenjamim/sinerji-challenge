package Company.Entities;

import java.time.LocalDate;

public class Sale {
    private final Seller seller;
    private final LocalDate date;
    private final double value;

    public Sale(Seller seller, LocalDate date, double value) {
        this.seller = seller;
        this.date = date;
        this.value = value;
    }

    public Seller getSeller() {
        return seller;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getValue() {
        return value;
    }
}
