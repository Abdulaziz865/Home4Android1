package com.example.home4android1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerFragment extends Fragment implements OnItemClickListener {

    AddFragment add = new AddFragment();
    Button buttonAdd;
    private final RickAndMortyRepository repository = new RickAndMortyRepository();
    private final RickAndMortyAdapter adapter = new RickAndMortyAdapter(this);
    private RecyclerView rvListOfName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recycler, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        buttonAdd = view.findViewById(R.id.button_add);
        rvListOfName = view.findViewById(R.id.rv_list_of_name);
        initialize();
        adapter.setData(repository.getListOfCharacters());
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, AddFragment.class, null)
                        .addToBackStack("RecyclerFragment").commit();

            }
        });
    }

    private void initialize() {
        rvListOfName.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rvListOfName.setAdapter(adapter);
    }

    public void onClick(RickAndMortyModel model) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("character", model);
        getParentFragmentManager().beginTransaction()
                .add(R.id.fragment_container, DetailFragment.class, bundle)
                .addToBackStack("RecyclerFragment")
                .commit();
    }


}