package incometaxcalculator.data.io;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
//import java.util.Map.Entry;

import incometaxcalculator.data.management.Receipt;
import incometaxcalculator.data.management.TaxpayerManager;

public abstract class InfoWriter implements FileWriter {

  
  protected abstract String giveTaxpayerInfo(int i);
  
  protected abstract String giveReceiptInfo(int i);
  
  
  public void generateFile(int taxRegistrationNumber) throws IOException {

    TaxpayerManager manager = new TaxpayerManager();

    PrintWriter outputStream = new PrintWriter(
        new java.io.FileWriter(taxRegistrationNumber + giveTaxpayerInfo(0) + giveTaxpayerInfo(6)));
    outputStream.println(giveTaxpayerInfo(1) + manager.getTaxpayerName(taxRegistrationNumber) + giveTaxpayerInfo(7));
    outputStream.println(giveTaxpayerInfo(2) + taxRegistrationNumber + giveTaxpayerInfo(8));
    outputStream.println(giveTaxpayerInfo(3) + manager.getTaxpayerStatus(taxRegistrationNumber) + giveTaxpayerInfo(9));
    outputStream.println(giveTaxpayerInfo(4) + manager.getTaxpayerIncome(taxRegistrationNumber) + giveTaxpayerInfo(10));
    outputStream.println();// den mas emfanize to \n se aplo notepad
    outputStream.println(giveTaxpayerInfo(5));
    outputStream.println();
    generateTaxpayerReceipts(taxRegistrationNumber, outputStream);
    outputStream.close();
  }

  public void generateTaxpayerReceipts(int taxRegistrationNumber, PrintWriter outputStream) {
    TaxpayerManager manager = new TaxpayerManager();
    HashMap<Integer, Receipt> receiptsHashMap = manager.getReceiptHashMap(taxRegistrationNumber);
    Iterator<HashMap.Entry<Integer, Receipt>> iterator = receiptsHashMap.entrySet().iterator();
    while (iterator.hasNext()) {
      HashMap.Entry<Integer, Receipt> entry = iterator.next();
      Receipt receipt = entry.getValue();
      outputStream.println(giveReceiptInfo(0) + getReceiptId(receipt));
      outputStream.println(giveReceiptInfo(1) + getReceiptIssueDate(receipt));
      outputStream.println(giveReceiptInfo(2) + getReceiptKind(receipt));
      outputStream.println(giveReceiptInfo(3) + getReceiptAmount(receipt));
      outputStream.println(giveReceiptInfo(4) + getCompanyName(receipt));
      outputStream.println(giveReceiptInfo(5) + getCompanyCountry(receipt));
      outputStream.println(giveReceiptInfo(6) + getCompanyCity(receipt));
      outputStream.println(giveReceiptInfo(7) + getCompanyStreet(receipt));
      outputStream.println(giveReceiptInfo(8) + getCompanyNumber(receipt));
      outputStream.println();
    }
  }

  

}
