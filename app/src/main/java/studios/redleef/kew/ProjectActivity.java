package studios.redleef.kew;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.manuelpeinado.fadingactionbar.FadingActionBarHelper;

public class ProjectActivity extends Activity {

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

        //setContentView(R.layout.project_main);

        ListView listView = (ListView) findViewById(android.R.id.list);
        ArrayList<String> items = new ArrayList<String>();
        for(int x = 0; x < 40; x++)
        {
            items.add("Woor" + x);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_project, menu);
        return true;
    }
}