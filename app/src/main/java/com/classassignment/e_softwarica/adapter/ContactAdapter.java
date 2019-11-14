package com.classassignment.e_softwarica.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.classassignment.e_softwarica.R;
import com.classassignment.e_softwarica.model.Contacts;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactsViewHolder> {
    Context context;
    static List<Contacts> contactsList;
    int imgId;

    //Constructor for data from activity


    public ContactAdapter(Context context, List<Contacts> contactsList) {
        this.context = context;
        this.contactsList = contactsList;
    }

    @NonNull
    @Override
    //To create new RecycleView.ContactsViewHolder and initialize to be used by RecycleView
    public ContactAdapter.ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.carddetail, parent, false);
        //LayoutInflator is for taking the xml layout and create view
        return new ContactsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ContactsViewHolder holder, final int position) {
        final Contacts detailclass = contactsList.get(position);
        //To hold data in detailclass

        String gender=detailclass.getGender();
        if(gender.equals("Female")){
            imgId=R.drawable.female;
        }
        else
        {
            imgId=R.drawable.male;
        }



       holder.imgview.setImageResource(imgId);
        holder.txnames.setText(detailclass.getName());
        holder.txgenders.setText(detailclass.getGender());
        holder.txages.setText(detailclass.getAge());
        holder.txaddress.setText(detailclass.getAddress());

        holder.imagedelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contactsList.remove(position);
                notifyDataSetChanged();
            }
        } );

    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }

    //Inner Class
    public class ContactsViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imgview;
        TextView txnames, txages, txgenders, txaddress;
        ImageButton imagedelete;

        public ContactsViewHolder(@NonNull View itemView) {
            super(itemView);
            imgview = itemView.findViewById(R.id.imgview);
            txnames = itemView.findViewById(R.id.name);
            txages = itemView.findViewById(R.id.age);
            txaddress = itemView.findViewById(R.id.address);
            txgenders = itemView.findViewById(R.id.gender);
            imagedelete = itemView.findViewById(R.id.imgdelete);


        }
    }
}
