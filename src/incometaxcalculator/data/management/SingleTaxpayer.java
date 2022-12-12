package incometaxcalculator.data.management;

public class SingleTaxpayer extends Taxpayer {

  public SingleTaxpayer(String fullname, int taxRegistrationNumber, float income) {
    super(fullname, taxRegistrationNumber, income);
  }

  
  @Override
  protected int getLimitArray(int i) {
    int[] array=new int[] {24680,81080,90000,152540};
    return array[i];
  }
  
  @Override
  protected double getResultArray(int i) {
    double[] array=new double[] {0.0535 * income,1320.38 + 0.0705 * (income - 24680),5296.58 + 0.0785 * (income - 81080),5996.80 + 0.0785 * (income - 90000),5996.80 + 0.0785 * (income - 90000)};
    return array[i];
  }

}