public class Pet {
    private String name;
    private String ownerName;
    private String color;
    protected int sex;

    public static final int MALE = 0;
    public static final int FEMALE = 1;
    public static final int SPAYED = 2;
    public static final int NEUTERED = 3;

    public Pet (String name, String ownerName, String color) {
        this.name = name;
        this.ownerName = ownerName;
        this.color = color;
    }

    public String getPetName() {
        return this.name;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public String getColor() {
        return this.color;
    }

    public void setSex (int sexId) {
        this.sex = sexId;
    }

    public String getSex() throws Exception {
        return switch (this.sex) {
            case 0 -> "Male";
            case 1 -> "Female";
            case 2 -> "Spayed";
            case 3 -> "Neutered";
            default -> throw new Exception("Unsupported sex type");
        };
    }

    public String toString() {
        String sex = "";
        try {
            sex = this.getSex();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return String.format("%s owned by %s.\nColor: is %s.\nSex: %s",
                this.getPetName(),
                this.getOwnerName(),
                this.getColor(),
                sex);
    }
}
