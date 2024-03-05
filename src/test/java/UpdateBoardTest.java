import io.qameta.allure.Step;
import okhttp3.Response;
import okhttpClientRequests.BoardClient;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class UpdateBoardTest extends BoardClient {
    @Test
    @Step("Update board name")
    public void updateSpecificBoard() throws IOException {
        String boardName = "nowanazwa2";
        String boardID = "65940c20d47277eb5a51b71f";
        Response response = updateBoard(boardID, boardName);

        String responseAsString = response.body().string();

        Assert.assertEquals(response.code(), 200);
        Assert.assertEquals(getValueFromJson("name", responseAsString), boardName);
    }
}
