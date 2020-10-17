package Assignment5;

public class Cookie extends DessertItem {
  private int number;
  private int pricePerDozen;

  public Cookie(){
    super();
  }

  public Cookie(String name, int number, int pricePerDozen) {
      super(name);
      this.number = number;
      this.pricePerDozen = pricePerDozen;
  }

  public int getCost() {
    return (int)Math.round(((double)this.number / 12) * this.pricePerDozen);
  }

  public int getNumber() {
    return this.number;
  }

  public int getPricePerDozen() {
    return this.pricePerDozen;
  }

  public String toString() {
    return String.format("%d @ %s /dz.\n%s %s",
        this.getNumber(),
        DessertShoppe.cents2dollarsAndCents(this.getPricePerDozen()),
        this.getName(),
        DessertShoppe.cents2dollarsAndCents(this.getCost()));
  }
}
