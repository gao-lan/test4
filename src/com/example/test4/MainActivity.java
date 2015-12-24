package com.example.test4;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends Activity {
	
	int counter;
	
	private TextView tv1;
	
	private SharedPreferences sp;
	private Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = getSharedPreferences("data",MODE_PRIVATE);
        editor = sp.edit();
        
        tv1 = (TextView)findViewById(R.id.tv_show1);
        
        tv1.setText("counter Ϊ" + sp.getInt("counter", 0) + "");
        
    }
    
    public void firstButton(View view){
    	Intent intent = new Intent(this,SecondActivity.class);
    	startActivity(intent);
		
	}
    
    @Override
    protected void onStop() {
    	super.onStop();
    	counter = sp.getInt("counter", 0);
    	counter++;
    	editor.putInt("counter", counter);
    	editor.commit();
    }
}
