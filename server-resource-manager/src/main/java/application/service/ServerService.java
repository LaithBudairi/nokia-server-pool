package application.service;

import application.model.Server;

public interface ServerService {

    Server createAllocateServer(int size);
    Server AllocateServer(int size);
}
