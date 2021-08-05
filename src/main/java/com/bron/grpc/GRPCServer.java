package com.bron.grpc;

import java.io.IOException;
import java.util.logging.Logger;

import BankingApp.BankingAppService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GRPCServer {
	
	
	private static final Logger logger = Logger.getLogger(GRPCServer.class.getName());
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		GRPCServer budgetServer = new GRPCServer(); 
		int port = 9097;
		String service_type = "_grpc._tcp.local.";
		String service_name = "GrpcServer";
		JMDNS.SimpleServiceRegistration ssr = new JMDNS.SimpleServiceRegistration();
		ssr.run(port, service_type, service_name);

		
	try {
	Server server = ServerBuilder.forPort(port).addService(new BankingAppService()).build(); 
	
	server.start();
	
	System.out.println("Server started at " + server.getPort());
	
	server.awaitTermination();
	
	//if error
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    logger.info("Server started, listening on " + port);
    
	}	    
   
}