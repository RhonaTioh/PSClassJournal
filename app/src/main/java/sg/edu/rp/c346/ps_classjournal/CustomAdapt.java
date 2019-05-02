package sg.edu.rp.c346.ps_classjournal;

import android.content.Context;
import android.icu.text.IDNA;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapt extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<InfoList> infoLists;

    public CustomAdapt(@NonNull Context context, int resource, @NonNull ArrayList<InfoList> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        infoLists = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View row = convertView;
        if(row == null){
            LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout_id, parent, false);
        }

        TextView tvWeek = row.findViewById(R.id.textViewWeek);
        TextView tvGrade = row.findViewById(R.id.textViewGrade);

        InfoList currentItem = infoLists.get(position);

        String week = currentItem.getWeek();
        String grade = currentItem.getGrade();

        tvWeek.setText(week);
        tvGrade.setText(grade);
        return row;
    }
}
