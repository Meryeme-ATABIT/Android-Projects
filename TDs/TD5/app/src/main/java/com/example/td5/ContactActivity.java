package com.example.td5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ContactActivity extends AppCompatActivity {

    List<Contact> contacts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        // Lookout hte recyclerview in activity layout
        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvContacts);

        // Initialistaion des contacts
        contacts.add(new Contact("Jean", "Pierre", "https://histoire-image.org/sites/default/jeanne-arc-sacre-charlesvii.jpg"));
        contacts.add(new Contact("Jeanne", "D'arc", "https://histoire-image.org/sites/default/jeanne-arc-sacre-charlesvii.jpg"));
        contacts.add(new Contact("Pierre", "Menez"));
        contacts.add(new Contact("Arthur", "Rimbaut"));

        // Création d'un adapter avec initialisation du constructeur avec notre liste de contacts
        ContactsAdapter adapter = new ContactsAdapter(contacts);

        // On notifie au recylerview notre ada^pter
        rvContacts.setAdapter(adapter);

        //On déclare quelle type de LayoutManager on désire
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
    }
}
