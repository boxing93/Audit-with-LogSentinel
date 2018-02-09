package org.springframework.samples.petclinic.audit;

import com.logsentinel.ApiException;
import com.logsentinel.LogSentinelClient;
import com.logsentinel.LogSentinelClientBuilder;
import com.logsentinel.client.model.ActionData;
import com.logsentinel.client.model.ActorData;
import com.logsentinel.client.model.LogResponse;
import org.springframework.stereotype.Controller;

/**
 * Created by Iliya on 9.2.2018 г..
 */
@Controller
public class AuditControllerApi {
    public static void main(String[] args) {
       final String applicationId = "8c7323b0-0d9e-11e8-9a78-7d8d5a4678f8";
       final String organizationId = "8c71c420-0d9e-11e8-9a78-7d8d5a4678f8";
       final String secret = "08c2fe830e7ee65893be22d2f981bfb3dc2150fc33cec365184d9ca2fbfa2e64";

        LogSentinelClientBuilder builder = LogSentinelClientBuilder
            .create(applicationId, organizationId, secret);
        LogSentinelClient client = builder.build();

        try {
            LogResponse result = client.getAuditLogActions().log(
                new ActorData(actorId).setActorDisplayName(username).setActorRoles(roles),
                new ActionData(details).setAction(action)
            );
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AuditLogControllerApi#logAuthAction");
            e.printStackTrace();
        }
    }
}
}
