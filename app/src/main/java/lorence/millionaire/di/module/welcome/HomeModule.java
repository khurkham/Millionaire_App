package lorence.millionaire.di.module.welcome;

import dagger.Module;
import lorence.millionaire.view.activity.welcome.WelcomeActivity;
import lorence.millionaire.view.fragment.home.HomeFragment;
import lorence.millionaire.view.fragment.home.HomeView;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

@Module
public class HomeModule {

    private HomeFragment mFragment;
    private WelcomeActivity mActivity;
    private HomeView mView;

    public HomeModule(WelcomeActivity activity, HomeFragment fragment, HomeView view) {
        mFragment = fragment;
        mActivity = activity;
        mView = view;
    }
}
