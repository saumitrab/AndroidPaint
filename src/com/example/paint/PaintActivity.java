package com.example.paint;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class PaintActivity extends Activity {

	private Map<Object, Integer> colorPalette;
	// TODO: Dirty hack
	public static int currentColor;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);
        
        colorPalette = new HashMap<Object, Integer>();
        currentColor = Color.BLACK;
        
        TextView tv = new TextView(getBaseContext());
        tv = (TextView) findViewById(R.id.tvBlack);
        tv.setBackgroundColor(Color.BLACK);
        colorPalette.put(tv.getTag(), Color.BLACK);
        tv.setOnClickListener(new myColorListener());
        
        tv = (TextView) findViewById(R.id.tvRed);
        tv.setBackgroundColor(Color.RED);
        colorPalette.put(tv.getTag(), Color.RED);
        tv.setOnClickListener(new myColorListener());
        
        tv = (TextView) findViewById(R.id.tvBlue);
        tv.setBackgroundColor(Color.BLUE);
        colorPalette.put(tv.getTag(), Color.BLUE);
        tv.setOnClickListener(new myColorListener());
        
        tv = (TextView) findViewById(R.id.tvGreen);
        tv.setBackgroundColor(Color.GREEN);
        colorPalette.put(tv.getTag(), Color.GREEN);
        tv.setOnClickListener(new myColorListener());
        
        tv = (TextView) findViewById(R.id.tvYellow);
        tv.setBackgroundColor(Color.YELLOW);
        colorPalette.put(tv.getTag(), Color.YELLOW);
        tv.setOnClickListener(new myColorListener());
          
    }
    
    public class myColorListener implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			currentColor = colorPalette.get(v.getTag());
			Toast.makeText(getBaseContext(), "TAG:"  + v.getTag() , Toast.LENGTH_SHORT).show();
		}
    	
    }
    
}