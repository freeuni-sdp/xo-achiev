package ge.edu.freeuni.sdp.xo.achiev;

import javax.ws.rs.core.Response;

public class MyCustomException extends RuntimeException {

    private String reason;
    private Response.Status status;
    private int errorCode;

    public MyCustomException(String reason, Response.Status status, int errorCode) {
        super(reason);
        this.reason = reason;
        this.status = status;
        this.errorCode = errorCode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Response.Status getStatus() {
        return status;
    }

    public void setStatus(Response.Status status) {
        this.status = status;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public ExceptionDo toDo() {
        ExceptionDo exceptionDo = new ExceptionDo();
        exceptionDo.setErrorCode(errorCode);
        exceptionDo.setReason(reason);

        return exceptionDo;
    }
}
