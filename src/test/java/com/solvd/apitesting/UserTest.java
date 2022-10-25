package com.solvd.apitesting;

import com.qaprosoft.apitools.validation.JsonComparatorContext;
import org.testng.annotations.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class UserTest {

    @Test
    public void createStatusTest() {
        PostCommentMethod pum = new PostCommentMethod();
        pum.callAPI().jsonPath();

        JsonComparatorContext comparatorContext = JsonComparatorContext.context()
                .<String>withPredicate("datePredicate", created_at -> Instant.parse(created_at).compareTo(Instant.now().truncatedTo(ChronoUnit.MINUTES)) >= 0);

        pum.validateResponse(comparatorContext);
    }

    @Test
    public void readCommitTest() {
        GetCommitMethod gum = new GetCommitMethod();
        gum.callAPI();
        gum.validateResponse();
    }

    @Test
    public void readEmojisTest() {
        GetEmojisMethod gem = new GetEmojisMethod();
        gem.callAPI();
        gem.validateResponseAgainstSchema("/api/users/get/rs-emojis.json");
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
        ucm.validateResponseAgainstSchema("/api/users/patch/rs.json");
    }
}