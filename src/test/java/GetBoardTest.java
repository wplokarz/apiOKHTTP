import okhttp3.Response;
import okhttpClientRequests.BoardClient;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetBoardTest extends BoardClient {

    @Test
    public void getSpecificBoardTest() throws IOException {
        String boardID = "658174cce75b456da0c7feaf";
        Response response = getBoard(boardID);

        Assert.assertEquals(getValueFromJson("id", response), boardID);
        Assert.assertEquals(response.code(), 200);
    }

}
