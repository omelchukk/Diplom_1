package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BurgerTests {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient1;

    @Mock
    Ingredient ingredient2;

    @Test
    void setBunsWorksCorrect() {
       Burger burger = new Burger();
       burger.setBuns(bun);

       MatcherAssert.assertThat(burger.bun, equalTo(bun));
    }

    @Test
    void addIngredientWorkCorrect() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);

        MatcherAssert.assertThat(burger.ingredients.size(), equalTo(1));
        MatcherAssert.assertThat(burger.ingredients.get(0), equalTo(ingredient1));
    }

    @Test
    void removeIngredientWorkCorrect() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);

        MatcherAssert.assertThat("Ингредиент не был удалён", burger.ingredients.size(), equalTo(0));
    }

    @Test
    void moveIngredientChangesIngredientIndex() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0,1);

        MatcherAssert.assertThat("Ингредиенты не поменялись местами", burger.ingredients.get(1), equalTo(ingredient1));
    }

    @Test
    void getPriceReturnsPrice() {
        Burger burger = new Burger();

        when(bun.getPrice()).thenReturn(3.5f);
        when(ingredient1.getPrice()).thenReturn(2.0f);
        when(ingredient2.getPrice()).thenReturn(2.5f);

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        float actualPrice = burger.getPrice();
        float expectedPrice = 3.5f * 2 + 2.0f + 2.5f;

        MatcherAssert.assertThat("Неправильная цена бургера", actualPrice, equalTo(expectedPrice));

    }

     @Test
    void getReceiptReturnsCorrectReceipt() {
         Burger burger = new Burger();

         when(bun.getName()).thenReturn("Булочка с кунжутом");
         when(bun.getPrice()).thenReturn(1.5f);

         when(ingredient1.getName()).thenReturn("Курица");
         when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
         when(ingredient1.getPrice()).thenReturn(2.0f);

         when(ingredient2.getName()).thenReturn("Чесночный");
         when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);
         when(ingredient2.getPrice()).thenReturn(0.5f);

         burger.setBuns(bun);
         burger.addIngredient(ingredient1);
         burger.addIngredient(ingredient2);

         String receipt = burger.getReceipt();

         assertTrue(receipt.contains("(==== Булочка с кунжутом ====)"));
         assertTrue(receipt.contains("= filling Курица ="));
         assertTrue(receipt.contains("= sauce Чесночный ="));
         MatcherAssert.assertThat(burger.getPrice(), equalTo(5.5f));

     }

}



