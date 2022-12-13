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

  private static HashMap<Integer, Taxpayer> taxpayerManagerhash = new HashMap<Integer, Taxpayer>(0);

  @Test
  public void createTaxpayerTest() {
    try {
      TaxpayerManager taxpayerManager= new TaxpayerManager();
      taxpayerManager.createTaxpayer("taxpayerManager Gerasis", 12345678, "Married Filing Jointly",22570);
      //System.out.println(taxpayerManagerhash);
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
      TaxpayerManager taxpayerManager= new TaxpayerManager();
      taxpayerManager.createTaxpayer("taxpayerManager Gerasis", 12345678, "Married Filing Jointly",22570);
      taxpayerManager.createReceipt(4332, "23/23/2020",(float) 10000.0,"Basic","ster","Greece","Ioannina","zerva",1,12345678);   
    }
    catch (Exception e) {
      System.out.println(e);
      Assert.fail("Exception " + e);
    }
  }
  
  @Test
  public void removeTaxpayerTest() throws WrongTaxpayerStatusException {
    HashMap<Integer, Taxpayer> taxpayerManagerhash = new HashMap<Integer, Taxpayer>(0);
    
    TaxpayerManager taxpayerManager=new TaxpayerManager();
    taxpayerManager.createTaxpayer("taxpayerManager Gerasis", 12345678, "Married Filing Jointly",22570);
    taxpayerManager.removeTaxpayer(12345678);
    
    System.out.println(taxpayerManagerhash);
    
    assertEquals(taxpayerManagerhash.get(12345678),null);
  }
  
  @Test
  public void addReceiptTest() {
    try {
      //Receipt myreceipt= new Receipt();
      TaxpayerManager taxpayerManager= new TaxpayerManager();
      taxpayerManager.createTaxpayer("taxpayerManager Gerasis", 12345678, "Married Filing Jointly",22570);
      //taxpayerManager.createReceipt(4332, "23/23/2020",(float) 10000.0,"Basic","ster","Greece","Ioannina","zerva",1,12345678);
      taxpayerManager.addReceipt(4332, "23/23/2020",(float) 10000.0,"Basic","ster","Greece","Ioannina","zerva",1,12345678); 
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
      TaxpayerManager taxpayerManager= new TaxpayerManager();
      taxpayerManager.createTaxpayer("taxpayerManager Gerasis", 12345678, "Married Filing Jointly",22570);
      taxpayerManager.createReceipt(4332, "23/23/2020",(float) 10000.0,"Basic","ster","Greece","Ioannina","zerva",1,12345678);
      taxpayerManager.removeReceipt(4332); 
    }
    catch (Exception e) {
      System.out.println(e);
      Assert.fail("Exception " + e);
    }
  }
  
  @Test
  public void saveLogFileTest() {
    try {
      TaxpayerManager taxpayerManager= new TaxpayerManager();
      taxpayerManager.createTaxpayer("taxpayerManager Gerasis", 12345678, "Married Filing Jointly",22570);
      //taxpayerManager.getTaxpayer(12345678);
      taxpayerManager.saveLogFile(12345678, "txt");
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
      TaxpayerManager taxpayerManager= new TaxpayerManager();
      taxpayerManager.createTaxpayer("taxpayerManager Gerasis", 12345678, "Married Filing Jointly",10000);
      //taxpayerManager.saveLogFile(12345678, "txt");
      taxpayerManager.loadTaxpayer("12345678");
    }
    catch (Exception e) {
      System.out.println(e);
      Assert.fail("Exception " + e);
    } 
  }
  */
  @Test(expected=WrongFileEndingException.class)
  public void loadTaxpayerTest() throws NumberFormatException, IOException, WrongFileFormatException, WrongFileEndingException, WrongTaxpayerStatusException, WrongReceiptKindException, WrongReceiptDateException {
    String fileName="C:\\users\\kostas\\testfileWithWrongEnding.txx";
    TaxpayerManager taxpayer= new TaxpayerManager();
    taxpayer.loadTaxpayer(fileName);
   
  }
}
