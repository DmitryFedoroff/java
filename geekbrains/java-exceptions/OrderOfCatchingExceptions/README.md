# Order of catching exceptions

## Description:

Refactor the code below if necessary:

```java
public static void main(String[] args) throws Exception {
    try {
        int a = 90;
        int b = 3;
        System.out.println(a / b);
        printSum(23, 234);
        int[] abc = { 1, 2 };
        abc[3] = 9;
    } catch (Throwable ex) {
        System.out.println("Something went wrong...");
    } catch (NullPointerException ex) {
        System.out.println("Attempt to access reference variable that currently points to null.");
    } catch (IndexOutOfBoundsException ex) {
        System.out.println("Array accessed with illegal index.");
    }
}
```

