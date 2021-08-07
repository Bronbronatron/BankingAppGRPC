package BankingApp;

import com.bron.grpc.authenticationMessage;
import com.bron.grpc.availableMachines;
import com.bron.grpc.inputPin;
import com.bron.grpc.remainingBudgetStream;
import com.bron.grpc.searchATM;
import com.bron.grpc.touchFreeATMGrpc.touchFreeATMImplBase;

import io.grpc.stub.StreamObserver;

public class TouchFreeService extends touchFreeATMImplBase {

	@Override
	public void authenticateCard(inputPin request, StreamObserver<authenticationMessage> responseObserver) {
		
		int pin = request.getPinNumber();
		
		int realPin = 8975;
		
		authenticationMessage.Builder auth = authenticationMessage.newBuilder();
		
		if (pin == realPin) {
			//set the isCorrectPin and welcomeMessage
			auth.setIsCorrectPin(true).setWelcomeMessage("Welcome!");
			
		}	
		
		else {
			
			auth.setIsCorrectPin(false).setWelcomeMessage("Invalid Pin");		
		}
		//build response 
		responseObserver.onNext(auth.build());
		
		//complete rpc call
		responseObserver.onCompleted();
	}

	@Override
	public void findNearByATM(searchATM request, StreamObserver<availableMachines> responseObserver) {
		boolean Find  = request.getSearchATM();
		
		if (Find==true) {
			try {
		//Set and build message 1
			availableMachines MachineReply1 = availableMachines.newBuilder().setMachine("AIB").setDistance(1.8f).build();	
			responseObserver.onNext(MachineReply1);

			
				// wait for a second
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
		//Set and build message 2
			availableMachines MachineReply2 = availableMachines.newBuilder().setMachine("Bank of Ireland").setDistance(0.3f).build();	
			responseObserver.onNext(MachineReply2);
			
			
				// wait for a second
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
			
			//Set and build message 2
			availableMachines MachineReply3 = availableMachines.newBuilder().setMachine("Ulster Bank").setDistance(0.1f).build();	
			responseObserver.onNext(MachineReply3);
			
			
				// wait for a second
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		//End Stream
		responseObserver.onCompleted();
	}	
			
			
		}
	

}
