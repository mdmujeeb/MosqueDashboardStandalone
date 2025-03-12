package com.mujeeb.mosquedashboard.grpc.server;

import java.util.Map;

import com.mujeeb.mosquedashboard.beans.DateBean;
import com.mujeeb.mosquedashboard.beans.NamazTimes;
import com.mujeeb.mosquedashboard.grpc.EmptyRequest;
import com.mujeeb.mosquedashboard.grpc.GenericReply;
import com.mujeeb.mosquedashboard.grpc.GetDataForMobileAppRequest;
import com.mujeeb.mosquedashboard.grpc.HijriAdjustmentUpdateRequest;
import com.mujeeb.mosquedashboard.grpc.MosqueDashboardServiceGrpc;
import com.mujeeb.mosquedashboard.grpc.NamazTime;
import com.mujeeb.mosquedashboard.grpc.ScreenSaverStateUpdateRequest;
import com.mujeeb.mosquedashboard.grpc.StringContainer;
import com.mujeeb.mosquedashboard.main.Main;
import com.mujeeb.mosquedashboard.util.Constants;
import com.mujeeb.mosquedashboard.util.DataUtil;
import com.mujeeb.mosquedashboard.util.IslamicUtil;

import io.grpc.stub.StreamObserver;

public class MosqueDashboardService extends MosqueDashboardServiceGrpc.MosqueDashboardServiceImplBase {

	@Override
	public void updateNamazTime(NamazTime request, StreamObserver<GenericReply> responseObserver) {
		
		Map<String,Object> data = Main.getData();
		if(!data.get(Constants.KEY_USER_ID).toString().equals(request.getAuthData().getUserName())
				|| !data.get(Constants.KEY_PASSWORD).toString().equals(request.getAuthData().getPassword())) {
			
			// Authentication Failed			
			responseObserver.onNext(GenericReply.newBuilder().setResponseCode(-1).setDescription("Authentication Failed!").build());
		    responseObserver.onCompleted();
		    return;
		}
		
		DataUtil.changeNamazTIme(request.getNamazTimeName(), request.getHour(), request.getMinute());
		responseObserver.onNext(GenericReply.newBuilder().setResponseCode(0).setDescription("Success!!").build());
	    responseObserver.onCompleted();
	}

	@Override
	public void getDataForMobileApp(EmptyRequest request, StreamObserver<GetDataForMobileAppRequest> responseObserver) {
		
		NamazTimes namazTimes = Main.getNamazTimes();
		DateBean hijriDate = IslamicUtil.getHijriDate((int)Main.getData().get(Constants.KEY_HIJRI_ADJUSTMENT));
		GetDataForMobileAppRequest response = GetDataForMobileAppRequest.newBuilder()
												.setFajrTime(NamazTime.newBuilder()
														.setNamazTimeName(Constants.KEY_NAMAZ_TIME_FAJR)
														.setHour(namazTimes.getNamazTimeFajr()[0])
														.setMinute(namazTimes.getNamazTimeFajr()[1]).build())
												.setZuhrTime(NamazTime.newBuilder()
														.setNamazTimeName(Constants.KEY_NAMAZ_TIME_ZUHR)
														.setHour(namazTimes.getNamazTimeZuhr()[0])
														.setMinute(namazTimes.getNamazTimeZuhr()[1]).build())
												.setAsrTime(NamazTime.newBuilder()
														.setNamazTimeName(Constants.KEY_NAMAZ_TIME_ASR)
														.setHour(namazTimes.getNamazTimeAsr()[0])
														.setMinute(namazTimes.getNamazTimeAsr()[1]).build())
												.setIshaTime(NamazTime.newBuilder()
														.setNamazTimeName(Constants.KEY_NAMAZ_TIME_ISHA)
														.setHour(namazTimes.getNamazTimeIsha()[0])
														.setMinute(namazTimes.getNamazTimeIsha()[1]).build())
												.setJumuaTime(NamazTime.newBuilder()
														.setNamazTimeName(Constants.KEY_NAMAZ_TIME_JUMUA)
														.setHour(namazTimes.getNamazTimeJumua()[0])
														.setMinute(namazTimes.getNamazTimeJumua()[1]).build())
												.setIshraqTime(NamazTime.newBuilder()
														.setNamazTimeName(Constants.KEY_NAMAZ_TIME_ISHRAQ)
														.setHour(namazTimes.getNamazTimeIshraq()[0])
														.setMinute(namazTimes.getNamazTimeIshraq()[1]).build())
												.setDuhaTime(NamazTime.newBuilder()
														.setNamazTimeName(Constants.KEY_NAMAZ_TIME_DUHA)
														.setHour(namazTimes.getNamazTimeDuha()[0])
														.setMinute(namazTimes.getNamazTimeDuha()[1]).build())
												.setSuhurTime(NamazTime.newBuilder()
														.setNamazTimeName(Constants.KEY_NAMAZ_TIME_SUHUR)
														.setHour(namazTimes.getNamazTimeSuhur()[0])
														.setMinute(namazTimes.getNamazTimeSuhur()[1]).build())
												.setIftarTime(NamazTime.newBuilder()
														.setNamazTimeName(Constants.KEY_NAMAZ_TIME_IFTAR)
														.setHour(namazTimes.getNamazTimeIftar()[0])
														.setMinute(namazTimes.getNamazTimeIftar()[1]).build())
												.setScreenSaverOnTime(NamazTime.newBuilder()
														.setNamazTimeName(Constants.KEY_SCREENSAVER_ON)
														.setHour(namazTimes.getScreenOffTime()[0])
														.setMinute(namazTimes.getScreenOffTime()[1]).build())
												.setScreenSaverOffTime(NamazTime.newBuilder()
														.setNamazTimeName(Constants.KEY_SCREENSAVER_OFF)
														.setHour(namazTimes.getScreenOnTime()[0])
														.setMinute(namazTimes.getScreenOnTime()[1]).build())
												.setHijriAdjustment((int)Main.getData().get(Constants.KEY_HIJRI_ADJUSTMENT))
												.setHijriDate(Integer.parseInt(hijriDate.getDate()))
												.setHijriMonth(hijriDate.getMonth())
												.setHijriYear(Integer.parseInt(hijriDate.getYear()))
												.build();

		responseObserver.onNext(response);
	    responseObserver.onCompleted();
	}

