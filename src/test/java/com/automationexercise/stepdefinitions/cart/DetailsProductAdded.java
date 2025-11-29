package com.automationexercise.stepdefinitions.cart;

import com.automationexercise.questions.CartPage;
import com.automationexercise.tasks.cart.ProductCart;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class DetailsProductAdded {
    @And("hace click en el botón View Cart en el mensaje de confirmacion")
    public void click_view_cart() {
        theActorInTheSpotlight().attemptsTo(
                ProductCart.clickViewCartLink()
        );
    }

    @Then("se muestra Nombre del producto, Precio y Cantidad")
    public void detail_product(DataTable data) {
        List<List<String>> rows = data.asLists(String.class);
        List<String> valores = rows.get(0); // primera fila

        String expectedName = valores.get(0);
        String expectedPrice = valores.get(1);
        String expectedQty = valores.get(2);

        theActorInTheSpotlight().should(
                seeThat("Se visualiza el nombre del producto", CartPage.productName(), equalTo(expectedName)),
                seeThat("Se visualiza el precio del producto", CartPage.productPrice(), equalTo(expectedPrice)),
                seeThat("Se visualiza la cantidad del producto", CartPage.productQuantity(), equalTo(expectedQty))
        );
    }
}
