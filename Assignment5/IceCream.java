package Assignment5;

public class IceCream extends DessertItem{
  private int cost;

  public IceCream() {
    super();
  }

  public IceCream(String name, int cost) {
    super(name);
    this.cost = cost;
  }

  public int getCost() {
    return this.cost;
  }

  public String toString() {
    return String.format("%s %s",
        this.getName(),
        DessertShoppe.cents2dollarsAndCents(this.getCost()));
  }
}
