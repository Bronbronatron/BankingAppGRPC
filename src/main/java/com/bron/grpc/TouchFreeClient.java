package com.bron.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class TouchFreeClient {

	

	public static void main(String[] args) {
		
	   TouchFreeClient touch = new TouchFreeClient();
	   touch.run();

	}
		
    private void run() {
    	
    	ManagedChannel TouchChannel = ManagedChannelBuilder.forAddress("LocalHost2", 9098).usePlaintext().build();		
    	doTouchFreeUnaryCall(TouchChannel);
			
			
			}
    
    
    
	private void doTouchFreeUnaryCall(ManagedChannel channel) {

		touchFreeATMGrpc.touchFreeATMBlockingStub TouchFreeBudgetStub = touchFreeATMGrpc.newBlockingStub(channel);

		inputPin pin = inputPin.newBuilder().setPinNumber(1111).build();

		// call rpc and get back a response
		authenticationMessage message = TouchFreeBudgetStub.authenticateCard(pin);
		
		// print the result
		System.out.println(message.getWelcomeMessage());

	}

}