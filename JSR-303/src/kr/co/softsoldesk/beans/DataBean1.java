package kr.co.softsoldesk.beans;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class DataBean1 {

	@AssertTrue
	private boolean data1;
	@AssertFalse
	private boolean data2;
	
	@Max(100)
	@Min(10)
	private int data3;
	
	
	
	public DataBean1() {
		this.data1=true;
		this.data2=false;
		this.data3=0;
	
	}

	public boolean isData1() {
		return data1;
	}

	public void setData1(boolean data1) {
		this.data1 = data1;
	}

	public boolean isData2() {
		return data2;
	}

	public void setData2(boolean data2) {
		this.data2 = data2;
	}

	public int getData3() {
		return data3;
	}

	public void setData3(int data3) {
		this.data3 = data3;
	}


	
}
