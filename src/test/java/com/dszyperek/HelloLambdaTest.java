package com.dszyperek;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class HelloLambdaTest {

    private HelloLambda helloLambda;

    @Mock
    Context context;

    @Mock
    LambdaLogger logger;

    @BeforeEach
    public void setUp() {
        when(context.getLogger()).thenReturn(logger);

        doAnswer(call -> {
            System.out.println((String)call.getArgument(0) );
            return null;
        }).when(logger).log(anyString());

        helloLambda = new HelloLambda();
    }

    @Test
    public void shouldReturnUppercaseOfInput() {
        when(context.getFunctionName()).thenReturn("handleRequest");

        assertEquals("HELLO, WORLD!", helloLambda.handleRequest("hello, world!", context));
    }
}