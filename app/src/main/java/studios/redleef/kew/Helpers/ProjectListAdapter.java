package studios.redleef.kew.Helpers;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.lzyzsd.circleprogress.DonutProgress;

import java.util.ArrayList;

import studios.redleef.kew.Objects.ProjectObject;
import studios.redleef.kew.ProjectDetailActivity;
import studios.redleef.kew.R;

/**
 * Created by Fred Lee on 8/10/2015.
 */
public class ProjectListAdapter extends BaseAdapter {
    Context context;
    protected ArrayList<ProjectObject> itemList;
    LayoutInflater inflater;

    public ProjectListAdapter(Context context, ArrayList<ProjectObject> itemList)
    {
        this.itemList = itemList;
        this.context = context;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount()
    {
        return itemList.size();
    }
    public ProjectObject getItem(int position)
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
            convertView = this.inflater.inflate(R.layout.project_list_item, parent, false);

            //Find UI elements for Lat Long and Timestamp
            holder.TitleTextView = (TextView) convertView.findViewById(R.id.projectTitle);
            holder.NumTasksTextView = (TextView) convertView.findViewById(R.id.numTasks);
            holder.Progress = (DonutProgress) convertView.findViewById(R.id.testArc);
            holder.DateAddedTextView = (TextView) convertView.findViewById(R.id.dateStarted);
            //Used to re-track the ingredient
            holder.TitleTextView.setTag(position);

            holder.RootLayout = (LinearLayout) convertView.findViewById(R.id.rootLayout);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        //Get the current Employee Object
        ProjectObject item = itemList.get(position);

        //Set the contents of the UI elements
        holder.TitleTextView.setText(item.getTitle());
        holder.NumTasksTextView.setText("Task Count: " + String.valueOf(item.getNumTasks()));
        holder.DateAddedTextView.setText("Created: " + item.getStringDateCreated());
        holder.Progress.setProgress(item.getProgress());

        holder.RootLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProjectDetailActivity.class);
                context.startActivity(intent);
            }
        });

        return convertView;
    }

    private class ViewHolder {
        TextView TitleTextView;
        TextView NumTasksTextView;
        TextView DateAddedTextView;
        LinearLayout RootLayout;
        DonutProgress Progress;
    }

}