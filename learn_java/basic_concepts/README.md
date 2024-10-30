### Hello World Program

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

## Variables and Data Types

- ### Primitive Data Types:

```java
byte b = 10; // 1 byte
short s = 20; // 2 bytes
int i = 30; // 4 bytes
int l = 40L; // 8 bytes
float f = 50.5f; // 4 bytes
double d = 60.5; // 8 bytes
char c = "A"; // 2 bytes
boolean bool = true;
```

- ### Non-Primitive Data Types:

```java
String str = "Hello";
int[] arr = {1, 2, 3, 4, 5};
```

## Operators

- ### Arithmetic Operators:

```java
int sum = a + b;
int diff = a - b;
int prod = a * b;
int quot = a / b;
int rem = a % b;
```

- ### Relational Operators:

```java
boolean isEqual = a == b;
boolean isNotEqual = a != b;
boolean isGreater = a > b;
boolean isLess = a < b;
boolean isGreaterOrEqual = a >= b;
boolean isLessOrEqual = a <= b;
```

- ### Logical Operators:

```java
boolean and = (a > b) && (a < c);
boolean or = (a > b) || (a < c);
boolean not = !(a > b);
```

## Control Flow

- ### If-Else Statement:

```java
if (condition) {
    // code to execute if condition is true
} else {
    // code to execute if condition is false
}
```

- ### Switch Statement:

```java
switch(variable) {
    case value1:
        // code to execute if variable == value1
        break;
    case value2:
        // code to execute if variable == value2
        break;
    default:
        // code to execute if variable doesn't match any case
}
```

- ### For Loop:

```java
for (int i = 0; i < 10; i++) {
    System.out.println(i);
}
```

- ### While Loop:

```java
while (condition) {
    // code to execute while this condition is true
}
```

- ### Do-While Loop:

```java
do {
    // code to execute at least once
} while (condition);
```

## Arrays

- ### Declare and Initialize:

```java
int[] arr = new int[5];
int[] arr2 = { 1, 2, 3, 4, 5 };
```

- ### Access Element:

```java
int firstElement = arr[0];
arr[1] = 10;
```

## Methods

- ### Method Declaration:

```java
public returnType methodName(parameters) {
    // method body
    return value; // if returnType is not valid
}
```

- ### Example:

```java
public int add(int a, int b) {
    return a + b;
}
```

## Object-Oriented Programming

- ### Class and Objects:

```java
public class Person {
    // Fields
    String name;
    int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method
    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

// Create an object
Person person1 = new Person("John", 25);
person1.display();
```

- ### Inheritence:

```java
public class Animal {
    public void eat() {
        System.out.println("This animal eats food.");
    }
}

public class Dog extends Animal {
    public void bark() {
        System.out.println("This dog barks.");
    }
}

Dog dog = new Dog();
dog.eat();
dog.bark();
```

- ### Polymorphism:

```java
public class Animal {
    public void sound() {
        System.out.println("Animal makes a sound");
    }
}

public class Dog extends Animal {
    public void sound() {
        System.out.println("Dog barks");
    }
}

Animal myDog = new Dog();
myDog.sound(); // Outputs: Dog barks
```

- ### Abstraction:

```java
abstract class Animal {
    public abstract void sound();
}

class Dog extends Animal {
    public void sound() {
        System.out.println("Dog Barks");
    }
}

Animal myDog = new Dog();
myDog.sound(); // Outputs: Dog barks
```

- ### Interfaces:

```java
interface Animal {
    void sound();
}

class Dog implements Animal {
    public void sound() {
        System.out.println("Dog barks");
    }
}

Dog myDog = new Dog();
myDog.sound(); // Outputs: Dog barks
```

## Exception Handling

- ### Try-Catch Block:

```java
try {
    // code that may throw an exception
} catch (ExceptionType name) {
    // code to handle the exception
} finally {
    // code to be executed regardless of an exception
}
```

- ### Example:

```java
try {
    int division = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("ArithmeticException: Division by zero.")
} finally {
    System.out.println("This block always executes.");
}
```

## Input and Outputs

- ### Reading Input:

```java
import java.util.Scanner;

Scanner scanner = new Scanner(System.in);
System.out.println("Enter your name: ");
String name = scanner.nextLine();
System.out.println("Your name is " + name);
```

- ### File Handling:

```java
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// write to a file
try {
    FileWriter writer = new FileWriter("filename.txt");
    writer.write("Hello, World!");
    writer.close();
} catch (IOException e) {
    e.printlnStackTrace();
}

// Read from a file
try {
    File file = new File("filename.txt");
    Scanner reader = new Scanner(file);
    while (reader.hasNextLine()) {
        String data = reader.nextLine();
        System.out.println(data);
    }
    reader.close();
} catch (IOException e) {
    e.printStackTrace();
}
```
