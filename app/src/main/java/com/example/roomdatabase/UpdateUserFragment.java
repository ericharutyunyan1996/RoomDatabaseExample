package com.example.roomdatabase;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class UpdateUserFragment extends Fragment {
    private EditText myIdUpdate, myNameUpdate, myEmailUpdate;
    private Button myUpdateBut;

    public UpdateUserFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_update_user, container, false);

        myIdUpdate = (EditText) view.findViewById(R.id.userUpdateId);
        myNameUpdate = (EditText) view.findViewById(R.id.userUpdateName);
        myEmailUpdate = (EditText) view.findViewById(R.id.userUpdateEmail);
        myUpdateBut = (Button) view.findViewById(R.id.btnUpdate);


        myUpdateBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int id = Integer.parseInt(myIdUpdate.getText().toString());
                String name = myNameUpdate.getText().toString();
                String email = myEmailUpdate.getText().toString();


                User user = new User();
                user.setId(id);
                if (!!TextUtils.isEmpty(name) & !!TextUtils.isEmpty(email)) {
                    user.setEmail(email);
                    user.setName(name);
                } else {
                    Toast.makeText(getActivity(), "Name and Email cant be empty", Toast.LENGTH_SHORT).show();
                    return;
                }


                MainActivity.myDatabaseClass.myDao().updateUser(user);
                Toast.makeText(getActivity(), "User is successfully updated", Toast.LENGTH_SHORT).show();

                myIdUpdate.setText("");
                myNameUpdate.setText("");
                myEmailUpdate.setText("");
            }
        });
        return view;
    }

}
