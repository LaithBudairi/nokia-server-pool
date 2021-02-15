package application.service;

import application.model.Server;

public interface ServerService {

    Server createServer();
    Server AllocateServer(int size);
}
