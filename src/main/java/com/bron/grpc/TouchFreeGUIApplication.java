package com.bron.grpc;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;


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

import com.bron.grpc.touchFreeATMGrpc.touchFreeATMBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


public class TouchFreeGUIApplication {
	


touchFreeATMBlockingStub TouchFreeStub;
	
		
		private JFrame frame;
		private JTextField InputPin;
		//private JTextField Cost;
		//where we put response into
		private JTextArea textResponse;
			
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						TouchFreeGUIApplication window = new TouchFreeGUIApplication();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		
		
	public TouchFreeGUIApplication() {
				
				
				int port = 9097;
				String host = "LocalHost";
		;
			
			ManagedChannel channel = ManagedChannelBuilder
					.forAddress(host, port)
					.usePlaintext()
					.build();

			//stubs -- generate from proto
			TouchFreeStub = touchFreeATMGrpc.newBlockingStub(channel);

			
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
				JLabel lblNewLabel_1 = new JLabel("Input Pin");
				panel_service_1.add(lblNewLabel_1);
				
				
				//Imput Textbox
				InputPin = new JTextField();
				panel_service_1.add(InputPin);
				InputPin.setColumns(10);
				
			//	JLabel lblNewLabel_2 = new JLabel("Cost");
			//	panel_service_1.add(lblNewLabel_2);
			//	
			//	Cost = new JTextField();
			//	panel_service_1.add(Cost);
			//	Cost.setColumns(10);
				
				
				
				
				JComboBox comboOperation = new JComboBox();
				
				
				//User chooses option
				comboOperation.setModel(new DefaultComboBoxModel(new String[] {"Check Pin", "Check Pin", "Check Pin", "Check Pin"}));
				panel_service_1.add(comboOperation);
			
				
				JButton SendRequest = new JButton("Check Pin");
				
				//Action Listener is on button
				SendRequest.addActionListener(new ActionListener() {
					
				
					public void actionPerformed(ActionEvent e) {
						
						//Extract data from GUI
					
						int IntPin = Integer.parseInt(InputPin.getText());

						inputPin pin = inputPin.newBuilder().setPinNumber(IntPin).build();

						// call rpc and get back a response
						authenticationMessage message = TouchFreeStub.authenticateCard(pin);

						// print the result
						System.out.println(message.getWelcomeMessage());
				
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
				
				
				
			}

		}
