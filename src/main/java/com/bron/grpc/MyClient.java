package com.bron.grpc;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

import javax.jmdns.ServiceInfo;

import com.bron.grpc.BudgetGrpc.BudgetBlockingStub;

import JMDNS.SimpleServiceDiscovery;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class MyClient {

	public static void main(String[] args) {

		ServiceInfo serviceInfo;

		// must correspond to server file
		String service_type = "_grpc._tcp.local.";

		// Get the service info by supplying service type

		serviceInfo = SimpleServiceDiscovery.run(service_type);
		// Get port using serviceInfo
		int port = serviceInfo.getPort();
		String host = "LocalHost";
		// int port = 9097;

		MyClient main = new MyClient();
		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		// main.run();

		// main.doUnaryCall(channel);
		// doBiDiStreamingCall(channel);
		main.doServerStreamingCall(channel);
		// main.doClientStreamingCall(channel);
		channel.shutdown();
	}



	private void doClientStreamingCall(ManagedChannel channel) {
		
		//create async stub
		//blocking stub won't work 
		BudgetGrpc.BudgetStub asyncClient = BudgetGrpc.newStub(channel);
		//create response observer 
		StreamObserver<updatedBudgetConfirmation> responseObserver = new StreamObserver<updatedBudgetConfirmation>() {

			@Override
			//we get only one response from server 
			public void onNext(updatedBudgetConfirmation msg) {
				System.out.println("receiving updated budget " + msg.getCat());
			}

			@Override
			//we get an error from the server
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			//the server is done sending data
			//onCompleted is called right after onNext
			public void onCompleted() {
				System.out.println("Stream is completed");
			}

		};
		
		//build messages
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
			//receive response from server
			requestObserver.onCompleted();

			Thread.sleep(10000);

		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private void doServerStreamingCall(ManagedChannel channel) {
		// create blocking stub
		BudgetGrpc.BudgetBlockingStub BudgetStub = BudgetGrpc.newBlockingStub(channel);

		// set and build request
		requestRemainingbudget Remainingbudget = requestRemainingbudget.newBuilder().setRequestRemainingbudget(true)
				.build();

		// pass in request and call method
		// use iterator to stream responses in blocking manner
		BudgetStub.getRemainingBudget(Remainingbudget).forEachRemaining(remainingBudgetStream -> {

			System.out.println(remainingBudgetStream.getCat() + " Budget: " + remainingBudgetStream.getBudget());

		});
		
		channel.shutdown();

	}

	private void doUnaryCall(ManagedChannel channel) {

		String CatagoryName = "EatingOut";

		// generate blocking stub
		BudgetGrpc.BudgetBlockingStub BudgetStub = BudgetGrpc.newBlockingStub(channel);

		// build request
		moneySpent moneyspent = moneySpent.newBuilder().setCatagoryName(CatagoryName).setCost(5).build();

		// call method by passing in request, and get back response
		lowBudgetAlert budgetalert = BudgetStub.getBudgetWarning(moneyspent);

		// print the result
		System.out.println(budgetalert.getNearingBudgetAlert());

	}

	private void doBiDiStreamingCall(ManagedChannel channel) {
		
		//create async stub
		//blocking stub won't work 

		BudgetGrpc.BudgetStub asyncClient = BudgetGrpc.newStub(channel);
		
		//using a CountDownLatch to sleep instead
		CountDownLatch latch = new CountDownLatch(1);
		

		StreamObserver<setBudget> responseObserver = new StreamObserver<setBudget>() {
			@Override
			public void onNext(setBudget value) {
				//for every request from client set and build response
				System.out.println("You Have set Budget!" + " \n Catagory: " + value.getOriginalCat() + "- Budget: "
						+ value.getOriginalBudget());

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
		
		//return request observer 
		StreamObserver<setBudget> requestObserver = asyncClient.setBudget(responseObserver);
		//every time we receive a request from server, send back a reponse
		try {
			//construct request
			requestObserver.onNext(setBudget.newBuilder().setOriginalCat("EatingOut").setOriginalBudget(99).build());
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
