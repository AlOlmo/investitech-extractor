package extractor;

import com.fasterxml.jackson.databind.ObjectMapper;
import extractor.entities.CompaniesResponse;
import extractor.entities.ValuesResponse;
import org.apache.hc.client5.http.fluent.Request;
import org.apache.hc.core5.util.Timeout;

public class BMEApiConnector {

    private static final String BASE_URL = "https://www.bolsasymercados.es/API/Market/v1/EQ/";
    private static final int PAGE_SIZE = 100;
    private ObjectMapper objectMapper = new ObjectMapper();

    public CompaniesResponse getCompanies(String tradingSystem, int page) {

        try {
            String url = BASE_URL +"ListedCompanies?tradingSystem=" + tradingSystem + "&page=" +page+ "&pageSize=" + PAGE_SIZE;
            String response = Request.get(url)
                    .connectTimeout(Timeout.ofSeconds(1))
                    .responseTimeout(Timeout.ofSeconds(5))
                    .execute().returnContent().asString();

            return objectMapper.readValue(response, CompaniesResponse.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ValuesResponse getValues(String dateFrom, String dateTo, String isin, int page) {

        try {
            String url = BASE_URL +"HistoricalSharesPrices?from=" + dateFrom + "&to=" + dateTo + "&type=V&isin=" +isin+ "&page=" +page+ "&pageSize=" + PAGE_SIZE;
            String response = Request.get(url)
                    .connectTimeout(Timeout.ofSeconds(1))
                    .responseTimeout(Timeout.ofSeconds(5))
                    .execute().returnContent().asString();

            return objectMapper.readValue(response, ValuesResponse.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
