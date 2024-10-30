## Collections Framework

- ### List:

```java
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

List<String> arrayList = new ArrayList<>();
arrayList.add("Alice");
arrayList.add("Bob");

List<String> linkedList = new LinkedList<>();
linkedList.add("Charlie");
linkedList.add("David");
```

- ### Set:

```java
import java.util.HashSet;
import java.util.Set;

Set<String> hashSet = new HashSet<>();
hashSet.add("Eve");
hashSet.add("Frank");
```

- ### Map:

```java
import java.util.HashMap;
import java.util.Map;

Map<String, Integer> hashMap = new HashMap<>();
hashMap.put("George", 30);
hashMap.put("Helen", 25);

int age = hashMap.get("George");
```

- ### Queue:

```java
import java.util.LinkedList;
import java.util.Queue;

Queue<String> queue = new LinkedList<>();
queue.add("Item1");
queue.add("Item2");

String item = queue.poll(); // Retrieves and removes the head of this queue
```

## Generics

- ### Generic Class:

```java
public class Box<T> {
    private T content;

    public void set(T content) {
        this.content = content;
    }

    public T get() {
        return content;
    }
}

Box<String> stringBox = new Box<>();
stringBox.set("Hello");
```

- ### Generic Method:

```java
public class Util {
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }
}

Integer[] intArray = {1, 2, 3, 4};
Util.printArray(intArray);
```

- ### Bounded Type Parameters:

```java
public class Util {
    public static <T extends Number> void printNumber(T number) {
        System.out.println(number);
    }
}

Util.printNumber(123); // Works with integer
Util.printNumber(45.67) // Works with Double
```

## Lambda Expressions

- ### Basic Lambda:

```java
import java.util.function.Function;

Function<Integer, Integer> square = x -> x * x;
int result = square.apply(5); // result is 25
```

- ### Using Lambdas with Collections:

```java
import java.util.ArrayList;
import java.util.List;

List<String> names = new ArrayList<>();
names.add("Alice");
names.add("Bob");
names.forEach(name -> System.out.println(name));
```

## Streams API

- ### Creating Streams:

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
Stream<String> stream = names.stream();
```

- ### Stream Operations:

```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
names.stream()
     .filter(name -> name.startsWith("A"))
     .map(String::toUpperCase)
     .forEach(System.out::println);
```

## Concurrency

- ### Creating a Thread:

```java
public class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running...");
    }
}

MyThread thread = new MyThread();
thread.start();
```

- ### Runnable Interface:

```java
public class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Running is running...");
    }
}

Thread thread = new Thread(new MyRunnable());
thread.start();
```

- ### Executor Service:

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

ExecutorService executor = Executors.newFixedThreadPool(2);
executor.submit(() -> {
    System.out.println("Task 1 is running");
});

executor.submit(() -> {
    System.out.println("Task 2 is running");
});

executor.shutdown();
```

- ### Synchronizing Methods:

```java
public class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
```

## Networking

- ### TCP Server:

```java
import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            new ServerThread(socket).start();
        }
    }
}

class ServerThread extends Thread {
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            String text;

            do {
                text = reader.readLine();
                writer.println("Server: " + text);
            } while (!text.equals("bye"));

            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
```

- ### TCP Client:

```java
import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 8080;

        try (Socket socket = new Socket(hostname, port)) {
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String text;

            do {
                text = reader.readLine();
                write.println(text);

                InputStream input = socket.getInputStream();
                BufferedReader serverReader = new BufferedReader(new InputStreamReader(input));
                System.out.println(serverReader.readLine());
            } while (!text.equals("bye"));
        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O errors: " + ex.getMessage());
        }
    }
}
```

## Annotations

- ### Custom Annotation:

```java
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyAnnotation {
    String value();
}

public class MyClass {
    @MyAnnotation(value = "Example Annotation")
    public void myMethod() {
        System.out.println("Annotated method");
    }
}
```

- ### Using Reflection to Process Annotations:

```java
import java.lang.reflect.Method;

public class AnnotationProcessor {
    public static void main(String[] args) throws Exception {
        MyClass obj = new MyClass();
        Method method = obj.getClass().getMethod("myMethod");

        if (method.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
            System.out.println("Annotation value: " + annotation.value());
        }
    }
}
```

## Java I/O (NIO)

- ### File Operations:

```java
import java.nio.file.*;

Path path = Paths.get("example.txt");

// Write to a file
String content = "Hello, World!";
Files.write(path, content.getBytes());

// Read from a file
String readContent = new String(Files.readAllBytes(path));
System.out.println(readContent);

// Copy a file
Path destination = Paths.get("example_copy.txt");
Files.copy(path, destination, StandardCopyOption.REPLACE_EXISTING);

// Delete a file
Files.delete(movedPath);
```

- ### Buffers and Channels:

```java
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.io.RandomAccessFile;

try (RandomAccessFile file = new RandomAccessFile("example.txt", "rw");
    FileChannel channel = file.getChannel()) {
        ByteBuffer buffer = ByteBuffer.allocate(48);
        int bytesRead = channel.read(buffer);

        while (bytesRead != -1) {
            buffer.flip();

            while (buffer.hasRemaining()) {
                System.out.println((char) buffer.get());
            }

            buffer.clear();
            bytesRead = channel.read(buffer);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
```

## Java 8 Features

- ### Optional:

```java
import.java.util.Optional;

Optional<String> optional = Optional.of("Hello");
optional.ifPresent(System.out::println);

String value = optional.orElse("Default Value");
System.out.println(value);
```

- ### Method References:

```java
import java.util.Arrays;
import java.util.List;

List<String> names = ArrayList.asList("Alice", "Bob", "Charlie");
names.forEach(System.out::println);
```

- ### Streams API:

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
List<String> filteredNames = names.stream()
                                  .filter(name -> name.startsWith("A"))
                                  .collect(Collectors.toList());
filteredNames.forEach(System.out::println);
```
