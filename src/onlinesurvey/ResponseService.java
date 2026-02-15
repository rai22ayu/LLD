package onlinesurvey;

import java.util.*;

public class ResponseService {

    SurveyRepository surveyRepository;
    AnalyticsFactory analyticsFactory;

    public SurveyResponse submitResponse(UUID submitterId, UUID surveyId, List<Answer> answerList){
        Survey survey = surveyRepository.findById(surveyId);
        Map<UUID, Answer> answerMap = new HashMap<>();
        for(Answer ans : answerList){
            answerMap.put(ans.getQuestionId(), ans);
        }
        SurveyResponse sr = survey.submitResponse(answerMap, submitterId);
        surveyRepository.saveResponse(sr);
        return sr;
    }

    /**  TODO get all response for survey
     aggregate response via question id
     get question info and figure out the question type
     based on question type get the analytics factory
     calculate analytics and return
     */
    public SurveyAnalytics generateAnalytics(UUID surveyId){
        // Fetch all answers for the survey
        List<Answer> answerList = surveyRepository.getAnswers(surveyId);

        // Group answers by questionId
        Map<UUID, List<Answer>> groupedAnswers = new HashMap<>();
        for (Answer answer : answerList) {
            groupedAnswers.computeIfAbsent(answer.getQuestionId(), k -> new ArrayList<>()).add(answer);
        }

        // Initialize the analytics result
        SurveyAnalytics surveyAnalytics = new SurveyAnalytics();
        List<Object> analyticsList = new ArrayList<>();
        Map<UUID, Object> analyticsMap = new HashMap<>();

        Survey survey = surveyRepository.findById(surveyId);
        // Process each question
        for (Map.Entry<UUID, List<Answer>> entry : groupedAnswers.entrySet()) {
            UUID questionId = entry.getKey();
            List<Answer> answers = entry.getValue();

            // Retrieve the question (assuming Survey has a method to get questions)
            Question question = survey.getQuestion(questionId);

            // Get the appropriate analytics factory
            QuestionAnalytics questionAnalytics = analyticsFactory.getAnalyticsFactory(question.getQuestionType());
            if (questionAnalytics != null) {
                AnalyticsResult analyticsResult = questionAnalytics.getAnalytics(answers);
                surveyAnalytics.addAnalytics(questionId, analyticsResult);

            }
        }

        return surveyAnalytics;

    }
}
