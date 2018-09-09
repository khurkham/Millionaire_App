package lorence.millionaire.di.module.welcome;

import dagger.Module;
import lorence.millionaire.view.activity.welcome.WelcomeActivity;
import lorence.millionaire.view.fragment.play.PlayFragment;
import lorence.millionaire.view.fragment.play.PlayView;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

@Module
public class PlayModule {

    private PlayFragment mFragment;
    private WelcomeActivity mActivity;
    private PlayView mView;

    public PlayModule(WelcomeActivity activity, PlayFragment fragment, PlayView view) {
        mFragment = fragment;
        mActivity = activity;
        mView = view;
    }
}
