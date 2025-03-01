package com.mujeeb.mosquedashboard.beans;

public class NamazTimes {
	
	int currentHour;
	int currentMinute;
    boolean isTodayFriday = false;
    int[] namazTimeFajr;
    int[] namazTimeZuhr;
    int[] namazTimeAsr;
    int[] namazTimeMaghrib;
    int[] namazTimeIsha;
    int[] namazTimeJumua;
    int[] namazTimeNoon;
    int[] namazTimeIshraq;
    int[] namazTimeDuha;
    int[] namazTimeSuhur;
    int[] namazTimeIftar;
    int[] screenOnTime;
    int[] screenOffTime;
	 
	public boolean isTodayFriday() {
		return isTodayFriday;
	}
	public void setTodayFriday(boolean isTodayFriday) {
		this.isTodayFriday = isTodayFriday;
	}
	public int[] getNamazTimeFajr() {
		return namazTimeFajr;
	}
	public void setNamazTimeFajr(int[] namazTimeFajr) {
		this.namazTimeFajr = namazTimeFajr;
	}
	public int[] getNamazTimeZuhr() {
		return namazTimeZuhr;
	}
	public void setNamazTimeZuhr(int[] namazTimeZuhr) {
		this.namazTimeZuhr = namazTimeZuhr;
	}
	public int[] getNamazTimeAsr() {
		return namazTimeAsr;
	}
	public void setNamazTimeAsr(int[] namazTimeAsr) {
		this.namazTimeAsr = namazTimeAsr;
	}
	public int[] getNamazTimeMaghrib() {
		return namazTimeMaghrib;
	}
	public void setNamazTimeMaghrib(int[] namazTimeMaghrib) {
		this.namazTimeMaghrib = namazTimeMaghrib;
	}
	public int[] getNamazTimeIsha() {
		return namazTimeIsha;
	}
	public void setNamazTimeIsha(int[] namazTimeIsha) {
		this.namazTimeIsha = namazTimeIsha;
	}
	public int[] getNamazTimeJumua() {
		return namazTimeJumua;
	}
	public void setNamazTimeJumua(int[] namazTimeJumua) {
		this.namazTimeJumua = namazTimeJumua;
	}
	public int[] getNamazTimeNoon() {
		return namazTimeNoon;
	}
	public void setNamazTimeNoon(int[] namazTimeNoon) {
		this.namazTimeNoon = namazTimeNoon;
	}
	public int getCurrentHour() {
		return currentHour;
	}
	public void setCurrentHour(int currentHour) {
		this.currentHour = currentHour;
	}
	public int getCurrentMinute() {
		return currentMinute;
	}
	public void setCurrentMinute(int currentMinute) {
		this.currentMinute = currentMinute;
	}
	public int[] getNamazTimeIshraq() {
		return namazTimeIshraq;
	}
	public void setNamazTimeIshraq(int[] namazTimeIshraq) {
		this.namazTimeIshraq = namazTimeIshraq;
	}
	public int[] getNamazTimeDuha() {
		return namazTimeDuha;
	}
	public void setNamazTimeDuha(int[] namazTimeDuha) {
		this.namazTimeDuha = namazTimeDuha;
	}
	public int[] getNamazTimeSuhur() {
		return namazTimeSuhur;
	}
	public void setNamazTimeSuhur(int[] namazTimeSuhur) {
		this.namazTimeSuhur = namazTimeSuhur;
	}
	public int[] getNamazTimeIftar() {
		return namazTimeIftar;
	}
	public void setNamazTimeIftar(int[] namazTimeIftar) {
		this.namazTimeIftar = namazTimeIftar;
	}
	public int[] getScreenOnTime() {
		return screenOnTime;
	}
	public void setScreenOnTime(int[] screenOnTime) {
		this.screenOnTime = screenOnTime;
	}
	public int[] getScreenOffTime() {
		return screenOffTime;
	}
	public void setScreenOffTime(int[] screenOffTime) {
		this.screenOffTime = screenOffTime;
	}
}
