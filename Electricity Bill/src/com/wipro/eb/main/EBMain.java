package com.wipro.eb.main;

import com.wipro.eb.service.ConnectionService;

public class EBMain {

 public static void main(String[] args) throws Exception {
  ConnectionService cs = new ConnectionService();
  System.out.println(cs.generateBill(130, 120, "Domestic"));
  System.out.println(cs.generateBill(180, 120, "Domestic"));
  System.out.println(cs.generateBill(280, 120, "Domestic"));
  System.out.println(cs.generateBill(-280, 120, "Domestic"));
  System.out.println(cs.generateBill(280, -120, "Domestic"));
  System.out.println(cs.generateBill(100, 120, "Domestic"));
  System.out.println(cs.generateBill(200, 120, "domestic"));
  System.out.println(cs.generateBill(200, 120, "dom"));
  System.out.println(cs.generateBill(130, 120, "Commercial"));
  System.out.println(cs.generateBill(180, 120, "Commercial"));
  System.out.println(cs.generateBill(280, 120, "Commercial"));
  System.out.println(cs.generateBill(-280, 120, "Commercial"));
  System.out.println(cs.generateBill(280, -120, "Commercial"));
  System.out.println(cs.generateBill(100, 120, "Commercial"));
  System.out.println(cs.generateBill(200, 120, "commercial"));
  System.out.println(cs.generateBill(200, 120, "comm"));
 }
}