public class Dog extends Pet implements Boardable {
    private String size;
    private int boardStartMonth;
    private int boardStartDay;
    private int boardStartYear;
    private int boardEndMonth;
    private int boardEndDay;
    private int boardEndYear;

    public Dog(String name, String ownerName, String color, String size) {
        super(name, ownerName, color);
        this.size = size;
    }

    public String getSize() {
        return this.size;
    }

    public String toString() {
        String str = "";
        try {
            str = String.format("Dog:\n%s owned by %s\nColor: %s\nSex: %s\nSize: %s",
                this.getPetName(),
                this.getOwnerName(),
                this.getColor(),
                this.getSex(),
                this.getSize());
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
        Dog d = new Dog("Spot", "Susan", "white", "medium");
        d.setSex(d.SPAYED);
        System.out.println(d.toString());
    }
}
