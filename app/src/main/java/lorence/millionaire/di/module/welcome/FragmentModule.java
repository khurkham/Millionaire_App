package lorence.millionaire.di.module.welcome;

import dagger.Module;
import dagger.Provides;
import lorence.millionaire.di.scope.ActivityScope;
import lorence.millionaire.view.activity.welcome.WelcomeActivity;
import lorence.millionaire.view.fragment.home.HomeFragment;
import lorence.millionaire.view.fragment.play.PlayFragment;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

@Module
public class FragmentModule {

    private WelcomeActivity mActivity;

    public FragmentModule() {
    }

    @Provides
    @ActivityScope
    HomeFragment provideHomeFragment() {
        return new HomeFragment();
    }

    @Provides
    @ActivityScope
    PlayFragment providePlayFragment() {
        return new PlayFragment();
    }
}
