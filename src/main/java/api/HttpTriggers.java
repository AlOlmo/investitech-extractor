package api;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import model.Company;
import model.CompanyV2;
import model.StockValue;
import model.StockValueV2;
import repository.CompaniesRepository;
import repository.ValuesRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HttpTriggers {

    private final String COMPANIES_ENDPOINT = "companies";
    private final String STOCK_VALUES_ENDPOINT = "stock-values";

    private CompaniesRepository companiesRepository = CompaniesRepository.fromEnvVariables();
    private ValuesRepository valuesRepository = ValuesRepository.fromEnvVariables();

    @FunctionName(COMPANIES_ENDPOINT)
    public List<CompanyV2> getCompanies(
            @HttpTrigger(name = COMPANIES_ENDPOINT, methods = {HttpMethod.GET}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<Company>> request,
            ExecutionContext context
    ) throws SQLException {
        return companiesRepository.selectAll();
    }

    @FunctionName(STOCK_VALUES_ENDPOINT)
    public List<StockValueV2> getStockValues(
            @HttpTrigger(name = STOCK_VALUES_ENDPOINT, methods = {HttpMethod.GET}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<StockValue>> request,
            ExecutionContext context
    ) throws SQLException {
        return valuesRepository.selectValues();
    }

}
