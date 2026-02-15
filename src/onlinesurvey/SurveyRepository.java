package onlinesurvey;

import java.util.List;
import java.util.UUID;

public interface SurveyRepository {
    void save(Survey survey);
    Survey findById(UUID surveyId);
    void saveResponse(SurveyResponse surveyResponse);
    List<Answer> getAnswers(UUID surveyId);
}
