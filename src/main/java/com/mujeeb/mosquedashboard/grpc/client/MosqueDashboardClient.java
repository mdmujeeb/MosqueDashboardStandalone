package com.mujeeb.mosquedashboard.grpc.client;

import java.io.IOException;

import com.mujeeb.mosquedashboard.grpc.GenericReply;
import com.mujeeb.mosquedashboard.grpc.MosqueDashboardServiceGrpc;
import com.mujeeb.mosquedashboard.grpc.MosqueDashboardServiceGrpc.MosqueDashboardServiceBlockingStub;
import com.mujeeb.mosquedashboard.grpc.MosqueDashboardServiceGrpc.MosqueDashboardServiceStub;
import com.mujeeb.mosquedashboard.grpc.NamazTimeUpdateRequest;
import com.mujeeb.mosquedashboard.util.Constants;

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
	
	public static void sendRequestToServer() {
		
		NamazTimeUpdateRequest request = NamazTimeUpdateRequest.newBuilder()
						.setNamazTimeName(Constants.KEY_NAMAZ_TIME_ISHA)
						.setHour(8)
						.setMinute(15).build();
		
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
	
//	public static void main(String[] args) {
//		try {
//			new MosqueDashboardClient("localhost", 8090);
//		} catch(Exception ex) {
//			ex.printStackTrace();
//		}
//		sendRequestToServer();
//		
//		new Thread() {
//			public void run() {
//				for(int i=0; i<5; i++) {
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		}.start();
//	}
}
