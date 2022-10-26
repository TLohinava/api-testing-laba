package com.solvd.apitesting;

import com.qaprosoft.apitools.validation.JsonComparatorContext;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.time.Instant;

public class UserTest {

    @Test
    public void createStatusTest() {
        PostCommentMethod pcm = new PostCommentMethod("TLohinava", "8b910c5f94d8fcc92a856b1551695e4c84007d35", "underground-db");
        pcm.addProperty("username", "TLohinava");
        pcm.addProperty("sha", "8b910c5f94d8fcc92a856b1551695e4c84007d35");
        pcm.addProperty("repo", "underground-db");
        JsonPath p = pcm.callAPI().jsonPath();
        Integer i = p.getInt("id");

        JsonComparatorContext comparatorContext = JsonComparatorContext.context()
                .<String>withPredicate("datePredicate", created_at -> Instant.parse(created_at).isAfter(Instant.now().minusSeconds(30)) && Instant.parse(created_at).isBefore(Instant.now()))
                .<String>withPredicate("htmlPredicate", html_url -> html_url.endsWith(i.toString()))
                .<String>withPredicate("urlPredicate", url -> url.endsWith(i.toString()));

        pcm.validateResponse(comparatorContext);
    }

    @Test
    public void readCommitTest() {
        GetCommitMethod gum = new GetCommitMethod("TLohinava", "underground-db");
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
        DeleteCommentMethod dcm = new DeleteCommentMethod("TLohinava", "underground-db", "87919889");
        dcm.callAPIExpectSuccess();
    }

    @Test
    public void updateCommentTest() {
        UpdateCommentMethod ucm = new UpdateCommentMethod("TLohinava", "underground-db", "87919889");
        ucm.callAPI();
        ucm.validateResponseAgainstSchema("/api/users/patch/rs.json");
    }
}