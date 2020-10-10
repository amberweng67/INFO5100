class Circle{
    private Double radius = 1.0;
    private String color = "red";

    public Circle() {
    }

    public Circle(Double radius) {
        this.setRadius(radius);
    }

    public Circle(Double radius, String color) {
        this.setRadius(radius);
        this.setColor(color);
    }

    public Double getRadius() {
        return this.radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getArea() {
        return Math.PI * radius * radius;
    }
}

class Cylinder extends Circle {
    private Double height = 1.0;

    public Cylinder() {
    }

    public Cylinder(Double height) {
        this.setHeight(height);
    }

    public Cylinder(Double height, Double radius) {
        this.setRadius(radius);
        this.setHeight(height);
    }

    public Cylinder(Double height, Double radius, String color){
        this.setRadius(radius);
        this.setColor(color);
        this.setHeight(height);
    }

    public Double getHeight() {
        return this.height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getVolume(){
        return this.getBaseArea() * height;
    }

    public Double getBaseArea() {
        return super.getArea();
    }

    @Override
    public Double getArea() {
        return 2 * Math.PI * this.getRadius() * (this.getRadius() + this.getHeight());
    }
}

Public class TestCylinder {
    public static void main(String[] args) {
        //Constructed a Circle with Circle()
        //Run of the program should produce the following output:
        //Radius is 2.0, Color is yellow, Base area is (your answer)
        Circle circle = new Circle(2.0, "yellow");
        printCircle(circle);

        //Constructed a Cylinder with Cylinder()
        //Run of the program should produce the following output:
        //Radius is 1.0, Height is 1.0, Color is red, Base area is (your answer), Volume is (your answer)
        Cylinder cylinder = new Cylinder();
        printCylinder(cylinder);

        //Constructed a Cylinder with Cylinder(height, radius)
        //Run of the program should produce the following output:
        //Radius is 2.0, Height is 5.0, Color is red, Base area is (your answer), Volume is (your answer)
        cylinder = new Cylinder(5.0, 2.0);
        printCylinder(cylinder);
    }

    private static void printCircle(Circle circle) {
        System.out.format(
                "Radius is %.1f, Color is %s, Base area is %.1f \n",
                circle.getRadius(),
                circle.getColor(),
                circle.getArea());
    }

    private static void printCylinder(Cylinder cylinder) {
        System.out.format(
                "Radius is %.1f, Height is %.1f, Color is %s, Base area is %.1f, Volume is %.1f \n",
                cylinder.getRadius(),
                cylinder.getHeight(),
                cylinder.getColor(),
                cylinder.getBaseArea(),
                cylinder.getVolume());
    }
}