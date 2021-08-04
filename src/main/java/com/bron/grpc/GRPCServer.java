package com.bron.grpc;

import java.io.IOException;

import BankingApp.BankingAppService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GRPCServer {

	public static void main(String[] args) throws IOException, InterruptedException {
	Server server = ServerBuilder.forPort(9097).addService(new BankingAppService()).build(); 
	
	server.start();
	
	System.out.println("Server started at " + server.getPort());
	
	server.awaitTermination();
	
	}

}
