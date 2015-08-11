package studios.redleef.kew.Objects;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Fred Lee on 8/9/2015.
 */
public class TaskObject {

    private String description;
    private String title;
    private ArrayList<SubTaskObject> subTaskList;

    public TaskObject()
    {
        title = "";
        description = "";
        subTaskList = new ArrayList<SubTaskObject>();
    }

    public TaskObject(String title, String description)
    {
        this.title = title;
        this.description = description;
        subTaskList = new ArrayList<SubTaskObject>();
    }

    public void setTitle(String toSet)
    {
        this.title = toSet;
    }
    public void setDescription(String toSet)
    {
        this.description = toSet;
    }

    public void addSubTask(SubTaskObject toAdd)
    {
        subTaskList.add(toAdd);
    }

    public String getTitle()
    {
        return title;
    }
    public String getDescription()
    {
        return description;
    }
    public int getProgress()
    {
        //Calculated from all the taskList --- No weights for now just make it 1 per subtask
        Random rand = new Random();
        return rand.nextInt(100 - 0);
    }
    public ArrayList<SubTaskObject> getSubTaskList()
    {
        return subTaskList;
    }

}
