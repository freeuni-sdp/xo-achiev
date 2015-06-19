package ge.edu.freeuni.sdp.xo.achiev;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MyCustomExceptionMapper implements ExceptionMapper<MyCustomException> {

    @Context
    private HttpHeaders headers;

    @Override
    public Response toResponse(MyCustomException e) {
        return Response.status(e.getStatus()).
                entity(e.toDo()).
                build();
    }
}
