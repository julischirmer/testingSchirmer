package com.solvd.carina.demo.api;


import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

@Endpoint(url = "${base_url}/comments/${id}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api2/comments/_patch/rs.json")
@RequestTemplatePath(path = "api2/comments/_patch/rq.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PatchCommentMethod extends AbstractApiMethodV2 {
    public PatchCommentMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("id", "1");
        setProperties("api2/comments/comment.properties");
    }

    public PatchCommentMethod(String id) {
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("id", id);
        setProperties("api2/comments/comment.properties");
    }

}
