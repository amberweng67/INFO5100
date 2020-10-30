public class Cat extends Pet implements Boardable {
    private String hairLength;
    private int boardStartMonth;
    private int boardStartDay;
    private int boardStartYear;
    private int boardEndMonth;
    private int boardEndDay;
    private int boardEndYear;

    public Cat(String name, String ownerName, String color, String hairLength) {
        super(name, ownerName, color);
        this.hairLength = hairLength;
    }

    public String getHairLength() {
        return this.hairLength;
    }

    public String toString() {
        String str = "";
        try {
            str = String.format("CAT:\n%s owned by %s\nColor: %s\nSex: %s\nHair: %s",
                    this.getPetName(),
                    this.getOwnerName(),
                    this.getColor(),
                    this.getSex(),
                    this.getHairLength());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return str;
    }

    public void setBoardStart(int month, int day, int year) {
        this.boardStartMonth = month;
        this.boardStartDay = day;
        this.boardStartYear = year;
    };

    public void setBoardEnd(int month, int day, int year) {
        this.boardEndMonth = month;
        this.boardEndDay = day;
        this.boardEndYear = year;
    };

    public boolean boarding(int month, int day, int year) {
        return this.boardStartDay <= day && day <= this.boardEndDay
                && this.boardStartMonth <= month && month <= this.boardEndMonth
                &&  this.boardStartYear <= year && year <= this.boardEndYear;
    };

    public static void main(String[] args) {
        Cat c = new Cat("Tom", "Bob", "black", "short");
        c.setSex(c.SPAYED);
        System.out.println(c.toString());
    }
}
