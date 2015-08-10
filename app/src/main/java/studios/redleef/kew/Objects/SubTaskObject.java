package studios.redleef.kew.Objects;

/**
 * Created by Fred Lee on 8/9/2015.
 */
public class SubTaskObject {

    public int weight;
    public String content;
    public boolean completed;

    public SubTaskObject(String content, int weight)
    {
        this.content = content;
        this.weight = weight;
        this.completed = false;
    }

    public void setCompleted(boolean toSet)
    {
        completed = toSet;
    }

}
