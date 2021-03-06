package config.videosystem.mixing;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.douzone.container.videosystem.DVDPlayer;
import com.douzone.container.videosystem.DigitalVideoDisc;

/**
 * 
 * Explicity Configuration : Java Configuration
 * JavaConfig2 <---- {JavaConfig1}
 *             import
 *             
 *  = JavaConfig1 + JavaConfig2
 */
@Configuration
@Import({DVDConfig.class})
public class DVDPlayerConfig {
	
//	@Bean
//	public DigitalVideoDisc avengers() {
//		return new Avengers();
//	}
//	
//	@Bean(name = "avengersInfinityWar")
//	public BlankDisc blankDisc() {
//		BlankDisc blankDisc = new BlankDisc();
//
//		blankDisc.setTitle("Avengers Infinity War");
//		blankDisc.setStudio("MARVEL");
//
//		return blankDisc;
//	}
	
	@Bean
	//public DVDPlayer dvdPlayer(DigitalVideoDisc dvd) -> 주입하기.
	public DVDPlayer dvdPlayer(@Qualifier("avengersInfinityWar") DigitalVideoDisc dvd) {
		return new DVDPlayer(dvd);
	}
}
