package config.videosystem.mixing;

import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;

import com.douzone.container.videosystem.Avengers;
import com.douzone.container.videosystem.BlankDisc;
import com.douzone.container.videosystem.DigitalVideoDisc;

@ContextConfiguration(classes = DVDPlayerConfig.class)
public class DVDConfig {
	@Bean
	public DigitalVideoDisc avengers() {
		return new Avengers();
	}
	
	@Bean(name = "avengersInfinityWar")
	public BlankDisc blankDisc() {
		BlankDisc blankDisc = new BlankDisc();

		blankDisc.setTitle("Avengers Infinity War");
		blankDisc.setStudio("MARVEL");

		return blankDisc;
	}
}
