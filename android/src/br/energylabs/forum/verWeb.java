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
  		Lucas Teske ( lucas at teske dot net dot br )	
 */
package br.energylabs.forum;

import android.os.*;
import android.widget.*;
import android.app.*;
import android.webkit.*;
import android.view.*;

public class verWeb extends Activity {

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
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK) && web.canGoBack()) {
			web.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	private class w2 extends WebViewClient {

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {

			view.loadUrl(url);
			return true;

		}
	}
}
