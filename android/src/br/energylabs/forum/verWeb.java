package br.energylabs.forum;

import android.content.*;
import android.graphics.*;
import android.os.*;
import android.widget.*;
import android.app.*;
import android.net.*;
import android.webkit.*;
import android.view.*;

public class verWeb extends Activity{
	
	// Variaveis dos widgets.
	WebView web;
	ProgressBar loading;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        web = (WebView) findViewById(R.id.webview01);
		loading = (ProgressBar) findViewById(R.id.load);
        
		// Abrir o WebView com o link do forum.
        web.setWebViewClient(new w2());
        web.getSettings().setJavaScriptEnabled(true);
		web.getSettings().setLoadsImagesAutomatically(true);
        web.loadUrl("http://forum.energylabs.com.br");

	}
	
    // Voltar ao clicar no "Retornar".
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) 
	{
		if ((keyCode == KeyEvent.KEYCODE_BACK) && web.canGoBack()) {
			web.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

 private class w2 extends WebViewClient
{
	@Override
	public void onPageStarted(WebView view, String url) {
		
		super.onPageStarted(view, url, null);
	}

	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		
		view.loadUrl(url);
		return true;

	}
  }
}
