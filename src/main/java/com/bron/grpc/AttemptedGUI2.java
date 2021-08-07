package com.bron.grpc;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class AttemptedGUI2 {
	
	BudgetGrpc.BudgetBlockingStub Stub;
	
	private JFrame frame;
	private JTextField Catagory;
	private JTextField Cost;
	//where we put response into
	private JTextArea textResponse;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AttemptedGUI2 window = new AttemptedGUI2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
		public AttemptedGUI2() {
			
			
			int port = 9097;
			String host = "LocalHost";
		
		//String math_service_type = "_maths._tcp.local.";
		//discoverMathService(math_service_type);
		
	//	String host = ServiceInfo.getHostAddresses()[0];
	//	int port = mathServiceInfo.getPort();
		
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress(host, port)
				.usePlaintext()
				.build();

		//stubs -- generate from proto
		Stub = BudgetGrpc.newBlockingStub(channel);

		
		initialize();
		
		
	}
		
		private void initialize() {
			frame = new JFrame();
			frame.setTitle("Client - Service Controller");
			frame.setBounds(100, 100, 500, 300);
			//closes when "X" is pressed
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//determines how components are laid out
			BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
			
			frame.getContentPane().setLayout(bl);

			
			
			JPanel panel_service_1 = new JPanel();
			frame.getContentPane().add(panel_service_1);
			panel_service_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			
			//Create new label and add to panel
			JLabel lblNewLabel_1 = new JLabel("Catagory");
			panel_service_1.add(lblNewLabel_1);
			
			
			//Imput Textbox
			Catagory = new JTextField();
			panel_service_1.add(Catagory);
			Catagory.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("Cost");
			panel_service_1.add(lblNewLabel_2);
			
			Cost = new JTextField();
			panel_service_1.add(Cost);
			Cost.setColumns(10);
			
			
			
			
			JComboBox comboOperation = new JComboBox();
			
			
			//User chooses option
			comboOperation.setModel(new DefaultComboBoxModel(new String[] {"GetBudgetWarning", "Get Remaining Budget", "Set Budget", "Update Budget"}));
		
			panel_service_1.add(comboOperation);
		
			
			JButton SendRequest = new JButton("SendRequest");
			
			
			
	if (comboOperation.equals("GetBudgetWarning")) {
			
			//Action Listener is on button
			SendRequest.addActionListener(new ActionListener() {
				
			
				public void actionPerformed(ActionEvent e) {
					
					//Extract data from GUI
					String Cat = Catagory.getText();
					double Cost1 = Integer.parseInt(Cost.getText());

					int index = comboOperation.getSelectedIndex();
					
					
					//Do some logic with our index or send it over 
					
				
					moneySpent moneyspent = moneySpent.newBuilder().setCatagoryName(Cat).setCost(Cost1).build();

					lowBudgetAlert budgetalert = Stub.getBudgetWarning(moneyspent);
					
					//populate the JtextArea in the panel
					textResponse.append(budgetalert.getNearingBudgetAlert());
					// print the result
					System.out.println(budgetalert.getNearingBudgetAlert());
				
				
				}
				
			});
			
			//Populate text response area
			panel_service_1.add(SendRequest);
			
			textResponse = new JTextArea(3, 20);
			textResponse .setLineWrap(true);
			textResponse.setWrapStyleWord(true);
			
			JScrollPane scrollPane = new JScrollPane(textResponse);
			
			//textResponse.setSize(new Dimension(15, 30));
			panel_service_1.add(scrollPane);
			
		
		}else {

			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9097).usePlaintext().build();
			BudgetGrpc.BudgetBlockingStub Stub;
			Stub = BudgetGrpc.newBlockingStub(channel);
			
			requestRemainingbudget Remainingbudget = requestRemainingbudget.newBuilder().setRequestRemainingbudget(true)
					.build();

			Stub.getRemainingBudget(Remainingbudget).forEachRemaining(remainingBudgetStream -> {
				
				textResponse.append(remainingBudgetStream.getCat() + " Budget: " + remainingBudgetStream.getBudget());

				System.out.println(remainingBudgetStream.getCat() + " Budget: " + remainingBudgetStream.getBudget());

			
			});
			
			//Populate text response area
			panel_service_1.add(SendRequest);
			
			textResponse = new JTextArea(3, 20);
			textResponse .setLineWrap(true);
			textResponse.setWrapStyleWord(true);
			
			JScrollPane scrollPane = new JScrollPane(textResponse);
			
			//textResponse.setSize(new Dimension(15, 30));
			panel_service_1.add(scrollPane);
			
			
	}
	}
}