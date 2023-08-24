package model;

public class Details {
     private String name;
     private String market;
     private String ticker;
     private String isin;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    @Override
    public String toString() {
        return "model.Details{" +
                "name='" + name + '\'' +
                ", market='" + market + '\'' +
                ", ticker='" + ticker + '\'' +
                ", isin='" + isin + '\'' +
                '}';
    }
}
