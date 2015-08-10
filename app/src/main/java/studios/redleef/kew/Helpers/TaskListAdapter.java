package studios.redleef.kew.Helpers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.daimajia.numberprogressbar.NumberProgressBar;

import java.util.ArrayList;

import studios.redleef.kew.Objects.TaskObject;
import studios.redleef.kew.R;

/**
 * Created by Fred Lee on 8/9/2015.
 */
public class TaskListAdapter extends BaseAdapter {
    Context context;
    protected ArrayList<TaskObject> itemList;
    LayoutInflater inflater;

    public TaskListAdapter(Context context, ArrayList<TaskObject> itemList)
    {
        this.itemList = itemList;
        this.context = context;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount()
    {
        return itemList.size();
    }
    public TaskObject getItem(int position)
    {
        return itemList.get(position);
    }
    public long getItemId(int position)
    {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = this.inflater.inflate(R.layout.task_list_item, parent, false);

            //Find UI elements for Lat Long and Timestamp
            holder.TitleTextView = (TextView) convertView.findViewById(R.id.taskItemTitle);
            holder.DescriptionTextView = (TextView) convertView.findViewById(R.id.taskItemDescription);
            holder.Progress = (NumberProgressBar) convertView.findViewById(R.id.taskItemProgress);
            //Used to re-track the ingredient
            holder.TitleTextView.setTag(position);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        //Get the current Employee Object
        TaskObject item = itemList.get(position);

        //Set the contents of the UI elements
        holder.TitleTextView.setText(item.getTitle());
        holder.DescriptionTextView.setText(item.getDescription());
        holder.Progress.setProgress(item.getProgress());

        return convertView;
    }

    private class ViewHolder {
        TextView TitleTextView;
        TextView DescriptionTextView;
        NumberProgressBar Progress;
    }

}