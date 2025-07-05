package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTests {

    @Test
    void getPriceShouldReturnIngredientPrice() {
        float expectedPrice = 5.5f;
        Ingredient ingredient = new Ingredient(SAUCE,"Сырный", expectedPrice);

        MatcherAssert.assertThat("Неправильная цена ингредиента", ingredient.getPrice(), equalTo(expectedPrice));
    }

    @Test
    void getNameShouldReturnIngredientName() {
        String expectedName = "Тартар";
        Ingredient ingredient = new Ingredient(SAUCE, expectedName, 6.0f);

        MatcherAssert.assertThat("Неправильное имя ингредиента", ingredient.getName(), equalTo(expectedName));
    }

    @Test
    void getTypeShouldReturnIngredientType() {
        IngredientType expectedType = FILLING;
        Ingredient ingredient = new Ingredient(expectedType, "Мясная", 7.8f);

        MatcherAssert.assertThat("Неправильный тип ингредиента", ingredient.getType(), equalTo(expectedType));
    }
}
