package gui;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.awt.EventQueue;
import java.awt.FlowLayout;
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

import com.bron.grpc.authenticationMessage;
import com.bron.grpc.inputPin;
import com.bron.grpc.searchATM;
import com.bron.grpc.touchFreeATMGrpc;
import com.bron.grpc.touchFreeATMGrpc.touchFreeATMBlockingStub;

import JMDNS.SimpleServiceDiscovery;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class touchFreeGUIApplication {

	touchFreeATMBlockingStub TouchFreeStub;

	private JFrame frame;
	private JTextField InputPin;
	// private JTextField Cost;
	// where we put response into
	private JTextArea textResponse;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					touchFreeGUIApplication windowTouch = new touchFreeGUIApplication();
					windowTouch.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public touchFreeGUIApplication() {

		ServiceInfo serviceInfo;

		// must correspond to server file
		String service_type_2 = "_grpc._tcp.local.TouchFree.";

		// Get the service info by supplying service type
		serviceInfo = SimpleServiceDiscovery.run(service_type_2);

		// Use the serviceInfo to retrieve the port
		int port_2 = serviceInfo.getPort();

		String host_2 = "LocalHost";

		ManagedChannel channel = ManagedChannelBuilder.forAddress(host_2, port_2).usePlaintext().build();

		// stubs -- generate from proto
		TouchFreeStub = touchFreeATMGrpc.newBlockingStub(channel);

		initialize();

	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Client - Service Controller");
		frame.setBounds(100, 200, 700, 300);
		// closes when "X" is pressed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// determines how components are laid out
		BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);

		frame.getContentPane().setLayout(bl);

		JPanel panel_service_1 = new JPanel();
		frame.getContentPane().add(panel_service_1);
		panel_service_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		// Create new label and add to panel
		JLabel lblNewLabel_1 = new JLabel("Input Pin");
		panel_service_1.add(lblNewLabel_1);

		// Imput Textbox
		InputPin = new JTextField();
		panel_service_1.add(InputPin);
		InputPin.setColumns(10);

		JButton B1 = new JButton("Validate Pin");
		JButton B2 = new JButton("Find ATM");

		// Action Listener is on button

		B1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// Extract data from GUI

				int IntPin = Integer.parseInt(InputPin.getText());

				inputPin pin = inputPin.newBuilder().setPinNumber(IntPin).build();

				// call rpc and get back a response
				authenticationMessage message = TouchFreeStub.authenticateCard(pin);

				// populate the JtextArea in the panel
				textResponse.append("\n" + message.getWelcomeMessage());

				// print the result
				System.out.println(message.getWelcomeMessage());

			}

		});

		B2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// build request
				searchATM Search = searchATM.newBuilder().setSearchATM(true).build();

				// For each machine found print name and distance from user
				TouchFreeStub.findNearByATM(Search).forEachRemaining(availableMachines -> {

					textResponse.append("\n ATM name: " + availableMachines.getMachine() + " Distance in km: "
							+ availableMachines.getDistance());

					System.out.println("ATM name: " + availableMachines.getMachine() + " Distance in km: "
							+ availableMachines.getDistance());

				});

			}

		});

		// Populate text response area
		panel_service_1.add(B1);
		panel_service_1.add(B2);

		textResponse = new JTextArea(6, 34);
		textResponse.setLineWrap(true);
		textResponse.setWrapStyleWord(true);

		JScrollPane scrollPane = new JScrollPane(textResponse);

		panel_service_1.add(scrollPane);

	}

}
