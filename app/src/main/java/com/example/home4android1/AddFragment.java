package com.example.home4android1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class AddFragment extends Fragment {

    private final List<RickAndMortyModel> listOfCharacters = new ArrayList<>();

    ImageView imageViewCreate;
    EditText editNameCreate;
    EditText editAgeCreate;
    Button buttonCreate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageViewCreate = view.findViewById(R.id.image_create);
        editNameCreate = view.findViewById(R.id.et_name_create);
        editAgeCreate = view.findViewById(R.id.et_age_create);
        buttonCreate = view.findViewById(R.id.btn_create);

        buttonCreate.setOnClickListener(new View.OnClickListener() {
            String nameCreateText = editNameCreate.getText().toString().trim();
            String nameAgeText = editAgeCreate.getText().toString().trim();

            @Override
            public void onClick(View view) {
                if (!nameCreateText.isEmpty() && !nameAgeText.isEmpty()) {
                    editNameCreate.setError("Введите имя");
                    editAgeCreate.setError("Введите возраст");
                } else if (!nameCreateText.isEmpty()) {
                    editNameCreate.setError("Введите имя");
                } else if (!nameAgeText.isEmpty()) {
                    editAgeCreate.setError("Введите возраст");
                } else {
                    listOfCharacters.add(new RickAndMortyModel("https://avatars.mds.yandex.net/i?id=358ef38c5d070e947d846ee41357859fd24cd965-5858200-images-thumbs&n=13",
                            nameCreateText, 0, "#FFE6FF00"));

                }
            }

        });
    }

    public List<RickAndMortyModel> getListOfCharacters() {
        return listOfCharacters;
    }
}


