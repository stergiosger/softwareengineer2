package incometaxcalculator.data.management;

import java.io.IOException;
import incometaxcalculator.data.io.TXTInfoWriter;
import incometaxcalculator.data.io.XMLInfoWriter;

public class FileInfoFactory {
  
  public void updateInfoFile(int taxRegistrationNumber, String fileEnding) throws IOException {
    if(fileEnding.equals("_INFO.xml")) 
      new XMLInfoWriter().generateFile(taxRegistrationNumber);
    else if(fileEnding.equals("_INFO.txt"))
      new TXTInfoWriter().generateFile(taxRegistrationNumber);
   
  }
}
