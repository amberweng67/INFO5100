package Assignment5;

public class DessertShoppe {
    protected static final double TAX_RATE = 0.065;
    protected static final String STORE_NAME = "Amber Dessert Shoppe";
    protected static final int MAX_RECEIPT_WIDTH = 20;
    protected static final int MAX_DESSERT_ITEM_NAME_LENGTH = 40;

    public static String cents2dollarsAndCents(int cost) {
        return String.format("%.2f", (double)cost / 100).replaceFirst("^0\\.", ".");
    }
}
