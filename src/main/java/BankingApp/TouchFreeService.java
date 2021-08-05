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
			
			auth.setIsCorrectPin(true).setWelcomeMessage("Welcome!");
			
		}	
		
		else {
			
			auth.setIsCorrectPin(false).setWelcomeMessage("Invalid Pin");		
		}
		
		responseObserver.onNext(auth.build());
		responseObserver.onCompleted();
	}

	@Override
	public void findNearByATM(searchATM request, StreamObserver<availableMachines> responseObserver) {
		boolean Find  = request.getSearchATM();
		
		if (Find==true) {
		
			//Message 1
			availableMachines MachineReply1 = availableMachines.newBuilder().setMachine("AIB").setDistance(1.8f).build();	
			responseObserver.onNext(MachineReply1);

			try {
				// wait for a second
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Message 2
			availableMachines MachineReply2 = availableMachines.newBuilder().setMachine("Bank of Ireland").setDistance(0.3f).build();	
			responseObserver.onNext(MachineReply2);
			
			try {
				// wait for a second
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Message 3
			availableMachines MachineReply3 = availableMachines.newBuilder().setMachine("Ulster Bank").setDistance(0.1f).build();	
			responseObserver.onNext(MachineReply3);
			
			try {
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
