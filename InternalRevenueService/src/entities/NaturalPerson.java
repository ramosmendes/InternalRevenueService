package entities;

public class NaturalPerson extends Person {

	private Double healthExpenses;

	public NaturalPerson(String name, Double annualIncome, Double healthExpenses) {
		super(name, annualIncome);
		this.healthExpenses = healthExpenses;
	}

	public Double getHealthExpenses() {
		return healthExpenses;
	}

	@Override
	public Double taxes() {
		double discount;
		if (healthExpenses == 0.00 || healthExpenses == null)
			discount = 0.00;
		else
			discount = (healthExpenses * 0.5);

		if (getAnnualIncome() < 20000.00)
			return (getAnnualIncome() * 0.15) - discount;
		else
			return (getAnnualIncome() * 0.25) - discount;
	}

	@Override
	public String toString() {
		return getName() + ": $ " + String.format("%.2f", taxes());
	}

}
