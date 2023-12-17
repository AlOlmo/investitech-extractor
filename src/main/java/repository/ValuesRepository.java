package repository;

import model.StockValue;
import model.StockValueV2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// TODO: Implementar todo, parecido a CompaniesRepository
public class ValuesRepository {

    private final String host;
    private final String port;
    private final String user;
    private final String pass;

    public ValuesRepository(String host, String port, String user, String pass) {
        this.host = host;
        this.port = port;
        this.user = user;
        this.pass = pass;
    }


    public static ValuesRepository fromEnvVariables() {
        String host = System.getenv().get("DATABASE_HOST");
        String port = System.getenv().get("DATABASE_PORT");
        String user = System.getenv().get("DATABASE_USER");
        String pass = System.getenv().get("DATABASE_PASS");
        return new ValuesRepository(host, port, user, pass);
    }


    public List<StockValueV2> selectValues() throws SQLException {
        List<StockValueV2> result = new ArrayList<>();

        String query = "SELECT * FROM [dbo].[values]";
        Connection connection = DriverManager.getConnection(buildConnectionString());
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(query);

        while (resultset.next()) {
            StockValueV2 values = new StockValueV2();
            values.setSymbol(resultset.getString("symbol"));
            values.setDate(resultset.getString("date"));
            values.setPrice(resultset.getDouble("price"));
            values.setVariation(resultset.getDouble("variation"));
            values.setMax_value(resultset.getDouble("max_value"));
            values.setMin_value(resultset.getDouble("min_value"));
            values.setOpen_value(resultset.getDouble("open_value"));

            result.add(values);
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
