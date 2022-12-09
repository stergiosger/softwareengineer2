package incometaxcalculator.data.io;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;

import incometaxcalculator.data.management.Receipt;
/////////////////////////////////////////
import incometaxcalculator.data.management.TaxpayerManager;
///////////////////////////////////////////
public class XMLInfoWriter implements FileWriter {

  public void generateFile(int taxRegistrationNumber) throws IOException {
    //////////////////////////////////////////
    TaxpayerManager manager = new TaxpayerManager();
    ////////////////////////////////////////////////////
    PrintWriter outputStream = new PrintWriter(
        new java.io.FileWriter(taxRegistrationNumber + "_INFO.xml"));
    outputStream.println("<Name> " + manager.getTaxpayerName(taxRegistrationNumber) + " </Name>");
    outputStream.println("<AFM> " + taxRegistrationNumber + " </AFM>");
    outputStream.println("<Status> " + manager.getTaxpayerStatus(taxRegistrationNumber) + " </Status>");
    outputStream.println("<Income> " + manager.getTaxpayerIncome(taxRegistrationNumber) + " </Income>");
    outputStream.println();// den mas emfanize to \n se aplo notepad
    outputStream.println("<Receipts>");
    outputStream.println();
    generateTaxpayerReceipts(taxRegistrationNumber, outputStream);
    outputStream.close();
  }

  
  public int getReceiptId(Receipt receipt) {
    return receipt.getId();
  }

  public String getReceiptIssueDate(Receipt receipt) {
    return receipt.getIssueDate();
  }

  public String getReceiptKind(Receipt receipt) {
    return receipt.getKind();
  }

  public float getReceiptAmount(Receipt receipt) {
    return receipt.getAmount();
  }

  public String getCompanyName(Receipt receipt) {
    return receipt.getCompany().getName();
  }

  public String getCompanyCountry(Receipt receipt) {
    return receipt.getCompany().getCountry();
  }

  public String getCompanyCity(Receipt receipt) {
    return receipt.getCompany().getCity();
  }

  public String getCompanyStreet(Receipt receipt) {
    return receipt.getCompany().getStreet();
  }

  public int getCompanyNumber(Receipt receipt) {
    return receipt.getCompany().getNumber();
  }
  
  private void generateTaxpayerReceipts(int taxRegistrationNumber, PrintWriter outputStream) {
    /////////////////////////////////////////
    TaxpayerManager manager = new TaxpayerManager();
    ////////////////////////////////////////////
    HashMap<Integer, Receipt> receiptsHashMap = manager.getReceiptHashMap(taxRegistrationNumber);
    Iterator<HashMap.Entry<Integer, Receipt>> iterator = receiptsHashMap.entrySet().iterator();
    while (iterator.hasNext()) {
      HashMap.Entry<Integer, Receipt> entry = iterator.next();
      Receipt receipt = entry.getValue();
      outputStream.println("<ReceiptID> " + getReceiptId(receipt) + " </ReceiptID>");
      outputStream.println("<Date> " + getReceiptIssueDate(receipt) + " </Date>");
      outputStream.println("<Kind> " + getReceiptKind(receipt) + " </Kind>");
      outputStream.println("<Amount> " + getReceiptAmount(receipt) + " </Amount>");
      outputStream.println("<Company> " + getCompanyName(receipt) + " </Company>");
      outputStream.println("<Country> " + getCompanyCountry(receipt) + " </Country>");
      outputStream.println("<City> " + getCompanyCity(receipt) + " </City>");
      outputStream.println("<Street> " + getCompanyStreet(receipt) + " </Street>");
      outputStream.println("<Number> " + getCompanyNumber(receipt) + " </Number>");
      outputStream.println();
    }
  }

}