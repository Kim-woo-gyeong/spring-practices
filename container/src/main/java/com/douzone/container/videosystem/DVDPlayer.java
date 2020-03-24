package com.douzone.container.videosystem;

public class DVDPlayer {
	private DigitalVideoDisc dvd;
	
	public DVDPlayer() {
		System.out.println("DVDPlayer DVDPlayer()");
	}
	
	public DVDPlayer(DigitalVideoDisc dvd) {
		System.out.println("DVDPlayer DVDPlayer(DigitalVideoDisc dvd)");
		this.dvd = dvd;
	}
	
	public void setDvd(DigitalVideoDisc dvd) {
		this.dvd = dvd;
	}

	public void play() {
		dvd.play();
	}
}
