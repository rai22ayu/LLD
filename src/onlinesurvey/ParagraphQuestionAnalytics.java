package onlinesurvey;

import java.util.List;

public class ParagraphQuestionAnalytics implements QuestionAnalytics{
    @Override
    public AnalyticsResult getAnalytics(List<Answer> answers) {
        return new ParagraphAnalyticsResult(answers.stream().map(answer -> ((String)answer.getValue())).toList());
    }
}
