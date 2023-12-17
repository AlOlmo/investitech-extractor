package repositories.entities;

public class StockValueV2 {

    private String symbol;
    private String date;
    private double price;
    private double variation;
    private double maxValue;
    private double minValue;
    private double openValue;

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

    public double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }

    public double getMinValue() {
        return minValue;
    }

    public void setMinValue(double minValue) {
        this.minValue = minValue;
    }

    public double getOpenValue() {
        return openValue;
    }

    public void setOpenValue(double openValue) {
        this.openValue = openValue;
    }

    @Override
    public String toString() {
        return "StockValueV2{" +
                "symbol='" + symbol + '\'' +
                ", date='" + date + '\'' +
                ", price=" + price +
                ", variation=" + variation +
                ", maxValue=" + maxValue +
                ", minValue=" + minValue +
                ", openValue=" + openValue +
                '}';
    }
}
