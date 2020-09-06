package parser;

import lombok.NoArgsConstructor;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@NoArgsConstructor
public class PropertiesParser {

    public Properties loadProperties() {
        InputStream inputStream = getClass().getResourceAsStream("/config.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            System.out.println("Error trying to load config.properties");
            System.exit(1);
        }
        return properties;
    }


}
