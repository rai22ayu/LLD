package onlinesurvey;

public class AnalyticsFactory {

    QuestionAnalytics<?> getAnalyticsFactory(QuestionType questionType){
        switch (questionType){
            case RATING -> {
                return new RatingQuestionAnalytics();
            }
            case PARAGRAPH -> {
                return new ParagraphQuestionAnalytics();
            }
            case MULTIPLE_CHOICE -> {
                return new MultipleChoiceQuestionAnalytics();
            }
            default -> {
                return null;
            }
        }
    }
}
