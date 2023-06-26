# Exception Handled Array Processor

## Description:

Create a method that accepts a two-dimensional string array of size `4x4`. If an array of any other size is submitted, an exception `MyArraySizeException` should be thrown.

The method should iterate through all elements of the array, convert them to `int`, and sum them. If the conversion fails in any element of the array (for example, if a cell contains a symbol or text instead of a number), an exception `MyArrayDataException` should be thrown, detailing exactly which cell contains incorrect data.

In the `main()` method, call the created method, handle possible `MyArraySizeException` and `MyArrayDataException` exceptions, and display the calculation result.

