package application.service.impl;

import application.config.AeroSpikeConfig;
import application.model.Server;
import application.service.ServerService;
import com.aerospike.client.AerospikeClient;

import java.io.IOException;

public class ServerServiceImpl implements ServerService {

    AerospikeClient client = AeroSpikeConfig.getAeroSpikeClient();

    public ServerServiceImpl() throws IOException { }

    @Override
    public Server createAllocateServer(int size) {
        return new Server("1321DWAQ21A", 12);
    }

    @Override
    public Server AllocateServer(int size) {
        return new Server("1321DWAQ21A", 12);
    }
}
