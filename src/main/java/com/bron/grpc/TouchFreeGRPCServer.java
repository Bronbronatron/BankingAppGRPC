package com.bron.grpc;

import java.io.IOException;

import BankingApp.TouchFreeService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class TouchFreeGRPCServer{
	
	public static void main(String[] args) throws IOException {
		
		Server TouchFreeServer = ServerBuilder.forPort(9098).addService(new TouchFreeService()).build();
		
		TouchFreeServer.start();
		System.out.println("Server started at " + TouchFreeServer.getPort());
	}
	
}