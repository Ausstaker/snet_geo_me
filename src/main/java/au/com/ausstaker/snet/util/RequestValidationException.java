package au.com.ausstaker.snet.util;

/**
 * @author edge2ipi (https://github.com/Ausstaker)
 */
public class RequestValidationException extends Exception {
    Status status;

    public RequestValidationException(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setMessage(Status status) {
        this.status = status;
    }
}

