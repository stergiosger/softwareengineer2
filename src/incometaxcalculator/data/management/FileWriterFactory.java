package incometaxcalculator.data.management;

import incometaxcalculator.data.io.FileWriter;
import incometaxcalculator.data.io.TXTLogWriter;
import incometaxcalculator.data.io.XMLLogWriter;

public class FileWriterFactory {

  public FileWriter createFileWriter(String fileFormat) {
    if(fileFormat.equals("txt")) return new TXTLogWriter();
    if (fileFormat.equals("xml")) return new XMLLogWriter();
    return null;
  }
}
