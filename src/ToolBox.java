public class ToolBox {

    static String greet(String name) {
        return "Hello, " + name + "! Welcome to my Java Toolbox.";
    }

    static double area(double side) {
        return side * side;
    }

    static double area(double length, double width) {
        return length * width;
    }

    static int sum(int... numbers) {
        int total = 0;

        for (int n : numbers) {
            total += n;
        }

        return total;
    }

    static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;

        System.out.println("(inside swap) a = " + a + ", b = " + b);
    }

    // Task 5 - addToBox (object mutation)
    static void addToBox(Box box, int amount) {
        box.value = box.value + amount;
    }

}