package incometaxcalculator.data.management;

public class TaxpayerFactory {

  public Taxpayer createTaxpayerModel(String taxKind,String fullname,int taxRegistrationNumber,float income) {
    
    if(taxKind.equals("Married Filing Jointly"))
      return new MarriedFilingJointlyTaxpayer(fullname, taxRegistrationNumber, income);
    else if(taxKind.equals("Married Filing Separately")) 
      return new MarriedFilingSeparatelyTaxpayer(fullname, taxRegistrationNumber, income);
    else if(taxKind.equals("Single")) 
      return new SingleTaxpayer(fullname, taxRegistrationNumber, income);
    else if(taxKind.equals("Head of Household")) 
      return new HeadOfHouseholdTaxpayer(fullname, taxRegistrationNumber, income);
    return null;
  }
}
