package com.example.test4;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends Activity {
	
	private TextView tv2;
	
	private SharedPreferences sp;
	private Editor editor;
	
	int counter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		sp = getSharedPreferences("data",MODE_PRIVATE);
		editor = sp.edit();
		
		 tv2 = (TextView)findViewById(R.id.tv_show2);
		 tv2.setText("counter Ϊ" + sp.getInt("counter", 0) + "");
		 
		
	}
	
	public void secondButton(View view){
		Intent intent = new Intent(this,MainActivity.class);
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
