package com.classassignment.e_softwarica.ui.add;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.classassignment.e_softwarica.MainActivity;
import com.classassignment.e_softwarica.R;
import com.classassignment.e_softwarica.adapter.ContactAdapter;
import com.classassignment.e_softwarica.model.Contacts;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {
    EditText tvname, tvage, tvaddress;
    RadioButton rbf, rbm;
    RadioGroup radioGroup;
    Button btnsave;
    RecyclerView viewR;
    String gender, name, address, age;

    static List<Contacts> contactsList = new ArrayList<>();
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_add, container, false);

        tvname = root.findViewById(R.id.txtname);
        tvage = root.findViewById(R.id.txtage);
        tvaddress = root.findViewById(R.id.txtaddress);
        rbf = root.findViewById(R.id.rbf);
        rbm = root.findViewById(R.id.rbm);
        btnsave = root.findViewById(R.id.btnsave);
        radioGroup = root.findViewById(R.id.genderG);
        viewR = root.findViewById(R.id.recyclerView);
        final List<Contacts> detailcls = new ArrayList<>();

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!tvname.getText().toString().isEmpty()) {

                    name = tvname.getText().toString();

                    if (!tvage.getText().toString().isEmpty()) {
                        age = (tvage.getText().toString());
                        if (!tvaddress.getText().toString().isEmpty()) {
                            address = (tvaddress.getText().toString());
                            try {
                                int selectGender = radioGroup.getCheckedRadioButtonId();
                                RadioButton radioButton = root.findViewById(selectGender);
                                gender = radioButton.getText().toString();



                                Contacts contacts = new Contacts(name, age, address, gender);
                                contactsList=contacts.getContactsList();
                                contactsList.add(contacts);
                                contacts.setContactsList(contactsList);
                                Toast.makeText(getActivity(), "Save Successful", Toast.LENGTH_SHORT).show();


                            } catch (Exception e) {
                                Toast.makeText(getActivity(), "error", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getActivity(), "Please Select address", Toast.LENGTH_SHORT).show();

                        }
                    } else {
                        Toast.makeText(getActivity(), "Please Enter age", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getActivity(), "Please Enter name", Toast.LENGTH_SHORT).show();

                }

            }

        });


        return root;
    }
}