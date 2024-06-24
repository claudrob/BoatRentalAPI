package com.petscreening.BoatRentalAPI.controllers;

import graphql.GraphQLError;

import graphql.GraphqlErrorBuilder;
import graphql.parser.InvalidSyntaxException;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.stereotype.Component;

@Component
public class CustomGraphQLErrorHandler extends DataFetcherExceptionResolverAdapter {

    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        ErrorType type = null;
       if (ex instanceof InvalidSyntaxException) {
            type = ErrorType.BAD_REQUEST;
        } else if (ex instanceof DataIntegrityViolationException) {
            type = ErrorType.BAD_REQUEST;
        } else if (ex instanceof NullPointerException) {
            type = ErrorType.BAD_REQUEST;
        } else if (ex instanceof IllegalArgumentException) {
            type = ErrorType.BAD_REQUEST;
        } else if (ex instanceof RuntimeException) {
            type = ErrorType.INTERNAL_ERROR;
        } else {
            type = ErrorType.INTERNAL_ERROR;
        }
        return GraphqlErrorBuilder.newError(env)
                .message("Received Message: " + ex.getMessage())
                .errorType(type)
                .build();
    }

}
