package sg.edu.rp.c346.ps_classjournal;

import android.content.Intent;
import android.icu.text.IDNA;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class infoActivity extends AppCompatActivity {

    ListView lvInfoList;
    Button btnInfo, btnAdd, btnEmail;
    ArrayList<InfoList> infoLists;
    CustomAdapt caInfo;
    ArrayAdapter aa;

    int requestCodeForGrade = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        lvInfoList = findViewById(R.id.lvDailyGrade);
        btnAdd = findViewById(R.id.buttonAdd);
        btnInfo = findViewById(R.id.buttonInfo);
        btnEmail = findViewById(R.id.buttonEmail);
        infoLists = new ArrayList<>();

        InfoList info1 = new InfoList("week 1", "B");
        InfoList info2 = new InfoList("week 2", "C");
        InfoList info3 = new InfoList("week 3", "A");
        infoLists.add(info1);
        infoLists.add(info2);
        infoLists.add(info3);

        caInfo = new CustomAdapt(this, R.layout.grades, infoLists);
        lvInfoList.setAdapter(caInfo);

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Intent to display data
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                // Set the URL to be used.
                rpIntent.setData(Uri.parse("http://www.rp.edu.sg"));
                startActivity(rpIntent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(infoActivity.this, AddMore.class);
                int num = infoLists.size();
                startActivityForResult(i,requestCodeForGrade);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // The action you want this intent to do;
                // ACTION_SEND is used to indicate sending text
                Intent email = new Intent(Intent.ACTION_SEND);
                // Put essentials like email address, subject & body text
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_SUBJECT, "");
                email.putExtra(Intent.EXTRA_TEXT, "");
                // This MIME type indicates email
                email.setType("message/rfc822");
                // createChooser shows user a list of app that can handle
                // this MIME type, which is, email
                startActivity(Intent.createChooser(email, "Choose an Email client :"));

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if(resultCode == RESULT_OK){
            if(data != null){
                String grade = data.getStringExtra("grade");
                String myWeek = data.getStringExtra("week");
                //int week = Integer.parseInt(myWeek);

                if(requestCode == requestCodeForGrade){
                    infoLists.add(new InfoList(myWeek,grade));
                    aa.notifyDataSetChanged();
                }

            }
        }
    }

 }

