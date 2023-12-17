package repositories;

import extractor.entities.Company;
import repositories.entities.CompanyV2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompaniesRepository {

    private final String host;
    private final String port;
    private final String user;
    private final String pass;

    public CompaniesRepository(String host, String port, String user, String pass) {
        this.host = host;
        this.port = port;
        this.user = user;
        this.pass = pass;
    }


    public static CompaniesRepository fromEnvVariables() {
        String host = System.getenv().get("DATABASE_HOST");
        String port = System.getenv().get("DATABASE_PORT");
        String user = System.getenv().get("DATABASE_USER");
        String pass = System.getenv().get("DATABASE_PASS");
        return new CompaniesRepository(host, port, user, pass);
    }

    public void save(List<Company> companies) throws SQLException {
        String query = "INSERT INTO dbo.companies(name, isin, sector, subsector, tradingSystem, indices) VALUES ( ?, ?, ?, ?, ?, ?)";
        Connection connection = DriverManager.getConnection(buildConnectionString());
        PreparedStatement statement = connection.prepareStatement(query);
        for (Company company : companies) {
            statement.setString(1, company.getName());
            statement.setString(2, company.getIsin());
            statement.setString(3, company.getSector());
            statement.setString(4, company.getSubsector());
            statement.setString(5, company.getTradingSystem());
            statement.setString(6, company.getIndices());
            statement.addBatch();
        }
        statement.executeBatch();
        statement.close();
        connection.close();
    }


    public List<CompanyV2> selectAll() throws SQLException {
        List<CompanyV2> result = new ArrayList<>();

        String query = "SELECT * FROM dbo.companies";
        Connection connection = DriverManager.getConnection(buildConnectionString());
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(query);

        while (resultset.next()) {
            CompanyV2 company = new CompanyV2();
            company.setName(resultset.getString("name"));
            company.setSymbol(resultset.getString("symbol"));
            result.add(company);
        }

        return result;
    }

    private String buildConnectionString() {
        return String.format(
                "jdbc:sqlserver://%s:%s;database=proyectoPFCDatabase;user=%s@proyecto-pfc-database-server;password=%s;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;",
                this.host, this.port, this.user, this.pass
                );
    }
}
