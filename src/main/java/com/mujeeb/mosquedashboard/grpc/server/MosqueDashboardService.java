package com.mujeeb.mosquedashboard.grpc.server;

import com.mujeeb.mosquedashboard.grpc.GenericReply;
import com.mujeeb.mosquedashboard.grpc.MosqueDashboardServiceGrpc;
import com.mujeeb.mosquedashboard.grpc.NamazTime;
import com.mujeeb.mosquedashboard.util.DataUtil;

import io.grpc.stub.StreamObserver;

public class MosqueDashboardService extends MosqueDashboardServiceGrpc.MosqueDashboardServiceImplBase {

	public MosqueDashboardService() {
	}

	@Override
	public void updateNamazTime(NamazTime request, StreamObserver<GenericReply> responseObserver) {
		
		DataUtil.changeNamazTIme(request.getNamazTimeName(), request.getHour(), request.getMinute());
		responseObserver.onNext(GenericReply.newBuilder().setResponseCode(0).setDescription("Success!!").build());
	    responseObserver.onCompleted();
	}	
}
