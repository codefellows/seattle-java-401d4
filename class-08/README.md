# Lecture 8: OO, JSON & External Libraries

## Agenda
- Announcements
  - Tomorrow's lab is optionally pair programming! You can pick your partner.
  - Labs/readings for next week are shifted; the numbers are a bit odd because of Career Coaching this Friday, but they all have correct due dates now.
  - Michelle out next Friday, 6/14; Brian will be here to teach you about trees!
- Code review
- Daily Systems: the PATH
- Warmup questions
- Lecture
- Lab intro

## Warmup Questions

1. What is JSON? If I say "here is some JSON", what data type is that?
2. In JavaScript, how do we deal with JSON data?
3. In Node/JavaScript, if we need to use a new package (like `express`), what steps do we take?
4. (somewhat unrelated) What's the difference between an application and a library?

## Lecture Notes

### Reading JSON
Java doesn't have it's own built-in JSON parser. We need to add a dependency on
one Google built called GSON. Add this to your project dependencies in
`build.gradle`.

```java
dependencies {
  compile 'com.google.code.gson:gson:2.8.2'
}
```

We're going to build a class that automatically serializes itself to JSON, and
deserializes JSON strings into a Java class. Our class will be called `Contact`.

```json
{
    "firstName": "John",
    "lastName": "Smith",
    "age": 25,
    "address": {
        "streetAddress": "21 2nd Street",
        "city": "New York",
        "state": "NY",
        "postalCode": 10021
    },
    "phoneNumbers": [
        {
            "type": "home",
            "number": "212 555-1234"
        },
        {
            "type": "fax",
            "number": "646 555-4567"
        }
    ]
}
```

In order for GSON to convert between JSON and a Java class we need to build a
Java class that looks like the JSON. Look at the JSON and create an appropriate
field for each top-level JSON property. Make two String fields for `firstName`
and `lastName`. Make an int field for `age`. The `address` and `phoneNumbers`
are more complicated. They're nested JSON objects. It wouldn't suffice to
use simply a String or an int to store their data.

Create two classes within your `Contact` class to represent the `Address` and
`PhoneNumber`. Inside each of those classes simply create fields to capture
the data these objects hold. The `PhoneNumber` class has two String fields to
hold the `type` of phone number and the `number` itself. The `Address` class
has four String fields to keep track of the streetAddress, city, state, and
postalCode.

Notice that in every case the field name that we chose in Java, like `firstName`
or `postalCode` matches the key names in the JSON object exactly. GSON will
match the Java class fields to the key names in the JSON object to transform
between the two.

Finally, we attach one static method to the `Contact` class that accepts a
`Reader`, uses `Gson`, tells it how to interpret the data by specifying
`Contact.class` and it returns a new Contact object! Take a look at the code
below to see how it all comes together.

Your class should look like this:

```java
public class Contact {
  String firstName;
  String lastName;
  int age;
  Address address;
  List<PhoneNumber> phoneNumbers;

  public class Address {
    String streetAddress;
    String city;
    String state;
    String postcalCode;
  }

  public class PhoneNumber {
    String type;
    String number;
  }

  public static Contact fromJson(Reader reader) {
    Gson gson = new Gson();
    Contact result =  gson.fromJson(reader, Contact.class);
    return result;
  }
}
```

**Check for understanding:** Why is the `fromJson` method static? What does
static mean in Java?

### Testing the Reader
* Create a new folder beside `src` called `test`
* Right click on test, choose "Mark Directory As" > "Test Sources Root"
* Go inside `Contact.java`, hover the cursor over the `Contact` classname,
  press `ALT+ENTER` and choose "Create Test"
* Choose JUnit4 for as the testing library.
* Press the "Fix" button to add the JUnit4 library to the module.
* A new class file under `test` should be created called `ContactTest`
* Make a new tiny test method that tests `assertTrue(true)` to make sure
  our tests work. Remember to annotate the method with `@Test`!
* Right click on the `test` directory and choose "Run 'All Tests'" to make sure
  the tests execute and report correctly.

Now that you're confident the test library is executing and reporting test
results correctly write a test to make sure `Contact.fromJson` returns a
`Contact` object with all of the correct information.

Mark the method with the `@Test` annotation. Write an `assertEquals()` statement
for each property on the Contact, and checking each property in the address,
and checking each property on the two phone numbers.

Excellent!

### Creating JSON
Let's create another class and see how we can configure it to work with GSON
to create JSON strings.

Let's try to model courses Code Fellows offers. We'll make a class called
`Institution` with a name, and a slogan. We'll make a sub class called
`Course` which has a `name` and a `description` for each course. The
`Institution` object will have a collection of `courses`.

Create a method on `Institution` called `toJson` that serializes the object
instance with GSON and returns the String.

Create a new test for `Institution` and include some sanity checks to make
sure it's creating something that looks like JSON.

* Assert the first character of the string is a curly brace `'{'`
* Assert the last character of the string is a curly brace `'}'`
* Assert it's true that the entire string contains JSON-like key substring
  like `"name":` and `"slogan":`

You can `System.out.println()` the entire JSON String to see what it looks like.
It should be a very compact string with no line breaks or any extra whitespace.

`{"name":"Code Fellows","slogan":"Learn more faster","courses":[{"name":"Code 101","description":"Intro to Software"},{"name":"Code 102","description":"Intro to JavaScript"},{"name":"Code 201","description":"Foundations"},{"name":"Code 301","description":"Intermediate"},{"name":"Code 401","description":"Advanced JavaScript"},{"name":"Code 401","description":"Advanced Python"},{"name":"Code 401","description":"Advanced Java"}]}`

### Serialize-Deserialize Test
It's a bit hard and obnoxious to check raw String JSON to see if it encoded
correctly. Write another test to create an object, serialize it to JSON, then
deserialize it from JSON back to an object, and use the two objects to make
sure the properties are all the same. This will give us a good way to test
that the serialization is happening correctly without having to test the raw
String data.

You'll need to add a `fromJson()` method to the `Institution` class. Have it
accept a String as a parameter. Last time we converted a `Reader` to JSON
because the data came from a JSON file. `Gson` can convert from raw Strings
too.

Notice all the code that created the Institution object last time has been
refactored in a `getInstitution()` method so it can be used over and over.

```java
@Test
public void testSerializeDeserialize() {
  Institution cf1 = getInstitution();
  String json = cf1.toJson();
  Institution cf2 = Institution.fromJson(json);

  assertEquals(cf1.name, cf2.name);
  assertEquals(cf1.slogan, cf2.slogan);
  assertEquals(cf1.courses.size(), cf2.courses.size());
}
```

**Check for understanding:** the `.toJson()` method isn't static, but the
`.fromJson()` method is static. Why?
