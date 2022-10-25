package com.solvd.apitesting;

import com.qaprosoft.apitools.validation.JsonComparatorContext;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.time.Instant;

public class UserTest {

    @Test
    public void createStatusTest() {
        PostCommentMethod pcm = new PostCommentMethod();
        JsonPath p = pcm.callAPI().jsonPath();
        Integer i = p.getInt("id");

        JsonComparatorContext comparatorContext = JsonComparatorContext.context()
                .<String>withPredicate("datePredicate", created_at -> Instant.parse(created_at).compareTo(Instant.now()) <= 0)
                .<String>withPredicate("htmlPredicate", html_url -> html_url.endsWith(i.toString()))
                .<String>withPredicate("urlPredicate", url -> url.endsWith(i.toString()));

        pcm.validateResponse(comparatorContext);
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
        dcm.callAPIExpectSuccess();
    }

    @Test
    public void updateCommentTest() {
        UpdateCommentMethod ucm = new UpdateCommentMethod();
        ucm.callAPI();
        ucm.validateResponseAgainstSchema("/api/users/patch/rs.json");
    }
}