/*
 *  EnergyLabs DangerCenter Forum Android App
    Copyright (C) 2014  DangerCenter

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along
    with this program; if not, write to the Free Software Foundation, Inc.,
    51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
  
  	Made by: 
  		Victor Silva ( viitorsant at gmail dot com )
  		Lucas Teske  ( lucas at teske dot net dot br )	
 */
package br.energylabs.forum;

import android.net.Uri;
import android.os.*;
import android.widget.*;
import android.annotation.SuppressLint;
import android.app.*;
import android.content.Intent;
import android.graphics.Bitmap;
import android.webkit.*;
import android.util.Log;
import android.view.*;

public class verWeb extends Activity {

	// Widgets variables
	WebView web;
	ProgressBar loading;
	ImageView background;
	
	@SuppressLint("SetJavaScriptEnabled")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		web = (WebView) findViewById(R.id.webview01);
		loading = (ProgressBar) findViewById(R.id.loadingbar);
		background = (ImageView) findViewById(R.id.fadebg);
		// Open Webview with forum link
		web.setWebViewClient(new w2());
		web.getSettings().setJavaScriptEnabled(true);
		web.getSettings().setLoadsImagesAutomatically(true);
		web.loadUrl("http://forum.energylabs.com.br");
		

	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.menu, menu);
	    return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	        case R.id.mensageiro:
	        	web.loadUrl("http://forum.energylabs.com.br/index.php?app=members&module=messaging");
	            return true;
	        case R.id.forum:
	    		web.loadUrl("http://forum.energylabs.com.br");
	            return true;
	        case R.id.pesquisar:
	        	web.loadUrl("http://forum.energylabs.com.br/index.php?app=core&module=search");
	        	return true;
	        case R.id.notificacoes:
	        	web.loadUrl("http://forum.energylabs.com.br/index.php?app=core&module=usercp&tab=core&area=notificationlog&clear=true");
	        	return true;
	        case R.id.forummenu:
	        	web.loadUrl("javascript:document.getElementById(\"user_navigation\").style.display = (document.getElementById(\"user_navigation\").style.display==\"block\")?\"none\":\"block\";");
	        	return true;
	        case R.id.exit:
	        	finish();
	        	return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	// Turn back on clicking key back
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch(keyCode)	{
		case KeyEvent.KEYCODE_BACK:
			web.goBack();
			return true;
		}
		
		return super.onKeyDown(keyCode, event);
	}

	private class w2 extends WebViewClient {
		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon)	{
			super.onPageStarted(view, url, favicon);
			background.setVisibility(View.VISIBLE);		
			loading.setVisibility(View.VISIBLE);
		}
		@Override
    	public void onPageFinished(WebView view, String url) {
    		super.onPageFinished(view, url);
			background.setVisibility(View.GONE);
			loading.setVisibility(View.GONE);
			// Just to remove the "Full version" button
			web.loadUrl("javascript:document.getElementById(\"full_version\").style.display=\"none\"");
		}
		
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			//	Open external browser if not on forum
			if(!url.contains("forum.energylabs.com.br"))	{	
				Log.v("shouldOverrideUrlLoading", "Opening Browser: "+url);
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
				startActivity(browserIntent);
				return true;
			}
			return false;
		}
	}
}
