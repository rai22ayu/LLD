package onlinesurvey;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;


public class Survey {
    private UUID surveyId;
    private String description;
    private UUID creatorId;
    private String title;
    private List<Question> questionList;
    private SurveySettings settings;
    private LocalDateTime createdAt;
    private LocalDateTime expireAt;
    private SurveyStatus surveyStatus;

    public Survey(UUID surveyId, String title) {
        this.surveyId = surveyId;
        this.title = title;
        surveyStatus = SurveyStatus.DRAFT;
    }

    public Survey(UUID surveyId, String description, UUID creatorId, String title,
                  List<Question> questionList, SurveySettings settings, LocalDateTime createdAt,
                  LocalDateTime expireAt, SurveyStatus surveyStatus) {
        this.surveyId = surveyId;
        this.description = description;
        this.creatorId = creatorId;
        this.title = title;
        this.questionList = questionList;
        this.settings = settings;
        this.createdAt = createdAt;
        this.expireAt = expireAt;
        this.surveyStatus = surveyStatus;
    }

    public UUID getSurveyId() {
        return surveyId;
    }

    public String getDescription() {
        return description;
    }

    public UUID getCreatorId() {
        return creatorId;
    }

    public String getTitle() {
        return title;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public Question getQuestion(UUID questionId){
        return questionList.stream().filter(q -> q.getQuestionId().equals(questionId)).findFirst().get();
    }

    public SurveySettings getSettings() {
        return settings;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getExpireAt() {
        return expireAt;
    }

    public SurveyStatus getSurveyStatus() {
        return surveyStatus;
    }

    public void addQuestion(Question question){
        if(!SurveyStatus.DRAFT.equals(surveyStatus)){
            throw new RuntimeException("survey cant be modified now");
        }
        questionList.add(question);
    }

    public void publishSurvey(){
        if(questionList.isEmpty()){
            throw new RuntimeException("question list should not be empty");
        }
        surveyStatus = SurveyStatus.PUBLISHED;
    }

    public SurveyResponse submitResponse(Map<UUID, Answer> answersMap, UUID submitterId){
        List<Answer> answerList = new ArrayList<>();
        for(Question q : questionList){
            Answer ans = answersMap.get(q.getQuestionId());
            if(ans != null){
                q.validateAnswer(ans);
            }
            answerList.add(ans);
        }

        return new SurveyResponse(surveyId, answerList, submitterId);
    }
}
