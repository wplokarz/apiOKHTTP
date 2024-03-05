import io.qameta.allure.Step;
import okhttp3.Response;
import okhttpClientRequests.BoardClient;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CreateBoardTest extends BoardClient {

    @Test
    @Step("Creating new board")
    public void createNewBoardTest() throws IOException {
        String boardName = "testowyboard1413";
        Response response = createBoard(boardName);

        String responseAsString = response.body().string();

        Assert.assertEquals(response.code(), 200);
        Assert.assertEquals(getValueFromJson("name", responseAsString), boardName);

        //clear test data
        String boardID = getValueFromJson("id", responseAsString);
        deleteBoard(boardID);
    }
}
