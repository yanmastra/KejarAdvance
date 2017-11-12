package com.example.yanmastra.kejaradvance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.yanmastra.kejaradvance.listener.FragmentToHostListener;
import com.example.yanmastra.kejaradvance.listener.HostToFragmentListener;

public class MainActivity extends AppCompatActivity implements FragmentToHostListener{

    private HostToFragmentListener hostToFragmentListener;

    public void setHostToFragmentListener(HostToFragmentListener hostToFragmentListener){
        this.hostToFragmentListener = hostToFragmentListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*

        FragmentOne fragmentOne = FragmentOne.newInstance(0);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, fragmentOne, "0").commit();
*/

        getSupportFragmentManager().beginTransaction()
                .addToBackStack(null).replace(R.id.container, new FragmentTwo(), "1").commit();
    }

    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();
        if (count > 0){
            getSupportFragmentManager().popBackStack();
        }else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_two, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.sent_to_fragment : hostToFragmentListener.onDataReceiveInFragment("My Data");
            break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDataReceiveFragment(String data) {
        Toast.makeText(this, data, Toast.LENGTH_LONG).show();
    }
}
