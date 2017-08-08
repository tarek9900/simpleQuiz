package lib.tarek.simplequiz;

/**
 * Created by Tarek on 01/08/2017.
 */

public class QuizItem {

    private String title ;
    private String desription ;
    private int imageId ;
    private Boolean answer ;

    public QuizItem(String title, String desription , Boolean answer) {
        this.title = title;
        this.desription = desription;
        this.answer = answer ;
    }

    public QuizItem(String title, String desription, int imageId, Boolean answer) {
        this.title = title;
        this.desription = desription;
        this.imageId = imageId;
        this.answer = answer;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesription() {
        return desription;
    }

    public void setDesription(String desription) {
        this.desription = desription;
    }

    public Boolean getAnswer() {
        return answer;
    }

    public void setAnswer(Boolean answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "QuizItem{" +
                "title='" + title + '\'' +
                ", desription='" + desription + '\'' +
                '}';
    }
}
