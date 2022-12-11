package tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import incometaxcalculator.data.management.*;
import incometaxcalculator.data.io.*;
import incometaxcalculator.data.management.TaxpayerManager;
import incometaxcalculator.exceptions.WrongFileEndingException;
import incometaxcalculator.exceptions.WrongFileFormatException;
import incometaxcalculator.exceptions.WrongReceiptDateException;
import incometaxcalculator.exceptions.WrongReceiptKindException;
import incometaxcalculator.exceptions.WrongTaxpayerStatusException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class TaxpayerManagerTests {

  private static HashMap<Integer, Taxpayer> stergioshash = new HashMap<Integer, Taxpayer>(0);

  @Test
  public void createTaxpayerTest() {
    try {
      TaxpayerManager stergios= new TaxpayerManager();
      stergios.createTaxpayer("Stergios Gerasis", 12345678, "Married Filing Jointly",22570);
      //System.out.println(stergioshash);
    }
    catch (Exception e) {
      //System.out.println(e);
      Assert.fail("Exception " + e);
    }
  }
  
  @Test
  public void createReceiptTest() {
    try {
      //Receipt myreceipt= new Receipt();
      TaxpayerManager stergios= new TaxpayerManager();
      stergios.createTaxpayer("Stergios Gerasis", 12345678, "Married Filing Jointly",22570);
      stergios.createReceipt(4332, "23/23/2020",(float) 10000.0,"Basic","ster","Greece","Ioannina","zerva",1,12345678);   
    }
    catch (Exception e) {
      System.out.println(e);
      Assert.fail("Exception " + e);
    }
  }
  
  @Test
  public void removeTaxpayerTest() throws WrongTaxpayerStatusException {
    HashMap<Integer, Taxpayer> stergioshash = new HashMap<Integer, Taxpayer>(0);
    
    TaxpayerManager stergios=new TaxpayerManager();
    stergios.createTaxpayer("Stergios Gerasis", 12345678, "Married Filing Jointly",22570);
    stergios.removeTaxpayer(12345678);
    
    System.out.println(stergioshash);
    
    assertEquals(stergioshash.get(12345678),null);
  }
  
  @Test
  public void addReceiptTest() {
    try {
      //Receipt myreceipt= new Receipt();
      TaxpayerManager stergios= new TaxpayerManager();
      stergios.createTaxpayer("Stergios Gerasis", 12345678, "Married Filing Jointly",22570);
      //stergios.createReceipt(4332, "23/23/2020",(float) 10000.0,"Basic","ster","Greece","Ioannina","zerva",1,12345678);
      stergios.addReceipt(4332, "23/23/2020",(float) 10000.0,"Basic","ster","Greece","Ioannina","zerva",1,12345678); 
    }
    catch (Exception e) {
      System.out.println(e);
      Assert.fail("Exception " + e);
    }
  }
  
  @Test
  public void removeReceiptTest() {
    try {
      //Receipt myreceipt= new Receipt();
      TaxpayerManager stergios= new TaxpayerManager();
      stergios.createTaxpayer("Stergios Gerasis", 12345678, "Married Filing Jointly",22570);
      stergios.createReceipt(4332, "23/23/2020",(float) 10000.0,"Basic","ster","Greece","Ioannina","zerva",1,12345678);
      stergios.removeReceipt(4332); 
    }
    catch (Exception e) {
      System.out.println(e);
      Assert.fail("Exception " + e);
    }
  }
  
  @Test
  public void saveLogFileTest() {
    try {
      TaxpayerManager stergios= new TaxpayerManager();
      stergios.createTaxpayer("Stergios Gerasis", 12345678, "Married Filing Jointly",22570);
      //stergios.getTaxpayer(12345678);
      stergios.saveLogFile(12345678, "txt");
    }
    catch (Exception e) {
      System.out.println(e);
      Assert.fail("Exception " + e);
    }
  }
  /*
  @Test
  public void loadTaxpayerTest() {
    try {
      TaxpayerManager stergios= new TaxpayerManager();
      stergios.createTaxpayer("Stergios Gerasis", 12345678, "Married Filing Jointly",10000);
      //stergios.saveLogFile(12345678, "txt");
      stergios.loadTaxpayer("12345678");
    }
    catch (Exception e) {
      System.out.println(e);
      Assert.fail("Exception " + e);
    } 
  }
  */
}
