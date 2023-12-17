package model;

public class CompanyV2 {

    private String name;
    private String symbol;





    //Getters - Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

//ToString


    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", symbol='" + symbol + '\''
                ;
    }
}
