package Assignment5;

import com.sun.jdi.PrimitiveValue;

public class Sundae extends IceCream {
  private int cost;
  private String sundae;

  public Sundae() {
    super();
  }

  public Sundae(String iceCream, int iceCreamCost, String topping, int toppingCost) {
    super(iceCream, iceCreamCost);
    this.name = topping;
    this.cost = iceCreamCost + toppingCost;
  }

  public int getCost() {
    return this.cost;
  }

  public String getSundae() {
    return this.sundae;
  }

  public String toString() {
    return String.format("%s Sundae with\n%s %s",
        this.getSundae(),
        super.getName(),
        DessertShoppe.cents2dollarsAndCents(this.getCost()));
  }
}
