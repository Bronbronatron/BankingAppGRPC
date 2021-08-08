package gui;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.jmdns.ServiceInfo;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.bron.grpc.BudgetGrpc;
import com.bron.grpc.lowBudgetAlert;
import com.bron.grpc.moneySpent;
import com.bron.grpc.requestRemainingbudget;
import com.bron.grpc.setBudget;
import com.bron.grpc.updatedBudget;
import com.bron.grpc.updatedBudgetConfirmation;
import com.bron.grpc.BudgetGrpc.BudgetBlockingStub;
import com.bron.grpc.BudgetGrpc.BudgetStub;

import JMDNS.SimpleServiceDiscovery;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class budgetGUIApplication {

	BudgetGrpc.BudgetBlockingStub Stub;
	BudgetGrpc.BudgetStub asyncStub;

	private JFrame frame;
	private JTextField Catagory1;
	private JTextField Catagory2;
	private JTextField Catagory3;
	private JTextField Catagory4;
	private JTextField Cost1;
	private JTextField Cost2;
	private JTextField Cost3;
	private JTextField Cost4;
	// where we put response into
	private JTextArea textResponse;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					budgetGUIApplication window = new budgetGUIApplication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public budgetGUIApplication() {
		
		
		ServiceInfo serviceInfo;
		
		// must correspond to server file
		String service_type = "_grpc._tcp.local.";

		// Get the service info by supplying service type

		serviceInfo = SimpleServiceDiscovery.run(service_type);
		int port = serviceInfo.getPort();
		String host = "LocalHost";
	
		

		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();

		// stubs -- generate from proto
		Stub = BudgetGrpc.newBlockingStub(channel);
		asyncStub = BudgetGrpc.newStub(channel);

		initialize();

	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Client - Service Controller");
		frame.setBounds(100, 100, 500, 600);
		// closes when "X" is pressed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// determines how components are laid out
		BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);

		frame.getContentPane().setLayout(bl);

		JPanel panel_service_1 = new JPanel();
		frame.getContentPane().add(panel_service_1);
		panel_service_1.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 30));

		// Create new label and add to panel
		JLabel CatLabel_1 = new JLabel("Catagory1");
		JLabel CatLabel_2 = new JLabel("Catagory2");
		JLabel Catlabel_3 = new JLabel("Catagory3");
		JLabel Catlabel_4 = new JLabel("Catagory4");
		JLabel CostLabel_1 = new JLabel("Cost1");
		JLabel CostLabel_2 = new JLabel("Cost2");
		JLabel CostLabel_3 = new JLabel("Cost3");
		JLabel CostLabel_4 = new JLabel("Cost4");

		// Imput Textbox

		panel_service_1.add(CatLabel_1);
		Catagory1 = new JTextField();
		panel_service_1.add(Catagory1);
		Catagory1.setColumns(10);

		panel_service_1.add(CostLabel_1);
		Cost1 = new JTextField();
		panel_service_1.add(Cost1);
		Cost1.setColumns(10);

		panel_service_1.add(CatLabel_2);
		Catagory2 = new JTextField();
		panel_service_1.add(Catagory2);
		Catagory2.setColumns(10);

		panel_service_1.add(CostLabel_2);
		Cost2 = new JTextField();
		panel_service_1.add(Cost2);
		Cost2.setColumns(10);

		panel_service_1.add(Catlabel_3);
		Catagory3 = new JTextField();
		panel_service_1.add(Catagory3);
		Catagory3.setColumns(10);

		panel_service_1.add(CostLabel_3);
		Cost3 = new JTextField();
		panel_service_1.add(Cost3);
		Cost3.setColumns(10);

		panel_service_1.add(Catlabel_4);
		Catagory4 = new JTextField();
		panel_service_1.add(Catagory4);
		Catagory4.setColumns(10);

		panel_service_1.add(CostLabel_4);
		Cost4 = new JTextField();
		panel_service_1.add(Cost4);
		Cost4.setColumns(10);

		JButton B1 = new JButton("Get Budget Warning");
		JButton B2 = new JButton("Get remaining Bugdet");
		JButton B3 = new JButton("Update Bugdet");
		JButton B4 = new JButton("Set Budget");

		// Action Listener is on button
		B1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// Extract data from GUI
				String Cat = Catagory1.getText();
				double num1 = Double.parseDouble(Cost1.getText());

				// double Cost1 = String.valueOf()Cost1.getText());

				// Do some logic with our index or send it over
				moneySpent moneyspent = moneySpent.newBuilder().setCatagoryName(Cat).setCost(num1).build();

				
				lowBudgetAlert budgetalert = Stub.getBudgetWarning(moneyspent);

				
				
				// populate the JtextArea in the panel
				textResponse.append("\n" + budgetalert.getNearingBudgetAlert());
				// print the result
				System.out.println(budgetalert.getNearingBudgetAlert());
				

			}

		});

		B2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// set and build request
				requestRemainingbudget Remainingbudget = requestRemainingbudget.newBuilder()
						.setRequestRemainingbudget(true).build();

				// pass in request and call method
				// use iterator to stream responses in blocking manner
				Stub.getRemainingBudget(Remainingbudget).forEachRemaining(remainingBudgetStream -> {

					textResponse.append(
							remainingBudgetStream.getCat() + " Budget: " + remainingBudgetStream.getBudget() + "\n");
					System.out
							.println(remainingBudgetStream.getCat() + " Budget: " + remainingBudgetStream.getBudget());

				});
			}

		});

		B3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String Cat1 = Catagory1.getText();
				int num1 = Integer.parseInt(Cost1.getText());
				String Cat2 = Catagory2.getText();
				int num2 = Integer.parseInt(Cost2.getText());
				String Cat3 = Catagory3.getText();
				int num3 = Integer.parseInt(Cost3.getText());
				String Cat4 = Catagory4.getText();
				int num4 = Integer.parseInt(Cost4.getText());

				// create response observer
				StreamObserver<updatedBudgetConfirmation> responseObserver = new StreamObserver<updatedBudgetConfirmation>() {

					@Override
					public void onNext(updatedBudgetConfirmation msg) {

						System.out.println("Receiving updated budget " + msg.getCat());
						textResponse.append("\n Receiving updated budget " + "\n" + msg.getCat());
					}

					@Override
					// we get an error from the server
					public void onError(Throwable t) {
						t.printStackTrace();
					}

					@Override
					// the server is done sending data
					// onCompleted is called right after onNext
					public void onCompleted() {

						System.out.println("Stream is completed");
					}

				};

				// build messages
				StreamObserver<updatedBudget> requestObserver = asyncStub.updateBugdet(responseObserver);

				try {
					requestObserver
							.onNext(updatedBudget.newBuilder().setYouHaveUpdated(Cat1).setUpdatedBudget(num1).build());
					Thread.sleep(500);

					requestObserver
							.onNext(updatedBudget.newBuilder().setYouHaveUpdated(Cat2).setUpdatedBudget(num2).build());
					Thread.sleep(500);

					requestObserver
							.onNext(updatedBudget.newBuilder().setYouHaveUpdated(Cat3).setUpdatedBudget(num3).build());
					Thread.sleep(500);

					requestObserver
							.onNext(updatedBudget.newBuilder().setYouHaveUpdated(Cat4).setUpdatedBudget(num4).build());
					Thread.sleep(500);

					// End of requests
					// receive response from server
					requestObserver.onCompleted();

					Thread.sleep(10000);

				} catch (RuntimeException d) {
					d.printStackTrace();
				} catch (InterruptedException f) {
					f.printStackTrace();
				}

			}

		});

		B4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String Cat1 = Catagory1.getText();
				double num1 = Double.parseDouble(Cost1.getText());
				String Cat2 = Catagory2.getText();
				double num2 = Double.parseDouble(Cost2.getText());
				String Cat3 = Catagory3.getText();
				double num3 = Double.parseDouble(Cost3.getText());
				String Cat4 = Catagory4.getText();
				double num4 = Double.parseDouble(Cost4.getText());

				// using a CountDownLatch to sleep instead
				CountDownLatch latch = new CountDownLatch(1);

				StreamObserver<setBudget> responseObserver = new StreamObserver<setBudget>() {
					@Override
					public void onNext(setBudget value) {
						// for every request from client set and build response
						textResponse.append("\n You Have set Budget!" + " \n" + " Catagory: " + value.getOriginalCat()
								+ "- Budget: " + value.getOriginalBudget());

						System.out.println("You Have set Budget!" + " \n Catagory: " + value.getOriginalCat()
								+ "- Budget: " + value.getOriginalBudget());

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

				// return request observer
				StreamObserver<setBudget> requestObserver = asyncStub.setBudget(responseObserver);
				// every time we receive a request from server, send back a reponse
				try {
					// construct request
					requestObserver.onNext(setBudget.newBuilder().setOriginalCat(Cat1).setOriginalBudget(num1).build());
					requestObserver.onNext(setBudget.newBuilder().setOriginalCat(Cat2).setOriginalBudget(num2).build());
					requestObserver.onNext(setBudget.newBuilder().setOriginalCat(Cat3).setOriginalBudget(num3).build());
					requestObserver.onNext(setBudget.newBuilder().setOriginalCat(Cat4).setOriginalBudget(num4).build());

					// Mark the end of requests
					requestObserver.onCompleted();

					// Sleep for a bit before sending the next one.
					Thread.sleep(new Random().nextInt(1000) + 500);

				} catch (RuntimeException b) {
					b.printStackTrace();
				} catch (InterruptedException b) {
					b.printStackTrace();
				}

				try {
					Thread.sleep(15000);
				} catch (InterruptedException a) {
					// TODO Auto-generated catch block
					a.printStackTrace();
				}

			}

		});

		// Populate text response area
		panel_service_1.add(B1);
		panel_service_1.add(B2);
		panel_service_1.add(B3);
		panel_service_1.add(B4);

		textResponse = new JTextArea(12, 34);
		textResponse.setLineWrap(true);
		textResponse.setWrapStyleWord(true);

		JScrollPane scrollPane = new JScrollPane(textResponse);
		panel_service_1.add(scrollPane);

	}

}
