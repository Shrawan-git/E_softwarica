package com.classassignment.e_softwarica.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.classassignment.e_softwarica.R;
import com.classassignment.e_softwarica.adapter.ContactAdapter;
import com.classassignment.e_softwarica.model.Contacts;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    static  List<Contacts> contactsList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = root.findViewById(R.id.recyclerView);

        // Create a list of contacts to display in RecyclerView

        // Adding all the contacts object in list

        Contacts contacts= new Contacts("Son" ,"21","Pokhara", "Male");

        contactsList = contacts.getContactsList();
        if(contactsList.isEmpty()) {
            contactsList.add(new Contacts("Son" ,"21","Pokhara", "Male"));
            contactsList.add(new Contacts("Daughter" ,"22","Kathmandu","Female"));
            contacts.setContactsList(contactsList);
        }



        ContactAdapter contactsAdapter = new ContactAdapter(getActivity(),contactsList);
        recyclerView.setAdapter(contactsAdapter);

        //Display all the contacts in linear layour (vertically)
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return root;
    }
}