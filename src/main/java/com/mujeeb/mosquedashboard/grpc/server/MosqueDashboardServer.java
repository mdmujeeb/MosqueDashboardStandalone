package com.mujeeb.mosquedashboard.grpc.server;

import java.io.IOException;


import io.grpc.Server;
import io.grpc.ServerBuilder;

public class MosqueDashboardServer {
	
	protected int port;
	protected Server server;

	public MosqueDashboardServer(int port) {
	  this.port = port;
	  server = ServerBuilder.forPort(port).addService(new MosqueDashboardService()).build();
	}
	
	public void start() throws IOException {
	  server.start();
	  System.out.println("Server started, listening on " + port);
	}
}
