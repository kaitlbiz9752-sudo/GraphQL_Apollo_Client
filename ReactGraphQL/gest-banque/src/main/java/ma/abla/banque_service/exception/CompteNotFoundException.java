package ma.abla.banque_service.exception;

/**
 * Exception personnalisée levée lorsqu'un compte n'est pas trouvé dans le système
 */
public class CompteNotFoundException extends RuntimeException {
    public CompteNotFoundException(String message) {
        super(message);
    }
}

