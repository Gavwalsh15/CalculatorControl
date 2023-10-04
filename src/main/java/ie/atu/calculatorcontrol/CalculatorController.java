package ie.atu.calculatorcontrol;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class CalculatorController{
    @GetMapping("/calculate")
    public Object calculate(int num1, int num2, String operation){
        int total;
        String lowerCase = operation.toLowerCase();
        switch (lowerCase){
            case "add"-> total = num1 + num2;
            case "subtract"-> total = num1 - num2;
            case "divide"-> total = num1 / num2;
            case "multiply"-> total = num1 * num2;
            default -> throw new IllegalStateException("Unexpected value: " + lowerCase);
        }


        return new returnMaths(total, operation);
    }

    public class returnMaths{
        private int total;
        private String operation;

        public returnMaths(int total, String operation) {
            this.total = total;
            this.operation = operation;
        }

        public int getTotal() {
            return total;
        }

        public String getOperation() {
            return operation;
        }
    }

}
