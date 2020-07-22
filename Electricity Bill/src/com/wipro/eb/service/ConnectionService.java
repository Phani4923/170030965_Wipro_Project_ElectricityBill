package com.wipro.eb.service;

import com.wipro.eb.entity.Commercial;
import com.wipro.eb.entity.Connection;
import com.wipro.eb.entity.Domestic;
import com.wipro.eb.exception.InvalidConnectionException;
import com.wipro.eb.exception.InvalidReadingException;

public class ConnectionService {
	public boolean validate(int currentReading, int previousReading, String type) throws InvalidReadingException, InvalidConnectionException
	{
		if(currentReading<previousReading || currentReading<0 || previousReading<0)
		{
			throw new InvalidReadingException();
		}		
		if(type.equalsIgnoreCase("Domestic")==false && type.equalsIgnoreCase("Commercial")==false)
		{
			throw new InvalidConnectionException();
		}
		return true;
	}
	public float calculateBillAmt(int currentReading, int previousReading, String type)
	{
		Connection connect = null;
		try{
			validate(currentReading,previousReading,type);
		}catch(InvalidReadingException e)
		{
			return -1;
		}
		catch(InvalidConnectionException e)
		{
			return -2;
		}
		if(type.equalsIgnoreCase("Domestic"))
		{
			float[] slabs={2.3f,4.2f,5.5f};
			connect=new Domestic(currentReading, previousReading, slabs);
		}
		else if(type.equalsIgnoreCase("Commercial"))
		{
			float[] slabs={5.2f,6.8f,8.3f};
			connect=new Commercial(currentReading, previousReading, slabs);
		}
		return connect.computeBill();
	}
	public String generateBill(int currentReading, int previousReading, String type) throws ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		float res=calculateBillAmt(currentReading, previousReading, type);
		if(res==-1)
		{
			return new InvalidReadingException().toString();
		}
		else if(res==-2)
		{
			return new InvalidConnectionException().toString();
		}
		return "Amount to be paid : "+Float.toString(res);
	}
}
