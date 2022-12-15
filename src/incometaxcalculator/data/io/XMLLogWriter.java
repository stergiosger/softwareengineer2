package incometaxcalculator.data.io;

public class XMLLogWriter extends LogWriter {

  @Override
  protected String giveLogInfo(int i) {
    String[] s = new String[]{"_LOG.xml","<Name> ","<AFM> ","<Income> ","<Basic Tax> ","<Tax Increase> ", "<Tax Decrease> ","<Total Tax> ","<TotalReceiptsGathered> ","<Entertainment:> ","<Basic> ","<Travel> ","<Health> ","<Other> ","</Name> ","</AFM> ","</Income> ","</Basic Tax> ","</Tax Increase> ", "</Tax Decrease> ","</Total Tax> ","</TotalReceiptsGathered> ","</Entertainment:> ","</Basic> ","</Travel> ","</Health> ","</Other> "};
    return  s[i];
  };

}
