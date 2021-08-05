package JMDNS;
	
	import java.io.IOException;
	import java.net.InetAddress;
	import java.net.UnknownHostException;

	import javax.jmdns.JmDNS;
	import javax.jmdns.ServiceEvent;
	import javax.jmdns.ServiceInfo;
	import javax.jmdns.ServiceListener;

	public class SimpleServiceDiscovery {
		
		private int port;
		private String host;
		
		
		
		//option 1
		private static class MyServiceListener implements ServiceListener{

			private int port;
			private String host;
			private ServiceInfo serviceInfo;
		
			//service must be added before resolved
			public void serviceAdded(ServiceEvent event) {
				
				System.out.println("\nService Added " + event.getInfo());
				
			}

			public void serviceRemoved(ServiceEvent event) {
			
				System.out.println("Service Removed " + event.getInfo());
				
			}
			
			//service will not work unless also resolved
			public void serviceResolved(ServiceEvent event) {
		
				System.out.println("Service Resolved " + event.getInfo());
				
				//add all data into serviceInfo object
				ServiceInfo serviceInfo = event.getInfo();
				this.setServiceInfo(serviceInfo);
				System.out.println("host " + serviceInfo.getHostAddress());
				//this.setHost(serviceInfo.getHostAddress());
				//In order to find service most important to get port
				System.out.println("port " + serviceInfo.getPort());
				this.setPort(serviceInfo.getPort());
				System.out.println("type " + serviceInfo.getType());
				System.out.println("name " + serviceInfo.getName());
				System.out.println("Computername " + serviceInfo.getServer());
				System.out.println("desc/properties " + serviceInfo.getNiceTextString());

			}

			public int getPort() {
				return port;
			}

			public void setPort(int port) {
				this.port = port;
			}

			//getter is used by run method
			public ServiceInfo getServiceInfo() {
				return serviceInfo;
			}

			public void setServiceInfo(ServiceInfo serviceInfo) {
				this.serviceInfo = serviceInfo;
			}
			
		}

		//public static void main(String[] args) {
		public static ServiceInfo run(String service_type) {
			
			int port = 0;
			ServiceInfo serviceInfo = null;
			// create an instance of jmDNS
					
			
			try {
				JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
				
				//find the service based on service type e.g. "_grpc._tcp.local";				
				
				//need to listen for services added/removed etc.
				
				//jmdns.addServiceListener(service_type, new MyServiceListener());         //listen for specified type
				MyServiceListener msl = new MyServiceListener();
				//must add listener and type
				jmdns.addServiceListener(service_type, msl);

				
				//sleep for 10 seconds
				Thread.sleep(10000);
				
				
				//N.B. use lister to get service info
				serviceInfo = msl.getServiceInfo();
				port = msl.getPort();
				System.out.println("This is the port retreived from jmDNS: " + port);
				
				jmdns.close();
				
				
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return serviceInfo;

		}


	}



