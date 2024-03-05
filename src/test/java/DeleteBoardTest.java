import okhttp3.Response;
import okhttpClientRequests.BoardClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;


public class DeleteBoardTest extends BoardClient {
    @Test
    public void deleteSpecificBoardTest() throws IOException {
        String boardName = "toRemoveBoard";
        Response response = createBoard(boardName);

        String responseAsString = response.body().string();
        // Create board and get board ID to remove it in next step
        String boardID = getValueFromJson("id", responseAsString);
        Assert.assertEquals(response.code(), 200);

        // remove new-created board
        response = deleteBoard(boardID);
        Assert.assertEquals(response.code(), 200);

        // try to remove again the same board
        response = deleteBoard(boardID);
        Assert.assertEquals(response.code(), 404);
    }
}
