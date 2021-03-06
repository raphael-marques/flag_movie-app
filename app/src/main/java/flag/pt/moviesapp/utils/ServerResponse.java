package flag.pt.moviesapp.utils;

/**
 * Created by Ricardo Neves on 20/01/2017.
 */

public class ServerResponse<ResponseEntity> {

    private ResponseEntity responseEntity;
    private int errorType;

    public ServerResponse(ResponseEntity responseEntity, int errorType){
        this.responseEntity = responseEntity;
        this.errorType = errorType;
    }

    public int getErrorType() {
        return errorType;
    }

    public ResponseEntity getResponseEntity() {
        return responseEntity;
    }
}
