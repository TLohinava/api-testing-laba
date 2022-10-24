package com.solvd.apitesting;

import org.testng.annotations.Test;

public class UserTest {

    @Test
    public void createStatusTest() {
        PostCommentMethod pum = new PostCommentMethod();
        pum.callAPI();
        pum.validateResponse();
    }

    @Test
    public void readCommitTest() {
        GetCommitMethod gum = new GetCommitMethod();
        gum.callAPI();
    }

    @Test
    public void readEmojisTest() {
        GetEmojisMethod gem = new GetEmojisMethod();
        gem.callAPI();
    }

    @Test
    public void deleteCommentTest() {
        DeleteCommentMethod dcm = new DeleteCommentMethod();
        dcm.callAPI();
    }

    @Test
    public void updateCommentTest() {
        UpdateCommentMethod ucm = new UpdateCommentMethod();
        ucm.callAPI();
    }
}