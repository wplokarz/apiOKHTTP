import io.qameta.allure.Step;
import okhttp3.Response;
import okhttpClientRequests.BoardClient;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetBoardTest extends BoardClient {

    @Test
    @Step("Get specific board")
    public void getSpecificBoardTest() throws IOException {
        String boardID = "658174cce75b456da0c7feaf";
        Response response = getBoard(boardID);

        String responseAsString = response.body().string();

        Assert.assertEquals(getValueFromJson("id", responseAsString), boardID);
        Assert.assertEquals(response.code(), 200);
    }

}
