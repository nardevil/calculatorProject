package com.vp.calculator;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.json.*;
import com.fathzer.soft.javaluator.DoubleEvaluator;

@RestController
public class HelloWorldController {

    /**
     *
     * @param operations - a string of numbers and mathematical operations
     * @return - returns a string with message(success or error) and result (if the input was valid)
     */

    @RequestMapping("/calculate")
    @CrossOrigin
    public String helloWorldMethod(@RequestParam(value = "operations") String operations){

        JSONObject response = new JSONObject();


        /**
         Check if 1st char is a digit
         If not then return Error message

        if(!Character.isDigit(operations.charAt(0)))
        {
            return response.toString();
        }
        else{
            for (int i = 1; i < operations.length()-1; i++){
                /**
                 Check if atleast one char is a number
                 If both chars are mathematical operators then return Error message

                if(Character.isDigit(operations.charAt(i)) || Character.isDigit(operations.charAt(i+1)))
                {
                }
                else {
                    return response.toString();
                }
                }
            }
         */
            try{
                Double operationResult = new DoubleEvaluator().evaluate(operations);
                response.put("message", "success");
                response.put("operations", String.valueOf(operationResult));
                }
            catch (Exception ex) {
                response.put("message", "error");
                response.put("operations", "Error - bad input");
                }
            finally {
                    return response.toString();
                    }
        }
    }

