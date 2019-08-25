package com.example.roomdatabase;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class DeleteUserFargment extends Fragment {
    private Button deleteUser;
    private EditText idText;

    public DeleteUserFargment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_delete_user_fargment, container, false);

        deleteUser = (Button) view.findViewById(R.id.delete);
        idText = (EditText) view.findViewById(R.id.userDeleteId);

        deleteUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(idText.getText().toString());
                User user = new User();
                user.setId(id);
                MainActivity.myDatabaseClass.myDao().deleteUser(user);
                Toast.makeText(getActivity(), "User is successfully dleted", Toast.LENGTH_SHORT).show();
                idText.setText("");
            }
        });
        return view;
    }

}
