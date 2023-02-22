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
		double taxes = (getAnnualIncome() < 20000.00) ? getAnnualIncome() * 0.15 : getAnnualIncome() * 0.25;
		taxes -= getHealthExpenses() * 0.5;
		return taxes;
	}

	@Override
	public String toString() {
		return getName() + ": $ " + String.format("%.2f", taxes());
	}

}
