package sg.edu.rp.c346.ps_classjournal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<String> al;
    ArrayAdapter<String> aa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = this.findViewById(R.id.lvModuleList);
        al = new ArrayList<String>();
        al.add("C347");

        aa = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, al);
        lv.setAdapter(aa);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, infoActivity.class);
                intent.putExtra("code", position+1);
                startActivity(intent);

            }
        });

    }
}
