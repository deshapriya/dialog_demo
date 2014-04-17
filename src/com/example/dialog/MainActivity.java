package com.example.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button btnNormal;
	private Button btnCustom;
	private Button btnCustomLayOut;
	private Typeface fontSerif;
	private Typeface fontMono;
	private Typeface fontSans;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		fontSerif = Typeface.SERIF;
		fontMono = Typeface.MONOSPACE;
		fontSans = Typeface.SANS_SERIF;
		
		btnNormal = (Button) findViewById(R.id.button);
		btnNormal.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				openNormalDialog();				
			}

		});
		
		btnCustom = (Button) findViewById(R.id.button1);
		btnCustom.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				openCustomDialog();				
			}

		});
		
		btnCustomLayOut = (Button) findViewById(R.id.button2);
		btnCustomLayOut.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				openDialog();				
			}

		});
	}
	
	private void openNormalDialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(R.string.dialog_title);
		builder.setMessage("some message");
		builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				((AlertDialog)dialog).dismiss();				
			}
		});
		
		builder.setNeutralButton("Report", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(getBaseContext(), R.string.msg_report, Toast.LENGTH_SHORT).show();
			}
		});
		
		builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(getBaseContext(), R.string.msg_ok, Toast.LENGTH_SHORT).show();
			}
		});
		
		builder.show();
		
	}

	private void openCustomDialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		TextView cusTitle = new TextView(getBaseContext());
		cusTitle.setTextColor(ColorStateList.valueOf(Color.GREEN));
		cusTitle.setText(R.string.dialog_title1);
		cusTitle.setTextSize(20);
		cusTitle.setPadding(10, 15, 10, 15);
		cusTitle.setBackgroundColor(Color.YELLOW);
		builder.setCustomTitle(cusTitle);
		builder.setMessage("Hello world..!!");
		builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				((AlertDialog)dialog).dismiss();				
			}
		});
		
		builder.setNeutralButton("Report", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(getBaseContext(), R.string.msg_report, Toast.LENGTH_SHORT).show();
			}
		});
		
		builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(getBaseContext(), R.string.msg_ok, Toast.LENGTH_SHORT).show();	
			}
		});
		
		final AlertDialog dialog = builder.create();
		dialog.setOnShowListener(new DialogInterface.OnShowListener() {

			@Override
			public void onShow(DialogInterface dialog) {

				Button btnPositive =  ((AlertDialog) dialog).getButton(Dialog.BUTTON_POSITIVE);
		        btnPositive.setTypeface(fontSerif);
		        btnPositive.setTextColor(Color.GREEN);

		        Button btnNegative = ((AlertDialog) dialog).getButton(Dialog.BUTTON_NEGATIVE);
		        btnNegative.setTypeface(fontMono);
		        btnNegative.setTextColor(Color.RED);
		        
		        
		        Button btnNeutral = ((AlertDialog) dialog).getButton(Dialog.BUTTON_NEUTRAL);
		        btnNeutral.setTypeface(fontSans);
		        btnNeutral.setBackgroundColor(Color.MAGENTA);
			}
		});
		dialog.show();
		TextView message = (TextView)dialog.findViewById(android.R.id.message);
		message.setTypeface(Typeface.DEFAULT_BOLD);
	}
	
	private void openDialog() {
		final Dialog dialog = new Dialog(this);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.setContentView(R.layout.dialog_layout);
		
		Button btnP = (Button) dialog.findViewById(R.id.btnok);
		btnP.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getBaseContext(), R.string.msg_ok, Toast.LENGTH_SHORT).show();
			}
		});
		Button btnN = (Button) dialog.findViewById(R.id.btncancel);
		btnN.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dialog.dismiss();
			}
		});
		dialog.show();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
