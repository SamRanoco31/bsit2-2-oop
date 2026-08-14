import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
// ONE list holds Cars AND Motorcycles,
// because both ARE Vehicles (inheritance).
        ArrayList&lt;Vehicle&gt; vehicles = new ArrayList&lt;&gt;();
        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (choice != 5) {
            System.out.println();
            System.out.println(&quot;===== VEHICLE MANAGER =====&quot;);
            System.out.println(&quot;1 - Add Car&quot;);
            System.out.println(&quot;2 - Add Motorcycle&quot;);
            System.out.println(&quot;3 - Remove a Vehicle&quot;);
            System.out.println(&quot;4 - Display All Vehicles&quot;);
            System.out.println(&quot;5 - Exit&quot;);
            System.out.print(&quot;Choose an option: &quot;);
            choice = input.nextInt();
            input.nextLine(); // clear the leftover newline
            if (choice == 1) {
                System.out.print(&quot;Brand: &quot;);
                String brand = input.nextLine();
                System.out.print(&quot;Year: &quot;);
                int year = input.nextInt();
                System.out.print(&quot;Number of doors: &quot;);
                int doors = input.nextInt();
// TODO 7: make a Car and add it to the list:
// vehicles.add(new Car(brand, year, doors));
                System.out.println(&quot;&gt;&gt; Car added!&quot;);
            }
            else if (choice == 2) {
                System.out.print(&quot;Brand: &quot;);
                String brand = input.nextLine();
                System.out.print(&quot;Year: &quot;);
                int year = input.nextInt();
                System.out.print(&quot;Has sidecar? (true/false): &quot;);
                boolean sidecar = input.nextBoolean();
// TODO 8: make a Motorcycle and add it to the list
                System.out.println(&quot;&gt;&gt; Motorcycle added!&quot;);
            }
            else if (choice == 3) {
                System.out.print(&quot;Enter the number to remove: &quot;);
                int number = input.nextInt();
// TODO 9: if the number is valid, remove that vehicle:
// if (number &gt;= 1 &amp;&amp; number &lt;= vehicles.size()) {

                Object-Oriented Programming • Lab Activity 6 — Inheritance • Page 4

// vehicles.remove(number - 1);
// System.out.println(&quot;&gt;&gt; Removed!&quot;);
// } else {
// System.out.println(&quot;&gt;&gt; Invalid number.&quot;);
// }
            }
            else if (choice == 4) {
                System.out.println(&quot;--- All Vehicles ---&quot;);
                if (vehicles.isEmpty()) {
                    System.out.println(&quot;(none yet)&quot;);
                }
// TODO 10: loop the list and show each vehicle:
// for (int i = 0; i &lt; vehicles.size(); i++) {
// System.out.print((i + 1) + &quot;. &quot;);
// vehicles.get(i).displayInfo();
// }
            }
        }
        System.out.println(&quot;Goodbye!&quot;);
        input.close();
    }
}
