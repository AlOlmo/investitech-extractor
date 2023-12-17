package extractor.entities;

// TODO: Adaptar el modelado a la nueva tabla
public class StockValue {

    private String date;
    private double close;
    private double reference;
    private int volume;
    private double turnover;
    private double last;
    private double high;
    private double low;
    private double average;
    private double previous;
    private int facMult;
    private int facDivi;
    private double diff;
    private int tendency;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getReference() {
        return reference;
    }

    public void setReference(double reference) {
        this.reference = reference;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public double getTurnover() {
        return turnover;
    }

    public void setTurnover(double turnover) {
        this.turnover = turnover;
    }

    public double getLast() {
        return last;
    }

    public void setLast(double last) {
        this.last = last;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public double getPrevious() {
        return previous;
    }

    public void setPrevious(double previous) {
        this.previous = previous;
    }

    public int getFacMult() {
        return facMult;
    }

    public void setFacMult(int facMult) {
        this.facMult = facMult;
    }

    public int getFacDivi() {
        return facDivi;
    }

    public void setFacDivi(int facDivi) {
        this.facDivi = facDivi;
    }

    public double getDiff() {
        return diff;
    }

    public void setDiff(double diff) {
        this.diff = diff;
    }

    public int getTendency() {
        return tendency;
    }

    public void setTendency(int tendency) {
        this.tendency = tendency;
    }

    @Override
    public String toString() {
        return "extractor.entities.StockValue{" +
                "date='" + date + '\'' +
                ", close=" + close +
                ", reference=" + reference +
                ", volume=" + volume +
                ", turnover=" + turnover +
                ", last=" + last +
                ", high=" + high +
                ", low=" + low +
                ", average=" + average +
                ", previous=" + previous +
                ", facMult=" + facMult +
                ", facDivi=" + facDivi +
                ", diff=" + diff +
                ", tendency=" + tendency +
                '}';
    }
}
