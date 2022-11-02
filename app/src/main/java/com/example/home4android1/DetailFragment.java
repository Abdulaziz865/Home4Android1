package com.example.home4android1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

public class DetailFragment extends Fragment {


    private ImageView ivFullScreen;
    private TextView namePerson;
    private TextView agePerson;
    private RickAndMortyModel model;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ivFullScreen = view.findViewById(R.id.iv_fullscreen);
        namePerson = view.findViewById(R.id.tv_name);
        agePerson = view.findViewById(R.id.tv_age);
        getData();
    }

    private void getData() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            model = (RickAndMortyModel) arguments.getSerializable("character");
            Glide.with(ivFullScreen.getContext()).load(model.getImageUrl()).into(ivFullScreen);
            namePerson.setText(model.getName());
            agePerson.setText(String.valueOf(model.getAge()));
        }
    }
}

//    requireActivity().getSupportFragmentManager().beginTransaction()
//
//        .replace(R.id.fragment, ThirdFragment.class,null )
//        .addToBackStack("SecondFragment").commit();


