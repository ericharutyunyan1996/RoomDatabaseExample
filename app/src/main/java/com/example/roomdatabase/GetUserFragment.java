package com.example.roomdatabase;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.List;


public class GetUserFragment extends Fragment {
private TextView userText;

    public GetUserFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_get_user, container, false);
        userText=(TextView)view.findViewById(R.id.textUser);
        List<User> users=MainActivity.myDatabaseClass.myDao().getUser();
        String info="";
        for (User user:users){
            int id=user.getId();
            String name=user.getName();
            String email=user.getEmail();
            info=info+"Id:"+id+"\n"+"Name:"+name+"\n"+"Email:"+email+"\n\n";

        }
        userText.setText(info);

        return view;
    }

}
