package incometaxcalculator.data.io;

import incometaxcalculator.data.management.Receipt;

public class TXTInfoWriter extends InfoWriter {

  @Override
  protected String giveTaxpayerInfo(int i) {
    String[] s = new String[]{"_INFO.txt","Name: ","AFM: ","Status: ","Income: ","Receipts:"};
    //System.out.println(s[1]);
    return  s[i];
  };
  
  
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
  
  @Override
  protected String giveReceiptInfo(int i) {
    String[] s = new String[]{"ReceiptID: ","Date: ","Kind: ","Amount: ","Company: ","Country: ", "City: ","Street: ","Number: "};
    //System.out.println(s[1]);
    return  s[i];
  }

}