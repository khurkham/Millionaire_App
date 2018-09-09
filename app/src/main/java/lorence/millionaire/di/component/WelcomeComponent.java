package lorence.millionaire.di.component;

import dagger.Subcomponent;
import lorence.millionaire.di.module.welcome.FragmentModule;
import lorence.millionaire.di.module.welcome.HomeModule;
import lorence.millionaire.di.module.welcome.PlayModule;
import lorence.millionaire.di.module.welcome.WelcomeModule;
import lorence.millionaire.di.scope.ActivityScope;
import lorence.millionaire.view.activity.welcome.WelcomeActivity;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

@ActivityScope
@Subcomponent(
        modules = {
                WelcomeModule.class,
                FragmentModule.class
        }
)
public interface WelcomeComponent {
    WelcomeActivity inject(WelcomeActivity activity);
    HomeComponent plus(HomeModule homeModule);
    PlayComponent plus(PlayModule playModule);
}
