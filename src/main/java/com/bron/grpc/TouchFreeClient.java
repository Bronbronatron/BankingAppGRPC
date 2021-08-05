package com.bron.grpc;

import javax.jmdns.ServiceInfo;

import JMDNS.SimpleServiceDiscovery;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class TouchFreeClient {

	public static void main(String[] args) {

		ServiceInfo serviceInfo;

		// must correspond to server file
		String service_type_2 = "_grpc._tcp.local.TouchFree.";

		// Get the service info by supplying service type
		serviceInfo = SimpleServiceDiscovery.run(service_type_2);

		// Use the serviceInfo to retrieve the port
		int port_2 = serviceInfo.getPort();

		String host_2 = "LocalHost";
		// int port = 9098;

		TouchFreeClient touch = new TouchFreeClient();
		ManagedChannel TouchChannel = ManagedChannelBuilder.forAddress(host_2, port_2).usePlaintext().build();

		
		//Obsolete 
		// touch.run();
		// }
		// private void run() {
		
		//Call methods 
	//	touch.doTouchFreeUnaryCall(TouchChannel);
		touch.doServerStreamingCall(TouchChannel);

	}

	private void doTouchFreeUnaryCall(ManagedChannel channel) {

		touchFreeATMGrpc.touchFreeATMBlockingStub TouchFreeStub = touchFreeATMGrpc.newBlockingStub(channel);

		inputPin pin = inputPin.newBuilder().setPinNumber(1111).build();

		// call rpc and get back a response
		authenticationMessage message = TouchFreeStub.authenticateCard(pin);

		// print the result
		System.out.println(message.getWelcomeMessage());

	}

	private void doServerStreamingCall(ManagedChannel channel) {

		touchFreeATMGrpc.touchFreeATMBlockingStub TouchFreeStub = touchFreeATMGrpc.newBlockingStub(channel);

		searchATM Search = searchATM.newBuilder().setSearchATM(true).build();
		
		//For each machine found print name and distance from user
		TouchFreeStub.findNearByATM(Search).forEachRemaining(availableMachines -> {

			System.out.println( "ATM name: " + availableMachines.getMachine() + " Distance in km: " + availableMachines.getDistance());

		});
		channel.shutdown();

	}

}
