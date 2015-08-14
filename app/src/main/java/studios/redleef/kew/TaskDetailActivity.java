package studios.redleef.kew;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

import studios.redleef.kew.Helpers.SubTaskListAdapter;
import studios.redleef.kew.Objects.ProjectObject;
import studios.redleef.kew.Objects.SubTaskObject;
import studios.redleef.kew.R;

public class TaskDetailActivity extends Activity {

    SubTaskListAdapter mAdapter;

    Context context;


    ArrayList<ProjectObject> masterProjectList;
    ArrayList<SubTaskObject> subTaskList;

    ListView subTaskListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_detail);

        subTaskListView = (ListView)findViewById(R.id.subTaskListView);
        subTaskList = new ArrayList<SubTaskObject>();
        for(int x = 0; x < 8; x++)
        {
            SubTaskObject toAdd = new SubTaskObject("SubTaskTest", 1);
            subTaskList.add(toAdd);
        }
        mAdapter = new SubTaskListAdapter(this, subTaskList);

        subTaskListView.setAdapter(mAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_task_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
