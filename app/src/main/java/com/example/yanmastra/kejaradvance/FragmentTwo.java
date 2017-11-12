package com.example.yanmastra.kejaradvance;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yanmastra.kejaradvance.listener.FragmentToHostListener;
import com.example.yanmastra.kejaradvance.listener.HostToFragmentListener;

/**
 * Created by Yan Mastra on 11/12/2017.
 */

public class FragmentTwo extends Fragment implements HostToFragmentListener{
    TextView tvText;
    Button btnPicu;

    FragmentToHostListener listener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_two, container, false);

        tvText = rootView.findViewById(R.id.tv_content_two);
        btnPicu = rootView.findViewById(R.id.btn_picu);

        ((MainActivity) getActivity()).setHostToFragmentListener(this);

        btnPicu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onDataReceiveFragment("T E R P I C U ");
                Intent intent = new Intent(getActivity(), ServiceActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }

    @Override
    public void onDataReceiveInFragment(String data) {
        Toast.makeText(getActivity(), data, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onAttach(Context context) {
        listener = (FragmentToHostListener) context;
        super.onAttach(context);
    }
}
