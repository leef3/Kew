package studios.redleef.kew.Objects;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    public String getStringDateCreated()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
        Date resultDate = new Date(dateCreated);
        return (sdf.format(resultDate));
    }

    public int getNumTasks()
    {
        return taskList.size();
    }

    public String getTitle()
    {
        return title;
    }

    public int getProgress()
    {
        //Calculating the overall progress
        int numTasks = getNumTasks();

        int totalProgress = 0;

        for(int x = 0; x < numTasks; x++)
        {
            //Adds  Ex 50, 61, 72, 10, 0, 1 -- Divs by NumTasks for Avg
            totalProgress = totalProgress + taskList.get(x).getProgress();
        }

        if(numTasks > 0)
        {
            double avgProgress = (totalProgress / numTasks);
            return (int)Math.round(avgProgress);
        }
        else
        {
            return 0;
        }
    }
}
