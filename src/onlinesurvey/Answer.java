package onlinesurvey;

import java.util.UUID;

public class Answer {
    private UUID questionId;
    private Object value;

    public UUID getQuestionId() {
        return questionId;
    }

    public Object getValue() {
        return value;
    }
}
