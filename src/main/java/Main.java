import model.Company;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        /*Extractor extractor = new Extractor();
        LocalDate dateFrom = LocalDate.of(2023, 1, 23);
        LocalDate dateTo = LocalDate.of(2023, 8, 24);
        List<StockValue> values = extractor.getValues(dateFrom, dateTo, "ES0125220311");
        System.out.println(values);*/

        Extractor extractor = new Extractor();
        List<Company> companies = extractor.getCompanies("SIBE");
        for (Company company : companies) {
            if (company.getIndices().matches(".*IBEX 35.*")) {
                System.out.println(company);
            }
        }
        //companies.forEach(System.out::println);

        /*
        model.ValuesResponse valuesResponse = bme.getValues();
        System.out.println(valuesResponse);
         */
    }
}

