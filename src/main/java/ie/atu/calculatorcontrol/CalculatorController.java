package ie.atu.calculatorcontrol;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class CalculatorController{
    //@GetMapping("/calculate")
    //public Object calculate(@RequestParam int num1,@RequestParam int num2,@RequestParam String operation){
    @GetMapping("/calculate/{num1}/{num2}/{operation}")
    public Object calculate(@PathVariable int num1, @PathVariable int num2, @PathVariable String operation){

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
