package api;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import extractor.entities.Company;
import repositories.entities.CompanyV2;
import extractor.entities.StockValue;
import repositories.entities.StockValueV2;
import repositories.CompaniesRepository;
import repositories.ValuesRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class HttpTriggers {

    private final CompaniesRepository companiesRepository = CompaniesRepository.fromEnvVariables();
    private final ValuesRepository valuesRepository = ValuesRepository.fromEnvVariables();

    private static final String COMPANIES_ENDPOINT = "companies";
    private static final String STOCK_VALUES_ENDPOINT = "stockvalues";

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
