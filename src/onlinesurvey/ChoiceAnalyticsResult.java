package onlinesurvey;

import java.util.Map;

public class ChoiceAnalyticsResult implements AnalyticsResult{
    private Map<?, Integer> percentageMap;

    public ChoiceAnalyticsResult(Map<?, Integer> percentageMap) {
        this.percentageMap = percentageMap;
    }

    public Map<?, Integer> getPercentageMap() {
        return percentageMap;
    }


}
