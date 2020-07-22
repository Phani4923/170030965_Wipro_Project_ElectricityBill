package com.wipro.eb.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConnectionServiceTest {

	@Test
	public void testGenerateBill() throws Exception {
		assertEquals("Amount to be paid : 159.12",new ConnectionService().generateBill(130,100,"Commercial"));
		assertEquals("Invalid Connection Type",new ConnectionService().generateBill(130,100,"Comarsial"));
		assertEquals("Amount to be paid : 655.0",new ConnectionService().generateBill(280, 120, "Domestic"));
		assertEquals("Incorrect Reading",new ConnectionService().generateBill(-100,100,"Commercial"));
	}

}
