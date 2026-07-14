package com.testinium.gaugeplaywright.steps;

import com.microsoft.playwright.Page;
import com.testinium.gaugeplaywright.support.PlaywrightRuntime;
import com.thoughtworks.gauge.Step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlaywrightSteps {

    private Page page() {
        return PlaywrightRuntime.page();
    }

    @Step("I open the Google page")
    public void iOpenTheGooglePage() {
        PlaywrightRuntime.markStep("open-google-page");
        page().navigate("https://www.google.com");
    }

    @Step("I should see Google in the title")
    public void iShouldSeeGoogleInTheTitle() {
        PlaywrightRuntime.markStep("assert-google-title");
        assertTrue(page().title().contains("Google"));
    }

    @Step("I prepare the login page")
    public void iPrepareTheLoginPage() {
        PlaywrightRuntime.markStep("prepare-login-page");
        page().setContent(String.join("\n",
                "<html>",
                "  <head><title>Login</title></head>",
                "  <body>",
                "    <label>Username <input id=\"username\"></label>",
                "    <label>Password <input id=\"password\" type=\"password\"></label>",
                "    <button id=\"login\">Login</button>",
                "    <p id=\"result\"></p>",
                "    <script>",
                "      document.querySelector('#login').onclick = () => {",
                "        document.querySelector('#result').textContent = 'Login successful';",
                "      };",
                "    </script>",
                "  </body>",
                "</html>"
        ));
    }

    @Step("I enter login credentials")
    public void iEnterLoginCredentials() {
        PlaywrightRuntime.markStep("enter-login-credentials");
        page().locator("#username").fill("testinium-user");
        page().locator("#password").fill("secret-password");
    }

    @Step("I submit the login form")
    public void iSubmitTheLoginForm() {
        PlaywrightRuntime.markStep("submit-login-form");
        page().locator("#login").click();
    }

    @Step("I should see the login success message")
    public void iShouldSeeTheLoginSuccessMessage() {
        PlaywrightRuntime.markStep("assert-login-success");
        assertEquals("Login successful", page().locator("#result").textContent());
    }

    @Step("I prepare the todo page")
    public void iPrepareTheTodoPage() {
        PlaywrightRuntime.markStep("prepare-todo-page");
        page().setContent(String.join("\n",
                "<html>",
                "  <head><title>Todo List</title></head>",
                "  <body>",
                "    <input id=\"todo\" placeholder=\"New task\">",
                "    <button id=\"add\">Add</button>",
                "    <ul id=\"list\"></ul>",
                "    <script>",
                "      document.querySelector('#add').onclick = () => {",
                "        const input = document.querySelector('#todo');",
                "        const item = document.createElement('li');",
                "        item.textContent = input.value;",
                "        document.querySelector('#list').appendChild(item);",
                "        input.value = '';",
                "      };",
                "    </script>",
                "  </body>",
                "</html>"
        ));
    }

    @Step("I add a todo item")
    public void iAddATodoItem() {
        PlaywrightRuntime.markStep("add-todo-item");
        page().locator("#todo").fill("Check the Playwright trace report");
        page().locator("#add").click();
    }

    @Step("I should see the todo item in the list")
    public void iShouldSeeTheTodoItemInTheList() {
        PlaywrightRuntime.markStep("assert-todo-item");
        assertEquals(
                "Check the Playwright trace report",
                page().locator("#list li").textContent()
        );
    }

    @Step("I prepare the preferences page")
    public void iPrepareThePreferencesPage() {
        PlaywrightRuntime.markStep("prepare-preferences-page");
        page().setContent(String.join("\n",
                "<html>",
                "  <head><title>Test Preferences</title></head>",
                "  <body>",
                "    <label>Browser",
                "      <select id=\"browser\">",
                "        <option value=\"chromium\">Chromium</option>",
                "        <option value=\"firefox\">Firefox</option>",
                "        <option value=\"webkit\">WebKit</option>",
                "      </select>",
                "    </label>",
                "    <label><input id=\"headless\" type=\"checkbox\"> Run headless</label>",
                "  </body>",
                "</html>"
        ));
    }

    @Step("I choose Firefox and enable headless mode")
    public void iChooseFirefoxAndEnableHeadlessMode() {
        PlaywrightRuntime.markStep("set-preferences");
        page().locator("#browser").selectOption("firefox");
        page().locator("#headless").check();
    }

    @Step("I should see the selected preferences")
    public void iShouldSeeTheSelectedPreferences() {
        PlaywrightRuntime.markStep("assert-preferences");
        assertEquals("firefox", page().locator("#browser").inputValue());
        assertTrue(page().locator("#headless").isChecked());
    }
}
