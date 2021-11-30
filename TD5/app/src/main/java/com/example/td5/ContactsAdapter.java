package com.example.td5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {

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
        firstNameTextView.setText(contact.getFirstName());

        TextView lastNameTextView = holder.lastnameTextView;
        lastNameTextView.setText(contact.getLastName());

        ImageView imageView = holder.imageView;
        String url = contact.getImageURL();

        Glide
                .with(imageView)
                .load(url)
                .centerCrop()
                .into(imageView);

    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView firstNameTextView;
        public TextView lastnameTextView;
        public ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            firstNameTextView = (TextView) itemView.findViewById(R.id.contact_firstname);
            lastnameTextView = (TextView) itemView.findViewById(R.id.contact_lastname);
            imageView = (ImageView) itemView.findViewById(R.id.imageview);
        }

    }
}
