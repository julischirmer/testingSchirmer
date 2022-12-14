package com.solvd.carina.demo;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.APIMethodPoller;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.solvd.carina.demo.api.*;
import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class APITestingComments implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "jschirmer")
    public void testPostComment() {

        PostCommentMethod api = new PostCommentMethod();
        AtomicInteger counter = new AtomicInteger(0);

        api.callAPIWithRetry()
                .withLogStrategy(APIMethodPoller.LogStrategy.ALL)
                .peek(rs -> counter.getAndIncrement())
                .until(rs -> counter.get() == 4)
                .pollEvery(1, ChronoUnit.SECONDS)
                .stopAfter(10, ChronoUnit.SECONDS)
                .execute();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "jschirmer")
    public void testPostCommentWithMissingSomeFields() {
        PostCommentMethod api = new PostCommentMethod();
        api.getProperties().remove("postId");
        api.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        api.callAPI();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "jschirmer")
    public void testPatchComment() {
        PostCommentMethod api = new PostCommentMethod();
        Response postResponse = api.callAPIExpectSuccess();
        LOGGER.info("Response a :" + postResponse.asString());
        api.validateResponse();

        Integer id = JsonPath.read(postResponse.asString(), "id");
        String idString = id.toString();
        LOGGER.info("id:" + idString);

        PatchCommentMethod apiPatch = new PatchCommentMethod(idString);
        apiPatch.expectResponseStatus(HttpResponseStatusType.OK_200);
        apiPatch.callAPI();
        apiPatch.validateResponse();

    }

    @Test()
    @MethodOwner(owner = "jschirmer")
    public void testGetComments() {
        GetCommentMethods getCommentMethods = new GetCommentMethods();
        getCommentMethods.expectResponseStatus(HttpResponseStatusType.OK_200);
        getCommentMethods.callAPI();
        getCommentMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getCommentMethods.validateResponseAgainstSchema("api2/comments/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "jschirmer")
    @TestPriority(Priority.P1)
    public void testDeleteComments() {
        DeleteCommentMethod deleteCommentMethod = new DeleteCommentMethod();
        deleteCommentMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        deleteCommentMethod.callAPI();
        deleteCommentMethod.validateResponse();
    }

}
