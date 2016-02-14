/*     / \____  _    _  ____   ______  / \ ____  __    _ _____
 *    /  /    \/ \  / \/    \ /  /\__\/  //    \/  \  / /  _  \   Javaslang
 *  _/  /  /\  \  \/  /  /\  \\__\\  \  //  /\  \ /\\/  \__/  /   Daniel Dietrich
 * /___/\_/  \_/\____/\_/  \_/\__\/__/___\_/  \_//  \__/_____/    MIT License
 */
package starter;

import starter.model.Address;
import starter.model.Person;

import java.time.LocalDate;

import static java.time.LocalDate.now;
import static javaslang.Match.*;
import static starter.pattern.StarterPatterns.*;

public class Main {

    public static void main(String[] args) {

        // Example 1

        // could be also null
        Person person = new Person("Carl", new Address("Milkyway", 42));

        // -- the good old way

        String result1 = "not found";
        if (person != null && "Carl".equals(person.getName())) {
            Address address = person.getAddress();
            if (address != null) {
                String street = address.getStreet();
                int number = address.getNumber();
                result1 = "Carl lives in " + street + " " + number;
            }
        }
        System.out.println(result1);

        // -- the fancy new Javaslang way

        String result2 = Match(person).of(
                Case(Person("Carl", Address($(), $())), (street, number) -> "Carl lives in " + street + " " + number),
                Case($_, () -> "not found")
        );
        System.out.println(result2);

        // Example 2

        LocalDate localDate = now();

        String result3 = Match(localDate).of(
                Case(LocalDate(2016, 2, 13), () -> "2016-02-13"),
                Case(LocalDate(2016, $(), $_), m -> "month " + m + " in 2016"),
                Case(LocalDate($(2016), $(), $_), (y, m) -> "month " + m + " in " + y),
                Case($_, () -> "(catch all)")
        );
        System.out.println(result3);
    }

}
