package studios.redleef.kew.Objects;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Fred Lee on 8/10/2015.
 */
public class ProjectObject {

    String title;
    long dateCreated;
    ArrayList<TaskObject> taskList;

    public ProjectObject(String title)
    {
        this.title = title;
        dateCreated = System.currentTimeMillis();
        taskList = new ArrayList<TaskObject>();
    }

    public void addTaskObject(TaskObject toAdd)
    {
        taskList.add(toAdd);
    }

    public long getDateCreated()
    {
        return dateCreated;
    }

    public int getNumTasks()
    {
        Random rand = new Random();
        return rand.nextInt(30 - 2);
        //return taskList.size();
    }

    public String getTitle()
    {
        return title;
    }

    public int getProgress()
    {
        Random rand = new Random();
        return rand.nextInt(100 - 0);
    }
}
