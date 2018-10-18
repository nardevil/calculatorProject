package com.vp.calculator;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.json.*;
import com.fathzer.soft.javaluator.DoubleEvaluator;

@RestController
public class HelloWorldController {

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/calculate")
    public String helloWorldMethod(@RequestParam(value = "operations") String operations){

        boolean isValid = true;
        JSONObject response = new JSONObject();
        response.put("message", "error");
        response.put("operations", "Error - wrong input");

        if(!Character.isDigit(operations.charAt(0)))
        {
            return response.toString();
        }
        else{
            for (int i = 0; i < operations.length()-1; i++){
                if(Character.isDigit(operations.charAt(i)) || Character.isDigit(operations.charAt(i+1)))
                {
                }
                else {
                    return response.toString();
                }
                }
            }

        Double operationResult = new DoubleEvaluator().evaluate(operations);
        response.put("message", "success");
        response.put("operations", String.valueOf(operationResult));
        return response.toString();
        }
    }

