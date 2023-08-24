package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CompaniesResponse {

    private Company[] data;
    private boolean hasMoreResults;

    // Getters - Setters
    public Company[] getData() {
        return data;
    }

    public void setData(Company[] data) {
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
        return "model.CompaniesResponse{" +
                "data=" + Arrays.toString(data) +
                ", hasMoreResults=" + hasMoreResults +
                '}';
    }
}
