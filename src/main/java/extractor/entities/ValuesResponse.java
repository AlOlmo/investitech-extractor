package extractor.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)

public class ValuesResponse {

    private Details details;
    private StockValue[] data;
    private boolean hasMoreResults;

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    public StockValue[] getData() {
        return data;
    }

    public void setData(StockValue[] data) {
        this.data = data;
    }

    public boolean isHasMoreResults() {
        return hasMoreResults;
    }

    public void setHasMoreResults(boolean hasMoreResults) {
        this.hasMoreResults = hasMoreResults;
    }

    @Override
    public String toString() {
        return "extractor.entities.ValuesResponse{" +
                "details=" + details +
                ", data=" + Arrays.toString(data) +
                ", hasMoreResults=" + hasMoreResults +
                '}';
    }
}
