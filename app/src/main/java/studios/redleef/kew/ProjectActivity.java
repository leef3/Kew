package studios.redleef.kew;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.manuelpeinado.fadingactionbar.FadingActionBarHelper;
import com.melnykov.fab.FloatingActionButton;

import studios.redleef.kew.Helpers.ProjectListAdapter;
import studios.redleef.kew.Objects.ProjectObject;

public class ProjectActivity extends Activity {

    Context context;

    ProjectListAdapter mAdapter;

    ArrayList<ProjectObject> projectList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        FadingActionBarHelper helper = new FadingActionBarHelper()
                .actionBarBackground(R.drawable.ab_background)
                .headerLayout(R.layout.header)
                .contentLayout(R.layout.project_main)
                .headerOverlayLayout(R.layout.header_overlay);
        setContentView(helper.createView(this));
        helper.initActionBar(this);


        context = this;

        projectList = new ArrayList<ProjectObject>();

        for(int x = 0; x < 14; x++)
        {
            ProjectObject toAdd = new ProjectObject("Test");
            projectList.add(toAdd);
        }

        ListView projectListView = (ListView)findViewById(android.R.id.list);
        mAdapter = new ProjectListAdapter(context, projectList);
        projectListView.setAdapter(mAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabProject);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProjectDetailActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_project, menu);
        return true;
    }
}