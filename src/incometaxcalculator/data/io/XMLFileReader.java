package incometaxcalculator.data.io;

import java.io.BufferedReader;
import java.io.IOException;

import incometaxcalculator.exceptions.WrongFileFormatException;

public class XMLFileReader extends FileReader {

 /* protected int checkForReceipt(BufferedReader inputStream)
      throws NumberFormatException, IOException {
    String line;
    while (!isEmpty(line = inputStream.readLine())) {
      String values[] = line.split(" ", 3);
      getReceiptId(values);
    }
    return -1;
  }*/
  
  @Override
  protected int getReceiptId(String[] values) {
    if (values[0].equals("<ReceiptID>")) {
      int receiptId = Integer.parseInt(values[1].trim());
      return receiptId;
    }
  return -1;
  }
  
 /* protected String getValueOfField(String fieldsLine) throws WrongFileFormatException {
    if (isEmpty(fieldsLine)) {
      throw new WrongFileFormatException();
    }
    try {
      String values[] = fieldsLine.split(" ", 2);
      return getValueOfSubFields(values);
    } catch (NullPointerException e) {
      throw new WrongFileFormatException();
    }
  }*/
  
  
  @Override
  protected String getValueOfSubFields(String[] values) {
    String valueReversed[] = new StringBuilder(values[1]).reverse().toString().trim()
        .split(" ", 2);
    return new StringBuilder(valueReversed[1]).reverse().toString();
  }

}
