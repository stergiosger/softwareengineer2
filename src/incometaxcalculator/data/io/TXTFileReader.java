package incometaxcalculator.data.io;

public class TXTFileReader extends FileReader {

  @Override
  protected int getReceiptId(String[] values) {
    if (values[0].equals("Receipt")) {
      if (values[1].equals("ID:")) {
        int receiptId = Integer.parseInt(values[2].trim());  
        return receiptId;
      }
    }
    return -1;
  }
  
  @Override
  protected String getValueOfSubFields(String[] values) {
    values[1] = values[1].trim();
    return values[1];
  }

}