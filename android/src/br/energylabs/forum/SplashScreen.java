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

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class SplashScreen extends Activity {
    private static int SPLASH_TIME_OUT = 3000;	//	mileseconds
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splashscreen);
		
	       new Handler().postDelayed(new Runnable() {
	            @Override
	            public void run() {
	                Intent i = new Intent(SplashScreen.this, verWeb.class);
	                startActivity(i);
	                finish();
	            }
	        }, SPLASH_TIME_OUT);
	}
}
