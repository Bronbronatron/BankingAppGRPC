package BankingApp;

import com.bron.grpc.BudgetGrpc.BudgetImplBase;

import java.util.Random;

import com.bron.grpc.lowBudgetAlert;
import com.bron.grpc.moneySpent;
import com.bron.grpc.remainingBudgetStream;
import com.bron.grpc.requestRemainingbudget;
import com.bron.grpc.updatedBudget;
import com.bron.grpc.updatedBudgetConfirmation;

import io.grpc.stub.StreamObserver;

public class BankingAppService extends BudgetImplBase {

	Random rand = new Random();
	
	//pick random number between 20 and 200, round to 2 decimal places
	//Example:
	// (.3621*180) = 65.178 + 20 =85.178 *100 = 8517.8(math.round) 8518/100 = 85.18
	
	double EatingOut = Math.round(100*(rand.nextDouble() * 180 + 20))/100;
	double Groceries = Math.round(100*(rand.nextDouble() * 180 + 20))/100;
	double Other = Math.round(100*(rand.nextDouble() * 180 + 20))/100;
	double Clothes = Math.round(100*(rand.nextDouble() * 180 + 20))/100;

	@Override
	public void getBudgetWarning(moneySpent request, StreamObserver<lowBudgetAlert> responseObserver) {

		String serviceType = request.getCatagoryName();
		double moneySpent = request.getCost();
		lowBudgetAlert.Builder lowBudget = lowBudgetAlert.newBuilder();

		if (serviceType.equalsIgnoreCase("EatingOut")) {
			EatingOut = EatingOut - moneySpent;
			if (EatingOut < 20.0) {
				lowBudget.setNearingBudgetAlert("You have less than €20 left in EatingOut budget");
				responseObserver.onNext(lowBudget.build());
			} else {
				return;
			}
		}

		else if (serviceType.equalsIgnoreCase("Groceries")) {
			Groceries = Groceries - moneySpent;
			if (Groceries < 20.0) {
				lowBudget.setNearingBudgetAlert("You have less than €20 left in Groceries budget");
				responseObserver.onNext(lowBudget.build());
			} else {
				return;
			}
		}

		else if (serviceType.equalsIgnoreCase("Clothes")) {
			Clothes = Clothes - moneySpent;
			if (Clothes < 20.0) {
				lowBudget.setNearingBudgetAlert("You have less than €20 left in Clothes budget");
				responseObserver.onNext(lowBudget.build());
			}

			else {
				return;
			}
	}

		else {
			Other = Other - moneySpent;
			if (Other < 20.0) {
				lowBudget.setNearingBudgetAlert("You have less than €20 left in Other budget");
				responseObserver.onNext(lowBudget.build());
			} else {
					return;
					
				}
			}
		

		responseObserver.onCompleted();
	}


	@Override
	public void getRemainingBudget(requestRemainingbudget request,
			StreamObserver<remainingBudgetStream> responseObserver) {
		boolean requestRemainingBudget = request.getRequestRemainingbudget();

		if (requestRemainingBudget == true) {

			remainingBudgetStream reply1 = remainingBudgetStream.newBuilder().setCat("EatingOut").setBudget(EatingOut)
					.build();
			
			responseObserver.onNext(reply1);

			try {
				// wait for a second
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			remainingBudgetStream reply2 = remainingBudgetStream.newBuilder().setCat("Groceries").setBudget(Groceries)
					.build();
			
			responseObserver.onNext(reply2);
			
			try {
				// wait for a second
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			remainingBudgetStream reply3 = remainingBudgetStream.newBuilder().setCat("Clothes").setBudget(Clothes).build();
			responseObserver.onNext(reply3);
			
			try {
				// wait for a second
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			remainingBudgetStream reply4 = remainingBudgetStream.newBuilder().setCat("Other").setBudget(Other).build();
			responseObserver.onNext(reply4);
			try {
				// wait for a second
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		responseObserver.onCompleted();
	}

	@Override
	public StreamObserver<updatedBudget> updateBugdet(StreamObserver<updatedBudgetConfirmation> responseObserver) {

		System.out.println("inside streaming implementation");

		StreamObserver<updatedBudget> request = new StreamObserver<updatedBudget>() {

			@Override
			public void onNext(updatedBudget value) {
				// TODO Auto-generated method stub
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
			public void onError(Throwable t) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onCompleted() {
				updatedBudgetConfirmation.Builder Confirmation = updatedBudgetConfirmation.newBuilder();
				Confirmation.setCat("You have sucessfully updated your budget!");
				responseObserver.onNext(Confirmation.build());
				responseObserver.onCompleted();
			}

		};
		return request;

	}

	@Override
	public StreamObserver<com.bron.grpc.setBudget> setBudget(StreamObserver<com.bron.grpc.setBudget> responseObserver) {

		StreamObserver<com.bron.grpc.setBudget> requestObserver = new StreamObserver<com.bron.grpc.setBudget>() {

			@Override
			public void onNext(com.bron.grpc.setBudget value) {
				String OriginalCat = value.getOriginalCat();
				double OriginalBudget = value.getOriginalBudget();
				if (OriginalCat.equalsIgnoreCase("EatingOut")) {
					EatingOut = OriginalBudget;
				} else if ((OriginalCat.equalsIgnoreCase("Clothes"))) {
					Clothes = OriginalBudget;
				}

				else if ((OriginalCat.equalsIgnoreCase("Groceries"))) {
					Groceries = OriginalBudget;
				}

				else {
					Other = OriginalBudget;
				}

				com.bron.grpc.setBudget message = com.bron.grpc.setBudget.newBuilder().setOriginalCat(OriginalCat)
						.setOriginalBudget(OriginalBudget).build();
				responseObserver.onNext(message);
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				// do nothing
			}

			@Override
			public void onCompleted() {
				responseObserver.onCompleted();

			}
		};
		return requestObserver;
	}
}
