package entities;

public class LegalPerson extends Person {

	private Integer numberOfEmployees;

	public LegalPerson(String name, Double annualIncome, Integer numberOfEmployees) {
		super(name, annualIncome);
		this.numberOfEmployees = numberOfEmployees;
	}

	public Integer getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(Integer numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	@Override
	public Double taxes() {
		if (getNumberOfEmployees() > 10)
			return getAnnualIncome() * 0.14;
		else
			return getAnnualIncome() * 0.16;
	}

	@Override
	public String toString() {
		return getName() + ": $ " + String.format("%.2f", getAnnualIncome());
	}

}
