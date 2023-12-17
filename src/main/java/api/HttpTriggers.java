package api;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import model.Company;
import model.StockValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HttpTriggers {

    private final String COMPANIES_ENDPOINT = "companies";
    private final String STOCK_VALUES_ENDPOINT = "stock-values";

    @FunctionName(COMPANIES_ENDPOINT)
    public List<Company> getCompanies(
            @HttpTrigger(name = COMPANIES_ENDPOINT, methods = {HttpMethod.GET}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<Company>> request,
            ExecutionContext context
    ) {
        Company company = new Company();
        company.setName("Test company");
        List<Company> result = new ArrayList<>();
        result.add(company);
        return result;
    }

    @FunctionName(STOCK_VALUES_ENDPOINT)
    public List<StockValue> getStockValues(
            @HttpTrigger(name = STOCK_VALUES_ENDPOINT, methods = {HttpMethod.GET}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<StockValue>> request,
            ExecutionContext context
    ) {
        StockValue value = new StockValue();
        value.setDate("Test Stock Value");
        List<StockValue> result = new ArrayList<>();
        result.add(value);
        return result;
    }

}
