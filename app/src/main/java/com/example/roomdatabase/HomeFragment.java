package com.example.roomdatabase;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class HomeFragment extends Fragment implements View.OnClickListener {
    private Button btnAddUser, btnViewUsers, btnDeleteUser, btnUpdateUser;


    public HomeFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        btnAddUser = (Button) view.findViewById(R.id.insertBut);
        btnAddUser.setOnClickListener(this);

        btnViewUsers = (Button) view.findViewById(R.id.viewBut);
        btnViewUsers.setOnClickListener(this);

        btnDeleteUser = (Button) view.findViewById(R.id.deleteBut);
        btnDeleteUser.setOnClickListener(this);

        btnUpdateUser = (Button) view.findViewById(R.id.updateBut);
        btnUpdateUser.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.insertBut:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,
                        new AddUserFargment()).addToBackStack(null).commit();
                break;
            case R.id.viewBut:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,
                        new GetUserFragment()).addToBackStack(null).commit();
                break;
            case R.id.deleteBut:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,
                        new DeleteUserFargment()).addToBackStack(null).commit();
                break;
            case R.id.updateBut:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,
                        new UpdateUserFragment()).addToBackStack(null).commit();
                break;

        }
    }
}
