package incometaxcalculator.data.management;

import incometaxcalculator.data.io.FileReader;
import incometaxcalculator.data.io.TXTFileReader;
import incometaxcalculator.data.io.XMLFileReader;

public class FileReaderFactory {
  public FileReader createFileReader(String fileFormat) {
    if(fileFormat.equals("txt")) return new TXTFileReader();
    if(fileFormat.equals("xml")) return new XMLFileReader();
    return null;
  }

}
