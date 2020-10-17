package Assignment5;

import java.util.ArrayList;

public class Checkout {
  ArrayList<DessertItem> dessertItems;

  public Checkout() {
    this.dessertItems = new ArrayList<>();
  }

  public int numberOfItems() {
    return this.dessertItems.size();
  }

  public void enterItem(DessertItem dessertItem) {
    this.dessertItems.add(dessertItem);
  }

  public void clear() {
    this.dessertItems.clear();
  }

  public int totalCost() {
    int totalCost = 0;
    for (DessertItem dessertItem : this.dessertItems) {
      totalCost += dessertItem.getCost();
    }
    return totalCost;
  }

  public int totalTax() {
    int totalTax = 0;
    for (DessertItem dessertItem : this.dessertItems) {
      totalTax += Math.round(dessertItem.getCost() * DessertShoppe.TAX_RATE);
    }
    return totalTax;
  }

  public String toString() {
    StringBuilder dessertItems = new StringBuilder();
    for (DessertItem dessertItem : this.dessertItems) {
      dessertItems.append(dessertItem.toString()).append("\n");
    }
    return String.format("%s\n%s\n%sTax %s\nTotal cost %s",
                          DessertShoppe.STORE_NAME,
                          "- ".repeat(DessertShoppe.MAX_RECEIPT_WIDTH / 2),
                          dessertItems.toString(),
                          DessertShoppe.cents2dollarsAndCents(this.totalTax()),
                          DessertShoppe.cents2dollarsAndCents(this.totalCost() + this.totalTax()));
  }
}
