package lorence.millionaire.di.component;

import dagger.Subcomponent;
import lorence.millionaire.di.module.welcome.PlayModule;
import lorence.millionaire.di.scope.FragmentScope;
import lorence.millionaire.view.fragment.play.PlayFragment;


@FragmentScope
@Subcomponent(

        modules = {
                PlayModule.class
        }
)
public interface PlayComponent {
    PlayFragment inject(PlayFragment fragment);
}
