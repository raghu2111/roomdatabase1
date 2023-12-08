package com.example.roomdatabase1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.roomdatabase1.ViewModel.ContactViewModel;
import com.example.roomdatabase1.databinding.ActivityMain3Binding;
import com.example.roomdatabase1.model.Contacts;

public class MainActivity3 extends AppCompatActivity {
    private ActivityMain3Binding activityMain3Binding;
    private Contacts login;
    private com.example.roomdatabase1.MyClickHandler3 handler;
    private ContactViewModel loginviewmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        activityMain3Binding = DataBindingUtil.setContentView(this, R.layout.activity_main3);
        ContactViewModel myViewModel = new ViewModelProvider(this)
                .get(ContactViewModel.class);

        login = new Contacts();
        handler = new com.example.roomdatabase1.MyClickHandler3(this, login, myViewModel);
        if (getIntent().getExtras() != null) {
            String a1 = getIntent().getStringExtra("name");
            String a2 = getIntent().getStringExtra("email");
            String a3 = String.valueOf(getIntent().getIntExtra("id", -1));
            login.setName(a1);
            login.setEmail(a2);
            login.setId(Integer.parseInt(a3));
            activityMain3Binding.setContact(login);
            activityMain3Binding.setClickHandler(handler);
        }
    }
}