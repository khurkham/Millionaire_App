package lorence.millionaire.di.module.welcome;

import dagger.Module;
import dagger.Provides;
import lorence.millionaire.di.scope.ActivityScope;
import lorence.millionaire.view.activity.welcome.WelcomeActivity;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

@Module
public class WelcomeModule {

    private WelcomeActivity mActivity;

    public WelcomeModule(WelcomeActivity activity) {
        mActivity = activity;
    }

    @Provides
    @ActivityScope
    WelcomeActivity provideWelcomeActivity() {
        return mActivity;
    }
}
