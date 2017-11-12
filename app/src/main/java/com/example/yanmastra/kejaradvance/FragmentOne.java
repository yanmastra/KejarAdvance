package com.example.yanmastra.kejaradvance;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Yan Mastra on 11/12/2017.
 */

public class FragmentOne extends Fragment implements View.OnClickListener{
    public static String KEY_NAME = "KEY_NAME";
    public static String KEY_COUNT = "KEY_COUNT";
    private Button btnAdd;
    private TextView tvText;
    private int count = 0;

    public static FragmentOne newInstance(int count){
        FragmentOne fragment = new FragmentOne();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_COUNT, count);

        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        //nName = bundle.getString(KEY_NAME);
        count = bundle.getInt(KEY_COUNT);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_one, container, false);

        btnAdd = rootView.findViewById(R.id.add_tv);
        tvText = rootView.findViewById(R.id.tv_content);
        tvText.setText("Fragment : "+count);

        btnAdd.setOnClickListener(this);
        Toast.makeText(getActivity(), "Count : "+count, Toast.LENGTH_LONG).show();

        return rootView;
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.add_tv :
                count ++;
                getFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.container, FragmentOne.newInstance(count), null).commit();
                break;
            default:;
        }
    }
}
