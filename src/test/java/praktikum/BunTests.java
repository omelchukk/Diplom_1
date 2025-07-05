package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class BunTests {


    @Test
    void getNameShouldReturnBunName() {
        String expectedName = "Булочка с кунжутом";
        Bun bun = new Bun(expectedName, 3.0f);

        MatcherAssert.assertThat("Неправильное имя булочки", bun.getName(), equalTo(expectedName));
    }

    @Test
    void getPriceShouldReturnBunPrice() {
        float expectedPrice = 2.25f;
        Bun bun = new Bun("Булочка пшеничная", expectedPrice);

        MatcherAssert.assertThat("Неправильная цена булочки", bun.getPrice(), equalTo(expectedPrice));
    }
}
