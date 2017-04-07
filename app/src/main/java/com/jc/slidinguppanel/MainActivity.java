package com.jc.slidinguppanel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> array_list;

    private SlidingUpPanelLayout mLayout;
    TextView textView;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setListView();
        panelListener();
    }

    /**
     * Initialization of the textView and SlidingUpPanelLayout
     * */
    private void init() {
        mLayout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        mLayout.setAnchorPoint((float) 0.2);
        textView = (TextView) findViewById(R.id.list_main);
        listView = (ListView) findViewById(R.id.list);
    }


    public void panelListener(){

       mLayout.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
           @Override
           public void onPanelSlide(View panel, float slideOffset) {
               Log.e("activityMain", "onPanelSlide, offset" + slideOffset);
           }

           @Override
           public void onPanelStateChanged(View panel, SlidingUpPanelLayout.PanelState previousState, SlidingUpPanelLayout.PanelState newState) {

           }

       });
    }
    
    
    public void setListView(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               mLayout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
               textView.setText(array_list.get(i));
                //Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                //startActivity(intent);

                Toast.makeText(MainActivity.this, "onItemClick", Toast.LENGTH_SHORT).show();
            }
        });

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, array_list());
        listView.setAdapter(arrayAdapter);
    }



    public List<String> array_list(){
        array_list = Arrays.asList(
                "This",
                "Is",
                "An",
                "Example",
                "ListView",
                "That",
                "You",
                "Can",
                "Scroll",
                ".",
                "It",
                "Shows",
                "How",
                "Any",
                "Scrollable",
                "View",
                "Can",
                "Be",
                "Included",
                "As",
                "A",
                "Child",
                "Of",
                "SlidingUpPanelLayout"
        );
        return array_list;
    }

    @Override
    public void onBackPressed() {
        if (mLayout != null && (mLayout.getPanelState() == SlidingUpPanelLayout.PanelState.EXPANDED || mLayout.getPanelState() == SlidingUpPanelLayout.PanelState.ANCHORED)){
            mLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
        }else{
            super.onBackPressed();
        }

    }
}







