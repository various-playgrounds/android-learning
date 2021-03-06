package com.example.android100ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PageFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;
    RecyclerView recyclerView;
    EditText textbox;

    public static PageFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        if (mPage == 1) {
            view = inflater.inflate(R.layout.fragment_page_new, container, false);

            Button button = view.findViewById(R.id.submit_button);
            textbox = view.findViewById(R.id.textbox);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String text = textbox.getText().toString();
                    Toast toast = Toast.makeText(PageFragment.this.getContext(), "Hello " + text, Toast.LENGTH_SHORT);
                    toast.show();
                }
            });
        } else if (mPage == 2) {
            view = inflater.inflate(R.layout.fragment_recycler_page, container, false);
            this.recyclerView = view.findViewById(R.id.recycler_view);
            this.recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

            List<Contact> contacts = Contact.createContactLists(100);
            ContactAdapter adapter = new ContactAdapter(contacts);
            this.recyclerView.setAdapter(adapter);
        } else {
            view = inflater.inflate(R.layout.fragment_page, container, false);
            TextView textView = (TextView) view;
            textView.setText("Fragment #" + mPage);
        }


        return view;
    }
}
