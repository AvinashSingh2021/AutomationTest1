//package steps;
//
//import io.cucumber.java8.En;
//import pages.Page;
//
//public class StepDefs extends Page implements En {
//
//    public StepDefs() {
//        Given("I go to url (.*)$", (final String url) -> getUrl(url));
//        When("I can log in with the following (.*) and (.*)$", (String sheetName, Integer rowNumber) -> getLoginPage(sheetName,rowNumber));
//        And("I select Finance tab", () -> getFinancePage());
//        And("I select calendar under Market Data", () -> getCalendarPage());
//        And("I scroll down to view the calendar events", () -> getCalendarEvents());
//        Then("I should verify the calendar events", () -> verifyCalendarEvents());
//	}
//
//}

package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.junit.Cucumber;
import pages.Page;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class StepDefs {

	Page page = new Page();
    
    @Given("^I go to url \"([^\"]*)\"$")
    public void i_go_to_url_automation(String url) {
    	page.getUrl(url);
    }
    
    @When("^I add to the cart dress1 (.+) size (.+)$")
    public void i_add_to_the_cart_dress1_size(String dresstype1, Integer size1) throws Throwable {
    	page.addTshirtToCart(dresstype1,size1);
    }

    @And("^I add to the cart dress2 (.+) size (.+)$")
    public void i_add_to_the_cart_dress2_size(String dresstype2, Integer size2) throws Throwable {
    	page.addEveningDressToCart(dresstype2,size2);
    }

    @And("^I add to the cart dress3 (.+) size (.+)$")
    public void i_add_to_the_cart_dress3_size(String dresstype3, Integer size3) throws Throwable {
    	page.addSummerDressToCart(dresstype3,size3);
    }

    @And("^I perform checkout$")
    public void i_perform_checkout() throws Throwable {
    	page.checkout();
    }

    @And("^I remove the evening dress from the cart$")
    public void i_remove_the_evening_dress_from_the_cart() throws Throwable {
    	page.removeEveningDressFromCart();
    }
    
    @And("^I add second dress1 to the cart (.+) size (.+)$")
    public void i_add_second_dress1_to_the_cart_size(String dresstype1, Integer size1) throws Throwable {
    	page.addTshirtToCart(dresstype1,size1);
    }
    
    @Then("^I assert the total for each line in the cart$")
    public void i_assert_the_total_for_each_line_in_the_cart() throws Throwable {
    	page.assertEachItem();
    }

    @And("^I assert the cart total$")
    public void i_assert_the_cart_total() throws Throwable {
    	page.assertCartTotal();
    }

}
