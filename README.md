# selenideGuideline

## Introduce

Selenide is a framework for writing easy-to-read and easy-to-maintain automated tests in Java. It defines concise fluent API,
natural language assertions and does some magic for ajax-based applications to let you focus entirely on the business logic of your tests.

Selenide is based on and is compatible to Selenium WebDriver 4.0+. For more information, you can look for in [link](https://github.com/selenide/selenide).

## Setup requirement

Before coding, you must set up:

- IDE (I suggest you should use JetBrains Aqua, a powerful IDE for automation testing. Other, you can choose your favourite IDE 
and import Selenide generator [link](https://plugins.jetbrains.com/plugin/16421-selenide-generator)).
- Java SDK

## Installation and Getting Started

The [quick start](https://selenide.org/quick-start.html) includes guideline to installation and set-up new project. 

Here is a quick teaser of a complete Selenide application in Java:

```MainPageTest.java
@Test
public void userCanLoginByUsername() {
  open("/login");
  $(By.name("user.name")).setValue("johny");
  $("#submit").click();
  $(".loading_progress").should(disappear); // Waits until element disappears
  $("#username").shouldHave(text("Hello, Johny!")); // Waits until element gets text
}
```

Each testcase will have decorator `@Test` before function. Besides that, you can 
use other tester framework to test such as: JUnit, TestNG. Example: When finish testing,
I want Result collects and summarizes information from running multiple tests. 
I can implement export result function like: 

```Result.java
@Rule
public TestRule report = new TextReport().onFailedTest(true).onSucceededTest(true);
```

## Building from Source
If you want to build and run everything, use the `clean test` task:

```sh
gradle clean test
```

