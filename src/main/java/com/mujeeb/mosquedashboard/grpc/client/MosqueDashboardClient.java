package com.mujeeb.mosquedashboard.grpc.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.mujeeb.mosquedashboard.grpc.GenericReply;
import com.mujeeb.mosquedashboard.grpc.MosqueDashboardServiceGrpc;
import com.mujeeb.mosquedashboard.grpc.MosqueDashboardServiceGrpc.MosqueDashboardServiceBlockingStub;
import com.mujeeb.mosquedashboard.grpc.MosqueDashboardServiceGrpc.MosqueDashboardServiceStub;
import com.mujeeb.mosquedashboard.grpc.NamazTime;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class MosqueDashboardClient  {
	
	protected static ManagedChannel channel;
	protected static MosqueDashboardServiceBlockingStub blockingStub;
	protected static MosqueDashboardServiceStub asyncStub;

	public MosqueDashboardClient(String host, int port) throws IOException {
		this(ManagedChannelBuilder.forAddress(host, port).usePlaintext());
	}

	/** Create a RouteGuide server using serverBuilder as a base and features as data. */
	public MosqueDashboardClient(ManagedChannelBuilder<?> channelBuilder) {
		  channel = channelBuilder.build();
		  blockingStub = MosqueDashboardServiceGrpc.newBlockingStub(channel);
		  asyncStub = MosqueDashboardServiceGrpc.newStub(channel);
	}
	
	public static void sendRequestToServer(String timeName, int hour, int minute) {
		
		NamazTime request = NamazTime.newBuilder()
						.setNamazTimeName(timeName)
						.setHour(hour)
						.setMinute(minute).build();
		
		asyncStub.updateNamazTime(request, new StreamObserver<GenericReply>() {
			
			@Override
			public void onNext(GenericReply reply) {
				System.out.println(reply.getResponseCode() + ":" + reply.getDescription());
			}
			
			@Override
			public void onError(Throwable error) {
				error.printStackTrace();
			}
			
			@Override
			public void onCompleted() {
				System.out.println("Request Completed.");
			}
		});
//		System.out.println(blockingStub.updateNamazTime(request));
	}
	
	public static void main(String[] args) throws IOException {
		
		if(args.length < 1) {
			System.out.println("Usage: MosqueDashboardClient <RemoteHost>");
			return;
		}
		
		String host = args[0];
		try {
			new MosqueDashboardClient(host, 8090);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		System.out.println("Welcome to Mosque Dashboard gRPC test, by Mujeeb Mohammad\n");
		
		while(true) {
			System.out.println("\n");
			
			System.out.println("1. Get Data for Mobile App");
			System.out.println("2. Change Namaz Time");
			System.out.println("3. Change Hijri Adjustment");
			System.out.println("4. Test Audio");
			System.out.println("5. Change Screen Saver State");
			System.out.println("6. Restart System\n");
			
			System.out.println("Enter your choice: ");
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			String line = reader.readLine();
			
			switch(line) {
				case "1":
						  break;
				case "2":
					  break;
				case "3":
					  break;
				case "4":
					  break;
				case "5":
					  break;
				case "6":
					  break;
				default:
					  System.out.println("\nPlease enter a valid Option.");
					  break;
			}
		}
	}
}
