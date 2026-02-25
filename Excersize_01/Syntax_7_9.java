package Excersize_01;

public class Syntax_7_9 {

    // Output Object Class (Used for returning multiple values)
    static class Result {
        int sum;
        int product;
        int difference;

        Result(int sum, int product, int difference) {
            this.sum = sum;
            this.product = product;
            this.difference = difference;
        }

        void display() {
            System.out.println("Sum: " + sum);
            System.out.println("Product: " + product);
            System.out.println("Difference: " + difference);
            System.out.println("----------------------");
        }
    }

    // Input Object Class (Used for passing multiple inputs)
    static class InputValues {
        int num1;
        int num2;

        InputValues(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
        }
    }

    // 1️ WITHOUT INPUT

    // Static Method
    static Result staticMethodWithoutInput() {
        int a = 10;
        int b = 5;
        return new Result(a + b, a * b, a - b);
    }

    // Instance Method
    Result instanceMethodWithoutInput() {
        int a = 20;
        int b = 4;
        return new Result(a + b, a * b, a - b);
    }

    // 2️ SINGLE INPUT

    // Static Method
    static Result staticMethodWithSingleInput(int number) {
        return new Result(number + 100, number * 2, number - 10);
    }

    // Instance Method
    Result instanceMethodWithSingleInput(int number) {
        return new Result(number + 200, number * 3, number - 20);
    }

    // 3️ MULTIPLE INPUTS (OBJECT)

    // Static Method
    static Result staticMethodWithObjectInput(InputValues input) {
        return new Result(
                input.num1 + input.num2,
                input.num1 * input.num2,
                input.num1 - input.num2
        );
    }

    // Instance Method
    Result instanceMethodWithObjectInput(InputValues input) {
        return new Result(
                input.num1 + input.num2 + 10,
                input.num1 * input.num2,
                input.num1 - input.num2 - 5
        );
    }

    public static void main(String[] args) {

        // Create object for instance methods
        Syntax_7_9 obj = new Syntax_7_9();

        System.out.println("=== 1 WITHOUT INPUT ===");

        Result r1 = staticMethodWithoutInput();
        r1.display();

        Result r2 = obj.instanceMethodWithoutInput();
        r2.display();

        System.out.println("=== 2 SINGLE INPUT ===");

        Result r3 = staticMethodWithSingleInput(30);
        r3.display();

        Result r4 = obj.instanceMethodWithSingleInput(30);
        r4.display();

        System.out.println("=== 3 OBJECT INPUT ===");

        InputValues input = new InputValues(40, 10);

        Result r5 = staticMethodWithObjectInput(input);
        r5.display();

        Result r6 = obj.instanceMethodWithObjectInput(input);
        r6.display();
    }
}