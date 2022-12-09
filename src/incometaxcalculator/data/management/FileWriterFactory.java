package incometaxcalculator.data.management;

import incometaxcalculator.data.io.FileWriter;
import incometaxcalculator.data.io.TXTLogWriter;
import incometaxcalculator.data.io.XMLLogWriter;

public class FileWriterFactory {

  public FileWriter createFileWriter(String fileFormat) {
    if(fileFormat.equals("txt")) return (FileWriter) new TXTLogWriter();
    if (fileFormat.equals("xml")) return (FileWriter) new XMLLogWriter();
    return null;
  }
}
