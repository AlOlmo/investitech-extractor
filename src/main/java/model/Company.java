package model;

public class Company {

    private String name;
    private String isin;
    private String sector;
    private String subsector;
    private String tradingSystem;
    private String indices;





    //Getters - Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getSubsector() {
        return subsector;
    }

    public void setSubsector(String subsector) {
        this.subsector = subsector;
    }

    public String getTradingSystem() {
        return tradingSystem;
    }

    public void setTradingSystem(String tradingSystem) {
        this.tradingSystem = tradingSystem;
    }

    public String getIndices() {
        return indices;
    }

    public void setIndices(String indices) {
        this.indices = indices;
    }

    //ToString


    @Override
    public String toString() {
        return "model.Company{" +
                "name='" + name + '\'' +
                ", isin='" + isin + '\'' +
                ", sector='" + sector + '\'' +
                ", subsector='" + subsector + '\'' +
                ", tradingSystem='" + tradingSystem + '\'' +
                ", indices='" + indices + '\'' +
                '}';
    }
}
