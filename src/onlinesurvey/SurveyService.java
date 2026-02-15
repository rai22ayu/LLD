package onlinesurvey;

import java.util.UUID;

public class SurveyService {
    private SurveyRepository surveyRepository;

    public UUID createSurvey(String title) {
        Survey survey = new Survey(UUID.randomUUID(), title);
        surveyRepository.save(survey);
        return survey.getSurveyId();
    }

    public void publishSurvey(UUID surveyId) {
        Survey survey = surveyRepository.findById(surveyId);
        survey.publishSurvey();
        surveyRepository.save(survey);
    }

    public void addQuestion(UUID surveyId, Question question) {
        Survey survey = surveyRepository.findById(surveyId);
        survey.addQuestion(question);
        surveyRepository.save(survey);
    }
}
