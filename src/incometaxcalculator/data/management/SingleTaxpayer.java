package incometaxcalculator.data.management;

public class SingleTaxpayer extends Taxpayer {

  public SingleTaxpayer(String fullname, int taxRegistrationNumber, float income) {
    super(fullname, taxRegistrationNumber, income);
  }

  public double calculateBasicTax() {
    if (income < 24680) {
      return 0.0535 * income;
    } else if (income < 81080) {
      return 1320.38 + 0.0705 * (income - 24680);
    } else if (income < 90000) {
      return 5296.58 + 0.0785 * (income - 81080);
    } else if (income < 152540) {
      return 5996.80 + 0.0785 * (income - 90000);
    } else {
      return 10906.19 + 0.0985 * (income - 152540);
    }
  }

}