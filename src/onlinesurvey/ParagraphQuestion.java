package onlinesurvey;

public class ParagraphQuestion extends Question{
    private Integer allowedCharacters;

    @Override
    public QuestionType getQuestionType() {
        return QuestionType.PARAGRAPH;
    }

    @Override
    public void validateAnswer(Object answer) {
        if(isRequired && (answer == null || ((String) answer).isEmpty())){
            throw new RuntimeException("Text answer required");
        }
    }
}
