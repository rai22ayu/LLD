package onlinesurvey;

import java.util.List;

public class MultipleChoiceQuestion extends Question{
    List<Option> optionList;
    private boolean allowMultiple;

    @Override
    public QuestionType getQuestionType() {
        return QuestionType.MULTIPLE_CHOICE;
    }

    @Override
    public void validateAnswer(Object answer) {
        if(isRequired && (answer == null)){
            throw new RuntimeException("answer required");
        }
        if(allowMultiple) {
            List<Option> selectedOptions = (List<Option>) answer;
            for(Option so : selectedOptions){
                if(!optionList.contains(so)){
                    throw new RuntimeException("invalid option selected");
                }
            }
        }else{
            Option op = (Option) answer;
            if(!optionList.contains(op)){
                throw new RuntimeException("invalid option selected");
            }
        }

    }
}
