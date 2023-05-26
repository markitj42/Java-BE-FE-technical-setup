package common.util;

import java.io.IOException;
import java.util.Properties;

public class TestData {
    private final Properties properties;
    private static final String FILENAME = "test_data.properties";
    private static TestData instance = null;
    public static TestData getInstance() throws IOException {
        if(instance == null) {
            instance = new TestData();
        }
        return instance;
    }
    private TestData() throws IOException {
        properties = new Properties();
        properties.load(getClass().getClassLoader().getResourceAsStream(FILENAME));
    }

    public String getValue(String key) {
        return properties.getProperty(key);
    }
}
