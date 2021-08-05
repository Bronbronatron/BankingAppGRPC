package com.bron.grpc;

import java.io.IOException;
import java.util.logging.Logger;

import BankingApp.TouchFreeService;
import JMDNS.SimpleServiceRegistration;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class TouchFreeGRPCServer{
	
	private static final Logger logger = Logger.getLogger(TouchFreeGRPCServer.class.getName());
	
	
	public static void main(String[] args) throws IOException {
		
		int port = 9098;
		String service_type = "_grpc._tcp.local.2";
		String service_name = "GrpcServer2";
		SimpleServiceRegistration ssr2 = new SimpleServiceRegistration();
		ssr2.run(port, service_type, service_name);
	
		try {
		
		Server TouchFreeServer = ServerBuilder.forPort(port).addService(new TouchFreeService()).build();
		
		TouchFreeServer.start();
		System.out.println("Server started at " + TouchFreeServer.getPort());
		
		TouchFreeServer.awaitTermination();

		
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