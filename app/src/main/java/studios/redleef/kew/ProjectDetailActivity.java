package studios.redleef.kew;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.lang.reflect.Type;
import java.util.ArrayList;

import studios.redleef.kew.Helpers.TaskListAdapter;
import studios.redleef.kew.Objects.ProjectObject;
import studios.redleef.kew.Objects.TaskObject;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.manuelpeinado.fadingactionbar.FadingActionBarHelper;
import com.melnykov.fab.FloatingActionButton;

/**
 * Created by Fred Lee on 8/9/2015.
 * \
 * Holds the list of Tasks for 1 project
 */
public class ProjectDetailActivity extends Activity {

    TaskListAdapter mAdapter;

    Context context;
    //Save Name
    public static final String MASTER_SAVE_NAME = "MASTER_SAVE_DATA_PROJECTS";

    //List
    ArrayList<ProjectObject> masterProjectList;
    ArrayList<TaskObject> taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FadingActionBarHelper helper = new FadingActionBarHelper()
                .actionBarBackground(R.drawable.ab_background)
                .headerLayout(R.layout.header)
                .contentLayout(R.layout.project_detail)
                .headerOverlayLayout(R.layout.header_overlay);
        setContentView(helper.createView(this));
        helper.initActionBar(this);

        context = this;

        //List Initiate
        taskList = new ArrayList<TaskObject>();
        taskList.clear();
        //Data Populate
        loadData();

        ListView fullList = (ListView)findViewById(android.R.id.list);
        mAdapter = new TaskListAdapter(this, taskList);
        fullList.setAdapter(mAdapter);
        fullList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView parent, View view, int position, long id) {
                taskList.remove(position);
                mAdapter.notifyDataSetChanged();
                saveData();
                return true;
            }
        });

    }

    private void loadData()
    {

        //Loading the Projects
        masterProjectList = new ArrayList<ProjectObject>();
        SharedPreferences settings = context.getSharedPreferences("pref", 0);
        settings = context.getSharedPreferences("pref", 0);
        String objectData = settings.getString(MASTER_SAVE_NAME, "");
        if (!objectData.equals("")) {
            System.out.println("Object Data: " + objectData);
            Gson gson = new Gson();
            Type collectionType = new TypeToken<ArrayList<ProjectObject>>() {
            }.getType();
            JsonArray jArray = new JsonParser().parse(objectData).getAsJsonArray();
            for (JsonElement e : jArray) {
                ProjectObject c = gson.fromJson(e, ProjectObject.class);
                masterProjectList.add(c);
            }
        }

        //Loading the Tasklist of given project -- Add test data
        for(int x = 0; x < 15; x++)
        {
            taskList.add(new TaskObject("Test Task", "Test Task Description, Should be long and explanatory and should take up multiple lines lets try this"));
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabTask);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TaskDetailActivity.class);
                startActivity(intent);
            }
        });

    }

    private void saveData()
    {
        SharedPreferences.Editor settings = context.getSharedPreferences("pref",0).edit();
        String data = new Gson().toJson(masterProjectList);
        System.out.println("Data!: " + data);
        settings.putString(MASTER_SAVE_NAME, data);
        settings.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_project, menu);
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