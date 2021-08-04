package com.bron.grpc;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

import com.bron.grpc.BudgetGrpc.BudgetBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class MyClient {

	public static void main(String[] args) {

		MyClient main = new MyClient();

		main.run();
	}

	private void run() {

		ManagedChannel channel = ManagedChannelBuilder.forAddress("LocalHost", 9097).usePlaintext().build();

		// doUnaryCall(channel);
		 doServerStreamingCall(channel);
		// doClientStreamingCall(channel);
	    // doBiDiStreamingCall(channel);
		//channel.shutdown();

	}

	private void doClientStreamingCall(ManagedChannel channel) {

		BudgetGrpc.BudgetStub asyncClient = BudgetGrpc.newStub(channel);
		StreamObserver<updatedBudgetConfirmation> responseObserver = new StreamObserver<updatedBudgetConfirmation>() {

			@Override
			public void onNext(updatedBudgetConfirmation msg) {
				System.out.println("receiving updated budget " + msg.getCat());
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onCompleted() {
				System.out.println("Stream is completed");
			}

		};

		StreamObserver<updatedBudget> requestObserver = asyncClient.updateBugdet(responseObserver);
		try {
			requestObserver
					.onNext(updatedBudget.newBuilder().setYouHaveUpdated("Eating Out").setUpdatedBudget(40).build());
			Thread.sleep(500);

			requestObserver
					.onNext(updatedBudget.newBuilder().setYouHaveUpdated("Clothes").setUpdatedBudget(100).build());
			Thread.sleep(500);

			requestObserver
					.onNext(updatedBudget.newBuilder().setYouHaveUpdated("Groceries").setUpdatedBudget(30).build());
			Thread.sleep(500);

			requestObserver.onNext(updatedBudget.newBuilder().setYouHaveUpdated("Other").setUpdatedBudget(90).build());
			Thread.sleep(500);

			// End of requests
			requestObserver.onCompleted();

			Thread.sleep(10000);

		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	
	

	private void doServerStreamingCall(ManagedChannel channel) {

		BudgetGrpc.BudgetBlockingStub BudgetStub = BudgetGrpc.newBlockingStub(channel);
		
		
		requestRemainingbudget Remainingbudget = requestRemainingbudget.newBuilder().setRequestRemainingbudget(true)
				.build();
		
		BudgetStub.getRemainingBudget(Remainingbudget).forEachRemaining(remainingBudgetStream -> {
			 
			System.out.println(remainingBudgetStream.getCat() + " Budget: " + remainingBudgetStream.getBudget()); 
			
			
		});
			channel.shutdown();
	
	
	}

	
	

	private void doUnaryCall(ManagedChannel channel) {

		BudgetGrpc.BudgetBlockingStub BudgetStub = BudgetGrpc.newBlockingStub(channel);

		moneySpent moneyspent = moneySpent.newBuilder().setCatagoryName("EatingOut").setCost(5).build();

		// call rpc and get back a response
		lowBudgetAlert budgetalert = BudgetStub.getBudgetWarning(moneyspent);

		// print the result
		System.out.println(budgetalert.getNearingBudgetAlert());

	}

	private void doBiDiStreamingCall(ManagedChannel channel) {

		BudgetGrpc.BudgetStub asyncClient = BudgetGrpc.newStub(channel);
		CountDownLatch latch = new CountDownLatch(1);
		// StreamObserver<setBudget> requestObserver = asyncClient.setBudget(new
		// StreamObserver<setBudget>() {

		StreamObserver<setBudget> responseObserver = new StreamObserver<setBudget>() {
			@Override
			public void onNext(setBudget value) {
				System.out.println("Response from server" + value.getOriginalCat() + value.getOriginalBudget());

			}

			@Override
			public void onError(Throwable t) {
				latch.countDown();
			}

			@Override
			public void onCompleted() {
				System.out.println("Server is done sending data");
				latch.countDown();

			}

		};

		StreamObserver<setBudget> requestObserver = asyncClient.setBudget(responseObserver);

		try {

			requestObserver.onNext(setBudget.newBuilder().setOriginalCat("Eating Out").setOriginalBudget(99).build());
			requestObserver.onNext(setBudget.newBuilder().setOriginalCat("Clothes").setOriginalBudget(100).build());
			requestObserver.onNext(setBudget.newBuilder().setOriginalCat("Groceries").setOriginalBudget(87).build());
			requestObserver.onNext(setBudget.newBuilder().setOriginalCat("Other").setOriginalBudget(45.50).build());

			// Mark the end of requests
			requestObserver.onCompleted();

			// Sleep for a bit before sending the next one.
			Thread.sleep(new Random().nextInt(1000) + 500);

		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
