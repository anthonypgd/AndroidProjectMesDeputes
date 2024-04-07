package com.example.mesdeputes;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class CollaborateurAdapter extends ArrayAdapter<String> {

    private List<String> collabos;
    private Context context;

    public CollaborateurAdapter(Context context, List<String> collabos) {
        super(context, 0, collabos);
        this.context = context;
        this.collabos = collabos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String collaborateur = collabos.get(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_collaborateur, parent, false);
        }

        TextView textViewCollabo = convertView.findViewById(R.id.textViewItemDeputyName);
        textViewCollabo.setText(collaborateur);

        return convertView;
    }
}