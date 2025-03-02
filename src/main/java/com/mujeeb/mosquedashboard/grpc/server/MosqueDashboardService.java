package com.mujeeb.mosquedashboard.grpc.server;

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

		Main.changeScreenSaverState(request.getIsOn());
		responseObserver.onNext(GenericReply.newBuilder().setResponseCode(0).setDescription("Success!!").build());
	    responseObserver.onCompleted();
	}

	@Override
	public void setDateTime(StringContainer request, StreamObserver<GenericReply> responseObserver) {

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
