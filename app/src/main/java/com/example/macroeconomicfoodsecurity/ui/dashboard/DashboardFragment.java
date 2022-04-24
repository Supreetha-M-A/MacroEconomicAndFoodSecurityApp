package com.example.macroeconomicfoodsecurity.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.macroeconomicfoodsecurity.DashboardGraphActivity;
import com.example.macroeconomicfoodsecurity.R;
import com.example.macroeconomicfoodsecurity.databinding.FragmentDashboardBinding;

public class
DashboardFragment extends Fragment implements AdapterView.OnItemSelectedListener{

    private FragmentDashboardBinding binding;
    private Button show;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        DashboardViewModel dashboardViewModel =
//                new ViewModelProvider(this).get(DashboardViewModel.class);
//
//        binding = FragmentDashboardBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
//        show=binding.;
//
//
//        final TextView textView = binding.textDashboard;
//        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
//        return root;
        View v=inflater.inflate(R.layout.fragment_dashboard,container,false);
        show=v.findViewById(R.id.button);
        //show.setOnClickListener();
        show.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity(), DashboardGraphActivity.class);
                startActivity(i);

            }
        });
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Spinner spinner = (Spinner) getView().findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getContext(),
                R.array.countries_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        Object itemAtPosition = parent.getItemAtPosition(pos);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}