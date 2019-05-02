package sg.edu.rp.c346.ps_classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class AddMore extends AppCompatActivity {

    TextView tvWeek;
    RadioGroup rg;
    private RadioButton radioButton;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_more);

        tvWeek = findViewById(R.id.textViewWeek);
        rg = findViewById(R.id.RadioGroup);
        btnSubmit = findViewById(R.id.buttonSubmit);

        Intent i = getIntent();
        int theNum = i.getIntExtra("num", 0);
        final String num = String.valueOf(theNum + 1);
        tvWeek.setText("Week " + num);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                int selected = rg.getCheckedRadioButtonId();
                radioButton = (RadioButton)findViewById(selected);
                i.putExtra("grade",radioButton.getText());
                i.putExtra("week",num);

                setResult(RESULT_OK);
                finish();
            }
        });
    }
}
