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


public class AddUserFargment extends Fragment implements View.OnClickListener {
    private Button saveButtton;
    private EditText myEditId, myEditName, myEditEmail;

    public AddUserFargment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_add_user_fargment, container, false);
        saveButtton = (Button) view.findViewById(R.id.btnSave);
        saveButtton.setOnClickListener(this);
        myEditId = (EditText) view.findViewById(R.id.userId);
        myEditName = (EditText) view.findViewById(R.id.userName);
        myEditEmail = (EditText) view.findViewById(R.id.userEmail);


        return view;
    }

    @Override
    public void onClick(View view) {
        if (myEditId.getText().toString().trim().length() > 0) {


            int userid = Integer.parseInt(myEditId.getText().toString());
            String username = myEditName.getText().toString();
            String useremail = myEditEmail.getText().toString();
if (username.trim().length()>0 & useremail.trim().length()>0){
    User user = new User();

    user.setId(userid);
    user.setName(username);
    user.setEmail(useremail);
    MainActivity.myDatabaseClass.myDao().addUser(user);
    Toast.makeText(getActivity(), "User added", Toast.LENGTH_SHORT).show();

    myEditId.setText("");
    myEditName.setText("");
    myEditEmail.setText("");
}

        } else {
            Toast.makeText(getActivity(), "Fields can't be empty", Toast.LENGTH_SHORT).show();
            return;
        }
    }
}
