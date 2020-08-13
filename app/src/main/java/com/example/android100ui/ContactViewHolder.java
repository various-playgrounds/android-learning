package com.example.android100ui;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactViewHolder extends RecyclerView.ViewHolder {
    TextView contactName;
    Button messageButton;

    public ContactViewHolder(@NonNull View itemView) {
        super(itemView);
        contactName = itemView.findViewById(R.id.contact_name);
        messageButton = itemView.findViewById(R.id.message_button);
    }
}
