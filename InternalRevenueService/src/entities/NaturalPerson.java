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
		double health;
		if (healthExpenses != 0.00 || healthExpenses != null)
			health = 0.00;
		else
			health = (healthExpenses * 0.5);

		if (getAnnualIncome() < 20000.00)
			return (getAnnualIncome() * 0.15) - health;
		else
			return (getAnnualIncome() * 0.25) - health;
	}

}
