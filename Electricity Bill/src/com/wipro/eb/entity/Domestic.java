package com.wipro.eb.entity;

public class Domestic extends Connection{

	public Domestic(int currentReading, int previousReading, float[] slabs) {
		super(currentReading, previousReading, slabs);
	}
	@Override
	public float computeBill()
	{
		int diff=currentReading-previousReading;
		float res=0;
		if((diff>0)&&(diff<50))
		{
			res=diff*slabs[	0];
		}
		else if((diff>=50)&&(diff<100))
		{
			res=(diff-50)*slabs[1]+(50)*slabs[0];
		}
		else
		{
			res=(diff-100)*slabs[2]+(50)*slabs[1]+(50)*slabs[0];
		}
		return res;
	}
}
