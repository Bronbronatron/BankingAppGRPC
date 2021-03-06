package bankingAppServices;

import com.bron.grpc.BudgetGrpc.BudgetImplBase;

import java.util.Random;

import com.bron.grpc.lowBudgetAlert;
import com.bron.grpc.moneySpent;
import com.bron.grpc.remainingBudgetStream;
import com.bron.grpc.requestRemainingbudget;
import com.bron.grpc.updatedBudget;
import com.bron.grpc.updatedBudgetConfirmation;

import io.grpc.stub.StreamObserver;

//import plug-in generated code
public class BankingAppService extends BudgetImplBase {

	Random rand = new Random();
	
	//pick random number between 20 and 200, round to 2 decimal places
	//Example:
	// (.3621*180) = 65.178 + 20 =85.178 *100 = 8517.8(math.round) 8518/100 = 85.18
	
	double EatingOut = Math.round(100*(rand.nextDouble() * 180 + 20))/100;
	double Groceries = Math.round(100*(rand.nextDouble() * 180 + 20))/100;
	double Other = Math.round(100*(rand.nextDouble() * 180 + 20))/100;
	double Clothes = Math.round(100*(rand.nextDouble() * 180 + 20))/100;
	
	//implement unary rpc
	//override getBugdetWarning method 
	@Override
	
	//takes in moneySpent request, does something and send to responseObserver
	public void getBudgetWarning(moneySpent request, StreamObserver<lowBudgetAlert> responseObserver) {
		
		
		//extract fields from moneySpent message
		String serviceType = request.getCatagoryName();
		double moneySpent = request.getCost();
		
		//Generate response
		lowBudgetAlert.Builder lowBudget = lowBudgetAlert.newBuilder();
		
		//If service type inputed = EatingOut, update eatingOut budget 
		if (serviceType.equalsIgnoreCase("EatingOut")) {
			EatingOut = EatingOut - moneySpent;
			//If EatingOut goes below a certain value, show warning message
			if (EatingOut < 20.0) {
				
				//set the nearingBudgetAlertMessage
				lowBudget.setNearingBudgetAlert("\n You have less than €20 left in Eating Out budget");
				//build response and send back to user
				responseObserver.onNext(lowBudget.build());
			//Else no nothing
			} else {
				lowBudget.setNearingBudgetAlert("\n Eating Out budget okay!");
				responseObserver.onNext(lowBudget.build());
			}
		}
		//Else if service type inputed = Groceries, update Groceries budget 
		else if (serviceType.equalsIgnoreCase("Groceries")) {
			Groceries = Groceries - moneySpent;
			if (Groceries < 20.0) {
				//If Groceries bugdet goes below a certain value, show warning message

				//set the nearingBudgetAlertMessage
				lowBudget.setNearingBudgetAlert("\n You have less than €20 left in Groceries budget");
				//build response and send back to user
				responseObserver.onNext(lowBudget.build());
				//Else no nothing
			} else {
				lowBudget.setNearingBudgetAlert("\n Groceries budget okay!");
				responseObserver.onNext(lowBudget.build());
			}
		}
		//Else if service type  = Clothes, update Clothes budget 
		else if (serviceType.equalsIgnoreCase("Clothes")) {
			Clothes = Clothes - moneySpent;
			//If Clothes budget goes below a certain value, show warning message
			if (Clothes < 20.0) {
				lowBudget.setNearingBudgetAlert("\n You have less than €20 left in Clothes budget");
				responseObserver.onNext(lowBudget.build());
			}
			//else do nothing
			else {
				lowBudget.setNearingBudgetAlert("\nClothes Budget okay!");
				responseObserver.onNext(lowBudget.build());
			}
	}

		else {
			//if Service Type inputed = anything else update budget for "Other"
			Other = Other - moneySpent;
			//If Other budget goes below a certain value, show warning message
			if (Other < 20.0) {
				lowBudget.setNearingBudgetAlert("\n You have less than €20 left in Other budget");
				responseObserver.onNext(lowBudget.build());
			} else {
				//else no nothing
				lowBudget.setNearingBudgetAlert("\n Other budget okay!");
				responseObserver.onNext(lowBudget.build());
					
				}
			}
		
		//complete rpc call
		responseObserver.onCompleted();
	}

