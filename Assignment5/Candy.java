package Assignment5;

public class Candy extends DessertItem {
  private double weight;
  private int pricePerPound;

  public Candy() {
    super();
  }

  public Candy(String name, double weight, int pricePerPound) {
    super(name);
    this.weight = weight;
    this.pricePerPound = pricePerPound;
  }

  public int getCost() {
    return (int) Math.round(this.weight * this.pricePerPound);
  }

  public double getWeight() {
    return this.weight;
  }

  public String toString() {
    return String.format("%.2f lbs. @ %s /lb.\n%s %s",
            this.getWeight(),
            DessertShoppe.cents2dollarsAndCents(this.pricePerPound),
            this.getName(),
            DessertShoppe.cents2dollarsAndCents(this.getCost()));
  }
}
