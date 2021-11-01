package com.example.textra_cernescudiana;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Page1 extends AppCompatActivity {
    private ListView listView;
    private ContactAdapter contactAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);
       contactAdapter=new ContactAdapter(getContacte());
        listView = findViewById(R.id.listContacte);
        listView.setAdapter(contactAdapter);


    }

    private List<Contact> getContacte()
    {
        List<Contact> list=new ArrayList<>();
        list.add(new Contact("Gigel","0724186425"));
        list.add(new Contact("Marcel","0758696447"));
        list.add(new Contact("Ioana","0725361468"));
        list.add(new Contact("George","0725689425"));
        list.add(new Contact("Miruna","0745869574"));
        list.add(new Contact("Ionel","0723268745"));
        list.add(new Contact("Andrei","0769857485"));
        list.add(new Contact("Sabin","0736251436"));
        list.add(new Contact("Teodor","0765986574"));
        list.add(new Contact("Diana","0732531636"));
        list.add(new Contact("Mihai","0712345698"));

        return list;}

}
