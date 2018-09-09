package lorence.millionaire.di.component;

import javax.inject.Singleton;

import dagger.Component;
import lorence.millionaire.di.module.app.AppModule;
import lorence.millionaire.di.module.welcome.WelcomeModule;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

@Singleton
@Component(
        modules = {
                AppModule.class
        }
)
public interface AppComponent {
        WelcomeComponent plus(WelcomeModule module);
}
