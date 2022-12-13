package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import incometaxcalculator.data.io.TXTInfoWriter;
import incometaxcalculator.data.management.Receipt;
import incometaxcalculator.exceptions.WrongReceiptDateException;
import incometaxcalculator.data.management.Company;
public class TXTInfoWriterTests {
 
  private TXTInfoWriter txtInfoWriter=new TXTInfoWriter();
  private Receipt receipt;
  private float amount;
  
  @Before
  public void createReceipt() throws WrongReceiptDateException {
    amount=(float) 56.0;
    Company company=new Company("KAYKAS","Greece","Ioannina","artas-ioanninwn",75);
    receipt=new Receipt(10,"23/12/2023",amount,"Health",company);
  }
  
  @Test
  public void getReceiptIdTest() throws WrongReceiptDateException {
    
    int expectedValue=10;
    int actual=txtInfoWriter.getReceiptId(receipt);
    assertEquals(expectedValue,actual);
    
  }
    
  @Test
  public void getReceiptIssueDateTest() {
    String expectedValue="23/12/2023";
    String actual=txtInfoWriter.getReceiptIssueDate(receipt);
    assertEquals(expectedValue,actual);
  }
  
  @Test
  public void getReceiptKindTest() {
    String expectedValue="Health";
    String actual=txtInfoWriter.getReceiptKind(receipt);
    assertEquals(expectedValue,actual);  
  }
  
  @Test
  public void getReceiptAmountTest() {
    float expectedValue=amount;
    float actual=txtInfoWriter.getReceiptAmount(receipt);
    assertTrue(expectedValue==actual); 
  }
  
  
  @Test
  public void getCompanyNameTest() {
    String expectedValue="KAYKAS";
    String actual=txtInfoWriter.getCompanyName(receipt);
    assertEquals(expectedValue,actual);  
  }
  
  
  @Test
  public void getCompanyCountryTest() {
    String expectedValue="Greece";
    String actual=txtInfoWriter.getCompanyCountry(receipt);
    assertEquals(expectedValue,actual);  
  }
  
  
  @Test
  public void getCompanyCityTest() {
    String expectedValue="Ioannina";
    String actual=txtInfoWriter.getCompanyCity(receipt);
    assertEquals(expectedValue,actual);  
  }
  
  
  @Test
  public void getCompanyStreetTest() {
    String expectedValue="artas-ioanninwn";
    String actual=txtInfoWriter.getCompanyStreet(receipt);
    assertEquals(expectedValue,actual);  
  }
  
  
  @Test
  public void getCompanyNumberTest() {
    int expectedValue=75;
    int actual=txtInfoWriter.getCompanyNumber(receipt);
    assertEquals(expectedValue,actual);  
  }
  
  
  
  
  
  
}

