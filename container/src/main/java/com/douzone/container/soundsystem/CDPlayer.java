package com.douzone.container.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component //암시적이기 때문에 붙어있어야 함.
public class CDPlayer {

	// wiring 01 : 바이너리 주입(CGLib)
	//@Inject(자바표준 DI 어노테이션)
	@Autowired // 1. 생성자가 사라짐.
	@Qualifier("highSchoolRapper3Final") // id가 기본적으로 잡힌다..?
	private CompactDisc cd;
	
	public CDPlayer() {
		
	}
	// wiring02 : 생성자 주입
	//@Autowired 
	//기본 생성자로 생성. 2. 그래서 이걸로 기본생성자 생성.. 3. 결론은 @Autowired가 필요 없음. 4. 그러나 @Autowired 생성자를 먼저 스캔하기 때문에 붙이는게 좋음.
	public CDPlayer(@Qualifier("highSchoolRapper3Final") CompactDisc cd) {
		this.cd = cd;
	}
	
	// wiring03 : setter 사용
	//@Autowired
	public void setCompactDisc(@Qualifier("highSchoolRapper3Final") CompactDisc cd) {
		this.cd = cd;
	}
	
	// wiring04 : 일반 메소드 사용
	//@Autowired
	public void insertConpactDisc(@Qualifier("highSchoolRapper3Final") CompactDisc cd) {
		this.cd = cd;
	}
	public void play() {
		cd.play();
	}

}
