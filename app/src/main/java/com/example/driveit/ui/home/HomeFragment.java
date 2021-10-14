package com.example.driveit.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.driveit.R;
import com.example.driveit.adapter.HomeAdapter;
import com.example.driveit.databinding.FragmentHomeBinding;
import com.example.driveit.model.ModelHome;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    private List<ModelHome> menuList = new ArrayList<>();
    private RecyclerView recyclerView;
    private HomeAdapter mAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = root.findViewById(R.id.home_recycler_view);
        mAdapter = new HomeAdapter(getContext(), menuList);


        // int mNoOfColumns = Utility.calculateNoOfColumns(getContext(),180);
       // RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 1);
        final GridLayoutManager manager = new GridLayoutManager(getContext(),2);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return mAdapter.isHeader(position) ? manager.getSpanCount() : 1;
            }
        });
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(mAdapter);

        prepareMenuData();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    private void prepareMenuData() {


        menuList.clear();
        ModelHome menus;
        for(int i=0;i<4;i++){
            menus = new ModelHome("Range Rover Sport","AED 3,980","Per Week",R.drawable.car_red);
            menuList.add(menus);
        }
        mAdapter.notifyDataSetChanged();
    }
}