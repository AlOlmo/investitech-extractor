package extractor;

import extractor.entities.CompaniesResponse;
import extractor.entities.Company;
import extractor.entities.StockValue;
import extractor.entities.ValuesResponse;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Extractor {

    private BMEApiConnector bmeApiConnector = new BMEApiConnector();

    public List<Company> getCompanies(String tradingSystem) {
        boolean fin = false;
        int page = 0;
        List<Company> result = new ArrayList<>();
        while(!fin) {
            System.out.println("Obteniendo página " + page);
            CompaniesResponse companiesResponse = bmeApiConnector.getCompanies(tradingSystem, page);
            result.addAll(Arrays.asList(companiesResponse.getData()));
            fin = !companiesResponse.isHasMoreResults();
            page++;
        }
        return result;
    }

    public List<StockValue> getValues(LocalDate dateFrom, LocalDate dateTo, String isin) {
        String dateFromFormatted = dateFrom.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String dateToFormatted = dateTo.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        boolean fin = false;
        int page = 0;
        List<StockValue> result = new ArrayList<>();
        while(!fin) {
            System.out.println("Obteniendo página " + page);
            ValuesResponse valuesResponse = bmeApiConnector.getValues(dateFromFormatted, dateToFormatted, isin, page);
            result.addAll(Arrays.asList(valuesResponse.getData()));
            fin = !valuesResponse.isHasMoreResults();
            page++;
        }
        return result;

    }
}
