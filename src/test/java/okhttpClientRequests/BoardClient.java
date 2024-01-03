package okhttpClientRequests;

import okhttp3.Response;

import java.io.IOException;

public class BoardClient extends ClientRequests{

    public Response getBoard(String boardID) throws IOException {
        return getRequest(boardID);
    }

    public Response createBoard(String boardName) throws IOException {
        return postRequest(boardName);
    }

    public Response updateBoard(String boardID, String boardName) throws IOException {
        return putRequest(boardID, boardName);
    }

    public Response deleteBoard(String boardID) throws IOException {
        return deleteRequest(boardID);
    }
}
