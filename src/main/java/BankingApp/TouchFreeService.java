package BankingApp;

import com.bron.grpc.authenticationMessage;
import com.bron.grpc.inputPin;
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
	

}
