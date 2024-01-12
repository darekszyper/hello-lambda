package com.dszyperek;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class HelloLambda implements RequestHandler<String, String> {

    @Override
    public String handleRequest(String s, Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log("Function '" + context.getFunctionName() + "' called");
        return s.toUpperCase();
    }
}
