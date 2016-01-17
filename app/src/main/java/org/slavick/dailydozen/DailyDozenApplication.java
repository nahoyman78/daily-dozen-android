package org.slavick.dailydozen;

import com.activeandroid.app.Application;
import com.crashlytics.android.Crashlytics;
import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

import org.slavick.dailydozen.model.Food;
import org.slavick.dailydozen.model.FoodInfo;

import io.fabric.sdk.android.Fabric;

public class DailyDozenApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Iconify.with(new FontAwesomeModule());

        if (!BuildConfig.DEBUG) {
            Fabric.with(this, new Crashlytics());
        }

        ensureAllFoodsExistInDatabase();

        FoodInfo.init(this);
    }

    private void ensureAllFoodsExistInDatabase() {
        Food.ensureAllFoodsExistInDatabase(
                getResources().getStringArray(R.array.food_names),
                getResources().getIntArray(R.array.food_quantities));
    }
}
