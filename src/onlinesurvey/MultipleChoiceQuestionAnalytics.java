package onlinesurvey;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class MultipleChoiceQuestionAnalytics implements QuestionAnalytics {
    @Override
    public AnalyticsResult getAnalytics(List<Answer> answerList) {
        Map<UUID, Integer> analyticsMap = new HashMap<>();
        for (Answer ans : answerList) {
            List<Option> options = (List<Option>) ans.getValue();
            for (Option op : options) {
                analyticsMap.put(op.getOptionId(), analyticsMap.getOrDefault(op.getOptionId(), 0) + 1);
            }
        }
        int totalResponse = answerList.size();
        for (Map.Entry<UUID, Integer> entry : analyticsMap.entrySet()) {
            entry.setValue(entry.getValue() * 100 / totalResponse); // Convert to percentage
        }
        return new ChoiceAnalyticsResult(analyticsMap);
    }
}