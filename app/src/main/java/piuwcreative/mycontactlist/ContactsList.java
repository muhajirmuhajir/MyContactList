package piuwcreative.mycontactlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class ContactsList extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Kontak> kontaks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_list);

        ArrayList<String> names = getIntent().getStringArrayListExtra("names");
        ArrayList<String> phones = getIntent().getStringArrayListExtra("phones");

        kontaks = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            Kontak kontak = new Kontak();
            kontak.setName(names.get(i));
            kontak.setPhone(phones.get(i));
            kontaks.add(kontak);
        }

        recyclerView = findViewById(R.id.rv_kontaks);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        KontakAdapter adapter = new KontakAdapter(this);
        adapter.setKontaks(kontaks);
        recyclerView.setAdapter(adapter);

    }
}
