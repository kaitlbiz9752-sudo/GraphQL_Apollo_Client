package ma.abla.banque_service.exception;

import graphql.ErrorClassification;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * Gestionnaire d'exceptions pour GraphQL qui transforme les exceptions Java en erreurs GraphQL
 */
@Component
public class GraphQLExceptionHandler extends DataFetcherExceptionResolverAdapter {
    
    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        return new GraphQLError() {
            @Override
            public String getMessage() {
                return ex.getMessage();
            }

            @Override
            public List<SourceLocation> getLocations() {
                return Collections.emptyList();
            }

            @Override
            public ErrorClassification getErrorType() {
                if (ex instanceof CompteNotFoundException) {
                    return ErrorType.DataFetchingException;
                }
                return ErrorType.ExecutionAborted;
            }
        };
    }
}