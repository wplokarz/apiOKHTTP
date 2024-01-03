package org.example.pojoClasses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Board {
    private String boardID;

    private String boardName;

    public Board(String boardID, String boardName) {
        this.boardID = boardID;
        this.boardName = boardName;
    }
}
