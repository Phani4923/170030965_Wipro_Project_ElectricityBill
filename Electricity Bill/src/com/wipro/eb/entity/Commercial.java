package com.wipro.eb.entity;

public class Commercial extends Connection{

	public Commercial(int currentReading, int previousReading, float[] slabs) {
		super(currentReading, previousReading, slabs);
	}

	@Override
	public float computeBill() {
		int diff=currentReading-previousReading;
		float res1=0;
		if((diff>0)&&(diff<50))
		{
			res1=diff*slabs[0];
		}
		else if((diff>=50)&&(diff<100))
		{
			res1=(diff-50)*slabs[1]+(50)*slabs[0];
		}
		else
		{
			res1=(diff-100)*slabs[2]+(50)*slabs[1]+(50)*slabs[0];
		}
		float res2=0;
		if(res1>=10000)
		{
			res2=res1*0.09f;
		}
		else if(res1>=5000)
		{
			res2=res1*0.06f;
		}
		else
		{
			res2=res1*0.02f;
		}
		res1=res1+res2;
		return res1;
	}
	
}
