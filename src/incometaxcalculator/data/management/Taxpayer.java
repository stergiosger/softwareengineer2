package incometaxcalculator.data.management;

import java.util.HashMap;

import incometaxcalculator.exceptions.WrongReceiptKindException;

public abstract class Taxpayer {

  protected final String fullname;
  protected final int taxRegistrationNumber;
  protected final float income;
  private float amountPerReceiptsKind[] = new float[5];
  private int totalReceiptsGathered = 0;
  private HashMap<Integer, Receipt> receiptHashMap = new HashMap<Integer, Receipt>(0);
 
  private final static HashMap<String,Integer> receiptKinds=new HashMap<String,Integer>();
  static {
    receiptKinds.put("ENTERTAINMENT", 0);
    receiptKinds.put("BASIC",1);
    receiptKinds.put("TRAVEL",2);
    receiptKinds.put("HEALTH",3);
    receiptKinds.put("OTHER",4);
  }
  

  abstract int getLimitArray(int i);
  abstract double getResultArray(int i);

  public double calculateBasicTax() {
    if (income < getLimitArray(0)) {
      return getResultArray(0);
    } else if (income < getLimitArray(1)) {
      return getResultArray(1);
    } else if (income < getLimitArray(2)) {
      return getResultArray(2);
    } else if (income < getLimitArray(3)) {
      return getResultArray(4);
    } else {
      return getResultArray(4);
    }
  }
  
  protected Taxpayer(String fullname, int taxRegistrationNumber, float income) {
    this.fullname = fullname;
    this.taxRegistrationNumber = taxRegistrationNumber;
    this.income = income;
  }
  
  public void addReceipt(Receipt receipt) throws WrongReceiptKindException {
    String receiptKind=receipt.getKind().toUpperCase();
    if (receiptKinds.containsKey(receiptKind)) {
      amountPerReceiptsKind[receiptKinds.get(receiptKind)] += receipt.getAmount();
    }else {
      throw new WrongReceiptKindException();
    }
    receiptHashMap.put(receipt.getId(), receipt);
    totalReceiptsGathered++;
  }
  
  public void removeReceipt(int receiptId) throws WrongReceiptKindException {
    Receipt receipt = receiptHashMap.get(receiptId);
    String receiptKind=receipt.getKind().toUpperCase();
    if (receiptKinds.containsKey(receiptKind)) {
      amountPerReceiptsKind[receiptKinds.get(receiptKind)] -= receipt.getAmount();
    }else {
      throw new WrongReceiptKindException();
    }
    totalReceiptsGathered--;
    receiptHashMap.remove(receiptId);
  }

  public String getFullname() {
    return fullname;
  }

  public int getTaxRegistrationNumber() {
    return taxRegistrationNumber;
  }

  public float getIncome() {
    return income;
  }

  public HashMap<Integer, Receipt> getReceiptHashMap() {
    return receiptHashMap;
  }

  
  public double getVariationTaxOnReceipts() {
    
    float totalAmountOfReceipts = getTotalAmountOfReceipts();
    double[] conditions= {0.2 * income,0.4 * income,0.6 * income};
    HashMap<Double,Double> calculations=new HashMap<Double,Double>(){{
      put(0.2 * income,calculateBasicTax() * 0.08);
      put(0.4 * income,calculateBasicTax() * 0.04);
      put(0.6 * income,-calculateBasicTax() * 0.15);
    }};
    
    for(double cond: conditions) {
      if(totalAmountOfReceipts<cond) return calculations.get(cond);          
    }
    return -calculateBasicTax() * 0.3;   
  }

  private float getTotalAmountOfReceipts() {
    int sum = 0;
    for (int i = 0; i < 5; i++) {
      sum += amountPerReceiptsKind[i];
    }
    return sum;
  }

  public int getTotalReceiptsGathered() {
    return totalReceiptsGathered;
  }

  public float getAmountOfReceiptKind(short kind) {
    return amountPerReceiptsKind[kind];
  }

  public double getTotalTax() {
    return calculateBasicTax() + getVariationTaxOnReceipts();
  }

  public double getBasicTax() {
    return calculateBasicTax();
  }

}