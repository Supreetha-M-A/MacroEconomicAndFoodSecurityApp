package com.example.macroeconomicfoodsecurity.ui.home;

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
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.macroeconomicfoodsecurity.DashboardGraphActivity;
import com.example.macroeconomicfoodsecurity.MainActivity;
import com.example.macroeconomicfoodsecurity.DBHandler;

import com.example.macroeconomicfoodsecurity.R;
import com.example.macroeconomicfoodsecurity.ReaderController;
import com.example.macroeconomicfoodsecurity.Result;
import com.example.macroeconomicfoodsecurity.WriterController;
import com.example.macroeconomicfoodsecurity.databinding.FragmentHomeBinding;
import com.example.macroeconomicfoodsecurity.ui.notifications.NotificationsFragment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private FragmentHomeBinding binding;

    private Button show;

    ReaderController readerController;
    DBHandler dbHandler;
    private ArrayList<String> yearGDP;
    private ArrayList<String> percentGDP;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_home,container,false);
        show=v.findViewById(R.id.economyShowButton);
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
            Log.e("Main Economy ", m.percent);
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
        Spinner spinner = (Spinner) getView().findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getContext(),
                R.array.countries_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

//        NotificationsFragment notificationsFragment = new NotificationsFragment();
//        Bundle args = new Bundle();
//        args.putBoolean("isResearcher", true);
//        radioGroup = (RadioGroup) getView().findViewById(R.id.accountRadioGroup);
//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                if(checkedId == R.id.govtOfficial){
//                    isResearcher = false;
//                } else {
//                    isResearcher = true;
//                }
//            }
//        });
//        notificationsFragment.setArguments(args);
//        getFragmentManager().beginTransaction().add(R.id.container, notificationsFragment).commit();
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

    public void toggleAccount() {

    }
}