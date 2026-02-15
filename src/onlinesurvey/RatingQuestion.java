package onlinesurvey;

public class RatingQuestion extends Question{
    private int minimumRating;
    private int maximumRating;

    @Override
    public QuestionType getQuestionType() {
        return QuestionType.RATING;
    }

    @Override
    public void validateAnswer(Object answer) {
        if(isRequired && answer == null){
            throw new RuntimeException("answer required");
        }

        int ans = (int) answer;
        if(ans > maximumRating || ans < minimumRating){
            throw new RuntimeException("wrong rating selected");
        }
    }
}
