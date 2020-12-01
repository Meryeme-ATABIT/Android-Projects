package com.example.td5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class ContactsAdapter extends  RecyclerView.Adapter<ContactsAdapter.ViewHolder>{
    private final List<Contact> mContacts;

    public ContactsAdapter(List<Contact> mContacts) {
        this.mContacts = mContacts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.item_contact, parent, false);
        return new ViewHolder(contactView);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contact contact = mContacts.get(position);

        TextView firstNameTextView = holder.firstNameTextView;
        firstNameTextView.setText(contact.getNom());

        TextView lastnameTextView = holder.lastnameTextView;
        lastnameTextView.setText(contact.getPrenom());

        ImageView urlPhoto = holder.urlPhoto;
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView firstNameTextView;
        public TextView lastnameTextView;
        public ImageView urlPhoto;

        public ViewHolder(View itemView){
            super(itemView);

            firstNameTextView =(TextView) itemView.findViewById(R.id.contact_firstname);
            lastnameTextView = (TextView) itemView.findViewById(R.id.contact_lastname);
            urlPhoto = (ImageView) itemView.findViewById(R.id.urlImage);
        }
    }
}
