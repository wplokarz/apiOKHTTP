import okhttp3.Response;
import okhttpClientRequests.BoardClient;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CreateBoardTest extends BoardClient {

    @Test
    public void createNewBoardTest() throws IOException {
        String boardName = "testowyboard1413";
        Response response = createBoard(boardName);

        Assert.assertEquals(response.code(), 200);
        Assert.assertEquals(getValueFromJson("name", response), boardName);

    }
}