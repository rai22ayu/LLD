package onlinesurvey;

import java.util.List;

public interface QuestionAnalytics{

    AnalyticsResult getAnalytics(List<Answer> answerList);
}
