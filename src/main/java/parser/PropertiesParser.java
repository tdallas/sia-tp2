package parser;

import lombok.NoArgsConstructor;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@NoArgsConstructor
public class PropertiesParser {

    public Properties loadProperties() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/config.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        return properties;
    }


}
