package com.example.macroeconomicfoodsecurity.ui.notifications;

import static com.example.macroeconomicfoodsecurity.MainActivity.isResearcher;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.macroeconomicfoodsecurity.DBHandler;
import com.example.macroeconomicfoodsecurity.DashboardGraphActivity;
import com.example.macroeconomicfoodsecurity.R;
import com.example.macroeconomicfoodsecurity.ReaderController;
import com.example.macroeconomicfoodsecurity.Result;
import com.example.macroeconomicfoodsecurity.WriterController;
import com.example.macroeconomicfoodsecurity.databinding.FragmentNotificationsBinding;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NotificationsFragment extends Fragment implements AdapterView.OnItemSelectedListener{

    private FragmentNotificationsBinding binding;
    private Button show;

    ReaderController readerController;
    DBHandler dbHandler;
    private ArrayList<String> yearGDP;
    private ArrayList<String> percentGDP;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        NotificationsViewModel notificationsViewModel =
//                new ViewModelProvider(this).get(NotificationsViewModel.class);
//
//        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
//
////        final TextView textView = binding.textNotifications;
////        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
//
//        return root;
        //return root;
        View v=inflater.inflate(R.layout.fragment_notifications,container,false);
        show=v.findViewById(R.id.tradeShowButton);
        dbHandler=new DBHandler(getActivity().getApplicationContext());
        Log.i("dbHandler-->", String.valueOf(dbHandler));
        readerController = new ReaderController(dbHandler);
        //dbHandler.addNewGDPPercent("1995", "34", "35", "33");
        try {
            WriterController.seedData(getActivity().getApplicationContext(), dbHandler);
        } catch (IOException e) {
            // e.printStackTrace();
            Log.i("printstacktrace","errorrr");
        }
        List<Result> courseModalArrayList = readerController.getFDIInFlowsPercent("india","2005","2022");
        Log.i("size--->", String.valueOf(courseModalArrayList.size()));
        yearGDP=new ArrayList<String>();
        percentGDP=new ArrayList<String>();
        for (Result m: courseModalArrayList
        ) {
            Log.e("Main Notifications ", m.percent);
            yearGDP.add(m.year);
            if(m.percent.length()>0) {
                percentGDP.add(m.percent);
            }
            else{
                percentGDP.add("5");
            }

        }
//        for(int i=0;i<9;i++){
//            yearGDP.add(Integer.valueOf(courseModalArrayList.get(i).year));
//            percentGDP.add(Integer.valueOf(courseModalArrayList.get(i).percent));
//
//        }
        show.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity(), DashboardGraphActivity.class);
//              i.putIntegerArrayListExtra("year",yearGDP);
//                i.putIntegerArrayListExtra("percent",percentGDP);
                i.putStringArrayListExtra("year", yearGDP);
                i.putStringArrayListExtra("percent", percentGDP);
//               Fragment fragment=new Fragment();
//               Bundle bundle=new Bundle();
//               bundle.putStringArrayList("year",yearGDP);
//               bundle.putStringArrayList("percent",percentGDP);

                startActivity(i);

            }
        });
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Spinner spinner = (Spinner) getView().findViewById(R.id.spinner4);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getContext(),
                R.array.countries_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
//        Boolean isResearcher = getArguments().getBoolean("isResearcher");
//        if(!isResearcher) {
//            Button annotateButton = getView().findViewById(R.id.annotateButton);
//            annotateButton.setVisibility(View.INVISIBLE);
//            EditText annotationText = getView().findViewById(R.id.annotationText);
//            annotationText.setVisibility(View.INVISIBLE);
//        }
        //show=(Button) getView().findViewById(R.id.button5)
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