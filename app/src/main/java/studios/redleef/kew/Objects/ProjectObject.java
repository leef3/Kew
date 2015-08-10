package studios.redleef.kew.Objects;

import java.util.ArrayList;

/**
 * Created by Fred Lee on 8/10/2015.
 */
public class ProjectObject {

    String name;
    ArrayList<TaskObject> taskList;

    public ProjectObject(String name)
    {
        this.name = name;
        taskList = new ArrayList<TaskObject>();
    }

    public void addTaskObject(TaskObject toAdd)
    {
        taskList.add(toAdd);
    }
}
