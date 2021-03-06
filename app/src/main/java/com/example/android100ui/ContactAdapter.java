package com.example.android100ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    private List<Contact> contacts;

    public ContactAdapter(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.contact_row, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact contact = contacts.get(position);

        holder.contactName.setText(contact.getName());
        if (contact.isOnline()) {
            holder.messageButton.setEnabled(true);
            holder.messageButton.setText("MESSAGE");
        } else {
            holder.messageButton.setEnabled(false);
            holder.messageButton.setText("OFFLINE");
        }
    }

    @Override
    public int getItemCount() {
        return this.contacts.size();
    }
}
