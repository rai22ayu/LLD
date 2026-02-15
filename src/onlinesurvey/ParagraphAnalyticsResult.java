package onlinesurvey;

import java.util.List;

class ParagraphAnalyticsResult implements AnalyticsResult {
    private List<String> responses;

    public ParagraphAnalyticsResult(List<String> responses) {
        this.responses = responses;
    }

    public List<String> getResponses() {
        return responses;
    }
}
