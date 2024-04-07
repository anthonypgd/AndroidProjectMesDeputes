package com.example.mesdeputes;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DeputyActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textViewName, textViewCirco, textViewEmail, textViewGroupe, textViewDateDeNaissance, textViewLieuDeNaissance, textViewSexe;
    private ListView listViewCollabos;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deputy);
        textViewName= findViewById(R.id.textViewDeputyName);
        textViewCirco= findViewById(R.id.textViewDeputyCirco);
        textViewGroupe= findViewById(R.id.textViewDeputyGroupe);
        textViewEmail= findViewById(R.id.textViewDeputyEmail);
        imageView= findViewById(R.id.imageViewDeputy);
        textViewDateDeNaissance= findViewById(R.id.textViewDateDeNaissance);
        textViewLieuDeNaissance= findViewById(R.id.textViewLieuDeNaissance);
        textViewSexe= findViewById(R.id.textViewSexe);
        listViewCollabos=findViewById(R.id.listViewCollaborator);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Deputy deputy= (Deputy) getIntent().getSerializableExtra("deputy");
        textViewName.setText(deputy.getFirstname()+" "+deputy.getLastname());
        textViewCirco.setText(deputy.getDepartment()+", "+
                deputy.getNameCirco()+ " "+ deputy.getNumCirco()+
                (deputy.getNumCirco()==1? "er": "eme")+" circoncription");
        textViewGroupe.setText(deputy.getGroupe());
        textViewEmail.setText(deputy.getEmail());
        textViewDateDeNaissance.setText("Né(e) le : "+deputy.getDateDeNaissance());
        textViewLieuDeNaissance.setText("Né(e) à : "+deputy.getLieuDeNaissance());
        textViewSexe.setText("Sexe : "+deputy.getSexe());

        CollaborateurAdapter adapter = new CollaborateurAdapter(this, deputy.getCollaborator());
        listViewCollabos.setAdapter(adapter);
        ApiServices.loadDeputyAvatar(this, deputy.getNameForAvatar(), imageView);
    }
}
