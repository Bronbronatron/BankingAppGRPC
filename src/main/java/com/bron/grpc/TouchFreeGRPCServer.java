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
		
		
		TouchFreeGRPCServer touchServer = new TouchFreeGRPCServer(); 
		int port_2 = 9098;
		String service_type_2 = "_grpc._tcp.local.TouchFree.";
		String service_name_2 = "GrpcServer2";
		SimpleServiceRegistration ssr2 = new SimpleServiceRegistration();
		ssr2.run(port_2, service_type_2, service_name_2);
		
		try {
		
		Server TouchFreeServer = ServerBuilder.forPort(port_2 ).addService(new TouchFreeService()).build();
		
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
	    
	    logger.info("Server started, listening on " + port_2);
	    
		}	    
	   
	}