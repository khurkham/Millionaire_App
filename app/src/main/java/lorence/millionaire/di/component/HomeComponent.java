package lorence.millionaire.di.component;

import dagger.Subcomponent;
import lorence.millionaire.di.module.welcome.HomeModule;
import lorence.millionaire.di.scope.FragmentScope;
import lorence.millionaire.view.fragment.home.HomeFragment;


@FragmentScope
@Subcomponent(

        modules = {
                HomeModule.class
        }
)
public interface HomeComponent {
    HomeFragment inject(HomeFragment fragment);
}
