package com.lec.ch03.ex1;

import lombok.Data;

@Data
public class Family {
	
	/* aop와 DI(context)가 아닌 다른 태그들 사용 해보기 위한 예제 */
	private String papaName;
	private String mamiName;
	private String sisterName;
	private String brotherName;
	
	public Family(String papaName, String mamiName) {
		this.papaName = papaName;
		this.mamiName = mamiName;
	}
	
	
}
