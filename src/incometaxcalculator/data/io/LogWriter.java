package incometaxcalculator.data.io;

import java.io.IOException;
import java.io.PrintWriter;

import incometaxcalculator.data.management.TaxpayerManager;

public abstract class LogWriter {

  static final short ENTERTAINMENT = 0;
  static final short BASIC = 1;
  static final short TRAVEL = 2;
  static final short HEALTH = 3;
  static final short OTHER = 4;

  protected abstract String giveLogInfo(int i);
  
  public void generateFile(int taxRegistrationNumber) throws IOException {

    TaxpayerManager manager = new TaxpayerManager();

    PrintWriter outputStream = new PrintWriter(
        new java.io.FileWriter(taxRegistrationNumber + giveLogInfo(0)));
    outputStream.println(giveLogInfo(1) + manager.getTaxpayerName(taxRegistrationNumber) + giveLogInfo(13));
    outputStream.println(giveLogInfo(2) + taxRegistrationNumber + giveLogInfo(14));
    outputStream.println(giveLogInfo(3) + manager.getTaxpayerIncome(taxRegistrationNumber) + giveLogInfo(15));
    outputStream.println(giveLogInfo(4) + manager.getTaxpayerBasicTax(taxRegistrationNumber) + giveLogInfo(16));
    if (manager.getTaxpayerVariationTaxOnReceipts(taxRegistrationNumber) > 0) {
      outputStream
          .println(giveLogInfo(5) + manager.getTaxpayerVariationTaxOnReceipts(taxRegistrationNumber)+ giveLogInfo(17));
    } else {
      outputStream
          .println(giveLogInfo(6) + manager.getTaxpayerVariationTaxOnReceipts(taxRegistrationNumber) + giveLogInfo(18));
    }
    outputStream.println(giveLogInfo(7) + manager.getTaxpayerTotalTax(taxRegistrationNumber) + giveLogInfo(19));
    outputStream.println(
        giveLogInfo(8) + manager.getTaxpayerTotalReceiptsGathered(taxRegistrationNumber) + giveLogInfo(20));
    outputStream.println(
        giveLogInfo(9) + manager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, ENTERTAINMENT) + giveLogInfo(21));
    outputStream.println(giveLogInfo(9) + manager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, BASIC) + giveLogInfo(22));
    outputStream
        .println(giveLogInfo(10) + manager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, TRAVEL) + giveLogInfo(23));
    outputStream
        .println(giveLogInfo(11) + manager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, HEALTH) + giveLogInfo(24));
    outputStream.println(giveLogInfo(12) + manager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, OTHER) + giveLogInfo(25));
    outputStream.close();
  }


}
