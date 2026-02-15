package onlinesurvey;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RatingQuestionAnalytics implements QuestionAnalytics{
    @Override
    public AnalyticsResult getAnalytics(List<Answer> answerList) {
        Map<Integer, Integer> ratingAnalytics = new HashMap<>();
        for(Answer answer : answerList){
            ratingAnalytics.put((int)answer.getValue(), ratingAnalytics.getOrDefault((int)answer.getValue(), 0) + 1);
        }
        int totalResponse = answerList.size();
        for(Map.Entry<Integer, Integer> entry : ratingAnalytics.entrySet()){
            entry.setValue(entry.getValue()*100/totalResponse);
        }
        return new ChoiceAnalyticsResult(ratingAnalytics);
    }
}
