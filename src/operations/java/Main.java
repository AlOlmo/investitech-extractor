import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {

    }

    public static void setDatabaseCredentials() throws IOException {
        Properties properties = new Properties();
        properties.load(Main.class.getResourceAsStream("credentials.properties"));
        properties.forEach((key, value) -> setEnv(
                (String) key,
                (String) value
        ));
    }

    public static void setEnv(String key, String value) {
        try {
            Map<String, String> env = System.getenv();
            Class<?> cl = env.getClass();
            Field field = cl.getDeclaredField("m");
            field.setAccessible(true);
            Map<String, String> writableEnv = (Map<String, String>) field.get(env);
            writableEnv.put(key, value);
        } catch (Exception e) {
            throw new IllegalStateException("Failed to set environment variable", e);
        }
    }
}

