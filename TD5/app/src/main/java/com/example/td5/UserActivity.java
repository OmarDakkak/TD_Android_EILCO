package com.example.td5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity {

    List<Contact> contacts = new ArrayList<>();
    List<String> myUrls = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvContacts);
        contacts.add(new Contact("Jean", "Pierre", "https://photos.tf1.fr/700/933/cover-jean-pierre-pernaut-jt-13h-58f17c-0@1x.jpg"));
        contacts.add(new Contact("Jeanne", "D'arc", "https://histoire-image.org/sites/default/jeanne-arc-sacre-charlesvii.jpg"));
        contacts.add(new Contact("Pierre", "Ménès", "https://img.lemde.fr/2021/07/12/0/0/5047/3359/664/0/75/0/ec8bffc_5200484-01-06.jpg"));
        contacts.add(new Contact("Arthur", "Rimbaud", "https://cdn.radiofrance.fr/s3/cruiser-production/2019/11/8b4794fb-a081-4223-a623-2cbef9909478/260x348_gettyimages-89861180.jpg"));
        contacts.add(new Contact("Richard", "Cœur de lion", "https://images.lanouvellerepublique.fr/image/upload/t_1020w/f_auto/58c2c255479a454c008b4966.jpg"));
        contacts.add(new Contact("Zinédine", "Zidane","https://therealchamps.com/wp-content/uploads/getty-images/2020/07/962797074.jpeg"));
        contacts.add(new Contact("Yannick", "Noah", "https://cdn0.scrvt.com/c2465e9022ba946df66d1244a69b1c75/df33aafb8efd9eca/fce536dfc522/v/28db93591732/yannick-noah.jpg"));


        ContactsAdapter adapter = new ContactsAdapter(contacts);

        rvContacts.setAdapter(adapter);

        rvContacts.setLayoutManager(new LinearLayoutManager(this));
    }
}