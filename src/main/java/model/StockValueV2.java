package model;

public class StockValueV2 {

    private String symbol;
    private String date;
    private double price;
    private double variation;
    private double max_value;
    private double min_value;
    private double open_value;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getVariation() {
        return variation;
    }

    public void setVariation(double variation) {
        this.variation = variation;
    }

    public double getMax_value() {
        return max_value;
    }

    public void setMax_value(double max_value) {
        this.max_value = max_value;
    }

    public double getMin_value() {
        return min_value;
    }

    public void setMin_value(double min_value) {
        this.min_value = min_value;
    }

    public double getOpen_value() {
        return open_value;
    }

    public void setOpen_value(double open_value) {
        this.open_value = open_value;
    }

    @Override
    public String toString() {
        return "model.StockValue{" +
                "date='" + date + '\'' +
                ", symbol=" + symbol +
                ", price=" + price +
                ", variation=" + variation +
                ", max_value=" + max_value +
                ", min_value=" + min_value +
                ", open_value=" + open_value +
                '}';
    }
}
