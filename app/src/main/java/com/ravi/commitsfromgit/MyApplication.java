package com.ravi.commitsfromgit;

import android.app.Activity;
import android.app.Application;

import com.ravi.commitsfromgit.di.components.ApplicationComponent;
import com.ravi.commitsfromgit.di.components.DaggerApplicationComponent;
import com.ravi.commitsfromgit.di.components.modules.ContextModule;

public class MyApplication extends Application {

    ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder().contextModule(new ContextModule(this)).build();
        applicationComponent.injectApplication(this);

    }

    public static MyApplication get(Activity activity){
        return (MyApplication) activity.getApplication();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
