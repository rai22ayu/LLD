package onlinesurvey;

import java.util.UUID;

public abstract class Question {
    protected UUID questionId;
    protected String text;
    protected boolean isRequired;

    public abstract QuestionType getQuestionType();
    public abstract void validateAnswer(Object answer);

    public UUID getQuestionId() {
        return questionId;
    }

    public String getText() {
        return text;
    }

    public boolean isRequired() {
        return isRequired;
    }
}