	//implement server streaming rpc
	//override getRemainingBudget method 
	@Override
	public void getRemainingBudget(requestRemainingbudget request,
			StreamObserver<remainingBudgetStream> responseObserver) {
		boolean requestRemainingBudget = request.getRequestRemainingbudget();
		//if user presses 'Request Remaining Budget
		
		if (requestRemainingBudget == true) {

			try {
		//Set and build message 1
			remainingBudgetStream reply1 = remainingBudgetStream.newBuilder().setCat("EatingOut").setBudget(EatingOut)
					.build();
			//Send response to client using response observer
			responseObserver.onNext(reply1);

			
				// wait for a second
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
			//Set and build message 2
			remainingBudgetStream reply2 = remainingBudgetStream.newBuilder().setCat("Groceries").setBudget(Groceries)
					.build();
			
			responseObserver.onNext(reply2);
			
			
				// wait for a second
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
			//Set and build message 3
			remainingBudgetStream reply3 = remainingBudgetStream.newBuilder().setCat("Clothes").setBudget(Clothes).build();
			responseObserver.onNext(reply3);
			
			
			
				// wait for a second
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
			//Set and build message 4
			remainingBudgetStream reply4 = remainingBudgetStream.newBuilder().setCat("Other").setBudget(Other).build();
			responseObserver.onNext(reply4);
			
				// wait for a second
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		//End Stream
		responseObserver.onCompleted();
	}

	@Override
	public StreamObserver<updatedBudget> updateBugdet(StreamObserver<updatedBudgetConfirmation> responseObserver) {

		System.out.println("inside streaming implementation");
		
		
		//create stream observer  as need to handle requests that come as a stream one by one 
		StreamObserver<updatedBudget> request = new StreamObserver<updatedBudget>() {

			@Override
			public void onNext(updatedBudget value) {
				
				//client sends  a message 
			
				System.out.println("Message received" + value.getYouHaveUpdated() + value.getUpdatedBudget());
				if (value.getYouHaveUpdated().equalsIgnoreCase("EatingOut")) {
					EatingOut = value.getUpdatedBudget();
				} else if (value.getYouHaveUpdated().equalsIgnoreCase("Clothes")) {
					Clothes = value.getUpdatedBudget();
				} else if (value.getYouHaveUpdated().equalsIgnoreCase("Groceries")) {
					Groceries = value.getUpdatedBudget();
				}

				else {
				
					Other = value.getUpdatedBudget();
				}
			}

			@Override
			//client sends an error 

			public void onError(Throwable t) {
				t.printStackTrace();
				
			}

			@Override
			public void onCompleted() {
				//client is done
				//return response using response observer 
				updatedBudgetConfirmation.Builder Confirmation = updatedBudgetConfirmation.newBuilder();
				Confirmation.setCat("You have sucessfully updated your budget!");
				responseObserver.onNext(Confirmation.build());
				responseObserver.onCompleted();
			}

		};
		//returns stream observer 
		return request;

	}

	@Override
	
	
	public StreamObserver<com.bron.grpc.setBudget> setBudget(StreamObserver<com.bron.grpc.setBudget> responseObserver) {
		
		//Create stream observer 
		StreamObserver<com.bron.grpc.setBudget> requestObserver = new StreamObserver<com.bron.grpc.setBudget>() {

			@Override
			public void onNext(com.bron.grpc.setBudget value) {
				
				//Every time a set budget message is received, send response back
				
				//extract value 
				//Extract the values
				String OriginalCat = value.getOriginalCat();
				double OriginalBudget = value.getOriginalBudget();
				
				//if eating out, set Eating out budget to inputed value
				if (OriginalCat.equalsIgnoreCase("EatingOut")) {
					EatingOut = OriginalBudget;
				
				//if clothes, set clothes budget to inputed value	
				} else if ((OriginalCat.equalsIgnoreCase("Clothes"))) {
					Clothes = OriginalBudget;
				}
				
				//if Groceries, set Groceries budget to inputed value
				else if ((OriginalCat.equalsIgnoreCase("Groceries"))) {
					Groceries = OriginalBudget;
				}

				else {
				//else set other budget to inputed value	
					Other = OriginalBudget;
				}
				//Create response 
				com.bron.grpc.setBudget message = com.bron.grpc.setBudget.newBuilder().setOriginalCat(OriginalCat)
						.setOriginalBudget(OriginalBudget).build();
				
				//Send response to client using response observer
				responseObserver.onNext(message);
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onCompleted() {
				responseObserver.onCompleted();

			}
		};
		//returns stream observer 
		
		return requestObserver;
	}
}
