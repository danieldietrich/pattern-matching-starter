/*     / \____  _    _  ____   ______  / \ ____  __    _ _____
 *    /  /    \/ \  / \/    \ /  /\__\/  //    \/  \  / /  _  \   Javaslang
 *  _/  /  /\  \  \/  /  /\  \\__\\  \  //  /\  \ /\\/  \__/  /   Daniel Dietrich
 * /___/\_/  \_/\____/\_/  \_/\__\/__/___\_/  \_//  \__/_____/    MIT License
 */
package starter.pattern;

import javaslang.Tuple;
import javaslang.Tuple2;
import javaslang.Tuple3;
import javaslang.match.Patterns;
import javaslang.match.Unapply;
import starter.model.Address;
import starter.model.Person;

import java.time.LocalDate;

@Patterns
class Starter {

    @Unapply
    static Tuple2<String, Address> Person(Person person) {
        return Tuple.of(person.getName(), person.getAddress());
    }

    @Unapply
    static Tuple2<String, Integer> Address(Address address) {
        return Tuple.of(address.getStreet(), address.getNumber());
    }

    @Unapply
    static Tuple3<Integer, Integer, Integer> LocalDate(LocalDate date) {
        return Tuple.of(date.getYear(), date.getMonthValue(), date.getDayOfMonth());
    }
}
