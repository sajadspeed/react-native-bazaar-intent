package com.reactnativebazaarintent;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

import android.content.Intent;
import android.net.Uri;

@ReactModule(name = BazaarIntentModule.NAME)
public class BazaarIntentModule extends ReactContextBaseJavaModule {
    public static final String NAME = "BazaarIntent";
	
	public ReactApplicationContext context;
	
    public BazaarIntentModule(ReactApplicationContext reactContext) {
        super(reactContext);
		this.context = reactContext;
    }

    @Override
    @NonNull
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void details(String packagename) {
		Intent intent = new Intent(Intent.ACTION_VIEW); 
		intent.setData(Uri.parse("bazaar://details?id=" + packagename)); 
		intent.setPackage("com.farsitel.bazaar"); 
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		this.context.startActivity(intent);
    }
	
	@ReactMethod
    public void comments(String packagename) {
		Intent intent = new Intent(Intent.ACTION_EDIT); 
		intent.setData(Uri.parse("bazaar://details?id=" + packagename)); 
		intent.setPackage("com.farsitel.bazaar"); 
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		this.context.startActivity(intent);
    }
	
	@ReactMethod
    public void developerApps(String developerId) {
		Intent intent = new Intent(Intent.ACTION_VIEW); 
		intent.setData(Uri.parse("bazaar://collection?slug=by_author&aid=" + developerId)); 
		intent.setPackage("com.farsitel.bazaar"); 
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		this.context.startActivity(intent); 
    }
	
	@ReactMethod
    public void userLogin() {
		Intent intent = new Intent(Intent.ACTION_VIEW); 
		intent.setData(Uri.parse("bazaar://login")); 
		intent.setPackage("com.farsitel.bazaar"); 
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		this.context.startActivity(intent); 
    }
	
}
