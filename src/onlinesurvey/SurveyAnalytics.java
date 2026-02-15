package onlinesurvey;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SurveyAnalytics {
    private Map<UUID, AnalyticsResult> analyticsMap = new HashMap<>();

    public void addAnalytics(UUID questionId, AnalyticsResult result) {
        analyticsMap.put(questionId, result);
    }
}
