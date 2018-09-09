package lorence.millionaire.app;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.lang.reflect.Field;

import lorence.millionaire.di.component.AppComponent;
import lorence.millionaire.di.component.DaggerAppComponent;
import lorence.millionaire.di.module.app.AppModule;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public class Application extends android.app.Application {

    private AppComponent mApplicationComponent;
    private Context mContext;
    private static Application sInstance;
    public static Typeface sEfFontStyle;

    public static synchronized Application getInstance() {
        if (sInstance == null) {
            sInstance = new Application();
        }
        return sInstance;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        sInstance = this;
        initAppComponent();
        FontsOverride.setDefaultFont(this, "MONOSPACE", "fonts/ProximaNova-Regular.ttf");
    }

    private void initAppComponent() {
        mApplicationComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this,mContext))
                .build();
    }

    public AppComponent getAppComponent() {
        return mApplicationComponent;
    }

    private static class FontsOverride {

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        static void setDefaultFont(Context context, String staticTypefaceFieldName, String fontAssetName) {
            sEfFontStyle = Typeface.createFromAsset(context.getAssets(),
                    fontAssetName);
            replaceFont(staticTypefaceFieldName, sEfFontStyle);
        }

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        static void replaceFont(String staticTypefaceFieldName, final Typeface newTypeface) {
            try {
                final Field staticField = Typeface.class
                        .getDeclaredField(staticTypefaceFieldName);
                staticField.setAccessible(true);
                staticField.set(null, newTypeface);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

    }

}


