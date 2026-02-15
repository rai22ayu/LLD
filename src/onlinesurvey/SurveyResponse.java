package onlinesurvey;

import java.util.List;
import java.util.UUID;

public class SurveyResponse {
    private UUID surveyId;
    private List<Answer> answerList;
    private UUID submittedId;

    public SurveyResponse(UUID surveyId, List<Answer> answerList, UUID submittedId) {
        this.surveyId = surveyId;
        this.answerList = answerList;
        this.submittedId = submittedId;
    }
}
