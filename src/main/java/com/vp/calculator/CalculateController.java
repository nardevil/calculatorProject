package com.vp.calculator;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.json.*;
import com.fathzer.soft.javaluator.DoubleEvaluator;

@RestController
public class CalculateController {

    /**
     *
     * @param operations - a string of numbers and mathematical operations
     * @return - returns a string with message(success or error) and result (if the input was valid)
     */

    @RequestMapping("/calculate")
    @CrossOrigin
    public String calculateMethod(@RequestParam(value = "operations") String operations){

        JSONObject response = new JSONObject();
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