	@Override
	public void changeHijriAdjustment(HijriAdjustmentUpdateRequest request, StreamObserver<GenericReply> responseObserver) {
		
		Map<String,Object> data = Main.getData();
		if(!data.get(Constants.KEY_USER_ID).toString().equals(request.getAuthData().getUserName())
				|| !data.get(Constants.KEY_PASSWORD).toString().equals(request.getAuthData().getPassword())) {
			
			// Authentication Failed			
			responseObserver.onNext(GenericReply.newBuilder().setResponseCode(-1).setDescription("Authentication Failed!").build());
		    responseObserver.onCompleted();
		    return;
		}
		
		DataUtil.changeHijriAdjustment(request.getHijriAdjustment());
		responseObserver.onNext(GenericReply.newBuilder().setResponseCode(0).setDescription("Success!!").build());
	    responseObserver.onCompleted();
	}

	@Override
	public void testAudio(EmptyRequest request, StreamObserver<GenericReply> responseObserver) {
		
		Main.testAudio();
		responseObserver.onNext(GenericReply.newBuilder().setResponseCode(0).setDescription("Success!!").build());
	    responseObserver.onCompleted();
	}

	@Override
	public void changeScreenSaverState(ScreenSaverStateUpdateRequest request, StreamObserver<GenericReply> responseObserver) {

		Map<String,Object> data = Main.getData();
		if(!data.get(Constants.KEY_USER_ID).toString().equals(request.getAuthData().getUserName())
				|| !data.get(Constants.KEY_PASSWORD).toString().equals(request.getAuthData().getPassword())) {
			
			// Authentication Failed			
			responseObserver.onNext(GenericReply.newBuilder().setResponseCode(-1).setDescription("Authentication Failed!").build());
		    responseObserver.onCompleted();
		    return;
		}
		
		Main.changeScreenSaverState(request.getIsOn());
		responseObserver.onNext(GenericReply.newBuilder().setResponseCode(0).setDescription("Success!!").build());
	    responseObserver.onCompleted();
	}

	@Override
	public void setDateTime(StringContainer request, StreamObserver<GenericReply> responseObserver) {

		Map<String,Object> data = Main.getData();
		if(!data.get(Constants.KEY_USER_ID).toString().equals(request.getAuthData().getUserName())
				|| !data.get(Constants.KEY_PASSWORD).toString().equals(request.getAuthData().getPassword())) {
			
			// Authentication Failed			
			responseObserver.onNext(GenericReply.newBuilder().setResponseCode(-1).setDescription("Authentication Failed!").build());
		    responseObserver.onCompleted();
		    return;
		}
		
		Main.setDateTime(request.getStr());
		responseObserver.onNext(GenericReply.newBuilder().setResponseCode(0).setDescription("Success!!").build());
	    responseObserver.onCompleted();
	}

	@Override
	public void restartSystem(EmptyRequest request, StreamObserver<GenericReply> responseObserver) {
		
		Main.restartSystem();
		responseObserver.onNext(GenericReply.newBuilder().setResponseCode(0).setDescription("Success!!").build());
	    responseObserver.onCompleted();
	}

	@Override
	public void hasDateChanged(EmptyRequest request, StreamObserver<StringContainer> responseObserver) {

		responseObserver.onNext(StringContainer.newBuilder().setStr(Main.hasDateChanged()).build());
	    responseObserver.onCompleted();
	}
}
