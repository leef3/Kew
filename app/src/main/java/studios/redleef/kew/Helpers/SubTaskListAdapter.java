package studios.redleef.kew.Helpers;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.numberprogressbar.NumberProgressBar;

import java.util.ArrayList;

import studios.redleef.kew.Objects.SubTaskObject;
import studios.redleef.kew.R;
import studios.redleef.kew.TaskDetailActivity;

/**
 * Created by Fred Lee on 8/11/2015.
 */
public class SubTaskListAdapter extends BaseAdapter {
    Context context;
    protected ArrayList<SubTaskObject> itemList;
    LayoutInflater inflater;

    public SubTaskListAdapter(Context context, ArrayList<SubTaskObject> itemList)
    {
        this.itemList = itemList;
        this.context = context;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount()
    {
        return itemList.size();
    }
    public SubTaskObject getItem(int position)
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
            convertView = this.inflater.inflate(R.layout.sub_task_list_item, parent, false);

            //Find UI elements for Lat Long and Timestamp
            holder.TitleTextView = (TextView) convertView.findViewById(R.id.subTaskTitle);
            holder.CheckBox = (CheckBox) convertView.findViewById(R.id.subTaskCheckBox);

            //Used to re-track the ingredient
            holder.TitleTextView.setTag(position);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        //Get the current Employee Object
        SubTaskObject item = itemList.get(position);

        //Set the contents of the UI elements
        holder.TitleTextView.setText(item.getTitle());
        holder.CheckBox.setChecked(item.getChecked());

        holder.CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(context, "Checked", Toast.LENGTH_SHORT);
            }
        });

        return convertView;
    }

    private class ViewHolder {
        TextView TitleTextView;
        CheckBox CheckBox;
    }
}
