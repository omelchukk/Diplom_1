package praktikum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredientTypeTests {

    @ParameterizedTest(name = "Проверка корректности списка типов ингредиентов")
    @EnumSource(IngredientType.class)
    void ingredientTypeIsCorrectEnum(IngredientType type) {

        assertEquals(type, IngredientType.valueOf(type.name()));
    }
}
