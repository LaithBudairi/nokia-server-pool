package application.config;

import com.aerospike.client.AerospikeClient;

import java.io.IOException;
import java.util.Properties;

public class AeroSpikeConfig {

    private static AerospikeClient client;

    private AeroSpikeConfig() {

    }

    public static AerospikeClient getAeroSpikeClient() throws IOException {
        if(client == null) {
            synchronized (AeroSpikeConfig.class) {
                if(client == null) {
                    Properties properties = new Properties();
                    properties.load(AeroSpikeConfig.class.getClassLoader().getResourceAsStream("application.properties"));
                    client = new AerospikeClient(properties.getProperty("host"), Integer.parseInt(properties.getProperty("port")));
                    client = new AerospikeClient("172.28.128.3", 3000);

                }
            }
        }
        return client;
    }
}