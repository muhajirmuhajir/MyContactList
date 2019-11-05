package piuwcreative.mycontactlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnAdd, mBtnShow;
    private EditText mEtName, mEtPhone;



    private ArrayList<String> names , phones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnAdd = findViewById(R.id.btn_add_contact);
        mBtnShow = findViewById(R.id.btn_show_contact);
        mEtName = findViewById(R.id.et_name);

        mEtPhone = findViewById(R.id.et_phone);
        names = new ArrayList<>();
        phones = new ArrayList<>();


        mBtnShow.setOnClickListener(this);
        mBtnAdd.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add_contact:
                addNew();
                break;
            case R.id.btn_show_contact:
                Intent intent = new Intent(MainActivity.this, ContactsList.class);
                intent.putExtra("names", names);
                intent.putExtra("phones", phones);
                startActivity(intent);
                break;
        }
    }

    private void addNew() {
        String name = mEtName.getText().toString();
        String phone = mEtPhone.getText().toString();

        if (!name.isEmpty() && !phone.isEmpty()) {
            names.add(name);
            phones.add(phone);

            mEtPhone.setText("");
            mEtName.setText("");
            Toast.makeText(this,"Kontak berhasil ditambahkan",Toast.LENGTH_SHORT).show();
        }


    }
}
