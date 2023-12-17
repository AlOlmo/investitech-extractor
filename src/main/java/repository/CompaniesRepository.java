package repository;

import model.Company;

import java.sql.*;
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

    public List<Company> selectAll() {
        return null; //TODO: Implementar
    }

    private String buildConnectionString() {
        return String.format(
                "jdbc:sqlserver://%s:%s;database=proyectoPFCDatabase;user=%s@proyecto-pfc-database-server;password=%s;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;",
                this.host, this.port, this.user, this.pass
                );
    }
}
