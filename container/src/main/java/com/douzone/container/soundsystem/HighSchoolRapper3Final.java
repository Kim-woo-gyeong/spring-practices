package com.douzone.container.soundsystem;

import org.springframework.stereotype.Component;

//@Component("HSRapper3Final")
//@Component("highSchoolRapper3Final") //spring
//@Named("highSchoolRapper3Final") 자바표준
@Component
public class HighSchoolRapper3Final implements CompactDisc {

	private String title = "지구멸망";
	private String artist = "양승호";
	
	public void play() {
		System.out.println("playing " + title + " by " + artist);
	}
}
